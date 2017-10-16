package com.hubert.xu.zmvp.mvp.view.adapter;

import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.constant.Constants;

import java.util.List;

/**
 * author: XQ
 * time  : 2017/10/15
 * desc  :
 */

public class BookDetailTagAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public BookDetailTagAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_book_tag, item);
        helper.setBackgroundColor(R.id.tv_book_tag, Color.parseColor(Constants.colorRandom.get((int) (Math.random() * Constants.colorRandom.size()))));
    }
}
