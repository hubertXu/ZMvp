package com.hubert.xu.zmvp.mvp.view.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseActivity;
import com.hubert.xu.zmvp.entity.AllRankTypeBean;
import com.hubert.xu.zmvp.mvp.contract.AllRankTypeContract;
import com.hubert.xu.zmvp.mvp.presenter.AllRankTypePresenter;
import com.hubert.xu.zmvp.mvp.view.adapter.RankingFemaleAdapter;
import com.hubert.xu.zmvp.mvp.view.adapter.RankingMaleAdapter;

import java.util.List;

import butterknife.BindView;

public class AllRankingTypeActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, AllRankTypeContract.View<AllRankTypeBean> {

    @BindView(R.id.rv_ranking_male)
    RecyclerView mRvRankingMale;
    @BindView(R.id.rv_ranking_female)
    RecyclerView mRvRankingFemale;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.llt_ranking_content)
    LinearLayout mLltRankingContent;
    private List<AllRankTypeBean.MaleBean> mMaleList;
    private List<AllRankTypeBean.FemaleBean> mFemaleList;
    private RankingMaleAdapter mRankingMaleAdapter;
    private RankingFemaleAdapter mRankingFemaleAdapter;
    private AllRankTypePresenter mAllRankTypePresenter;


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
        mRvRankingMale.setLayoutManager(new GridLayoutManager(this, 3));
        mRvRankingFemale.setLayoutManager(new GridLayoutManager(this, 3));
        mRankingMaleAdapter = new RankingMaleAdapter(mMaleList, this);
        mRankingFemaleAdapter = new RankingFemaleAdapter(mFemaleList, this);
        mRvRankingMale.setAdapter(mRankingMaleAdapter);
        mRvRankingFemale.setAdapter(mRankingFemaleAdapter);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        onRefresh();
    }

    @Override
    public void setData(AllRankTypeBean data) {
        mRankingFemaleAdapter.setFemaleList(data.getFemale());
        mRankingMaleAdapter.setMaleList(data.getMale());
        mSwipeRefreshLayout.setRefreshing(false);
        mLltRankingContent.setVisibility(View.VISIBLE);
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
