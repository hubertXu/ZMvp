package com.hubert.xu.zmvp.mvp.contract;

import com.hubert.xu.zmvp.base.BaseContract;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/17
 * Desc  :
 */

public interface AllRankTypeContract extends BaseContract {

    interface View<AllRankTypeBean> extends BaseView {
        void setData(AllRankTypeBean data);
    }


    interface Presenter extends BasePresenter {
        void getData();
    }

}
