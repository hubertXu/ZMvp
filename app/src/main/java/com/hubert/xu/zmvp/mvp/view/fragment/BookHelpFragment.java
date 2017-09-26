package com.hubert.xu.zmvp.mvp.view.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseFragment;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.entity.BookHelpListBean;
import com.hubert.xu.zmvp.mvp.contract.BookHelpContract;
import com.hubert.xu.zmvp.mvp.presenter.BookHelpPresenter;
import com.hubert.xu.zmvp.mvp.view.adapter.BookHelpAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/25
 * Desc  :
 */

public class BookHelpFragment extends BaseFragment implements BookHelpContract.View<BookHelpListBean>, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.rv_book_help)
    RecyclerView mRvBookHelp;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    private List<BookHelpListBean.HelpsBean> mData;
    private BookHelpAdapter mBookHelpAdapter;
    private BookHelpPresenter mBookHelpPresenter;
    private int start;
    private String mSortType = Constants.TYPE_SORT_DEFAULT;
    private String mIsFine = "";

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_book_help;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        mBookHelpPresenter = new BookHelpPresenter(this);
        mRvBookHelp.setLayoutManager(new LinearLayoutManager(mContext));
        mBookHelpAdapter = new BookHelpAdapter(R.layout.item_book_help, mData);
        mRvBookHelp.setAdapter(mBookHelpAdapter);
        mSwipeLayout.setOnRefreshListener(this);
        mBookHelpAdapter.setOnLoadMoreListener(this);
        ((CommunityFragment) getParentFragment()).setDiscussSortLisenter(sortType -> {
            mSortType = sortType;
            onRefresh();
        });
        onRefresh();
    }

    @Override
    public void onRefresh() {
        mRvBookHelp.scrollToPosition(0);
        mSwipeLayout.setRefreshing(true);
        start = 0;
        mBookHelpPresenter.getData(start, mSortType);
    }

    @Override
    public void onLoadMoreRequested() {
        mSwipeLayout.setEnabled(false);
        mBookHelpPresenter.getData(start, mSortType);
    }

    @Override
    public void setData(BookHelpListBean data, boolean isRefresh) {
        mSwipeLayout.setRefreshing(false);
        if (isRefresh) {
            if (mData != null) mData.clear();
            mData = data.getHelps();
            mRvBookHelp.scrollToPosition(0);
        } else {
            mData.addAll(data.getHelps());
        }
        mSwipeLayout.setEnabled(true);
        mBookHelpAdapter.setEnableLoadMore(true);
        mBookHelpAdapter.setNewData(mData);
        start = start + data.getHelps().size();
    }

    @Override
    public void showError() {
        mSwipeLayout.setEnabled(false);
        mBookHelpAdapter.loadMoreFail();
    }

    @Override
    public void complete() {

    }
}
