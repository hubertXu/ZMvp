package com.hubert.xu.zmvp.mvp.presenter;

import com.hubert.xu.zmvp.entity.BookListBean;
import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.mvp.contract.BookListContract;
import com.hubert.xu.zmvp.mvp.model.BookListMananger;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/28
 * Desc  :
 */

public class BookListPresenter implements BookListContract.Presenter {


    private BookListContract.View mView;

    public BookListPresenter(BookListContract.View view) {
        mView = view;
    }

    @Override
    public void getData(int start, String sign, String type, String major, String minor) {
        HashMap<String, String> params = new HashMap<>();
        params.put("type", type);
        params.put("major", major);
        params.put("limit", 20 + "");
        params.put("start", start + "");
        params.put("gender", sign);
        params.put("minor", minor);
        BookListMananger.getInstance().getBookList(params, new BaseObserver<BookListBean>() {
            @Override
            public void subscribe(Disposable d) {

            }

            @Override
            public void next(BookListBean bookListBean) {
                mView.setData(bookListBean, start == 0);
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
