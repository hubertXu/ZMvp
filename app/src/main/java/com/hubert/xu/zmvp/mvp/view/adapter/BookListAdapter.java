package com.hubert.xu.zmvp.mvp.view.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hubert.xu.zmvp.entity.BookListBean;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/30
 * Desc  :
 */

public class BookListAdapter extends BaseQuickAdapter<BookListBean.BooksBean,BaseViewHolder> {

    public BookListAdapter(@LayoutRes int layoutResId, @Nullable List<BookListBean.BooksBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BookListBean.BooksBean item) {

    }
}
