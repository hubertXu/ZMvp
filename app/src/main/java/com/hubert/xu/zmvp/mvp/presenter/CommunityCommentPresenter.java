package com.hubert.xu.zmvp.mvp.presenter;

import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.mvp.contract.CommunityCommentContract;
import com.hubert.xu.zmvp.mvp.contract.CommunityDiscussContract;
import com.hubert.xu.zmvp.mvp.model.RemoteDataManager;
import com.hubert.xu.zmvp.mvp.model.entity.HotReviewBean;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/10/25
 * Desc  :
 */

public class CommunityCommentPresenter implements CommunityDiscussContract.Presenter {

    private CommunityCommentContract.View mView;

    public CommunityCommentPresenter(CommunityCommentContract.View view) {
        mView = view;
    }

    @Override
    public void getData(String bookId, String sort, int start) {
        HashMap<String, String> map = new HashMap<>(5);
        map.put("book", bookId);
        map.put("start", start + "");
        map.put("limit", 20 + "");
        map.put("sort", sort);
        map.put("type", "normal");
        RemoteDataManager.getInstance().getCommunityComment(map, new BaseObserver<HotReviewBean>() {
            @Override
            public void subscribe(Disposable d) {

            }

            @Override
            public void next(HotReviewBean data) {
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
