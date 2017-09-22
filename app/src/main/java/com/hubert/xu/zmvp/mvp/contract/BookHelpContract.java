package com.hubert.xu.zmvp.mvp.contract;

import com.hubert.xu.zmvp.base.BaseContract;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/17
 * Desc  :
 */

public interface BookHelpContract extends BaseContract {

    interface View<HelpsBean> extends BaseView {
        void setData(HelpsBean data, boolean isRefresh);
    }


    interface Presenter extends BasePresenter {
        void getData(int start, String sortType, String bookState);
    }

}
