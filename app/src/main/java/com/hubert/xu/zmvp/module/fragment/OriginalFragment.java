package com.hubert.xu.zmvp.module.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseFragment;
import com.hubert.xu.zmvp.entity.DiscussBean;
import com.hubert.xu.zmvp.module.adapter.DiscussAdapter;
import com.hubert.xu.zmvp.module.contract.OriginalContract;
import com.hubert.xu.zmvp.module.presenter.OriginalPresenter;

import java.util.List;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/17
 * Desc  :
 */

public class OriginalFragment extends BaseFragment implements OriginalContract.View<DiscussBean>, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.rv_original)
    RecyclerView mRvOriginal;
    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout mSwipeLayout;

    private OriginalPresenter mPresenter;
    private List<DiscussBean.PostsBean> mData;
    private DiscussAdapter mDiscussAdapter;
    private int start;

    public static OriginalFragment newInstance() {
        Bundle args = new Bundle();
        OriginalFragment fragment = new OriginalFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_original;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        mSwipeLayout.setOnRefreshListener(this);
        mPresenter = new OriginalPresenter(this);
        mRvOriginal.setLayoutManager(new LinearLayoutManager(mContext));
        mDiscussAdapter = new DiscussAdapter(R.layout.item_discuss, mData);
        mRvOriginal.setAdapter(mDiscussAdapter);
        mDiscussAdapter.setOnLoadMoreListener(this);
        mDiscussAdapter.openLoadAnimation();
        onRefresh();
    }


    @Override
    public void setPresenter(Object presenter) {

    }

    @Override
    public void showError() {
        mSwipeLayout.setRefreshing(false);
        mDiscussAdapter.loadMoreFail();
    }

    @Override
    public void complete() {
        mSwipeLayout.setRefreshing(false);
        mDiscussAdapter.setEnableLoadMore(false);
    }


    @Override
    public void onRefresh() {
        mSwipeLayout.setRefreshing(true);
        mPresenter.getData(0);
    }

    @Override
    public void onLoadMoreRequested() {
        mSwipeLayout.setEnabled(false);
        mPresenter.getData(start);
    }

    @Override
    public void setData(DiscussBean data, boolean isRefresh) {
        List<DiscussBean.PostsBean> list = data.getPosts();
        if (isRefresh) {
            if (mData != null) mData.clear();
            mData = list;
            start = 0;
        } else {
            mData.addAll(list);
        }
        mDiscussAdapter.setNewData(mData);
        mSwipeLayout.setRefreshing(false);
        mSwipeLayout.setEnabled(true);
        mDiscussAdapter.setEnableLoadMore(true);
        start = start + list.size();
    }
}
