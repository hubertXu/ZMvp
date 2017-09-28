package com.hubert.xu.zmvp.mvp.view.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseFragment;
import com.hubert.xu.zmvp.entity.RankingBean;
import com.hubert.xu.zmvp.mvp.contract.RankingContract;
import com.hubert.xu.zmvp.mvp.presenter.RankingPresenter;
import com.hubert.xu.zmvp.mvp.view.adapter.RankingAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/28
 * Desc  :
 */

public class RankingFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, RankingContract.View<RankingBean> {

    @BindView(R.id.rv_ranking)
    RecyclerView mRvRanking;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    public final static String BUNDLE_ID = "rankingId";
    private List<RankingBean.BooksBean> mBooks;
    private RankingAdapter mRankingAdapter;
    private RankingPresenter mRankingPresenter;
    private String mRankingId;


    public static RankingFragment newInstance(String rankingId) {
        Bundle args = new Bundle();
        args.putString(BUNDLE_ID, rankingId);
        RankingFragment fragment = new RankingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fagment_ranking;
    }

    @Override
    public void initView() {
        mRankingId = getArguments().getString(BUNDLE_ID);
        mRvRanking.setLayoutManager(new LinearLayoutManager(mContext));
        mRankingPresenter = new RankingPresenter(this);
        mRankingAdapter = new RankingAdapter(R.layout.item_complex_discuss, mBooks);
        mRvRanking.setAdapter(mRankingAdapter);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        mSwipeLayout.setRefreshing(true);
        mRankingPresenter.getData(mRankingId);
    }

    @Override
    public void setData(RankingBean data) {
        mSwipeLayout.setRefreshing(false);
        mRankingAdapter.setNewData(data.getBooks());
    }

    @Override
    public void showError() {
        mSwipeLayout.setRefreshing(false);
    }

    @Override
    public void complete() {

    }
}
