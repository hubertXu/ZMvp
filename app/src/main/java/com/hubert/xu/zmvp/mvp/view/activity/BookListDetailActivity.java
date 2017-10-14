package com.hubert.xu.zmvp.mvp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseActivity;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.mvp.model.entity.BookListDetailBean;
import com.hubert.xu.zmvp.mvp.contract.BookListDetailContract;
import com.hubert.xu.zmvp.mvp.presenter.BookListDetailPresenter;
import com.hubert.xu.zmvp.mvp.view.adapter.BookListDetailAdapter;
import com.hubert.xu.zmvp.utils.imageload.GlideImageLoader;

import java.util.List;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/10/11
 * Desc  :
 */

public class BookListDetailActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, BookListDetailContract.View<BookListDetailBean> {

    private static final String INTENT_BOOK_LIST_ID = "intent_book_list_id";
    @BindView(R.id.rv_book_list_detail)
    RecyclerView mRvBookListDetail;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    TextView mTvBookListTitle;
    TextView mTvBookListDesc;
    CircleImageView mIvUserAvatar;
    TextView mTvUserName;
    private BookListDetailPresenter mPresenter;
    private String mBookListId;
    private List<BookListDetailBean.BookListBean.BooksBean> mBooks;
    private BookListDetailAdapter mAdapter;


    public static void startActivity(Context context, String bookListId) {
        context.startActivity(new Intent(context, BookListDetailActivity.class)
                .putExtra(INTENT_BOOK_LIST_ID, bookListId));
    }


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_book_list_detail;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTvTitle.setText(R.string.book_list_detail);
        mBookListId = getIntent().getExtras().getString(INTENT_BOOK_LIST_ID);
        mPresenter = new BookListDetailPresenter(this);
        mSwipeLayout.setOnRefreshListener(this);
        mRvBookListDetail.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new BookListDetailAdapter(R.layout.item_book_list_detail, mBooks);
        View hearer = LayoutInflater.from(this).inflate(R.layout.header_book_list_detail, mRvBookListDetail, false);
        mTvBookListTitle = (TextView) hearer.findViewById(R.id.tv_book_list_title);
        mTvBookListDesc = (TextView) hearer.findViewById(R.id.tv_book_list_desc);
        mTvUserName = (TextView) hearer.findViewById(R.id.tv_user_name);
        mIvUserAvatar = (CircleImageView) hearer.findViewById(R.id.iv_user_avatar);
        mAdapter.addHeaderView(hearer);
        mRvBookListDetail.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((adapter, view, position) -> BookDetailActivity.startActivity(BookListDetailActivity.this, mBooks.get(position).getBook().getTitle(), mBooks.get(position).getBook().get_id()));
        onRefresh();
    }

    @Override
    public void onRefresh() {
        mSwipeLayout.setRefreshing(true);
        mPresenter.getData(mBookListId);
    }

    @Override
    public void setData(BookListDetailBean data) {
        mSwipeLayout.setRefreshing(false);
        BookListDetailBean.BookListBean bookList = data.getBookList();
        mBooks = bookList.getBooks();
        mAdapter.setNewData(mBooks);
        mTvBookListTitle.setText(bookList.getTitle());
        mTvBookListDesc.setText(bookList.getDesc());
        mTvUserName.setText(bookList.getAuthor().getNickname());
        new GlideImageLoader().getRequestManager(this).load(Constants.IMG_BASE_URL + bookList.getAuthor().getAvatar()).into(mIvUserAvatar);
    }

    @Override
    public void showError() {
        mSwipeLayout.setRefreshing(false);
    }

    @Override
    public void complete() {

    }
}
