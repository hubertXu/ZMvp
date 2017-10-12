package com.hubert.xu.zmvp.mvp.presenter;

import com.hubert.xu.zmvp.mvp.model.entity.LocalBookTagsBean;
import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.mvp.contract.BookListTagContract;
import com.hubert.xu.zmvp.mvp.model.RemoteDataManager;

import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/28
 * Desc  :
 */

public class BookTagsPresenter implements BookListTagContract.Presenter {


    private BookListTagContract.View mView;

    public BookTagsPresenter(BookListTagContract.View view) {
        mView = view;
    }


    @Override
    public void getTagData() {
        RemoteDataManager.getInstance().getBookTag(new BaseObserver<LocalBookTagsBean>() {
            @Override
            public void subscribe(Disposable d) {

            }

            @Override
            public void next(LocalBookTagsBean localBookTagsBean) {
                mView.setTagData(localBookTagsBean);
            }

            @Override
            public void error(Throwable e) {
                mView.showError();
            }

            @Override
            public void completed() {

            }

        });
    }
}
