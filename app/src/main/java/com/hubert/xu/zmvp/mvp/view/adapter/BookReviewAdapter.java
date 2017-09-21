package com.hubert.xu.zmvp.mvp.view.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hubert.xu.zmvp.entity.BookReviewListBean;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/21
 * Desc  :
 */

public class BookReviewAdapter extends BaseQuickAdapter<BookReviewListBean.ReviewsBean, BaseViewHolder> {


    public BookReviewAdapter(@LayoutRes int layoutResId, @Nullable List<BookReviewListBean.ReviewsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BookReviewListBean.ReviewsBean item) {

    }
}
