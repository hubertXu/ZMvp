package com.hubert.xu.zmvp.mvp.view.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.mvp.model.entity.RecommendBookBean;
import com.hubert.xu.zmvp.utils.imageload.GlideImageLoader;

import java.util.List;

/**
 * author: XQ
 * time  : 2017/10/16
 * desc  :
 */

public class RecommendBookAdapter extends BaseQuickAdapter<RecommendBookBean.BooksBean, BaseViewHolder> {

    public RecommendBookAdapter(@LayoutRes int layoutResId, @Nullable List<RecommendBookBean.BooksBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RecommendBookBean.BooksBean item) {
        helper.setText(R.id.tv_book_name, item.getTitle());
        new GlideImageLoader().getRequestManager(mContext)
                .load(Constants.IMG_BASE_URL + item.getCover()).into((ImageView) helper.getView(R.id.iv_book_cover));
    }
}
