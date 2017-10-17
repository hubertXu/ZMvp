package com.hubert.xu.zmvp.mvp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseActivity;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.mvp.contract.BookDetailContract;
import com.hubert.xu.zmvp.mvp.model.entity.BookDetailBean;
import com.hubert.xu.zmvp.mvp.model.entity.HotReviewBean;
import com.hubert.xu.zmvp.mvp.model.entity.LocalBookdetailBean;
import com.hubert.xu.zmvp.mvp.model.entity.RecommendBookBean;
import com.hubert.xu.zmvp.mvp.model.entity.RecommendBookListBean;
import com.hubert.xu.zmvp.mvp.presenter.BookDetailPresenter;
import com.hubert.xu.zmvp.mvp.view.adapter.BookDetailAdapter;
import com.hubert.xu.zmvp.mvp.view.adapter.BookDetailTagAdapter;
import com.hubert.xu.zmvp.mvp.view.adapter.HotReviewAdapter;
import com.hubert.xu.zmvp.mvp.view.adapter.RecommendBookAdapter;
import com.hubert.xu.zmvp.mvp.view.adapter.RecommendBookListAdapter;
import com.hubert.xu.zmvp.utils.StringUtil;
import com.hubert.xu.zmvp.utils.TimeFormatUtil;
import com.hubert.xu.zmvp.utils.ToastUtil;
import com.hubert.xu.zmvp.utils.imageload.GlideImageLoader;

import java.text.DecimalFormat;
import java.util.List;

import butterknife.BindView;

import static com.hubert.xu.zmvp.R.id.tv_discuss_counts;

/**
 * Author: Hubert.Xu
 * Date  : 2017/10/12
 * Desc  :
 */

public class BookDetailActivity extends BaseActivity implements BookDetailContract.View, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.OnItemClickListener, View.OnClickListener {

