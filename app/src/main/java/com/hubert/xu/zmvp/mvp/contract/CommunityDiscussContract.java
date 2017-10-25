package com.hubert.xu.zmvp.mvp.contract;

import com.hubert.xu.zmvp.base.BaseContract;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/17
 * Desc  :
 */

public interface CommunityDiscussContract extends BaseContract {

    interface View<DiscussListBean> extends BaseView {
        void setData(DiscussListBean data);
    }


    interface Presenter extends BasePresenter {
        void getData(String bookId, String sort, int start);
    }

}
