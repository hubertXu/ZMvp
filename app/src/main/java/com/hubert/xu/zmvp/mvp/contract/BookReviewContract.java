package com.hubert.xu.zmvp.mvp.contract;

import com.hubert.xu.zmvp.base.BaseContract;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/17
 * Desc  :
 */

public interface BookReviewContract extends BaseContract {

    interface View<BookReiewBean> extends BaseView {
        void setData(BookReiewBean data, boolean isRefresh);
    }


    interface Presenter extends BasePresenter {
        void getData(int start, String sortType, String bookState, String type);
    }
}
