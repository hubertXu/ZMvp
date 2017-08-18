package com.hubert.xu.zmvp.module.contract;

import com.hubert.xu.zmvp.base.BaseContract;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/17
 * Desc  :
 */

public interface OriginalContract extends BaseContract {

    interface View<Presenter>extends BaseView {

    }


    interface Presenter extends BasePresenter {

    }
}
