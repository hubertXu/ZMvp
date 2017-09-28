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

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/27
 * Desc  :
 */

public class RankingFemaleAdapter extends RecyclerView.Adapter {


    private List<AllRankTypeBean.FemaleBean> mFemaleList;
    private AllRankingTypeActivity mMContext;

    public RankingFemaleAdapter(List<AllRankTypeBean.FemaleBean> femaleList, AllRankingTypeActivity mContext) {
        mFemaleList = femaleList;
        mMContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MViewHolder(LayoutInflater.from(mMContext).inflate(R.layout.item_ranking_type, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MViewHolder mViewHolder = (MViewHolder) holder;
        mViewHolder.mTvRankingType.setText(mFemaleList.get(position).getTitle().replace("Top100",""));
        mViewHolder.mCardContent.setOnClickListener(v -> {

        });
    }

    @Override
    public int getItemCount() {
        return mFemaleList == null ? 0 : mFemaleList.size();
    }

    public void setFemaleList(List<AllRankTypeBean.FemaleBean> femaleList) {
        mFemaleList = femaleList;
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
