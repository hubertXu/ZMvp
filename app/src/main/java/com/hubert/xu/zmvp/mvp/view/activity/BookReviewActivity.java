package com.hubert.xu.zmvp.mvp.view.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import com.afollestad.materialdialogs.MaterialDialog;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseActivity;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.entity.BookReviewListBean;
import com.hubert.xu.zmvp.mvp.contract.BookReviewContract;
import com.hubert.xu.zmvp.mvp.presenter.BookReviewPresenter;
import com.hubert.xu.zmvp.mvp.view.adapter.BookReviewAdapter;
import com.hubert.xu.zmvp.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;

public class BookReviewActivity extends BaseActivity implements BookReviewContract.View<BookReviewListBean>, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rv_book_review)
    RecyclerView mRvBookReview;
    @BindView(R.id.swipe_book_review)
    SwipeRefreshLayout mSwipeBookReview;
    private BookReviewAdapter mBookReviewAdapter;
    private BookReviewPresenter mBookReviewPresenter;
    private int start = 0;
    private String sortType = Constants.TYPE_SORT_DEFAULT;
    private String mBookState = "";
    private String type = Constants.TYPE_BOOKE_ALL;
    private List<BookReviewListBean.ReviewsBean> mBookReviewData;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_book_review;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTvTitle.setText(R.string.book_review_area);
        mToolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_type_select:
                    new MaterialDialog.Builder(this)
                            .items(R.array.booke_type)
                            .itemsCallback((dialog, itemView, position, text) -> {
                                dialog.dismiss();
                                type = Constants.bookTypeList.get(position);
                                ToastUtil.showShortToastSafely(text);
                                onRefresh();
                            }).show();
                    break;
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
        mBookReviewPresenter = new BookReviewPresenter(this);
        mSwipeBookReview.setOnRefreshListener(this);
        mRvBookReview.setLayoutManager(new LinearLayoutManager(this));
        mBookReviewAdapter = new BookReviewAdapter(R.layout.item_book_review, mBookReviewData);
        mRvBookReview.setAdapter(mBookReviewAdapter);
        mBookReviewAdapter.setOnLoadMoreListener(this);
        onRefresh();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_book_review, menu);
        return true;
    }

    @Override
    public void onRefresh() {
        start = 0;
        mSwipeBookReview.setRefreshing(true);
        mBookReviewPresenter.getData(start, sortType, mBookState, type);
    }

    @Override
    public void onLoadMoreRequested() {
        mSwipeBookReview.setEnabled(false);
        mBookReviewPresenter.getData(start, sortType, mBookState, type);
    }


    @Override
    public void showError() {
        mSwipeBookReview.setRefreshing(false);
        mBookReviewAdapter.loadMoreFail();
    }

    @Override
    public void complete() {

    }

    @Override
    public void setData(BookReviewListBean data, boolean isRefresh) {
        mSwipeBookReview.setRefreshing(false);
        if (isRefresh) {
            if (mBookReviewData != null) mBookReviewData.clear();
            mBookReviewData = data.getReviews();
            mRvBookReview.scrollToPosition(0);
        } else {
            mBookReviewData.addAll(data.getReviews());
        }
        mSwipeBookReview.setEnabled(true);
        mBookReviewAdapter.setEnableLoadMore(true);
        mBookReviewAdapter.setNewData(mBookReviewData);
        start = start + data.getReviews().size();
    }
}
