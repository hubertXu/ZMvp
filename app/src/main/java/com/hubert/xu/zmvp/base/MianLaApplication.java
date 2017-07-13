package com.hubert.xu.zmvp.base;

import android.app.Application;
import android.graphics.Typeface;

import com.hubert.xu.zmvp.utils.LogUtils;
import com.hubert.xu.zmvp.utils.SPUtils;
import com.hubert.xu.zmvp.utils.ToastUtils;
import com.hubert.xu.zmvp.utils.Utils;
import com.squareup.leakcanary.LeakCanary;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;


/**
 * author: XQ
 * time  : 2017/3/6
 * desc  : MianLaApplication
 */
public class MianLaApplication extends Application {

    private String spName = "BaseApp_SP_Data";
    private static MianLaApplication mAppContext = null;

    public static MianLaApplication getApplication() {
        return mAppContext;
    }

    //字体图标
    private Typeface iconTypeFace;

    public Typeface getIconTypeFace() {
        return iconTypeFace;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = this;
        initUtils();
        initComplie();
        initData();
    }

    private void initUtils() {
        Utils.init(mAppContext);
        SPUtils.init(mAppContext, spName);
        LogUtils.init(true, false, 'd', "Log");
        ToastUtils.init(this);
    }


    private void initComplie() {
        initOkHttp();
        initLeakCanary();
    }


    private void initData() {
    }



    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }



    private void initOkHttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggerInterceptor("okhttp "))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS).build();
        OkHttpUtils.initClient(okHttpClient);
    }
}
