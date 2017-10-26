package com.hubert.xu.zmvp.mvp.presenter;

import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.mvp.contract.CommentDetailContract;
import com.hubert.xu.zmvp.mvp.model.RemoteDataManager;
import com.hubert.xu.zmvp.mvp.model.entity.CommentListBean;
import com.hubert.xu.zmvp.mvp.model.entity.CommentDetailBean;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

/**
 * author: XQ
 * time  : 2017/10/21
 * desc  :
 */

public class CommentDetailPresenter implements CommentDetailContract.Presenter {

    private final CommentDetailContract.View mView;

    public CommentDetailPresenter(CommentDetailContract.View view) {
        mView = view;
    }

    @Override
    public void getRefreshData(String rankingId) {
        HashMap<String, String> map = new HashMap<>(2);
        map.put("start", "0");
        map.put("limit", "20");
        RemoteDataManager.getInstance().getDicussDetailRefresh(rankingId, map, new BaseObserver<CommentDetailBean>() {
            @Override
            public void subscribe(Disposable d) {

            }

            @Override
            public void next(CommentDetailBean localDiscussDetailBean) {
                mView.setRefreshData(localDiscussDetailBean);
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

    @Override
    public void getMoreData(String rankingId, int start) {
        HashMap<String, String> map = new HashMap<>(2);
        map.put("start", start + "");
        map.put("limit", "20");
        RemoteDataManager.getInstance().getDiscussMore(rankingId, map, new BaseObserver<CommentListBean>() {
            @Override
            public void subscribe(Disposable d) {

            }

            @Override
            public void next(CommentListBean commentListBean) {
                mView.setMoreData(commentListBean);
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
