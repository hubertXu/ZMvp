package com.hubert.xu.zmvp.http;

import android.accounts.NetworkErrorException;
import android.net.ParseException;

import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.hubert.xu.zmvp.utils.LogUtil;
import com.hubert.xu.zmvp.utils.ToastUtil;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/20
 * Desc  :
 */

public abstract class BaseObserver<T extends BookBaseBean> implements Observer<T>, ISubscriber<T> {

    protected BaseObserver() {
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        subscribe(d);
       /* if (!NetworkUtils.isAvailableByPing()) {
            ToastUtil.showShort("无网络，读取缓存数据");
            onComplete();
        }*/
    }

    @Override
    public void onNext(@NonNull T t) {
        if (t.ok) {
            next(t);
        } else {
            ToastUtil.showShort("ok=false");
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {
        StringBuffer sb = new StringBuffer();
        if (e instanceof NetworkErrorException || e instanceof UnknownHostException || e instanceof ConnectException) {
            sb.append("网络异常");
        } else if (e instanceof SocketTimeoutException || e instanceof InterruptedIOException || e instanceof TimeoutException) {
            sb.append("请求超时");
        } else if (e instanceof JsonSyntaxException) {
            sb.append("请求不合法");
        } else if (e instanceof JsonParseException || e instanceof JSONException || e instanceof ParseException) {
            sb.append("解析错误");
        } else {
            ToastUtil.showShort(e.getMessage());
            LogUtil.json(e.getMessage());
        }
        error(e);
    }

    @Override
    public void onComplete() {
        completed();
    }
}
