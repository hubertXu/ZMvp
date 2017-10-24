package com.hubert.xu.zmvp.mvp.view.adapter;


import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.mvp.model.entity.CommentListBean;
import com.hubert.xu.zmvp.utils.imageload.GlideImageLoader;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * author: XQ
 * time  : 2017/10/22
 * desc  :
 */

public class ComementListAdapter extends BaseQuickAdapter<CommentListBean.CommentsBean, BaseViewHolder> {

    public ComementListAdapter(@LayoutRes int layoutResId, @Nullable List<CommentListBean.CommentsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommentListBean.CommentsBean item) {
        String userNameInfo = item.getFloor() + "楼" +" "+ item.getAuthor().getNickname() + "lv" + item.getAuthor().getLv();
        SpannableString strUserNameInfo = new SpannableString(userNameInfo);
        strUserNameInfo.setSpan(new ForegroundColorSpan(ContextCompat.getColor(mContext, R.color.brown)), (item.getFloor() + "楼").length(), userNameInfo.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        strUserNameInfo.setSpan(new RelativeSizeSpan(0.8f), 0, (item.getFloor() + "楼").length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        strUserNameInfo.setSpan(new RelativeSizeSpan(0.8f), (item.getFloor() + "楼 "+ item.getAuthor().getNickname()).length(),strUserNameInfo.length() , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        helper.setText(R.id.tv_user_name, strUserNameInfo)
                .setText(R.id.tv_comment_time, item.getLikeCount() + "次同感")
                .setText(R.id.tv_comment, item.getContent());
        new GlideImageLoader().getRequestManager(mContext).load(Constants.IMG_BASE_URL + item.getAuthor().getAvatar()).into((CircleImageView) helper.getView(R.id.iv_user_avatar));
    }
}
