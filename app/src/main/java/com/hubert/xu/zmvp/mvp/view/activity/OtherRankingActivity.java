package com.hubert.xu.zmvp.mvp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseActivity;
import com.hubert.xu.zmvp.entity.RankingBean;
import com.hubert.xu.zmvp.mvp.contract.RankingContract;
import com.hubert.xu.zmvp.mvp.presenter.RankingPresenter;
import com.hubert.xu.zmvp.mvp.view.adapter.RankingAdapter;

import java.util.List;

import butterknife.BindView;

public class OtherRankingActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, RankingContract.View<RankingBean> {

    private static final String INTENT_RANKING_ID = "INTENT_RANKING_ID";
    private static final String INTENT_RANKING_TITLE = "INTENT_RANKING_TITLE";
    @BindView(R.id.rv_other_ranking)
    RecyclerView mRvOtherRanking;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    private RankingPresenter mRankingPresenter;
    private String mRankingID;
    private List<RankingBean.RankingsBean.BooksBean> mBooks;
    private RankingAdapter mRankingAdapter;


    public static void startActivity(Context context, String rankindId, String title) {
        context.startActivity(new Intent(context, OtherRankingActivity.class)
                .putExtra(INTENT_RANKING_TITLE, title)
                .putExtra(INTENT_RANKING_ID, rankindId));
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_other_ranking;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        mRankingID = intent.getStringExtra(INTENT_RANKING_ID);
        String rankingTitle = intent.getStringExtra(INTENT_RANKING_TITLE);
        mTvTitle.setText(rankingTitle);
        mRankingPresenter = new RankingPresenter(this);
        mSwipeLayout.setOnRefreshListener(this);
        mRankingAdapter = new RankingAdapter(R.layout.item_ranking, mBooks);
        mRvOtherRanking.setLayoutManager(new LinearLayoutManager(this));
        mRvOtherRanking.setAdapter(mRankingAdapter);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        mSwipeLayout.setRefreshing(true);
        mRankingPresenter.getData(mRankingID);
    }

    @Override
    public void setData(RankingBean data) {
        mSwipeLayout.setRefreshing(false);
        mRankingAdapter.setNewData(data.getRanking().getBooks());
    }

    @Override
    public void showError() {
        mSwipeLayout.setRefreshing(false);
    }

    @Override
    public void complete() {

    }
}
