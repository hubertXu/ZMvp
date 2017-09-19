package com.hubert.xu.zmvp.module.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.entity.DiscussBean;
import com.hubert.xu.zmvp.utils.imageload.GlideImageLoader;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/15
 * Desc  :
 */

public class DiscussAdapter extends BaseQuickAdapter<DiscussBean.PostsBean, BaseViewHolder> {

    public DiscussAdapter(int layout, List<DiscussBean.PostsBean> data) {
        super(layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DiscussBean.PostsBean item) {
        helper.setText(R.id.tv_user_name, item.getAuthor().getNickname())
                .setText(R.id.tv_discuss_content, item.getTitle())
                .setText(R.id.tv_last_updated, item.getUpdated())
                .setText(R.id.tv_comment_count, item.getCommentCount() + "")
                .setText(R.id.tv_like_count, item.getLikeCount() + "");
        new GlideImageLoader().getRequestManager(mContext).load(Constants.API_BASE_URL + item.getAuthor().getAvatar()).into((CircleImageView) helper.getView(R.id.cv_avatar));
    }
}
