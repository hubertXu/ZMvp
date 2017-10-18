package com.hubert.xu.zmvp.mvp.presenter;

import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.mvp.contract.BookDetailContract;
import com.hubert.xu.zmvp.mvp.model.RemoteDataManager;
import com.hubert.xu.zmvp.mvp.model.entity.LocalBookdetailBean;

import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/28
 * Desc  :
 */

public class BookDetailPresenter implements BookDetailContract.Presenter {


    private BookDetailContract.View mView;

    public BookDetailPresenter(BookDetailContract.View view) {
        mView = view;
    }

    @Override
    public void getData(String bookId) {
        RemoteDataManager.getInstance().getBookDetail(bookId, new BaseObserver<LocalBookdetailBean>() {
            @Override
            public void subscribe(Disposable d) {

            }

            @Override
            public void next(LocalBookdetailBean localBookdetailBean) {
                mView.setData(localBookdetailBean);
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
