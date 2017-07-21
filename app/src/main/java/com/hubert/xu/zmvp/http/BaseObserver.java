package com.hubert.xu.zmvp.http;

import com.hubert.xu.zmvp.utils.ToastUtil;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/20
 * Desc  :
 */

public abstract class BaseObserver<T extends HttpResult> implements Observer<T>, ISubscriber<T> {

    protected BaseObserver() {
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        subscribe(d);
    }

    @Override
    public void onNext(@NonNull T t) {
        if (t.getCode() == 200) {
            next(t);
        } else if (t.getCode() == 400) {

        } else {
            ToastUtil.showShort(t.getMsg());
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {
        if (e instanceof SocketTimeoutException) {
            ToastUtil.showShort(ApiException.ERROR_MSG_SOCKETTIMEOUTEXCEPTION);
        } else if (e instanceof ConnectException) {
            ToastUtil.showShort(ApiException.ERROR_MSG_CONNECTEXCEPTION);
        } else if (e instanceof UnknownHostException) {
            ToastUtil.showShort(ApiException.ERROR_MSG_UNKONWNHOSTEXCEPTION);
        } else {
            ToastUtil.showShort(e.getMessage());
        }
        error(e);
    }

    @Override
    public void onComplete() {
        completed();
    }
}
