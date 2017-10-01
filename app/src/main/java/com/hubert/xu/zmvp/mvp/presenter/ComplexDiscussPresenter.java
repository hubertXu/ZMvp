package com.hubert.xu.zmvp.mvp.presenter;

import com.hubert.xu.zmvp.entity.DiscussListBean;
import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.mvp.contract.ComplexDiscussContract;
import com.hubert.xu.zmvp.mvp.model.ComplexDiscussManager;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/18
 * Desc  :
 */

public class ComplexDiscussPresenter implements ComplexDiscussContract.Presenter {

    private int mLimit = 20;
    private ComplexDiscussContract.View view;
    private boolean mIsRefresh;

    public ComplexDiscussPresenter(ComplexDiscussContract.View view) {
        this.view = view;
    }


    @Override
    public void getData(int start, String sortype) {
        // 最新创建
        HashMap<String, String> defaultParamsMap = new HashMap<>();
        defaultParamsMap.put("block", "ramble");
        defaultParamsMap.put("duration", "all");
        defaultParamsMap.put("sort", sortype);
        defaultParamsMap.put("type", "all");
        defaultParamsMap.put("start", start + "");
        defaultParamsMap.put("limit", mLimit + "");
        defaultParamsMap.put("distillate", "");
        ComplexDiscussManager.getInstance().getOriginalList(defaultParamsMap, new BaseObserver<DiscussListBean>() {
            @Override
            public void subscribe(Disposable d) {

            }

            @Override
            public void next(DiscussListBean data) {
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


