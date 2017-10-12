package com.hubert.xu.zmvp.mvp.presenter;

import com.hubert.xu.zmvp.mvp.model.entity.LocalAllRankingTypeBean;
import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.mvp.contract.AllRankTypeContract;
import com.hubert.xu.zmvp.mvp.model.RemoteDataManager;

import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/28
 * Desc  :
 */

public class AllRankTypePresenter implements AllRankTypeContract.Presenter {


    private AllRankTypeContract.View mView;

    public AllRankTypePresenter(AllRankTypeContract.View view) {
        mView = view;
    }

    @Override
    public void getData() {
        RemoteDataManager.getInstance().getAllRankingType(new BaseObserver<LocalAllRankingTypeBean>() {
            @Override
            public void subscribe(Disposable d) {

            }

            @Override
            public void next(LocalAllRankingTypeBean localAllRankingTypeBean) {
                mView.setData(localAllRankingTypeBean);
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
