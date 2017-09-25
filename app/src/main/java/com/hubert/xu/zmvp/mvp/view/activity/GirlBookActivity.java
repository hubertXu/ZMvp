package com.hubert.xu.zmvp.mvp.view.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseActivity;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.entity.GirlBookListBean;
import com.hubert.xu.zmvp.mvp.contract.GirlBookContract;
import com.hubert.xu.zmvp.mvp.presenter.GirlBookPresenter;
import com.hubert.xu.zmvp.mvp.view.adapter.GirBookAdapter;
import com.hubert.xu.zmvp.utils.LogUtil;
import com.hubert.xu.zmvp.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/22
 * Desc  :
 */

public class GirlBookActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, GirlBookContract.View<GirlBookListBean.PostsBean>, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.rv_girl_book)
    RecyclerView mRvGirlBook;
    @BindView(R.id.swipe_girl_book)
    SwipeRefreshLayout mSwipeGirlBook;

    private String mBookState = "";
    private String sortType = Constants.TYPE_SORT_DEFAULT;
    private int start = 0;
    private List<GirlBookListBean.PostsBean> mData;
    private GirlBookPresenter mGirlBookPresenter;
    private GirBookAdapter mGirBookAdapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_girl_book;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTvTitle.setText(R.string.female_area);
        mGirlBookPresenter = new GirlBookPresenter(this);
        mRvGirlBook.setLayoutManager(new LinearLayoutManager(this));
        mGirBookAdapter = new GirBookAdapter(R.layout.item_girl_book, mData);
        mRvGirlBook.setAdapter(mGirBookAdapter);
        mSwipeGirlBook.setOnRefreshListener(this);
        mGirBookAdapter.setOnLoadMoreListener(this);
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
    public void onRefresh() {
        mSwipeGirlBook.setRefreshing(true);
        start = 0;
        LogUtil.info(mBookState);
        mGirlBookPresenter.getData(start, sortType, mBookState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_book_help, menu);
        return true;
    }

    @Override
    public void setData(GirlBookListBean data, boolean isRefresh) {
        mSwipeGirlBook.setRefreshing(false);
        if (isRefresh) {
            if (mData != null) mData.clear();
            mData = data.getPosts();
            mRvGirlBook.scrollToPosition(0);
        } else {
            mData.addAll(data.getPosts());
        }
        mSwipeGirlBook.setEnabled(true);
        mGirBookAdapter.setEnableLoadMore(true);
        mGirBookAdapter.setNewData(mData);
        start = start + data.getPosts().size();
    }

    @Override
    public void showError() {
        mSwipeGirlBook.setRefreshing(false);
        mGirBookAdapter.loadMoreFail();
    }

    @Override
    public void complete() {

    }

    @Override
    public void onLoadMoreRequested() {
        mSwipeGirlBook.setEnabled(false);
        mGirlBookPresenter.getData(start, sortType, mBookState);
    }
}
