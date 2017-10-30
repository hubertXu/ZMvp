package com.hubert.xu.zmvp.mvp.view.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseFragment;
import com.hubert.xu.zmvp.mvp.contract.CommunityCommentContract;
import com.hubert.xu.zmvp.mvp.model.entity.HotReviewBean;
import com.hubert.xu.zmvp.mvp.presenter.CommunityCommentPresenter;
import com.hubert.xu.zmvp.mvp.view.activity.BookCommunityActivity;
import com.hubert.xu.zmvp.mvp.view.adapter.CommunityCommentAdapter;
import com.hubert.xu.zmvp.mvp.view.lisenter.DiscussSortLisenter;

import java.util.List;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/10/25
 * Desc  :
 */

public class CommunityCommentFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, CommunityCommentContract.View<HotReviewBean>, BaseQuickAdapter.RequestLoadMoreListener, DiscussSortLisenter {

    private static final String ARGS_BOOK_ID = "args_book_id";
    @BindView(R.id.rv_community_comment)
    RecyclerView mRvCommunityComment;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    private CommunityCommentAdapter mAdapter;
    private CommunityCommentPresenter mPresenter;
    private String mBookId;
    private int mStart;
    private String mSort = "updated";
    private List<HotReviewBean.ReviewsBean> mReviews;

    public static CommunityCommentFragment newInstance(String bookId) {

        Bundle args = new Bundle();
        args.putString(ARGS_BOOK_ID, bookId);
        CommunityCommentFragment fragment = new CommunityCommentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_community_comment;
    }

    @Override
    public void initView() {
        mBookId = getArguments().getString(ARGS_BOOK_ID);
        mPresenter = new CommunityCommentPresenter(this);
        mRvCommunityComment.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new CommunityCommentAdapter(R.layout.item_community_comment, mReviews);
        mRvCommunityComment.setAdapter(mAdapter);
        mAdapter.setOnLoadMoreListener(this,mRvCommunityComment);
        mSwipeLayout.setOnRefreshListener(this);
        BookCommunityActivity activity = (BookCommunityActivity) getActivity();
        activity.addDiscussSortLisenter(this);
        mAdapter.disableLoadMoreIfNotFullPage(mRvCommunityComment);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        mSwipeLayout.setRefreshing(true);
        mStart = 0;
        mRvCommunityComment.scrollToPosition(0);
        mPresenter.getData(mBookId, mSort, mStart);
    }


    @Override
    public void setData(HotReviewBean data) {
        mSwipeLayout.setRefreshing(false);
        mAdapter.loadMoreComplete();
        if (mStart == 0) {
            mReviews = data.getReviews();
        } else {
            mReviews.addAll(data.getReviews());
        }
        mAdapter.setNewData(mReviews);
        mStart = mStart + data.getReviews().size();
        mAdapter.setEnableLoadMore(data.getReviews() != null && data.getReviews().size() >= 20);
    }

    @Override
    public void showError() {
        mSwipeLayout.setRefreshing(false);
        mAdapter.loadMoreFail();
    }

    @Override
    public void complete() {

    }

    @Override
    public void onLoadMoreRequested() {
        mPresenter.getData(mBookId, mSort, mStart);
    }

    @Override
    public void refreshDiscussData(String sortType) {
        mSort = sortType;
        onRefresh();
    }
}
