package com.hubert.xu.zmvp.mvp.presenter;

import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.mvp.model.entity.BookReviewListBean;
import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.mvp.contract.BookReviewContract;
import com.hubert.xu.zmvp.mvp.model.RemoteDataManager;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/21
 * Desc  :
 */

public class BookReviewPresenter implements BookReviewContract.Presenter {

    private BookReviewContract.View mView;

    public BookReviewPresenter(BookReviewContract.View view) {
        mView = view;
    }

    @Override
    public void getData(int start,String type) {
        HashMap<String, String> parmasMap = new HashMap<>();
        parmasMap.put("duration", "all");
        parmasMap.put("sort", Constants.TYPE_SORT_DEFAULT);
        parmasMap.put("type", type);
        parmasMap.put("start", start + "");
        parmasMap.put("limit", 20 + "");
        parmasMap.put("distillate", "");
        RemoteDataManager.getInstance().getBookReviewList(parmasMap, new BaseObserver<BookReviewListBean>() {
            @Override
            public void subscribe(Disposable d) {

            }

            @Override
            public void next(BookReviewListBean bookReviewBean) {
                mView.setData(bookReviewBean, start == 0);
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
