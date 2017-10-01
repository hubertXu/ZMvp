package com.hubert.xu.zmvp.mvp.view.adapter;

import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.entity.DiscussListBean;
import com.hubert.xu.zmvp.utils.TimeFormatUtil;
import com.hubert.xu.zmvp.utils.imageload.GlideImageLoader;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/15
 * Desc  :
 */

public class ComplexDiscussAdapter extends BaseQuickAdapter<DiscussListBean.PostsBean, BaseViewHolder> {

    public ComplexDiscussAdapter(int layout, List<DiscussListBean.PostsBean> data) {
        super(layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DiscussListBean.PostsBean item) {
        helper.setText(R.id.tv_user_name, item.getAuthor().getNickname())
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
