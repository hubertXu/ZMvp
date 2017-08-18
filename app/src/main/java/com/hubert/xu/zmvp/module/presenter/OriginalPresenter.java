package com.hubert.xu.zmvp.module.presenter;

import android.content.Context;

import com.hubert.xu.zmvp.module.contract.OriginalContract;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/18
 * Desc  :
 */

public class OriginalPresenter implements OriginalContract.Presenter {

    public OriginalPresenter(Context context, OriginalContract.View view) {
        view.setPresenter(this);
    }

}


