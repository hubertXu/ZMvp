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
import com.hubert.xu.zmvp.mvp.contract.FineContract;
import com.hubert.xu.zmvp.mvp.presenter.FinePresenter;
import com.hubert.xu.zmvp.mvp.view.activity.ComplexDiscussActivity;
import com.hubert.xu.zmvp.mvp.view.adapter.FineDiscussAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/17
 * Desc  :
 */

public class FineFragment extends BaseFragment implements FineContract.View<DiscussListBean>, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {


    @BindView(R.id.rv_fine_discuss)
    RecyclerView mRvFineDiscuss;
    @BindView(R.id.swipe_fine)
    SwipeRefreshLayout mSwipeFine;
    private List<DiscussListBean.PostsBean> mData;
    private FinePresenter mFinePresenter;
    private ComplexDiscussActivity mDiscussActivity;
    private String sortType = Constants.TYPE_SORT_DEFAULT;
    private FineDiscussAdapter mFineDiscussAdapter;
    private int start = 0;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mDiscussActivity = (ComplexDiscussActivity) activity;
    }

    public static FineFragment newInstance() {
        Bundle args = new Bundle();
        FineFragment fragment = new FineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_fine;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        mFinePresenter = new FinePresenter(this);
        mRvFineDiscuss.setLayoutManager(new LinearLayoutManager(mContext));
        mFineDiscussAdapter = new FineDiscussAdapter(R.layout.item_fine_discuss, mData);
        mRvFineDiscuss.setAdapter(mFineDiscussAdapter);
        mSwipeFine.setOnRefreshListener(this);
        mFineDiscussAdapter.setOnLoadMoreListener(this);
        mDiscussActivity.setDiscussSortLisenter(sortType -> {
            this.sortType = sortType;
            start = 0;
            onRefresh();
        });
        onRefresh();
    }

    @Override
    public void onRefresh() {
        mSwipeFine.setRefreshing(true);
        mFinePresenter.getData(start, sortType);
    }

    @Override
    public void setData(DiscussListBean data, boolean isRefresh) {
        List<DiscussListBean.PostsBean> list = data.getPosts();
        if (isRefresh) {
            if (mData != null) mData.clear();
            mData = list;
            start = 0;
            mRvFineDiscuss.scrollToPosition(0);
        } else {
            mData.addAll(list);
        }
        mFineDiscussAdapter.setNewData(mData);
        mSwipeFine.setRefreshing(false);
        mSwipeFine.setEnabled(true);
        mFineDiscussAdapter.setEnableLoadMore(true);
        start = start + list.size();
    }

    @Override
    public void showError() {
        mSwipeFine.setRefreshing(false);
        mFineDiscussAdapter.loadMoreFail();
    }

    @Override
    public void complete() {

    }

    @Override
    public void onLoadMoreRequested() {
        mSwipeFine.setEnabled(false);
        mFinePresenter.getData(start, sortType);
    }
}
