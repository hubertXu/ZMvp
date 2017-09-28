package com.hubert.xu.zmvp.mvp.view.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hubert.xu.zmvp.entity.RankingBean;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/28
 * Desc  :
 */

public class RankingAdapter extends BaseQuickAdapter<RankingBean.BooksBean,BaseViewHolder> {

    public RankingAdapter(@LayoutRes int layoutResId, @Nullable List<RankingBean.BooksBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RankingBean.BooksBean item) {

    }

}
