package com.hubert.xu.zmvp.mvp.view.adapter;


import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hubert.xu.zmvp.mvp.model.entity.CommentListBean;

import java.util.List;

/**
 * author: XQ
 * time  : 2017/10/22
 * desc  :
 */

public class ComementListAdapter extends BaseQuickAdapter<CommentListBean.CommentsBean, BaseViewHolder> {

    public ComementListAdapter(@LayoutRes int layoutResId, @Nullable List<CommentListBean.CommentsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommentListBean.CommentsBean item) {

    }
}
