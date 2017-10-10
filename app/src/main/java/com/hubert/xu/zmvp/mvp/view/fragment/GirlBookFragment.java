package com.hubert.xu.zmvp.mvp.view.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseFragment;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.entity.GirlBookListBean;
import com.hubert.xu.zmvp.mvp.contract.GirlBookContract;
import com.hubert.xu.zmvp.mvp.presenter.GirlBookPresenter;
import com.hubert.xu.zmvp.mvp.view.adapter.GirBookAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/25
 * Desc  :
 */

public class GirlBookFragment extends BaseFragment implements GirlBookContract.View<GirlBookListBean.PostsBean>, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.rv_book_girl)
    RecyclerView mRvBookGirl;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;

    private String sortType = Constants.TYPE_SORT_DEFAULT;
    private int start = 0;
    private List<GirlBookListBean.PostsBean> mData;
    private GirlBookPresenter mGirlBookPresenter;
    private GirBookAdapter mGirBookAdapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_girl_book;
    }


    @Override
    public void initView() {
        mGirlBookPresenter = new GirlBookPresenter(this);
        mRvBookGirl.setLayoutManager(new LinearLayoutManager(mContext));
        mGirBookAdapter = new GirBookAdapter(R.layout.item_complex_discuss, mData);
        mRvBookGirl.setAdapter(mGirBookAdapter);
        mSwipeLayout.setOnRefreshListener(this);
        mGirBookAdapter.setOnLoadMoreListener(this);
        ((CommunityFragment) getParentFragment()).setDiscussSortLisenter(sortType -> {
            this.sortType = sortType;
            onRefresh();
        });
        onRefresh();
    }

    @Override
    public void onRefresh() {
        mSwipeLayout.setRefreshing(true);
        start = 0;
        mGirlBookPresenter.getData(start, sortType);
    }

    @Override
    public void onLoadMoreRequested() {
        mSwipeLayout.setEnabled(false);
        mGirlBookPresenter.getData(start, sortType);
    }

    @Override
    public void setData(GirlBookListBean data, boolean isRefresh) {
        mSwipeLayout.setRefreshing(false);
        if (data==null||data.getPosts()==null||data.getPosts().size()==0){
            mGirBookAdapter.loadMoreComplete();
        }else {
            if (isRefresh) {
                if (mData != null) mData.clear();
                mData = data.getPosts();
                mRvBookGirl.scrollToPosition(0);
            } else {
                mData.addAll(data.getPosts());
            }
            mSwipeLayout.setEnabled(true);
            mGirBookAdapter.setEnableLoadMore(true);
            mGirBookAdapter.setNewData(mData);
            start = start + data.getPosts().size();
        }

    }

    @Override
    public void showError() {
        mSwipeLayout.setRefreshing(false);
        mGirBookAdapter.loadMoreFail();
    }

    @Override
    public void complete() {

    }
}
