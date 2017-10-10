package com.hubert.xu.zmvp.mvp.view.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hubert.xu.zmvp.entity.BookListBean;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/10/10
 * Desc  :
 */

public class BookListAdapter extends BaseQuickAdapter<BookListBean.BookListsBean, BaseViewHolder> {

    public BookListAdapter(@LayoutRes int layoutResId, @Nullable List<BookListBean.BookListsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BookListBean.BookListsBean item) {

    }
}
