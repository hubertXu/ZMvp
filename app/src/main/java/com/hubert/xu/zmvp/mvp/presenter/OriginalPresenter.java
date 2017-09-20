package com.hubert.xu.zmvp.mvp.presenter;

import com.hubert.xu.zmvp.entity.DiscussBean;
import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.mvp.contract.OriginalContract;
import com.hubert.xu.zmvp.mvp.model.OriginalManager;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/18
 * Desc  :
 */

public class OriginalPresenter implements OriginalContract.Presenter {

    private int mLimit = 20;
    private OriginalContract.View view;
    private boolean mIsRefresh;

    public OriginalPresenter(OriginalContract.View view) {
        view.setPresenter(this);
        this.view = view;
    }


    @Override
    public void getData(int start, String type) {
        // 最新创建
        HashMap<String, String> defaultParamsMap = new HashMap<>();
        defaultParamsMap.put("block", "ramble");
        defaultParamsMap.put("duration", "all");
        defaultParamsMap.put("sort", type);
        defaultParamsMap.put("type", "all");
        defaultParamsMap.put("start", start + "");
        defaultParamsMap.put("limit", mLimit + "");
        defaultParamsMap.put("distillate", "false");
        OriginalManager.getInstance().getOriginalList(defaultParamsMap, new BaseObserver<DiscussBean>() {
            @Override
            public void subscribe(Disposable d) {

            }

            @Override
            public void next(DiscussBean data) {
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


