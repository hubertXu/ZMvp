package com.hubert.xu.zmvp.mvp.view.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseFragment;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.entity.BookReviewListBean;
import com.hubert.xu.zmvp.mvp.contract.BookReviewContract;
import com.hubert.xu.zmvp.mvp.presenter.BookReviewPresenter;
import com.hubert.xu.zmvp.mvp.view.adapter.BookReviewAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/25
 * Desc  :
 */

public class BookReviewFragment extends BaseFragment implements BookReviewContract.View<BookReviewListBean>, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.rv_book_review)
    RecyclerView mRvBookReview;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    private List<BookReviewListBean.ReviewsBean> mData;
    private BookReviewAdapter mBookReviewAdapter;
    private BookReviewPresenter mBookReviewPresenter;
    private int start;
    private String type = Constants.TYPE_BOOKE_ALL;


    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_book_review;
    }


    @Override
    public void initView() {
        mBookReviewPresenter = new BookReviewPresenter(this);
        mRvBookReview.setLayoutManager(new LinearLayoutManager(mContext));
        mBookReviewAdapter = new BookReviewAdapter(R.layout.item_book_review, mData);
        mRvBookReview.setAdapter(mBookReviewAdapter);
        mSwipeLayout.setOnRefreshListener(this);
        mBookReviewAdapter.setOnLoadMoreListener(this);
        ((CommunityFragment) getParentFragment()).setDiscussSortLisenter(type -> {
            this.type = type;
            onRefresh();
        });
        onRefresh();
    }

    @Override
    public void onRefresh() {
        mRvBookReview.scrollToPosition(0);
        mSwipeLayout.setRefreshing(true);
        start = 0;
        mBookReviewPresenter.getData(start, type);
    }

    @Override
    public void onLoadMoreRequested() {
        mSwipeLayout.setEnabled(false);
        mBookReviewPresenter.getData(start, type);
    }


    @Override
    public void showError() {
        mSwipeLayout.setEnabled(false);
        mBookReviewAdapter.loadMoreFail();
    }

    @Override
    public void complete() {
        mSwipeLayout.setEnabled(false);
        mBookReviewPresenter.getData(start, type);
    }

    @Override
    public void setData(BookReviewListBean data, boolean isRefresh) {
        mSwipeLayout.setRefreshing(false);
        if (isRefresh) {
            if (mData != null) mData.clear();
            mData = data.getReviews();
        } else {
            mData.addAll(data.getReviews());
        }
        mSwipeLayout.setEnabled(true);
        mBookReviewAdapter.setEnableLoadMore(true);
        mBookReviewAdapter.setNewData(mData);
        start = start + data.getReviews().size();
    }
}
