package com.hubert.xu.zmvp.mvp.contract;

import com.hubert.xu.zmvp.base.BaseContract;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/17
 * Desc  :
 */

public interface BookClassifyContract extends BaseContract {

    interface View<BookClassifyBean> extends BaseView {
        void setData(BookClassifyBean data);
    }


    interface Presenter extends BasePresenter {
        void getData();
    }

}
