package com.hubert.xu.zmvp.http;

import com.hubert.xu.zmvp.utils.NetworkUtils;
import com.hubert.xu.zmvp.utils.ToastUtil;

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
        if (!NetworkUtils.isAvailableByPing()) {
            ToastUtil.showShort("无网络，读取缓存数据");
            onComplete();
        }
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
        ToastUtil.showShort(ApiException.handleException(e).getMessage());
        error(e);
    }

    @Override
    public void onComplete() {
        completed();
    }
}