    private static final String INTENT_BOOK_NAME = "intent_book_name";
    private static final String INTENT_BOOK_ID = "intent_book_id";
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    @BindView(R.id.rv_book_detail)
    RecyclerView mRvBookDtail;
    private String mBookId;
    private BookDetailPresenter mPresenter;
    private BookDetailAdapter mBookDetailAdapter;
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
    private ForegroundColorSpan mColorSpan;
    private RelativeSizeSpan mSizeSpan;
    private RecyclerView mRvBookTag;
    private List<String> mTags;
    private BookDetailTagAdapter mDetailTagAdapter;
    private RecyclerView mRvHotReview;
    private List<HotReviewBean.ReviewsBean> mHotReviews;
    private HotReviewAdapter mHotReviewAdapter;
    private List<RecommendBookBean.BooksBean> mBooks;
    private RecommendBookAdapter mRecommendBookAdapter;
    private RecommendBookListAdapter mRecommendBookListAdapter;

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
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRvBookDtail.setLayoutManager(layoutManager);
        mBookDetailAdapter = new BookDetailAdapter(R.layout.item_recommend_book_list, mBookLists);
        initHeaderView();
        mSwipeLayout.setOnRefreshListener(this);
        mRvBookDtail.setAdapter(mBookDetailAdapter);
        onRefresh();
    }

    private void initHeaderView() {
        View headerBookDetail = getLayoutInflater().inflate(R.layout.header_book_detail, mRvBookDtail, false);
        View headerHotReview = getLayoutInflater().inflate(R.layout.header_hot_review, mRvBookDtail, false);
        View headerRecommendBook = getLayoutInflater().inflate(R.layout.header_recommend_book, mRvBookDtail, false);
        View headerRecommendBookList = getLayoutInflater().inflate(R.layout.header_recommend_book_list, mRvBookDtail, false);
        mBookDetailAdapter.addHeaderView(headerBookDetail, 0);
        mBookDetailAdapter.addHeaderView(headerHotReview, 1);
        mBookDetailAdapter.addHeaderView(headerRecommendBook, 2);
        mBookDetailAdapter.addHeaderView(headerRecommendBookList, 3);
        // book详情
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
        mTvDiscussCounts = (TextView) headerBookDetail.findViewById(tv_discuss_counts);
        mTvDalyUpdateWords = (TextView) headerBookDetail.findViewById(R.id.tv_dayly_update_words);
        mTvBookDesc = (TextView) headerBookDetail.findViewById(R.id.tv_book_desc);
        mRvBookTag = (RecyclerView) headerBookDetail.findViewById(R.id.rv_book_tag);

        mRvBookTag.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mDetailTagAdapter = new BookDetailTagAdapter(R.layout.item_tag, mTags);
        mRvBookTag.setAdapter(mDetailTagAdapter);
        mColorSpan = new ForegroundColorSpan(ContextCompat.getColor(BookDetailActivity.this, R.color.normalGray));
        mSizeSpan = new RelativeSizeSpan(0.8f);
        // 热评
        mRvHotReview = (RecyclerView) headerHotReview.findViewById(R.id.rv_hot_review);
        TextView tvMoreHotReview = (TextView)headerHotReview.findViewById(R.id.tv_more_hot_review);
        mRvHotReview.setLayoutManager(new LinearLayoutManager(this));
        mHotReviewAdapter = new HotReviewAdapter(R.layout.item_hot_review, mHotReviews);
        mRvHotReview.setAdapter(mHotReviewAdapter);
        // 推荐的书
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView rvRecommendBook = (RecyclerView) headerRecommendBook.findViewById(R.id.rv_recommend_book);
        TextView tvMoreRecommendBook = (TextView)headerRecommendBook.findViewById(R.id.tv_more_recommend_book);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvRecommendBook.setLayoutManager(linearLayoutManager);
        mRecommendBookAdapter = new RecommendBookAdapter(R.layout.item_reccomend_book, mBooks);
        rvRecommendBook.setAdapter(mRecommendBookAdapter);
        // 推荐书单
        RecyclerView rvRecommendBookList = (RecyclerView) headerRecommendBookList.findViewById(R.id.rv_recommend_book_list);
        TextView tvMoreBookList = (TextView)headerRecommendBookList.findViewById(R.id.tv_more_book_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvRecommendBookList.setLayoutManager(layoutManager);
        mRecommendBookListAdapter = new RecommendBookListAdapter(R.layout.item_recommend_book_list, mBookLists);
        rvRecommendBookList.setAdapter(mRecommendBookListAdapter);
        mRecommendBookListAdapter.setOnItemClickListener(this);
        mRecommendBookAdapter.setOnItemClickListener(this);
        mHotReviewAdapter.setOnItemClickListener(this);
        tvMoreHotReview.setOnClickListener(this);
        tvMoreRecommendBook.setOnClickListener(this);
        tvMoreBookList.setOnClickListener(this);
        mTvDiscussCounts.setOnClickListener(this);
    }


    @Override
    public void setData(LocalBookdetailBean data) {
        mSwipeLayout.setRefreshing(false);
        mBookLists = data.getBookList().getBooklists();
        BookDetailBean bookDetail = data.getBookDetail();
        // 设置书籍详情
        mTvBookName.setText(bookDetail.getTitle());
        mTvBookAuthor.setText(bookDetail.getAuthor());
        mTvBookClassify.setText(bookDetail.getMajorCate());
        mRatingBarBook.setMax(5);
        mRatingBarBook.setRating((float) (bookDetail.getRating().getScore() / 2));
        mTvBookScore.setText(new DecimalFormat("0.00").format(bookDetail.getRating().getScore()) + "分");
        mTvScorerCount.setText(bookDetail.getRating().getCount() + "人评");
        mTvBookWordCount.setText(StringUtil.formatWordCount(bookDetail.getWordCount()));
        mTvBookUpdateTime.setText(TimeFormatUtil.formatTime(bookDetail.getUpdated()));
        SpannableString strReaderCounts = new SpannableString("追书人气\n" + bookDetail.getLatelyFollower());
        strReaderCounts.setSpan(mColorSpan, 0, 4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        strReaderCounts.setSpan(mSizeSpan, 0, 4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        SpannableString strReaderTetained = new SpannableString("读者留存\n" + bookDetail.getRetentionRatio() + "%");
        strReaderTetained.setSpan(mColorSpan, 0, 4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        strReaderTetained.setSpan(mSizeSpan, 0, 4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        SpannableString strPostCounts = new SpannableString("社区帖子\n" + bookDetail.getPostCount());
        strPostCounts.setSpan(mColorSpan, 0, 4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        strPostCounts.setSpan(mSizeSpan, 0, 4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        SpannableString strDalyUpdateWords = new SpannableString("日更新字\n" + bookDetail.getSerializeWordCount());
        strDalyUpdateWords.setSpan(mColorSpan, 0, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        strDalyUpdateWords.setSpan(mSizeSpan, 0, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        mTvReaderCounts.setText(strReaderCounts);
        mTvReaderRetained.setText(strReaderTetained);
        mTvDiscussCounts.setText(strPostCounts);
        mTvDalyUpdateWords.setText(strDalyUpdateWords);
        mTvBookDesc.setText("  " + bookDetail.getLongIntro());
        mTags = bookDetail.getTags();
        mDetailTagAdapter.setNewData(mTags);
        new GlideImageLoader().getRequestManager(this).load(Constants.IMG_BASE_URL + bookDetail.getCover()).into(mIvBookCover);
        // 热评
        mHotReviewAdapter.setNewData(data.getHotReview().getReviews());
        // 推荐书籍
        mRecommendBookAdapter.setNewData(data.getRecommendBook().getBooks());
        // 推荐书单
        mRecommendBookListAdapter.setNewData(data.getBookList().getBooklists());
        mRvBookDtail.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }

    @Override
    public void onRefresh() {
        mSwipeLayout.setRefreshing(true);
        mPresenter.getData(mBookId);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_discuss_counts:
                ToastUtil.show("帖子");
                break;
            case R.id.tv_more_hot_review:
                ToastUtil.show("跟多热评");
                break;
            case R.id.tv_more_recommend_book:
                ToastUtil.show("推荐书籍");
                break;
            case R.id.tv_more_book_list:
                ToastUtil.show("推荐书单");
                break;
        }
    }
}
