package com.hubert.xu.zmvp.mvp.view.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseActivity;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.entity.LocalAllRankingTypeBean;
import com.hubert.xu.zmvp.mvp.contract.AllRankTypeContract;
import com.hubert.xu.zmvp.mvp.presenter.AllRankTypePresenter;
import com.hubert.xu.zmvp.mvp.view.adapter.ALlRankingTypeAdapter;

import butterknife.BindView;

public class AllRankingTypeActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, AllRankTypeContract.View<LocalAllRankingTypeBean> {


    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.rv_all_ranking)
    RecyclerView mRvAllRanking;
    private AllRankTypePresenter mAllRankTypePresenter;
    private ALlRankingTypeAdapter mAdapter;


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_all_ranking_type;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mAllRankTypePresenter = new AllRankTypePresenter(this);
        mRvAllRanking.setLayoutManager(new GridLayoutManager(this, 3));
        mSwipeRefreshLayout.setOnRefreshListener(this);
        onRefresh();
    }

    @Override
    public void setData(LocalAllRankingTypeBean data) {
        mSwipeRefreshLayout.setRefreshing(false);
        if (data == null || data.getRanking() == null || data.getRanking().size() == 0) {
            mAdapter.loadMoreComplete();
        } else {
            if (mAdapter == null) {
                mAdapter = new ALlRankingTypeAdapter(data.getRanking());
                mAdapter.setSpanSizeLookup((gridLayoutManager, position) -> data.getRanking().get(position).getSign() == Constants.BOOK_TYPE_SIGN ? 3 : 1);
                mRvAllRanking.setAdapter(mAdapter);
                mAdapter.setOnItemClickListener((adapter, view, position) -> {
                    LocalAllRankingTypeBean.RankingBean ranking = data.getRanking().get(position);
                    if (ranking.isCollapse()) {
                        OtherRankingActivity.startActivity(AllRankingTypeActivity.this, ranking.get_id(), ranking.getTitle());
                    } else {
                        RankingActivity.startActivity(AllRankingTypeActivity.this, ranking.get_id(), ranking.getMonthRank(), ranking.getTotalRank(), ranking.getTitle().replace("Top100", ""));
                    }
                });
            }
            mAdapter.setNewData(data.getRanking());
        }
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }

    @Override
    public void onRefresh() {
        mSwipeRefreshLayout.setRefreshing(true);
        mAllRankTypePresenter.getData();
    }
}
