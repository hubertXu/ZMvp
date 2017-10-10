package com.hubert.xu.zmvp.mvp.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseFragment;
import com.hubert.xu.zmvp.entity.BookListBean;
import com.hubert.xu.zmvp.mvp.contract.BookListContract;
import com.hubert.xu.zmvp.mvp.presenter.BookListPresenter;
import com.hubert.xu.zmvp.mvp.view.activity.BookListActivity;
import com.hubert.xu.zmvp.mvp.view.adapter.BookListAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/10/10
 * Desc  :
 */

public class BookListFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, BookListActivity.TagChangeLisenter, BookListContract.View<BookListBean.BookListsBean> {


    private static final String ARGS_TAB_KEY = "args_tab_key";
    @BindView(R.id.rv_book_list)
    RecyclerView mRvBookList;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    private int mTabPosition;
    private BookListActivity mBookListActivity;
    private String mTag;
    private String mGender;
    private List<BookListBean.BookListsBean> bookList;
    private BookListPresenter mPresenter;
    private BookListAdapter mAdapter;

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
        mTabPosition = getArguments().getInt(ARGS_TAB_KEY);
        mSwipeLayout.setOnRefreshListener(this);
        mBookListActivity.setTagChangeLisenters(this);
        mPresenter = new BookListPresenter(this);
        mAdapter = new BookListAdapter(R.layout.itemt_book_list, bookList);
        mRvBookList.setAdapter(mAdapter);
        onRefresh();
    }


    @Override
    public void onRefresh() {
        mSwipeLayout.setRefreshing(true);
        mPresenter.getData();
    }

    @Override
    public void tagChange(String gender, String tag) {
        mTag = tag;
        mGender = gender;
    }

    @Override
    public void setData(BookListBean data) {

    }

    @Override
    public void showError() {
        mSwipeLayout.setRefreshing(false);
        mAdapter.loadMoreFail();
    }

    @Override
    public void complete() {

    }
}
