package com.hubert.xu.zmvp.mvp.presenter;

import com.hubert.xu.zmvp.mvp.model.entity.BookListBean;
import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.mvp.contract.BookListContract;
import com.hubert.xu.zmvp.mvp.model.RemoteDataManager;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/28
 * Desc  :
 */

public class BookListPresenter implements BookListContract.Presenter {


    private BookListContract.View<BookListBean> mView;

    public BookListPresenter(BookListContract.View<BookListBean> view) {
        mView = view;
    }


    @Override
    public void getData(String duration, String tag, String gender, int start, String sort) {
        HashMap<String, String> map = new HashMap<>(6);
        map.put("duration", duration);
        map.put("tag", tag);
        map.put("gender", gender);
        map.put("limit", 20 + "");
        map.put("start", start + "");
        map.put("sort", sort);
        RemoteDataManager.getInstance().getBookList(map, new BaseObserver<BookListBean>() {
            @Override
            public void subscribe(Disposable d) {

            }

            @Override
            public void next(BookListBean data) {
                mView.setData(data, start == 0);
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
