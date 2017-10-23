package com.hubert.xu.zmvp.mvp.view.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.mvp.model.entity.RecommendBookListBean;
import com.hubert.xu.zmvp.utils.imageload.GlideImageLoader;

import java.util.List;

/**
 * author: XQ
 * time  : 2017/10/17
 * desc  :
 */

public class RecommendBookListAdapter extends BaseQuickAdapter<RecommendBookListBean.BooklistsBean, BaseViewHolder> {

    public RecommendBookListAdapter(@LayoutRes int layoutResId, @Nullable List<RecommendBookListBean.BooklistsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RecommendBookListBean.BooklistsBean item) {
        helper.setText(R.id.tv_book_list_name, item.getTitle());
        new GlideImageLoader().getRequestManager(mContext)
                .load(Constants.IMG_BASE_URL + item.getCover()).into((ImageView) helper.getView(R.id.iv_book_list_cover));
    }
}
