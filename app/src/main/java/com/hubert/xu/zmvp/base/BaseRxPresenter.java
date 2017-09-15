package com.hubert.xu.zmvp.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/14
 * Desc  :
 */

public class BaseRxPresenter implements BaseContract.BasePresenter {


    private CompositeDisposable mCompositeDisposable;

/*    @Override
    public void attachView(V view, M modler) {
        mView = view;
        mModler = modler;
    }

    @Override
    public void detachView() {
        mView = null;
        unSubscribe();
    }*/

    protected void addSubscrebe(Disposable subscription) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }

    protected void unSubscribe() {
        if (mCompositeDisposable != null)
            mCompositeDisposable.clear();
    }
}
