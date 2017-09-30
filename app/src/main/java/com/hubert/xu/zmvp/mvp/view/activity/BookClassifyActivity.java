package com.hubert.xu.zmvp.mvp.view.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseActivity;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.entity.BookclassifyLocalBean;
import com.hubert.xu.zmvp.mvp.contract.BookClassifyContract;
import com.hubert.xu.zmvp.mvp.presenter.BookClassifyPresenter;
import com.hubert.xu.zmvp.mvp.view.adapter.BookClassifyAdapter;

import java.util.List;

import butterknife.BindView;

public class BookClassifyActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, BookClassifyContract.View<BookclassifyLocalBean> {


    @BindView(R.id.rv_book_classify)
    RecyclerView mRvBookClassify;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    private BookClassifyPresenter mClassifyPresenter;
    private List<BookclassifyLocalBean.LocalBookClassifyBean> mLocalBookclassifys;
    private BookClassifyAdapter mAdapter;

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
        mRvBookClassify.setLayoutManager(new GridLayoutManager(this, 3));
        mSwipeLayout.setOnRefreshListener(this);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        mSwipeLayout.setRefreshing(true);
        mClassifyPresenter.getData();
    }


    @Override
    public void showError() {
        mSwipeLayout.setRefreshing(false);
    }

    @Override
    public void complete() {

    }

    @Override
    public void setData(BookclassifyLocalBean data) {
        mSwipeLayout.setRefreshing(false);
        if (mAdapter == null) {
            mAdapter = new BookClassifyAdapter(data.getLocalBookclassifys());
            mAdapter.setSpanSizeLookup((gridLayoutManager, position) -> data.getLocalBookclassifys().get(position).getSign() == Constants.BOOK_TYPE_SIGN ? 3 : 1);
            mRvBookClassify.setAdapter(mAdapter);
            mAdapter.setOnItemClickListener((adapter, view, position) -> {
                
            });
        }
        mAdapter.setNewData(data.getLocalBookclassifys());
    }
}
