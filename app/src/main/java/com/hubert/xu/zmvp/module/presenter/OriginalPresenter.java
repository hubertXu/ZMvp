package com.hubert.xu.zmvp.module.presenter;

import android.content.Context;
import android.util.Log;

import com.hubert.xu.zmvp.entity.ComplexDiscussBean;
import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.module.contract.OriginalContract;
import com.hubert.xu.zmvp.module.model.OriginalManager;
import com.hubert.xu.zmvp.utils.LogUtil;
import com.orhanobut.logger.Logger;

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
        OriginalManager.getInstance().getOriginalList("remale", "updated", 0, 20, "false", new BaseObserver<ComplexDiscussBean>() {
            @Override
            public void subscribe(Disposable d) {

            }

            @Override
            public void next(ComplexDiscussBean complexDiscussBean) {
                LogUtil.json(complexDiscussBean.toString());
            }

            @Override
            public void error(Throwable e) {
                LogUtil.error(e,e.getMessage());
                LogUtil.info("ZZZZZZZZZZZZ");
            }

            @Override
            public void completed() {

            }
        });
    }
}


