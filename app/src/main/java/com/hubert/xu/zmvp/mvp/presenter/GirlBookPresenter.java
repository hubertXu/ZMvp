package com.hubert.xu.zmvp.mvp.presenter;

import com.hubert.xu.zmvp.mvp.model.entity.GirlBookListBean;
import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.mvp.contract.GirlBookContract;
import com.hubert.xu.zmvp.mvp.model.RemoteDataManager;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/18
 * Desc  :
 */

public class GirlBookPresenter implements GirlBookContract.Presenter {

    private int mLimit = 20;
    private GirlBookContract.View view;
    private boolean mIsRefresh;

    public GirlBookPresenter(GirlBookContract.View view) {
        this.view = view;
    }


    @Override
    public void getData(int start, String type) {
        // 最新创建
        HashMap<String, String> defaultParamsMap = new HashMap<>(7);
        defaultParamsMap.put("block", "ramble");
        defaultParamsMap.put("duration", "girl");
        defaultParamsMap.put("sort", type);
        defaultParamsMap.put("type", "all");
        defaultParamsMap.put("start", String.valueOf(start));
        defaultParamsMap.put("limit", String.valueOf(20));
        defaultParamsMap.put("distillate", "");
        RemoteDataManager.getInstance().getGirlBookList(defaultParamsMap, new BaseObserver<GirlBookListBean>() {
            @Override
            public void subscribe(Disposable d) {

            }

            @Override
            public void next(GirlBookListBean data) {
                mIsRefresh = start == 0;
                view.setData(data, mIsRefresh);
            }

            @Override
            public void error(Throwable e) {
                view.showError();
            }

            @Override
            public void completed() {

            }
        });
    }
}


