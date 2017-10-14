package com.hubert.xu.zmvp.mvp.view.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hubert.xu.zmvp.mvp.model.entity.RecommendBookListBean;
import com.hubert.xu.zmvp.utils.LogUtil;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/10/12
 * Desc  :
 */

public class RecommendBookListAdapter extends BaseQuickAdapter<RecommendBookListBean.BooklistsBean,BaseViewHolder> {

    public RecommendBookListAdapter(@LayoutRes int layoutResId, @Nullable List<RecommendBookListBean.BooklistsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RecommendBookListBean.BooklistsBean item) {
        LogUtil.info(item.getTitle());
    }
}
