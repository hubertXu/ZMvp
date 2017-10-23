package com.hubert.xu.zmvp.mvp.view.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.mvp.model.entity.DiscussListBean;
import com.hubert.xu.zmvp.utils.imageload.GlideImageLoader;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/21
 * Desc  :
 */

public class FineDiscussAdapter extends BaseQuickAdapter<DiscussListBean.PostsBean, BaseViewHolder> {

    public FineDiscussAdapter(@LayoutRes int layoutResId, @Nullable List<DiscussListBean.PostsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DiscussListBean.PostsBean item) {
        helper.setText(R.id.tv_user_name, item.getAuthor().getNickname())
                .setText(R.id.tv_discuss_content, item.getTitle())
                .setText(R.id.tv_comment_count, item.getCommentCount() + "")
                .setText(R.id.tv_comment_time, item.getLikeCount() + "");
        new GlideImageLoader().getRequestManager(mContext).load(Constants.API_BASE_URL + item.getAuthor().getAvatar()).into((CircleImageView) helper.getView(R.id.cv_avatar));

    }
}
