package com.hubert.xu.zmvp.mvp.view.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.entity.BookReviewListBean;
import com.hubert.xu.zmvp.utils.TimeFormatUtil;
import com.hubert.xu.zmvp.utils.imageload.GlideImageLoader;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/21
 * Desc  :
 */

public class BookReviewAdapter extends BaseQuickAdapter<BookReviewListBean.ReviewsBean, BaseViewHolder> {


    public BookReviewAdapter(@LayoutRes int layoutResId, @Nullable List<BookReviewListBean.ReviewsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BookReviewListBean.ReviewsBean item) {
        SpannableString spannableString = new SpannableString(item.getBook().getTitle() + "[" + Constants.bookTypeMap.get(item.getBook().getType()) + "]");
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(mContext, R.color.half_black)), item.getBook().getTitle().length(), spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        helper.setText(R.id.tv_book_name, spannableString);
        helper.setText(R.id.tv_review_title, item.getTitle());
        helper.setText(R.id.tv_helpful_count, item.getHelpful().getYes() + "");
        helper.setText(R.id.tv_helpless_count, item.getHelpful().getNo() + "");
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
        new GlideImageLoader()
                .getRequestManager(mContext)
                .load(Constants.IMG_BASE_URL + item.getBook().getCover())
                .into((ImageView) helper.getView(R.id.iv_book_cover));
    }
}
