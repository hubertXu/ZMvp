package com.hubert.xu.zmvp.mvp.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseFragment;
import com.hubert.xu.zmvp.mvp.model.entity.BookListBean;
import com.hubert.xu.zmvp.mvp.contract.BookListContract;
import com.hubert.xu.zmvp.mvp.presenter.BookListPresenter;
import com.hubert.xu.zmvp.mvp.view.activity.BookListActivity;
import com.hubert.xu.zmvp.mvp.view.activity.BookListDetailActivity;
import com.hubert.xu.zmvp.mvp.view.adapter.BookListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/10/10
 * Desc  :
 */

public class BookListFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener, BookListActivity.TagChangeLisenter, BookListContract.View<BookListBean> {


    private static final String ARGS_TAB_KEY = "args_tab_key";
    @BindView(R.id.rv_book_list)
    RecyclerView mRvBookList;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    private BookListActivity mBookListActivity;
    private BookListPresenter mPresenter;
    private BookListAdapter mAdapter;
    private String mTag = "";
    private String mGender = "";
    private int mStart;
    private String mDuration;
    private String mSort;
    private List<BookListBean.BookListsBean> mBookLists = new ArrayList<>();

    public static BookListFragment newInstance(int tabPostion) {

        Bundle args = new Bundle();
        BookListFragment fragment = new BookListFragment();
        args.putInt(ARGS_TAB_KEY, tabPostion);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mBookListActivity = (BookListActivity) activity;
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_book_list;
    }

    @Override
    public void initView() {
        switch (getArguments().getInt(ARGS_TAB_KEY)) {
            case 0:
                mSort = "collectorCount";
                mDuration = "last-seven-days";
                break;
            case 1:
                mSort = "created";
                mDuration = "all";
                break;
            case 2:
                mSort = "collectorCount";
                mDuration = "all";
                break;
            default:
                break;
        }
        mPresenter = new BookListPresenter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        mRvBookList.setLayoutManager(layoutManager);
        mAdapter = new BookListAdapter(R.layout.item_book_list, mBookLists);
        mRvBookList.setAdapter(mAdapter);
        mAdapter.setOnLoadMoreListener(this, mRvBookList);
        mSwipeLayout.setOnRefreshListener(this);
        mBookListActivity.setTagChangeLisenters(this);
        mAdapter.setOnItemClickListener((adapter, view, position) -> BookListDetailActivity.startActivity(mContext, mBookLists.get(position).get_id()));
        mAdapter.disableLoadMoreIfNotFullPage(mRvBookList);
        onRefresh();
    }


    @Override
    public void onRefresh() {
        mSwipeLayout.setRefreshing(true);
        mStart = 0;
        mRvBookList.scrollToPosition(0);
        mPresenter.getData(mDuration, mTag, mGender, mStart, mSort);
    }

    @Override
    public void tagChange(String gender, String tag) {
        mTag = tag;
        mGender = gender;
        onRefresh();
    }

    @Override
    public void setData(BookListBean data, boolean isRefresh) {
        mSwipeLayout.setRefreshing(false);
        mAdapter.loadMoreComplete();
        if (isRefresh) {
            if (mBookLists != null) {
                mBookLists.clear();
            }
            mBookLists = data.getBookLists();
        } else {
            mBookLists.addAll(data.getBookLists());

        }
        mAdapter.setNewData(mBookLists);
        mStart = mStart + data.getBookLists().size();
        mAdapter.setEnableLoadMore(data.getBookLists() != null && data.getBookLists().size() >= 20);
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
        mPresenter.getData(mDuration, mTag, mGender, mStart, mSort);
    }
}
