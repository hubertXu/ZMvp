package com.hubert.xu.zmvp.mvp.contract;

import com.hubert.xu.zmvp.base.BaseContract;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/17
 * Desc  :
 */

public interface BookListByTagContract extends BaseContract {

    interface View<BookListTagBean> extends BaseView {
        void setData(BookListTagBean data);
    }


    interface Presenter extends BasePresenter {
        void getData(String tag,int start);
    }

}
