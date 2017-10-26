package com.hubert.xu.zmvp.mvp.view.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseFragment;
import com.hubert.xu.zmvp.mvp.contract.CommunityDiscussContract;
import com.hubert.xu.zmvp.mvp.model.entity.DiscussListBean;
import com.hubert.xu.zmvp.mvp.presenter.CommunityDiscussPresenter;
import com.hubert.xu.zmvp.mvp.view.activity.BookCommunityActivity;
import com.hubert.xu.zmvp.mvp.view.adapter.ComplexDiscussAdapter;
import com.hubert.xu.zmvp.mvp.view.lisenter.DiscussSortLisenter;

import java.util.List;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/10/25
 * Desc  :
 */

public class CommunityDiscussFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, CommunityDiscussContract.View<DiscussListBean>, BaseQuickAdapter.RequestLoadMoreListener, DiscussSortLisenter {

    private static final String ARGS_BOOK_ID = "args_book_id";
    @BindView(R.id.rv_community_discuss)
    RecyclerView mRvCommunityDiscuss;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    private List<DiscussListBean.PostsBean> mDiscussList;
    private ComplexDiscussAdapter mAdapter;
    private CommunityDiscussPresenter mPresenter;
    private String mBookId;
    private int mStart;
    private String mSort = "updated";

    public static CommunityDiscussFragment newInstance(String bookId) {

        Bundle args = new Bundle();
        args.putString(ARGS_BOOK_ID, bookId);
        CommunityDiscussFragment fragment = new CommunityDiscussFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_community_discuss;
    }

    @Override
    public void initView() {
        mBookId = getArguments().getString(ARGS_BOOK_ID);
        mPresenter = new CommunityDiscussPresenter(this);
        mRvCommunityDiscuss.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new ComplexDiscussAdapter(R.layout.item_complex_discuss, mDiscussList);
        mRvCommunityDiscuss.setAdapter(mAdapter);
        mAdapter.setOnLoadMoreListener(this, mRvCommunityDiscuss);
        mSwipeLayout.setOnRefreshListener(this);
        BookCommunityActivity activity = (BookCommunityActivity) getActivity();
        activity.addDiscussSortLisenter(this);
        mAdapter.disableLoadMoreIfNotFullPage(mRvCommunityDiscuss);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        mSwipeLayout.setRefreshing(true);
        mStart = 0;
        mPresenter.getData(mBookId, mSort, mStart);
    }


    @Override
    public void setData(DiscussListBean data) {
        mSwipeLayout.setRefreshing(false);
        mAdapter.loadMoreComplete();
        if (mStart == 0) {
            mDiscussList = data.getPosts();
        } else {
            mDiscussList.addAll(data.getPosts());
        }
        mAdapter.setNewData(mDiscussList);
        mStart = mStart + data.getPosts().size();
        mAdapter.setEnableLoadMore(data.getPosts() != null && data.getPosts().size() >= 20);
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
        if (mAdapter.isLoadMoreEnable()) {
            mPresenter.getData(mBookId, mSort, mStart);
        }
    }

    @Override
    public void refreshDiscussData(String sortType) {
        mSort = sortType;
        onRefresh();
    }
}
