package com.hubert.xu.zmvp.mvp.presenter;

import com.hubert.xu.zmvp.mvp.model.entity.BookClassifyListBean;
import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.mvp.contract.BookClassifyListContract;
import com.hubert.xu.zmvp.mvp.model.RemoteDataManager;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/28
 * Desc  :
 */

public class BookClassifyListPresenter implements BookClassifyListContract.Presenter {


    private BookClassifyListContract.View mView;

    public BookClassifyListPresenter(BookClassifyListContract.View view) {
        mView = view;
    }

    @Override
    public void getData(int start, String sign, String type, String major, String minor) {
        HashMap<String, String> params = new HashMap<>(6);
        params.put("type", type);
        params.put("major", major);
        params.put("limit", 20 + "");
        params.put("start", start + "");
        params.put("gender", sign);
        params.put("minor", minor);
        RemoteDataManager.getInstance().getBookClassifyList(params, new BaseObserver<BookClassifyListBean>() {
            @Override
            public void subscribe(Disposable d) {

            }

            @Override
            public void next(BookClassifyListBean bookListBean) {
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
