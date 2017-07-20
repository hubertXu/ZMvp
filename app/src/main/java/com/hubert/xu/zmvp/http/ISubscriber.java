package com.hubert.xu.zmvp.http;

import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/20
 * Desc  : 定义请求结果处理接口
 */

public interface ISubscriber<T extends HttpResult> {

    void onSubscribe(Disposable d);

    void onNext(T t);

    void onError(String errorMsg);

    void onComplete();

}
