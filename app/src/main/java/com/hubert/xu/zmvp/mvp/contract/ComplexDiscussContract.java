package com.hubert.xu.zmvp.mvp.contract;

import com.hubert.xu.zmvp.base.BaseContract;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/17
 * Desc  :
 */

public interface ComplexDiscussContract extends BaseContract {

    interface View<DiscussBean> extends BaseView {
        void setData(DiscussBean data, boolean isRefresh);
    }


    interface Presenter extends BasePresenter {
        void getData(int start, String sortype);
    }
}
