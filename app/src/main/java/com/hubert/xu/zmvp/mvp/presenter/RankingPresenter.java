package com.hubert.xu.zmvp.mvp.presenter;

import com.hubert.xu.zmvp.mvp.model.entity.RankingBean;
import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.mvp.contract.RankingContract;
import com.hubert.xu.zmvp.mvp.model.RemoteDataManager;

import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/28
 * Desc  :
 */

public class RankingPresenter implements RankingContract.Presenter {


    private RankingContract.View mView;

    public RankingPresenter(RankingContract.View view) {
        mView = view;
    }

    @Override
    public void getData(String rankingId) {
        RemoteDataManager.getInstance().getRankingList(rankingId, new BaseObserver<RankingBean>() {
            @Override
            public void subscribe(Disposable d) {

            }

            @Override
            public void next(RankingBean rankingBean) {
                mView.setData(rankingBean);
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
