package com.hubert.xu.zmvp.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.utils.AppUtil;
import com.hubert.xu.zmvp.utils.LogUtil;
import com.hubert.xu.zmvp.utils.ResourceUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/14
 * Desc  :
 */

public class RetrofitClient {
    private static final int DEFAULT_TIMEOUT = 20;
    private volatile static Retrofit retrofitInstance = null;

    public static Retrofit getInstance() {
        if (null == retrofitInstance) {
            synchronized (Retrofit.class) {
                if (null == retrofitInstance) {
                    retrofitInstance = new Retrofit.Builder()
                            .baseUrl(Constants.API_BASE_URL)
                            .client(initOkhttp())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(buildGsonConverterFactory())
                            .build();
                }
            }
        }
        return retrofitInstance;
    }

    /**
     * 构建GSON转换器
     *
     * @return GsonConverterFactory
     */
    private static GsonConverterFactory buildGsonConverterFactory() {
        GsonBuilder builder = new GsonBuilder();
        builder.setLenient();
        // 注册类型转换适配器
        builder.registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> null == json ? null : new Date(json.getAsLong()));
        Gson gson = builder.create();
        return GsonConverterFactory.create(gson);
    }

    private static OkHttpClient initOkhttp() {
        // 添加日志拦截器，非debug模式不打印任何日志
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        Interceptor responseTimeinterceptor = responseTimeInterceptor();
        Interceptor headerInterceptor = getRequsetHeader();
        loggingInterceptor.setLevel(AppUtil.isDev() ? HttpLoggingInterceptor.Level.HEADERS : HttpLoggingInterceptor.Level.NONE);

        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)                       // 添加日志拦截器
                .addInterceptor(headerInterceptor)                        // 添加请求头拦截器
                .addInterceptor(responseTimeinterceptor)                  // 添加服务器响应拦截器
//               .addInterceptor(buildTokenInterceptor())                 // 添加token拦截器
                .addNetworkInterceptor(buildCacheInterceptor())           // 添加网络缓存拦截器
                .cache(getCache())                                        // 设置缓存文件
                .retryOnConnectionFailure(true)                           // 自动重连
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)        // 15秒连接超时
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)           // DEFAULT_TIMEOUT秒读取超时
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)          // 20秒写入超时
                .build();
    }

    /**
     * 自定义CookieJar
     */
    private CookieJar cookieJar = new CookieJar() {
        final HashMap<HttpUrl, List<Cookie>> cookieStore = new HashMap<>();

        @Override
        public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
            cookieStore.put(url, cookies);//保存cookie
            // 也可使用sp保存
        }

        @Override
        public List<Cookie> loadForRequest(HttpUrl url) {
            List<Cookie> cookies = cookieStore.get(url);//取出cookie
            return cookies != null ? cookies : new ArrayList<>();
        }
    };

    /**
     * 请求头拦截：让服务端能更好的识别该请求,服务器那边通过请求头判断该请求是否为有效请求等。
     * 使用addHeader()不会覆盖之前设置的header
     * 若使用header()则会覆盖之前的header
     *
     * @return
     */
    private static Interceptor getRequsetHeader() {
        Interceptor headerInterceptor = chain -> {
            Request originalRequest = chain.request();
            Request.Builder builder = originalRequest.newBuilder();
            builder.addHeader("version", "1");
            builder.addHeader("time", System.currentTimeMillis() + "");
            Request.Builder requestBuilder = builder.method(originalRequest.method(), originalRequest.body());
            Request request = requestBuilder.build();
            return chain.proceed(request);
        };
        return headerInterceptor;
    }


    /**
     * 拦截器Interceptors
     * 添加公共的请求参数
     */
    private Interceptor commonParamsInterceptor() {
        Interceptor commonParams = chain -> {
            Request originRequest = chain.request();
            Request request;
            HttpUrl httpUrl = originRequest.url().newBuilder().
                    addQueryParameter("paltform", "android").
                    addQueryParameter("version", "1.0.0").build();
            request = originRequest.newBuilder().url(httpUrl).build();
            return chain.proceed(request);
        };
        return commonParams;
    }

    /**
     * 拦截器Interceptors
     * 从响应中获取服务器返回的time
     *
     * @return
     */
    public static Interceptor responseTimeInterceptor() {
        Interceptor interceptor = chain -> {
            Response response = chain.proceed(chain.request());
            String responseTime = response.header("time");
            if (responseTime == null) {
                LogUtil.info("ResponseTime", responseTime);
            }
            return response;
        };
        return interceptor;
    }

    /**
     * 获取缓存
     *
     * @return Cache
     */
    private static Cache getCache() {
        // 获取缓存目标,SD卡
        File cacheFile = new File(AppUtil.getContext().getCacheDir(), ResourceUtil.getString(R.string.app_name));
        // 创建缓存对象,最大缓存50m
        return new Cache(cacheFile, 1024 * 1024 * 20);
    }

    /**
     * 构建拦截器
     *
     * @return Interceptor
     */
    private static Interceptor buildCacheInterceptor() {
        return chain -> {
            Request request = chain.request();
            // 无网络连接时请求从缓存中读取
            if (!AppUtil.isNetworkConnected()) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            // 响应内容处理
            // 在线时缓存5分钟
            // 离线时缓存4周
            Response response = chain.proceed(request);
            if (AppUtil.isNetworkConnected()) {
                int maxAge = 300;
                response.newBuilder()
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .removeHeader("Pragma")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                        .build();
            } else {
                // 无网络时，设置超时为4周
                int maxStale = 60 * 60 * 24 * 28;
                response.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .removeHeader("Pragma")
                        .build();
            }
            return response;
        };
    }
}
