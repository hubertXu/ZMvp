package com.hubert.xu.zmvp.mvp.presenter;

import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.mvp.contract.BookListByTagContract;
import com.hubert.xu.zmvp.mvp.model.RemoteDataManager;
import com.hubert.xu.zmvp.mvp.model.entity.BookListTagBean;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/28
 * Desc  :
 */

public class BookListByTagPresenter implements BookListByTagContract.Presenter {


    private BookListByTagContract.View mView;

    public BookListByTagPresenter(BookListByTagContract.View view) {
        mView = view;
    }

    @Override
    public void getData(String tag, int start) {
        HashMap<String, String> map = new HashMap<>();
        map.put("tags", tag);
        map.put("start", start+"");
        map.put("limit", 20 + "");
        RemoteDataManager.getInstance().getBookListByTag(map, new BaseObserver<BookListTagBean>() {
            @Override
            public void subscribe(Disposable d) {

            }

            @Override
            public void next(BookListTagBean bookListTagBean) {
                mView.setData(bookListTagBean);
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
