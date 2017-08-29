package com.hubert.xu.zmvp.module.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.hubert.xu.zmvp.entity.TTBean;
import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.module.contract.OriginalContract;
import com.hubert.xu.zmvp.module.model.OriginalManager;
import com.hubert.xu.zmvp.utils.LogUtil;

import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/18
 * Desc  :
 */

public class OriginalPresenter implements OriginalContract.Presenter {

    public OriginalPresenter(Context context, OriginalContract.View view) {
        view.setPresenter(this);
    }


    @Override
    public void getData() {
        OriginalManager.getInstance().getOriginalList("ramble", "updated", 0, 20, "", new BaseObserver<TTBean>() {

            @Override
            public void subscribe(Disposable d) {

            }

            @Override
            public void next(TTBean ttBean) {
                String msg = new Gson().toJson(ttBean, TTBean.class);
                LogUtil.json(msg);
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


