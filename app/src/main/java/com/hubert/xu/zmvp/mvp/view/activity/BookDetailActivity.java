package com.hubert.xu.zmvp.mvp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseActivity;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.mvp.contract.BookDetailContract;
import com.hubert.xu.zmvp.mvp.model.entity.BookDetailBean;
import com.hubert.xu.zmvp.mvp.model.entity.LocalBookdetailBean;
import com.hubert.xu.zmvp.mvp.model.entity.RecommendBookListBean;
import com.hubert.xu.zmvp.mvp.presenter.BookDetailPresenter;
import com.hubert.xu.zmvp.mvp.view.adapter.RecommendBookListAdapter;
import com.hubert.xu.zmvp.utils.StringUtil;
import com.hubert.xu.zmvp.utils.TimeFormatUtil;
import com.hubert.xu.zmvp.utils.imageload.GlideImageLoader;

import java.text.DecimalFormat;
import java.util.List;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/10/12
 * Desc  :
 */

public class BookDetailActivity extends BaseActivity implements BookDetailContract.View, SwipeRefreshLayout.OnRefreshListener {

    private static final String INTENT_BOOK_NAME = "intent_book_name";
    private static final String INTENT_BOOK_ID = "intent_book_id";
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    @BindView(R.id.rv_book_detail)
    RecyclerView mRvBookDetail;
    private String mBookId;
    private BookDetailPresenter mPresenter;
    private RecommendBookListAdapter mHotReviewAdapter;
    private List<RecommendBookListBean.BooklistsBean> mBookLists;
    private ImageView mIvBookCover;
    private TextView mTvBookName;
    private TextView mTvBookAuthor;
    private TextView mTvBookClassify;
    private RatingBar mRatingBarBook;
    private TextView mTvBookScore;
    private TextView mTvBookWordCount;
    private TextView mTvBookUpdateTime;
    private TextView mTvReaderCounts;
    private TextView mTvReaderRetained;
    private TextView mTvDiscussCounts;
    private TextView mTvDalyUpdateWords;
    private TextView mTvBookDesc;
    private TextView mTvScorerCount;

    public static void startActivity(Context context, String bookName, String bookId) {
        context.startActivity(new Intent(context, BookDetailActivity.class)
                .putExtra(INTENT_BOOK_NAME, bookName)
                .putExtra(INTENT_BOOK_ID, bookId));
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_book_detail;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTvTitle.setText(getIntent().getStringExtra(INTENT_BOOK_NAME));
        mBookId = getIntent().getStringExtra(INTENT_BOOK_ID);
        mPresenter = new BookDetailPresenter(this);
        mRvBookDetail.setLayoutManager(new LinearLayoutManager(this));
        mHotReviewAdapter = new RecommendBookListAdapter(R.layout.item_reccomend_book_list, mBookLists);
        initHeaderView();
        mRvBookDetail.setAdapter(mHotReviewAdapter);
        mSwipeLayout.setOnRefreshListener(this);
        onRefresh();
    }

    private void initHeaderView() {
        View headerBookDetail = getLayoutInflater().inflate(R.layout.header_book_detail, mRvBookDetail, false);
        View headerHotReview = getLayoutInflater().inflate(R.layout.header_hot_review, mRvBookDetail, false);
        View headerHotReviewSign = getLayoutInflater().inflate(R.layout.header_hot_review_sign, mRvBookDetail, false);
        View headerRecommendBook = getLayoutInflater().inflate(R.layout.header_recommend_book, mRvBookDetail, false);
        mHotReviewAdapter.addHeaderView(headerBookDetail, 0);
        mHotReviewAdapter.addHeaderView(headerHotReview, 1);
        mHotReviewAdapter.addHeaderView(headerHotReviewSign, 3);
        mHotReviewAdapter.addHeaderView(headerRecommendBook, 4);
        mIvBookCover = (ImageView) headerBookDetail.findViewById(R.id.iv_book_cover);
        mTvBookName = (TextView) headerBookDetail.findViewById(R.id.tv_book_name);
        mTvBookAuthor = (TextView) headerBookDetail.findViewById(R.id.tv_book_author);
        mTvBookClassify = (TextView) headerBookDetail.findViewById(R.id.tv_book_classify);
        mRatingBarBook = (RatingBar) headerBookDetail.findViewById(R.id.ratingBar_book);
        mTvBookScore = (TextView) headerBookDetail.findViewById(R.id.tv_book_score);
        mTvScorerCount = (TextView) headerBookDetail.findViewById(R.id.tv_scorer_count);
        mTvBookWordCount = (TextView) headerBookDetail.findViewById(R.id.tv_book_word_count);
        mTvBookUpdateTime = (TextView) headerBookDetail.findViewById(R.id.tv_book_update_time);
        mTvReaderCounts = (TextView) headerBookDetail.findViewById(R.id.tv_reader_counts);
        mTvReaderRetained = (TextView) headerBookDetail.findViewById(R.id.tv_reader_retained);
        mTvDiscussCounts = (TextView) headerBookDetail.findViewById(R.id.tv_discuss_counts);
        mTvDalyUpdateWords = (TextView) headerBookDetail.findViewById(R.id.tv_dayly_update_words);
        mTvBookDesc = (TextView) headerBookDetail.findViewById(R.id.tv_book_desc);
    }


    @Override
    public void setData(LocalBookdetailBean data) {
        mBookLists = data.getBookList().getBooklists();
        mHotReviewAdapter.setNewData(data.getBookList().getBooklists());
        BookDetailBean bookDetail = data.getBookDetail();
        // 设置书籍详情
        mTvBookName.setText(bookDetail.getTitle());
        mTvBookAuthor.setText(bookDetail.getAuthor());
        mTvBookClassify.setText(bookDetail.getMajorCate());
        mRatingBarBook.setMax(5);
        mRatingBarBook.setRating((float) (bookDetail.getRating().getScore()/2));
        mTvBookScore.setText(new DecimalFormat("0.00").format(bookDetail.getRating().getScore()) + "分");
        mTvScorerCount.setText(bookDetail.getRating().getCount() + "人评");
        mTvBookWordCount.setText(StringUtil.formatWordCount(bookDetail.getWordCount()));
        mTvBookUpdateTime.setText(TimeFormatUtil.formatTime(bookDetail.getUpdated()));
        mTvReaderCounts.setText("追书人气\n" + bookDetail.getLatelyFollower() + "");
        mTvReaderRetained.setText(bookDetail.getRetentionRatio() + "%");
        mTvDiscussCounts.setText(bookDetail.getPostCount() + "");
        mTvDalyUpdateWords.setText(bookDetail.getSerializeWordCount() + "");
        mTvBookDesc.setText(bookDetail.getLongIntro());
        new GlideImageLoader().getRequestManager(this).load(Constants.IMG_BASE_URL + bookDetail.getCover()).into(mIvBookCover);
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }

    @Override
    public void onRefresh() {
        mPresenter.getData(mBookId);
    }

}
