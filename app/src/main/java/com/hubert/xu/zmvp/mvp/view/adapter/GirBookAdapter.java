package com.hubert.xu.zmvp.mvp.view.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.mvp.model.entity.GirlBookListBean;
import com.hubert.xu.zmvp.utils.TimeFormatUtil;
import com.hubert.xu.zmvp.utils.imageload.GlideImageLoader;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/21
 * Desc  :
 */

public class GirBookAdapter extends BaseQuickAdapter<GirlBookListBean.PostsBean, BaseViewHolder> {


    public GirBookAdapter(@LayoutRes int layoutResId, @Nullable List<GirlBookListBean.PostsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GirlBookListBean.PostsBean item) {
        SpannableString spannableString = new SpannableString(item.getAuthor().getNickname() + "lv." + item.getAuthor().getLv());
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(mContext, R.color.half_black)), item.getAuthor().getNickname().length(), spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        helper.setText(R.id.tv_user_name, spannableString)
                .setText(R.id.tv_discuss_content, item.getTitle())
                .setText(R.id.tv_comment_count, item.getCommentCount() + "")
                .setText(R.id.tv_like_count, item.getLikeCount() + "");
        if (TextUtils.equals("hot", item.getState())) {
            helper.setVisible(R.id.btn_type_hot, true);
            helper.setVisible(R.id.btn_type_fine, false);
            helper.setVisible(R.id.tv_updated_time, false);
        } else if (TextUtils.equals("distillate", item.getState())) {
            helper.setVisible(R.id.btn_type_hot, false);
            helper.setVisible(R.id.btn_type_fine, true);
            helper.setVisible(R.id.tv_updated_time, false);
        } else {
            helper.setVisible(R.id.btn_type_hot, false);
            helper.setVisible(R.id.btn_type_fine, false);
            helper.setVisible(R.id.tv_updated_time, true);
            helper.setText(R.id.tv_updated_time, TimeFormatUtil.formatTime(item.getUpdated()));
        }
        new GlideImageLoader().getRequestManager(mContext).load(Constants.IMG_BASE_URL + item.getAuthor().getAvatar()).into((CircleImageView) helper.getView(R.id.cv_avatar));

    }
}
