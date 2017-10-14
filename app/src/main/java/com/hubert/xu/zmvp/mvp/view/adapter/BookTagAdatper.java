package com.hubert.xu.zmvp.mvp.view.adapter;

import android.support.v4.content.ContextCompat;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.util.MultiTypeDelegate;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.mvp.model.entity.LocalBookTagsBean;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/10/10
 * Desc  :
 */

public class BookTagAdatper extends BaseQuickAdapter<LocalBookTagsBean.BookTag, BaseViewHolder> {


    public BookTagAdatper(List<LocalBookTagsBean.BookTag> bookTags) {
        super(bookTags);
        setMultiTypeDelegate(new MultiTypeDelegate<LocalBookTagsBean.BookTag>() {
            @Override
            protected int getItemType(LocalBookTagsBean.BookTag bookTag) {
                return bookTag.getSign();
            }
        });
        getMultiTypeDelegate().registerItemType(Constants.BOOK_TYPE_SIGN, R.layout.item_book_classify_sign).registerItemType(Constants.BOOK_TYPE_NAME, R.layout.item_book_tag_name);
    }

    @Override
    protected void convert(BaseViewHolder helper, LocalBookTagsBean.BookTag item) {
        if (helper.getItemViewType() == Constants.BOOK_TYPE_SIGN) {
            helper.setText(R.id.tv_book_sign, item.getName());
        } else {
            helper.setText(R.id.tv_book_tag_name, item.getName());
            helper.setTextColor(R.id.tv_book_tag_name, ContextCompat.getColor(mContext, item.isSelsect() ? R.color.accent : R.color.colorPrimaryDark));
        }
    }
}
