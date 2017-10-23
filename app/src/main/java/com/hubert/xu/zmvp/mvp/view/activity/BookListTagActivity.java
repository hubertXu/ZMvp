package com.hubert.xu.zmvp.mvp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseActivity;
import com.hubert.xu.zmvp.mvp.contract.BookListByTagContract;
import com.hubert.xu.zmvp.mvp.model.entity.BookListTagBean;
import com.hubert.xu.zmvp.mvp.presenter.BookListByTagPresenter;
import com.hubert.xu.zmvp.mvp.view.adapter.BookListByTagAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * author: XQ
 * time  : 2017/10/18
 * desc  :
 */

public class BookListTagActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener, BookListByTagContract.View<BookListTagBean>, BaseQuickAdapter.OnItemClickListener {

    private static final String INTENT_TAG = "intent_tag";
    @BindView(R.id.rv_book_list_tag)
    RecyclerView mRvBookListTag;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    private int mStart = 0;
    private List<BookListTagBean.BooksBean> mBooks;
    private BookListByTagAdapter mAdapter;
    private BookListByTagPresenter mPresenter;
    private String mTag;

    public static void startActivity(Context context, String tag) {
        context.startActivity(new Intent(context, BookListTagActivity.class)
                .putExtra(INTENT_TAG, tag));
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_book_list_by_tag;
    }

    @Override
    protected void initData() {
        mTag = getIntent().getStringExtra(INTENT_TAG);
        mTvTitle.setText(mTag);
        mPresenter = new BookListByTagPresenter(this);
        mRvBookListTag.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new BookListByTagAdapter(R.layout.item_book_by_tag, mBooks);
        mRvBookListTag.setAdapter(mAdapter);
        mSwipeLayout.setOnRefreshListener(this);
        mAdapter.setOnLoadMoreListener(this);
        mAdapter.setOnItemClickListener(this);
        onRefresh();
    }

    @Override
    protected void initView() {

    }

    @Override
    public void onRefresh() {
        mSwipeLayout.setRefreshing(true);
        mStart = 0;
        mPresenter.getData(mTag, mStart);
    }

    @Override
    public void onLoadMoreRequested() {
        mSwipeLayout.setRefreshing(false);
        mPresenter.getData(mTag, mStart);
    }

    @Override
    public void setData(BookListTagBean data) {
        mSwipeLayout.setRefreshing(false);
        if (data == null || data.getBooks() == null || data.getBooks().size() == 0) {
            mAdapter.loadMoreComplete();
        } else {
            if (mStart == 0) {
                if (mBooks != null) mBooks.clear();
                mBooks = data.getBooks();
            } else {
                mBooks.addAll(data.getBooks());
            }
            mSwipeLayout.setEnabled(true);
            mAdapter.setEnableLoadMore(false);
            mAdapter.setNewData(mBooks);
            mStart = mStart + data.getBooks().size();
        }
    }

    @Override
    public void showError() {
        mSwipeLayout.setRefreshing(false);
    }

    @Override
    public void complete() {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        BookDetailActivity.startActivity(this, mBooks.get(position).getTitle(), mBooks.get(position).get_id());
    }
}
