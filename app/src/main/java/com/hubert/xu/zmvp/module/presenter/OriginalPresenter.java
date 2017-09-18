package com.hubert.xu.zmvp.module.presenter;

import android.content.Context;

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

    private int limit = 20;
    private OriginalContract.View view;
    private boolean isRefresh;

    public OriginalPresenter(Context context, OriginalContract.View view) {
        view.setPresenter(this);
        this.view = view;
    }


    @Override
    public void getData(int start) {
        HashMap<String, String> defaultParamsMap = new HashMap<>();
        defaultParamsMap.put("block", "ramble");
        defaultParamsMap.put("duration", "all");
        defaultParamsMap.put("sort", "updated");
        defaultParamsMap.put("tyep", "all");
        defaultParamsMap.put("start", start + "");
        defaultParamsMap.put("limit", limit + "");
        defaultParamsMap.put("distillate", "false");
        HashMap<String, String> fineParamsMap = new HashMap<>();
        fineParamsMap.put("block", "ramble");
        fineParamsMap.put("duration", "all");
        fineParamsMap.put("sort", "updated");
        fineParamsMap.put("tyep", "all");
        fineParamsMap.put("start", start + "");
        fineParamsMap.put("limit", 5 + "");
        fineParamsMap.put("distillate", "true");
        OriginalManager.getInstance().getOriginalList(fineParamsMap, defaultParamsMap, new BaseObserver<DiscussBean>() {
            @Override
            public void subscribe(Disposable d) {

            }

            @Override
            public void next(DiscussBean data) {
                isRefresh = start == 0;
                view.setData(data, isRefresh);
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


