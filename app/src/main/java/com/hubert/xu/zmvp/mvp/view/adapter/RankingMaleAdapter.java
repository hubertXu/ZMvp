package com.hubert.xu.zmvp.mvp.view.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.entity.AllRankTypeBean;
import com.hubert.xu.zmvp.mvp.view.activity.AllRankingTypeActivity;
import com.hubert.xu.zmvp.mvp.view.activity.RankingActivity;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/27
 * Desc  :
 */

public class RankingMaleAdapter extends RecyclerView.Adapter {


    private List<AllRankTypeBean.MaleBean> mMaleList;
    private AllRankingTypeActivity mMContext;

    public RankingMaleAdapter(List<AllRankTypeBean.MaleBean> maleList, AllRankingTypeActivity mContext) {
        mMaleList = maleList;
        mMContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MViewHolder(LayoutInflater.from(mMContext).inflate(R.layout.item_ranking_type, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MViewHolder mViewHolder = (MViewHolder) holder;
        AllRankTypeBean.MaleBean maleBean = mMaleList.get(position);
        mViewHolder.mTvRankingType.setText(maleBean.getTitle().replace("Top100",""));
        mViewHolder.mCardContent.setOnClickListener(v -> {
            RankingActivity.startActivity(mMContext, "", maleBean.getMonthRank(), maleBean.getTotalRank(), maleBean.getTitle().replace("Top100",""));
        });
    }

    @Override
    public int getItemCount() {
        return mMaleList == null ? 0 : mMaleList.size();
    }

    public void setMaleList(List<AllRankTypeBean.MaleBean> maleList) {
        mMaleList = maleList;
        notifyDataSetChanged();
    }

    class MViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvRankingType;
        private CardView mCardContent;

        public MViewHolder(View itemView) {
            super(itemView);
            mTvRankingType = (TextView) itemView.findViewById(R.id.tv_ranking_type);
            mCardContent = (CardView) itemView.findViewById(R.id.card_view);
        }
    }
}
