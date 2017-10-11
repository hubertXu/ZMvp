package com.hubert.xu.zmvp.mvp.view.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.entity.BookListBean;
import com.hubert.xu.zmvp.utils.imageload.GlideImageLoader;

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
        helper.setText(R.id.tv_book_list_name, item.getTitle())
                .setText(R.id.tv_book_list_author, item.getAuthor())
                .setText(R.id.tv_book_list_desc, item.getDesc())
                .setText(R.id.tv_list_book_count, item.getBookCount()+"本书")
                .setText(R.id.tv_list_collect_count, item.getCollectorCount()+"人收藏");
        new GlideImageLoader().getRequestManager(mContext).load(Constants.IMG_BASE_URL + item.getCover()).into((ImageView) helper.getView(R.id.iv_list_cover));
    }
}
