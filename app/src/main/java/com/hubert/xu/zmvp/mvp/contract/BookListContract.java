package com.hubert.xu.zmvp.mvp.contract;

import com.hubert.xu.zmvp.base.BaseContract;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/17
 * Desc  :
 */

public interface BookListContract extends BaseContract {

    interface View<BookListBean> extends BaseView {
        void setData(BookListBean data, boolean isRefresh);
    }


    interface Presenter extends BasePresenter {
        void getData(String duration, String tag, String gender, int start, String sort);
    }
}
