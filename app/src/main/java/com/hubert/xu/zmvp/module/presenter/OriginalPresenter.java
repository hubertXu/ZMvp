package com.hubert.xu.zmvp.module.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.hubert.xu.zmvp.entity.DiscussBean;
import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.module.contract.OriginalContract;
import com.hubert.xu.zmvp.module.model.OriginalManager;
import com.hubert.xu.zmvp.utils.LogUtil;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/18
 * Desc  :
 */

public class OriginalPresenter implements OriginalContract.Presenter {

    private int page = 0;
    private int limit = 20;
    private OriginalContract.View view;

    public OriginalPresenter(Context context, OriginalContract.View view) {
        view.setPresenter(this);
        this.view = view;
    }


    @Override
    public void getData() {
        HashMap<String, String> defaultParamsMap = new HashMap<>();
        defaultParamsMap.put("block", "ramble");
        defaultParamsMap.put("duration", "all");
        defaultParamsMap.put("sort", "updated");
        defaultParamsMap.put("tyep", "all");
        defaultParamsMap.put("start", page + "");
        defaultParamsMap.put("limit", limit + "");
        defaultParamsMap.put("distillate", "false");
        HashMap<String, String> fineParamsMap = new HashMap<>();
        fineParamsMap.put("block", "ramble");
        fineParamsMap.put("duration", "all");
        fineParamsMap.put("sort", "updated");
        fineParamsMap.put("tyep", "all");
        fineParamsMap.put("start", 0 + "");
        fineParamsMap.put("limit", 5 + "");
        fineParamsMap.put("distillate", "true");
        OriginalManager.getInstance().getOriginalList(fineParamsMap, defaultParamsMap, new BaseObserver<DiscussBean>() {
            @Override
            public void subscribe(Disposable d) {

            }

            @Override
            public void next(DiscussBean data) {
                LogUtil.json(new Gson().toJson(data, DiscussBean.class));
                view.setData(data.getPosts());
            }

            @Override
            public void error(Throwable e) {

            }

            @Override
            public void completed() {

            }
        });
    }
}


