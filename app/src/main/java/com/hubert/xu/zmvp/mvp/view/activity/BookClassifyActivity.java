package com.hubert.xu.zmvp.mvp.view.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseActivity;
import com.hubert.xu.zmvp.entity.BookClassifyBean;
import com.hubert.xu.zmvp.mvp.contract.BookClassifyContract;
import com.hubert.xu.zmvp.mvp.presenter.BookClassifyPresenter;

import butterknife.BindView;

public class BookClassifyActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, BookClassifyContract.View<BookClassifyBean> {


    @BindView(R.id.rv_book_classify)
    RecyclerView mRvBookClassify;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    private BookClassifyPresenter mClassifyPresenter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_book_classify;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTvTitle.setText(R.string.classify);
        mClassifyPresenter = new BookClassifyPresenter(this);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        mSwipeLayout.setRefreshing(true);
        mClassifyPresenter.getData();
    }

    @Override
    public void setData(BookClassifyBean data) {
        mSwipeLayout.setRefreshing(false);
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }

}
