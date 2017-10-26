package com.hubert.xu.zmvp.mvp.presenter;

import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.mvp.contract.CommunityDiscussContract;
import com.hubert.xu.zmvp.mvp.model.RemoteDataManager;
import com.hubert.xu.zmvp.mvp.model.entity.DiscussListBean;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/10/25
 * Desc  :
 */

public class CommunityDiscussPresenter implements CommunityDiscussContract.Presenter {

    private CommunityDiscussContract.View mView;

    public CommunityDiscussPresenter(CommunityDiscussContract.View view) {
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
        RemoteDataManager.getInstance().getCommunityDiscuss(map, new BaseObserver<DiscussListBean>() {
            @Override
            public void subscribe(Disposable d) {

            }

            @Override
            public void next(DiscussListBean discussListBean) {
                mView.setData(discussListBean);
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
