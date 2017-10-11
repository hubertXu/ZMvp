package com.hubert.xu.zmvp.mvp.presenter;

import com.hubert.xu.zmvp.entity.BookListDetailBean;
import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.mvp.contract.BookListDetailContract;
import com.hubert.xu.zmvp.mvp.model.BookListDetailMananger;

import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/28
 * Desc  :
 */

public class BookListDetailPresenter implements BookListDetailContract.Presenter {


    private BookListDetailContract.View<BookListDetailBean> mView;

    public BookListDetailPresenter(BookListDetailContract.View<BookListDetailBean> view) {
        mView = view;
    }


    @Override
    public void getData(String bookListid) {
        BookListDetailMananger.getInstance().getBookListDetail(bookListid, new BaseObserver<BookListDetailBean>() {
            @Override
            public void subscribe(Disposable d) {

            }

            @Override
            public void next(BookListDetailBean data) {
                mView.setData(data);
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
