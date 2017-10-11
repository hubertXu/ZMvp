package com.hubert.xu.zmvp.mvp.view.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.entity.BookListDetailBean;
import com.hubert.xu.zmvp.utils.imageload.GlideImageLoader;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/10/11
 * Desc  :
 */

public class BookListDetailAdapter extends BaseQuickAdapter<BookListDetailBean.BookListBean.BooksBean, BaseViewHolder> {


    public BookListDetailAdapter(@LayoutRes int layoutResId, @Nullable List<BookListDetailBean.BookListBean.BooksBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BookListDetailBean.BookListBean.BooksBean item) {
        helper.setText(R.id.tv_book_name, item.getBook().getTitle())
                .setText(R.id.tv_book_author, item.getBook().getAuthor())
                .setText(R.id.tv_book_reader_counts, item.getBook().getLatelyFollower() + "人在读")
                .setText(R.id.tv_book_word_count, item.getBook().getWordCount() + "字")
                .setText(R.id.tv_book_desc, item.getBook().getLongIntro());
        new GlideImageLoader().getRequestManager(mContext).load(Constants.IMG_BASE_URL + item.getBook().getCover()).into((ImageView) helper.getView(R.id.iv_book_cover));
    }
}
