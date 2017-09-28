package com.hubert.xu.zmvp.mvp.contract;

import com.hubert.xu.zmvp.base.BaseContract;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/17
 * Desc  :
 */

public interface RankingContract extends BaseContract {

    interface View<RankingBean> extends BaseView {
        void setData(RankingBean data);
    }


    interface Presenter extends BasePresenter {
        void getData(String rankingId);
    }

}
