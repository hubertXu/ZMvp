package com.hubert.xu.zmvp.base;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/14
 * Desc  :
 */
public interface BaseContract {
    interface BasePresenter<V extends BaseView> {

        //        void attachView(T view, M modler);
//
//        void detachView();
//        void attachView(V view);

//        void detachView(boolean retainInstance);
    }


    interface BaseView<T> {

        void setPresenter(T presenter);

        void showError();

        void complete();
    }
}
