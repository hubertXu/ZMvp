package com.hubert.xu.zmvp.mvp.contract;

import com.hubert.xu.zmvp.base.BaseContract;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/17
 * Desc  :
 */

public interface BookListDetailContract extends BaseContract {

    interface View<BookListDetailBean> extends BaseView {
        void setData(BookListDetailBean data);
    }


    interface Presenter extends BasePresenter {
        void getData(String bookListId);
    }
}
