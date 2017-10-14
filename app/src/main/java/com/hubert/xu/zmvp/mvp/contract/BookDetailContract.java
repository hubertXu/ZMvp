package com.hubert.xu.zmvp.mvp.contract;

import com.hubert.xu.zmvp.base.BaseContract;
import com.hubert.xu.zmvp.mvp.model.entity.LocalBookdetailBean;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/17
 * Desc  :
 */

public interface BookDetailContract extends BaseContract {

    interface View<T> extends BaseView {
        void setData(LocalBookdetailBean data);
    }


    interface Presenter extends BasePresenter {
        void getData(String bookId);
    }
}
