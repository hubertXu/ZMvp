package com.hubert.xu.zmvp.mvp.contract;

import com.hubert.xu.zmvp.base.BaseContract;
import com.hubert.xu.zmvp.mvp.model.entity.LocalBookTagsBean;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/17
 * Desc  :
 */

public interface BookListTagContract extends BaseContract {

    interface View extends BaseView {
        void setTagData(LocalBookTagsBean data);
    }


    interface Presenter extends BasePresenter {
        void getTagData();
    }

}
