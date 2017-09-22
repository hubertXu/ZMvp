package com.hubert.xu.zmvp.mvp.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseFragment;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.entity.DiscussListBean;
import com.hubert.xu.zmvp.mvp.contract.OriginalContract;
import com.hubert.xu.zmvp.mvp.view.activity.ComplexDiscussActivity;
import com.hubert.xu.zmvp.mvp.view.adapter.DiscussAdapter;
import com.hubert.xu.zmvp.mvp.presenter.OriginalPresenter;

import java.util.List;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/17
 * Desc  :
 */

public class OriginalFragment extends BaseFragment implements OriginalContract.View<DiscussListBean>, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.rv_original)
    RecyclerView mRvOriginal;
    @BindView(R.id.swipe_original)
    SwipeRefreshLayout mSwipeOriginal;

    private OriginalPresenter mPresenter;
    private List<DiscussListBean.PostsBean> mData;
    private DiscussAdapter mDiscussAdapter;
    private int start;
    private ComplexDiscussActivity mDiscussActivity;
    private String mSortType = Constants.TYPE_SORT_DEFAULT;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mDiscussActivity = (ComplexDiscussActivity) activity;
    }

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
        mSwipeOriginal.setOnRefreshListener(this);
        mPresenter = new OriginalPresenter(this);
        mRvOriginal.setLayoutManager(new LinearLayoutManager(mContext));
        mDiscussAdapter = new DiscussAdapter(R.layout.item_original_discuss, mData);
        mRvOriginal.setAdapter(mDiscussAdapter);
        mDiscussAdapter.setOnLoadMoreListener(this);
        mDiscussAdapter.openLoadAnimation();
        onRefresh();
        mDiscussActivity.setDiscussSortLisenter(sortType -> {
            mSortType = sortType;
            start = 0;
            onRefresh();
        });
    }


    @Override
    public void showError() {
        mSwipeOriginal.setRefreshing(false);
        mDiscussAdapter.loadMoreFail();
    }

    @Override
    public void complete() {
        mSwipeOriginal.setRefreshing(false);
        mDiscussAdapter.setEnableLoadMore(false);
    }


    @Override
    public void onRefresh() {
        mSwipeOriginal.setRefreshing(true);
        start = 0;
        mPresenter.getData(start, mSortType);
    }

    @Override
    public void onLoadMoreRequested() {
        mSwipeOriginal.setEnabled(false);
        mPresenter.getData(start, mSortType);
    }

    @Override
    public void setData(DiscussListBean data, boolean isRefresh) {
        List<DiscussListBean.PostsBean> list = data.getPosts();
        if (isRefresh) {
            if (mData != null) mData.clear();
            mData = list;
            mRvOriginal.scrollToPosition(0);
        } else {
            mData.addAll(list);
        }
        mDiscussAdapter.setNewData(mData);
        mSwipeOriginal.setRefreshing(false);
        mSwipeOriginal.setEnabled(true);
        mDiscussAdapter.setEnableLoadMore(true);
        start = start + list.size();
    }
}
