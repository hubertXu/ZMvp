package com.hubert.xu.zmvp.mvp.contract;

import com.hubert.xu.zmvp.base.BaseContract;
import com.hubert.xu.zmvp.entity.BookListBean;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/17
 * Desc  :
 */

public interface BookListContract extends BaseContract {

    interface View<B> extends BaseView {
        void setData(BookListBean data);
    }


    interface Presenter extends BasePresenter {
        void getData();
    }
}
