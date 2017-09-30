package com.hubert.xu.zmvp.mvp.view.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseFragment;
import com.hubert.xu.zmvp.entity.BookListBean;
import com.hubert.xu.zmvp.mvp.contract.BookListContract;
import com.hubert.xu.zmvp.mvp.presenter.BookListPresenter;
import com.hubert.xu.zmvp.mvp.view.adapter.BookListAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/30
 * Desc  :
 */

public class BookListFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, BookListContract.View<BookListBean>, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rv_book_list)
    RecyclerView mRvBookList;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    private List<BookListBean.BooksBean> mBooks;
    private BookListPresenter mPresenter;
    private BookListAdapter mAdapter;
    private int start;

    public static BookListFragment newInstance() {
        Bundle args = new Bundle();
        BookListFragment fragment = new BookListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_book_list;
    }

    @Override
    public void initView() {
        mPresenter = new BookListPresenter(this);
        mRvBookList.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new BookListAdapter(R.layout.item_book, mBooks);
        mRvBookList.setAdapter(mAdapter);
        mAdapter.setOnLoadMoreListener(this);
        mSwipeLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        mSwipeLayout.setRefreshing(true);
        start = 0;
        mPresenter.getData(start, "", "", "", "");
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
    public void setData(BookListBean data, boolean isRefresh) {
        mSwipeLayout.setRefreshing(false);
        if (isRefresh) {
            if (mBooks != null) mBooks.clear();
        }
        mBooks = data.getBooks();
        mAdapter.setNewData(mBooks);
        start = start + data.getBooks().size();
    }

    @Override
    public void onLoadMoreRequested() {
        mPresenter.getData(start, "", "", "", "");
    }
}
