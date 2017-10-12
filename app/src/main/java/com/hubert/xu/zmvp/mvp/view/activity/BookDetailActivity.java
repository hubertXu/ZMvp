package com.hubert.xu.zmvp.mvp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseActivity;
import com.hubert.xu.zmvp.mvp.contract.BookDetailContract;
import com.hubert.xu.zmvp.mvp.model.entity.LocalBookdetailBean;
import com.hubert.xu.zmvp.mvp.model.entity.RecommendBookListBean;
import com.hubert.xu.zmvp.mvp.presenter.BookDetailPresenter;
import com.hubert.xu.zmvp.mvp.view.adapter.RecommendBookListAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/10/12
 * Desc  :
 */

public class BookDetailActivity extends BaseActivity implements BookDetailContract.View, SwipeRefreshLayout.OnRefreshListener {

    private static final String INTENT_BOOK_NAME = "intent_book_name";
    private static final String INTENT_BOOK_ID = "intent_book_id";
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    @BindView(R.id.rv_book_detail)
    RecyclerView mRvBookDetail;
    private String mBookId;
    private BookDetailPresenter mPresenter;
    private RecommendBookListAdapter mHotReviewAdapter;
    private List<RecommendBookListBean.BooklistsBean> mBookLists;
    private TextView mTv_bbb;
    private TextView mTv_ccc;
    private TextView mTv_ddd;
    private TextView mTv_eee;

    public static void startActivity(Context context, String bookName, String bookId) {
        context.startActivity(new Intent(context, BookDetailActivity.class)
                .putExtra(INTENT_BOOK_NAME, bookName)
                .putExtra(INTENT_BOOK_ID, bookId));
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_book_detail;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTvTitle.setText(getIntent().getStringExtra(INTENT_BOOK_NAME));
        mBookId = getIntent().getStringExtra(INTENT_BOOK_ID);
        mPresenter = new BookDetailPresenter(this);
        mRvBookDetail.setLayoutManager(new LinearLayoutManager(this));
        mHotReviewAdapter = new RecommendBookListAdapter(R.layout.item_reccomend_book_list, mBookLists);
        View headerBookDetail = getLayoutInflater().inflate(R.layout.header_book_detail, mRvBookDetail, false);
        View headerHotReview = getLayoutInflater().inflate(R.layout.header_hot_review, mRvBookDetail, false);
        View headerHotReviewSign = getLayoutInflater().inflate(R.layout.header_hot_review_sign, mRvBookDetail, false);
        View headerRecommendBook = getLayoutInflater().inflate(R.layout.header_recommend_book, mRvBookDetail, false);
        mRvBookDetail.setAdapter(mHotReviewAdapter);
        mHotReviewAdapter.addHeaderView(headerBookDetail, 0);
        mHotReviewAdapter.addHeaderView(headerHotReview, 1);
        mHotReviewAdapter.addHeaderView(headerHotReviewSign, 3);
        mHotReviewAdapter.addHeaderView(headerRecommendBook, 4);
        mSwipeLayout.setOnRefreshListener(this);
        onRefresh();
    }

    @Override
    public void setData(LocalBookdetailBean data) {
        mBookLists = data.getBookList().getBooklists();
        mHotReviewAdapter.setNewData(data.getBookList().getBooklists());
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }

    @Override
    public void onRefresh() {
        mPresenter.getData(mBookId);
    }
}
