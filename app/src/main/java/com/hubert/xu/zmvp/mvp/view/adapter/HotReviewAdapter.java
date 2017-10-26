package com.hubert.xu.zmvp.mvp.view.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.RatingBar;

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
 * author: XQ
 * time  : 2017/10/15
 * desc  :
 */

public class HotReviewAdapter extends BaseQuickAdapter<HotReviewBean.ReviewsBean, BaseViewHolder> {


    public HotReviewAdapter(@LayoutRes int layoutResId, @Nullable List<HotReviewBean.ReviewsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HotReviewBean.ReviewsBean item) {
        helper.setText(R.id.tv_user_name, item.getAuthor().getNickname() + "  Lv" + item.getAuthor().getLv());
        helper.setText(R.id.tv_review, item.getContent());
        helper.setText(R.id.tv_review_time, TimeFormatUtil.formatTime(item.getUpdated()));
        helper.setText(R.id.tv_praise_count, item.getLikeCount() + "");
        RatingBar ratingBar = helper.getView(R.id.ratingBar_frome_user);
        ratingBar.setMax(5);
        ratingBar.setRating(item.getRating());
        new GlideImageLoader().getRequestManager(mContext).load(Constants.IMG_BASE_URL + item.getAuthor().getAvatar())
                .into((CircleImageView) helper.getView(R.id.iv_user_avatar));
    }
}
