package com.hubert.xu.zmvp.mvp.view.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.entity.BookClassifyListBean;
import com.hubert.xu.zmvp.utils.imageload.GlideImageLoader;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/30
 * Desc  :
 */

public class BookClassifyListAdapter extends BaseQuickAdapter<BookClassifyListBean.BooksBean, BaseViewHolder> {

    public BookClassifyListAdapter(@LayoutRes int layoutResId, @Nullable List<BookClassifyListBean.BooksBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BookClassifyListBean.BooksBean item) {
        helper.setText(R.id.tv_book_name, item.getTitle())
                .setText(R.id.tv_book_author, item.getAuthor())
                .setText(R.id.tv_book_sign, item.getMajorCate())
                .setText(R.id.tv_book_breif, item.getShortIntro())
                .setText(R.id.tv_reader_retained_rate, item.getRetentionRatio() + "%读者留存")
                .setText(R.id.tv_book_reading_count, item.getLatelyFollower() + "人在读");
        new GlideImageLoader().getRequestManager(mContext).load(Constants.IMG_BASE_URL + item.getCover()).into((ImageView) helper.getView(R.id.iv_book_cover));
    }
}
