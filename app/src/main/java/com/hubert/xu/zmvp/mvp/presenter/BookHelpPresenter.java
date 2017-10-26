package com.hubert.xu.zmvp.mvp.presenter;

import com.hubert.xu.zmvp.mvp.model.entity.BookHelpListBean;
import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.mvp.contract.BookHelpContract;
import com.hubert.xu.zmvp.mvp.model.RemoteDataManager;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/21
 * Desc  :
 */

public class BookHelpPresenter implements BookHelpContract.Presenter {

    private BookHelpContract.View mView;

    public BookHelpPresenter(BookHelpContract.View view) {
        mView = view;
    }

    @Override
    public void getData(int start, String sortType) {
        HashMap<String, String> parmasMap = new HashMap<>(6);
        parmasMap.put("duration", "all");
        parmasMap.put("sort", sortType);
        parmasMap.put("start", start + "");
        parmasMap.put("limit", 20 + "");
        parmasMap.put("distillate", "");
        RemoteDataManager.getInstance().getBookHelpList(parmasMap, new BaseObserver<BookHelpListBean>() {
            @Override
            public void subscribe(Disposable d) {

            }

            @Override
            public void next(BookHelpListBean bookHelpListBean) {
                mView.setData(bookHelpListBean, start == 0);
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
