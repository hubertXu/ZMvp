package com.hubert.xu.zmvp.mvp.view.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.mvp.model.entity.HotReviewBean;
import com.hubert.xu.zmvp.utils.TimeFormatUtil;
import com.hubert.xu.zmvp.utils.imageload.GlideImageLoader;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/10/25
 * Desc  :
 */

public class CommunityCommentAdapter extends BaseQuickAdapter<HotReviewBean.ReviewsBean, BaseViewHolder> {

    public CommunityCommentAdapter(@LayoutRes int layoutResId, @Nullable List<HotReviewBean.ReviewsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HotReviewBean.ReviewsBean item) {
        helper.setText(R.id.tv_user_name, item.getAuthor().getNickname() + "lv" + item.getAuthor().getLv())
                .setText(R.id.tv_comment_title, item.getTitle())
                .setText(R.id.tv_comment_content, item.getContent())
                .setText(R.id.tv_comment_time, TimeFormatUtil.formatTime(item.getCreated()))
                .setText(R.id.tv_comment_time, item.getHelpful().getYes() + "有用");
        helper.setVisible(R.id.tv_fine, item.getState().toString().endsWith("distillate"));
        helper.setRating(R.id.ratingBar_book, Float.valueOf(String.valueOf(item.getRating())));
        new GlideImageLoader().getRequestManager(mContext).load(Constants.IMG_BASE_URL + item.getAuthor().getAvatar()).into((CircleImageView) helper.getView(R.id.iv_user_avatar));
    }
}
