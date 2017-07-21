package com.hubert.xu.zmvp.http;

import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/21
 * Desc  :
 */

public interface ISubscriber<T> {

    void subscribe(Disposable d);

    void next(T t);

    void error(Throwable e);

    void completed();
}
