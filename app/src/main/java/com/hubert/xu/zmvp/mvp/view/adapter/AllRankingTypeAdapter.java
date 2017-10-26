package com.hubert.xu.zmvp.mvp.view.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.util.MultiTypeDelegate;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.mvp.model.entity.LocalAllRankingTypeBean;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/10/9
 * Desc  :
 */

public class AllRankingTypeAdapter extends BaseQuickAdapter<LocalAllRankingTypeBean.RankingBean, BaseViewHolder> {

    public AllRankingTypeAdapter(@LayoutRes int layoutResId, @Nullable List<LocalAllRankingTypeBean.RankingBean> data) {
        super(layoutResId, data);
    }

    public AllRankingTypeAdapter(List<LocalAllRankingTypeBean.RankingBean> ranking) {
        super(ranking);
        setMultiTypeDelegate(new MultiTypeDelegate<LocalAllRankingTypeBean.RankingBean>() {
            @Override
            protected int getItemType(LocalAllRankingTypeBean.RankingBean ranking) {
                return ranking.getSign();
            }
        });
        getMultiTypeDelegate().registerItemType(Constants.BOOK_TYPE_SIGN, R.layout.item_book_classify_sign).registerItemType(Constants.BOOK_TYPE_NAME, R.layout.item_book_ranking_name);
    }

    @Override
    protected void convert(BaseViewHolder helper, LocalAllRankingTypeBean.RankingBean item) {
        switch (helper.getItemViewType()) {
            case Constants.BOOK_TYPE_NAME:
                helper.setText(R.id.tv_book_classify_name, item.getTitle().replace("Top100", ""));
                break;
            case Constants.BOOK_TYPE_SIGN:
                helper.setText(R.id.tv_book_sign, item.getTitle());
                break;
            default:
                break;
        }
    }
}
