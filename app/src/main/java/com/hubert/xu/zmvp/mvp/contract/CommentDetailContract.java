package com.hubert.xu.zmvp.mvp.contract;

import com.hubert.xu.zmvp.base.BaseContract;
import com.hubert.xu.zmvp.mvp.model.entity.CommentListBean;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/17
 * Desc  :
 */

public interface CommentDetailContract extends BaseContract {

    interface View<LocalCommentDetailBean> extends BaseView {
        void setRefreshData(LocalCommentDetailBean data);

        void setMoreData(CommentListBean data);
    }


    interface Presenter extends BasePresenter {

        void getRefreshData(String rankingId);

        void getMoreData(String rankingId, int start);
    }
}
