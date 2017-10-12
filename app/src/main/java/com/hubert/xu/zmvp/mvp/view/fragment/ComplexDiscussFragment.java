package com.hubert.xu.zmvp.mvp.view.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseFragment;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.mvp.model.entity.DiscussListBean;
import com.hubert.xu.zmvp.mvp.contract.ComplexDiscussContract;
import com.hubert.xu.zmvp.mvp.presenter.ComplexDiscussPresenter;
import com.hubert.xu.zmvp.mvp.view.adapter.ComplexDiscussAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/25
 * Desc  :
 */

public class ComplexDiscussFragment extends BaseFragment implements ComplexDiscussContract.View<DiscussListBean>, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rv_complex_discuss)
    RecyclerView mRvComplexDiscuss;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    private List<DiscussListBean.PostsBean> mData;
    private ComplexDiscussAdapter mComplexDiscussAdapter;
    private ComplexDiscussPresenter mComplexDiscussPresenter;
    private int start;
    private String mSortType = Constants.TYPE_SORT_DEFAULT;

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_complex_discuss;
    }

    @Override
    public void initView() {
        mComplexDiscussPresenter = new ComplexDiscussPresenter(this);
        mRvComplexDiscuss.setLayoutManager(new LinearLayoutManager(mContext));
        mComplexDiscussAdapter = new ComplexDiscussAdapter(R.layout.item_complex_discuss, mData);
        mRvComplexDiscuss.setAdapter(mComplexDiscussAdapter);
        mSwipeLayout.setOnRefreshListener(this);
        mComplexDiscussAdapter.setOnLoadMoreListener(this);
        ((CommunityFragment) getParentFragment()).setDiscussSortLisenter(sortType -> {
            mSortType = sortType;
            onRefresh();
        });
        onRefresh();
    }

    @Override
    public void onRefresh() {
        mRvComplexDiscuss.scrollToPosition(0);
        mSwipeLayout.setRefreshing(true);
        start = 0;
        mComplexDiscussPresenter.getData(start, mSortType);
    }

    @Override
    public void setData(DiscussListBean data, boolean isRefresh) {
        if (data == null || data.getPosts() == null || data.getPosts().size() == 0) {
            mComplexDiscussAdapter.loadMoreComplete();
        } else {
            if (isRefresh) {
                if (mData != null) mData.clear();
                mData = data.getPosts();
            } else {
                mData.addAll(data.getPosts());
            }
            mComplexDiscussAdapter.setNewData(mData);
            mSwipeLayout.setRefreshing(false);
            mSwipeLayout.setEnabled(true);
            mComplexDiscussAdapter.setEnableLoadMore(true);
            start = start + data.getPosts().size();
        }

    }

    @Override
    public void showError() {
        mSwipeLayout.setEnabled(false);
        mComplexDiscussAdapter.loadMoreFail();
    }

    @Override
    public void complete() {

    }

    @Override
    public void onLoadMoreRequested() {
        mSwipeLayout.setEnabled(false);
        mComplexDiscussPresenter.getData(start, mSortType);
    }
}
