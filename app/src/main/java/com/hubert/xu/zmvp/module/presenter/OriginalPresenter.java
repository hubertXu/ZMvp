package com.hubert.xu.zmvp.module.presenter;

import com.hubert.xu.zmvp.entity.DiscussBean;
import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.module.contract.OriginalContract;
import com.hubert.xu.zmvp.module.model.OriginalManager;

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
    private int mMostCommentedStart = 0;

    public OriginalPresenter(OriginalContract.View view) {
        view.setPresenter(this);
        this.view = view;
    }


    @Override
    public void getData(int start) {
        // 最新创建
        HashMap<String, String> defaultParamsMap = new HashMap<>();
        defaultParamsMap.put("block", "ramble");
        defaultParamsMap.put("duration", "all");
        defaultParamsMap.put("sort", "created");
        defaultParamsMap.put("tyep", "all");
        defaultParamsMap.put("start", start + "");
        defaultParamsMap.put("mLimit", mLimit + "");
        defaultParamsMap.put("distillate", "false");
        // 最多评论
        HashMap<String, String> fineParamsMap = new HashMap<>();
        fineParamsMap.put("block", "ramble");
        fineParamsMap.put("duration", "all");
        fineParamsMap.put("sort", "coment-count");
        fineParamsMap.put("tyep", "all");
        fineParamsMap.put("start", mMostCommentedStart + "");
        fineParamsMap.put("mLimit", 5 + "");
        fineParamsMap.put("distillate", "true");
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


