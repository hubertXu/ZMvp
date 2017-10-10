package com.hubert.xu.zmvp.mvp.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseFragment;
import com.hubert.xu.zmvp.entity.BookClassifyListBean;
import com.hubert.xu.zmvp.mvp.contract.BookClassifyListContract;
import com.hubert.xu.zmvp.mvp.presenter.BookClassifyListPresenter;
import com.hubert.xu.zmvp.mvp.view.activity.BookClassifyListActivity;
import com.hubert.xu.zmvp.mvp.view.adapter.BookClassifyListAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/30
 * Desc  :
 */

public class BookLClassifyistFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, BookClassifyListContract.View<BookClassifyListBean>, BaseQuickAdapter.RequestLoadMoreListener {

    private static final String INTENT_BOOK_LIST_TYPE = "intent_book_list_type";
    private static final String INTENT_BOOK_CLASSIFY_TYPE = "intent_book_classify_type";
    private static final String INTENT_BOOK_LIST_MINOR = "intent_book_list_minor";
    private static final String INTENT_BOOK_LIST_MAJOR = "intent_book_list_major";
    @BindView(R.id.rv_book_list)
    RecyclerView mRvBookList;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    private List<BookClassifyListBean.BooksBean> mBooks;
    private BookClassifyListPresenter mPresenter;
    private BookClassifyListAdapter mAdapter;
    private int start;
    private BookClassifyListActivity mBookClassifyListActivity;
    String mMinor;
    String mMajor;
    String type;
    String gender;

    public static BookLClassifyistFragment newInstance(String major, String gender, String minor, String type) {
        Bundle args = new Bundle();
        BookLClassifyistFragment fragment = new BookLClassifyistFragment();
        args.putString(INTENT_BOOK_CLASSIFY_TYPE, gender);
        args.putString(INTENT_BOOK_LIST_MINOR, minor);
        args.putString(INTENT_BOOK_LIST_MAJOR, major);
        args.putString(INTENT_BOOK_LIST_TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mBookClassifyListActivity = (BookClassifyListActivity) activity;
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_book_classify_list;
    }

    @Override
    public void initView() {
        type = getArguments().getString(INTENT_BOOK_LIST_TYPE);
        gender = getArguments().getString(INTENT_BOOK_CLASSIFY_TYPE);
        mMinor = getArguments().getString(INTENT_BOOK_LIST_MINOR);
        mMajor = getArguments().getString(INTENT_BOOK_LIST_MAJOR);
        mPresenter = new BookClassifyListPresenter(this);
        mRvBookList.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new BookClassifyListAdapter(R.layout.item_book, mBooks);
        mRvBookList.setAdapter(mAdapter);
        mAdapter.setOnLoadMoreListener(this);
        mSwipeLayout.setOnRefreshListener(this);
        mBookClassifyListActivity.setGetBookListDataLisenter((lv2Type) -> {
            mMinor = lv2Type;
            onRefresh();
        });
        onRefresh();
    }

    @Override
    public void onRefresh() {
        mRvBookList.scrollToPosition(0);
        mSwipeLayout.setRefreshing(true);
        start = 0;
        mPresenter.getData(start, gender, type, mMajor, mMinor);
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
    public void setData(BookClassifyListBean data, boolean isRefresh) {
        mSwipeLayout.setRefreshing(false);
        if (data==null||data.getBooks() == null || data.getBooks().size() == 0) {
            mAdapter.loadMoreComplete();
        } else {
            if (isRefresh) {
                if (mBooks != null) mBooks.clear();
                mBooks = data.getBooks();
            } else {
                mBooks.addAll(data.getBooks());
            }
            mAdapter.setNewData(mBooks);
            mAdapter.setEnableLoadMore(true);
            start = start + data.getBooks().size();
        }
    }

    @Override
    public void onLoadMoreRequested() {
        mSwipeLayout.setRefreshing(false);
        mPresenter.getData(start, gender, type, mMajor, mMinor);
    }
}
