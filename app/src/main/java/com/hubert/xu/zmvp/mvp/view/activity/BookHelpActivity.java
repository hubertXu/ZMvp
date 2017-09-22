package com.hubert.xu.zmvp.mvp.view.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseActivity;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.entity.BookHelpListBean;
import com.hubert.xu.zmvp.mvp.contract.BookHelpContract;
import com.hubert.xu.zmvp.mvp.presenter.BookHelpPresenter;
import com.hubert.xu.zmvp.mvp.view.adapter.BookHelpAdapter;
import com.hubert.xu.zmvp.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;

public class BookHelpActivity extends BaseActivity implements BookHelpContract.View<BookHelpListBean>, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {


    @BindView(R.id.rv_book_help)
    RecyclerView mRvBookHelp;
    @BindView(R.id.swipe_book_help)
    SwipeRefreshLayout mSwipeBookHelp;

    private String mBookState = "";
    private String sortType = Constants.TYPE_SORT_DEFAULT;
    private int start = 0;
    private BookHelpPresenter mBookHelpPresenter;
    private List<BookHelpListBean.HelpsBean> mData;
    private BookHelpAdapter mBookHelpAdapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_book_help;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTvTitle.setText(getString(R.string.book_help_area));
        mBookHelpPresenter = new BookHelpPresenter(this);
        mBookHelpAdapter = new BookHelpAdapter(R.layout.item_book_help, mData);
        mRvBookHelp.setLayoutManager(new LinearLayoutManager(this));
        mRvBookHelp.setAdapter(mBookHelpAdapter);
        mSwipeBookHelp.setOnRefreshListener(this);
        mToolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_fine:
                    item.setChecked(!item.isChecked());
                    item.setIcon(item.isChecked() ? R.drawable.ic_action_fine_select : R.drawable.ic_action_fine_normal);
                    mBookState = item.isChecked() ? true + "" : "";
                    onRefresh();
                    break;
                case R.id.action_default_sort:
                    ToastUtil.showShortToastSafely("默认排序");
                    sortType = Constants.TYPE_SORT_DEFAULT;
                    onRefresh();
                    break;
                case R.id.action_latest_sort:
                    ToastUtil.showShortToastSafely("最新发布");
                    sortType = Constants.TYPE_SORT_LATEST;
                    onRefresh();
                    break;
                case R.id.action_most_sort:
                    ToastUtil.showShortToastSafely("最多评论");
                    sortType = Constants.TYPE_SORT_MOST;
                    onRefresh();
                    break;
            }
            return false;
        });
        onRefresh();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_book_help, menu);
        return true;
    }

    @Override
    public void onRefresh() {
        mSwipeBookHelp.setRefreshing(true);
        start = 0;
        mBookHelpPresenter.getData(start, sortType, mBookState);
    }

    @Override
    public void onLoadMoreRequested() {
        mSwipeBookHelp.setEnabled(false);
        mBookHelpPresenter.getData(start, sortType, mBookState);
    }

    @Override
    public void setData(BookHelpListBean data, boolean isRefresh) {
        mSwipeBookHelp.setRefreshing(false);
        if (isRefresh) {
            if (mData != null) mData.clear();
            mData = data.getHelps();
            mRvBookHelp.scrollToPosition(0);
        } else {
            mData.addAll(data.getHelps());
        }
        mSwipeBookHelp.setEnabled(true);
        mBookHelpAdapter.setEnableLoadMore(true);
        mBookHelpAdapter.setNewData(mData);
        start = start + data.getHelps().size();
    }

    @Override
    public void showError() {
        mSwipeBookHelp.setRefreshing(false);
        mBookHelpAdapter.loadMoreFail();
    }

    @Override
    public void complete() {

    }
}
