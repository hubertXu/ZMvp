package com.hubert.xu.zmvp.mvp.contract;

import com.hubert.xu.zmvp.base.BaseContract;
import com.hubert.xu.zmvp.entity.GirlBookListBean;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/17
 * Desc  :
 */

public interface GirlBookContract extends BaseContract {

    interface View<T> extends BaseView {
        void setData(GirlBookListBean data, boolean isRefresh);
    }


    interface Presenter extends BasePresenter {
        void getData(int start, String sortType);
    }

}
