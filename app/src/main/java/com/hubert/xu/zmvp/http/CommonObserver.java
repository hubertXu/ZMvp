package com.hubert.xu.zmvp.http;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;

import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/21
 * Desc  :
 */

public abstract class CommonObserver<T extends HttpResult<T>> extends BaseObserver<T> {

    private MaterialDialog mDialog;

    public abstract void onSubscribe(Disposable d);

    public abstract void onNext(T t);

    public abstract void onError(Throwable e);

    public abstract void onComplete();

    public CommonObserver() {
    }

    @Override
    public void subscribe(Disposable d) {
        if (mDialog != null && !mDialog.isShowing())
            mDialog.show();
        onSubscribe(d);
    }

    @Override
    public void next(T t) {
        if (t.getCode() == 200) {
            onNext(t.getData());
        }
    }

    @Override
    public void error(Throwable e) {
        onError(e);
    }

    @Override
    public void completed() {
        if (mDialog != null && !mDialog.isShowing())
            mDialog.dismiss();
        onComplete();
    }

    public CommonObserver buildDialog(Context context, CharSequence content) {
        mDialog = new MaterialDialog.Builder(context).content(content).cancelable(false).progress(true, 0).build();
        return this;
    }
}
