package com.hubert.xu.zmvp.mvp.view.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.mvp.model.entity.BookListTagBean;
import com.hubert.xu.zmvp.utils.imageload.GlideImageLoader;

import java.util.List;

/**
 * author: XQ
 * time  : 2017/10/18
 * desc  :
 */

public class BookListByTagAdapter extends BaseQuickAdapter<BookListTagBean.BooksBean, BaseViewHolder> {

    public BookListByTagAdapter(@LayoutRes int layoutResId, @Nullable List<BookListTagBean.BooksBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BookListTagBean.BooksBean item) {
        String sbTag = "";
        List<String> tags = item.getTags();
        int size = tags.size();
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                sbTag = sbTag + tags.get(i);
            } else {
                sbTag = sbTag + tags.get(i) + "|";
            }
        }
        helper.setText(R.id.tv_book_name, item.getTitle())
                .setText(R.id.tv_book_author, item.getAuthor())
                .setText(R.id.tv_book_desc, item.getShortIntro())
                .setText(R.id.tv_book_tag, sbTag);
        new GlideImageLoader().getRequestManager(mContext).load(Constants.IMG_BASE_URL + item.getCover()).into((ImageView) helper.getView(R.id.iv_book_cover));
    }
}
