package com.hubert.xu.zmvp.mvp.presenter;

import com.hubert.xu.zmvp.entity.BookclassifyLocalBean;
import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.mvp.contract.BookClassifyContract;
import com.hubert.xu.zmvp.mvp.model.BookClassifyMannager;

import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/29
 * Desc  :
 */

public class BookClassifyPresenter implements BookClassifyContract.Presenter {


    private BookClassifyContract.View mView;

    public BookClassifyPresenter(BookClassifyContract.View view) {
        mView = view;
    }

    @Override
    public void getData() {
        BookClassifyMannager.getInstance().getBookClassify(new BaseObserver<BookclassifyLocalBean>() {
            @Override
            public void subscribe(Disposable d) {

            }

            @Override
            public void next(BookclassifyLocalBean data) {
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
