package com.hubert.xu.zmvp.mvp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseActivity;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.mvp.contract.CommentDetailContract;
import com.hubert.xu.zmvp.mvp.model.entity.CommentDetailBean;
import com.hubert.xu.zmvp.mvp.model.entity.CommentListBean;
import com.hubert.xu.zmvp.mvp.model.entity.ReviewDetailBean;
import com.hubert.xu.zmvp.mvp.presenter.CommentDetailPresenter;
import com.hubert.xu.zmvp.mvp.view.adapter.BaseCommentAdapter;
import com.hubert.xu.zmvp.mvp.view.adapter.ComementListAdapter;
import com.hubert.xu.zmvp.utils.TimeFormatUtil;
import com.hubert.xu.zmvp.utils.imageload.GlideImageLoader;

import java.util.List;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author: XQ
 * time  : 2017/10/21
 * desc  :
 */
public class CommentDetailActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener, CommentDetailContract.View<CommentDetailBean>, View.OnClickListener {


    private static final String INTENT_DISCUSS_ID = "intent_discuss_id";
    private static final String INTENT_BOOK_RATING = "intent_book_rating";
    @BindView(R.id.rv_comment_detail)
    RecyclerView mRvCommentDetail;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    private String mDiscussId;
    private int start;
    private CommentDetailPresenter mPresenter;
    private List<CommentListBean.CommentsBean> mComments;
    private ComementListAdapter mAdapter;
    private CircleImageView mIvUserAvatar;
    private TextView mTvUserName;
    private TextView mTvCommentTime;
    private TextView mTvCommentContent;
    private TextView mTvBookName;
    private ImageView mIvBookCover;
    private RatingBar mRatBook;
    private TextView mTvCommentTitle;
    private CardView mCardBook;
    private ReviewDetailBean.PostBean mReviewDetail;
    private TextView mTvAgreeCount;
    private TextView mTvDisagreeCount;
    private RecyclerView mRvBestComment;
    private List<CommentListBean.CommentsBean> mBestComments;
    private BaseCommentAdapter mBaseCommentAdapter;
    private View mHeaderBestComment;
    private TextView mTvCommentCount;

    public static void startActivity(Context context, String discussId, float rating) {

        context.startActivity(new Intent(context, CommentDetailActivity.class)
                .putExtra(INTENT_DISCUSS_ID, discussId)
                .putExtra(INTENT_BOOK_RATING, rating));
    }


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_comment_detail;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTvTitle.setText("书评详情");
        mDiscussId = getIntent().getStringExtra(INTENT_DISCUSS_ID);
        mPresenter = new CommentDetailPresenter(this);
        mRvCommentDetail.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ComementListAdapter(R.layout.item_comment_list, mComments);
        mRvCommentDetail.setAdapter(mAdapter);
        View headerCommentDetail = LayoutInflater.from(this).inflate(R.layout.header_comment_detail, mRvCommentDetail, false);
        mHeaderBestComment = LayoutInflater.from(this).inflate(R.layout.header_best_comment, mRvCommentDetail, false);
        View headerCommentCount = LayoutInflater.from(this).inflate(R.layout.header_comment_count, mRvCommentDetail, false);
        // 书评详情
        mIvUserAvatar = (CircleImageView) headerCommentDetail.findViewById(R.id.iv_user_avatar);
        mTvUserName = (TextView) headerCommentDetail.findViewById(R.id.tv_user_name);
        mTvCommentTime = (TextView) headerCommentDetail.findViewById(R.id.tv_comment_time);
        mTvCommentContent = (TextView) headerCommentDetail.findViewById(R.id.tv_comment_content);
        mTvBookName = (TextView) headerCommentDetail.findViewById(R.id.tv_book_name);
        mTvCommentTitle = (TextView) headerCommentDetail.findViewById(R.id.tv_comment_title);
        mIvBookCover = (ImageView) headerCommentDetail.findViewById(R.id.iv_book_cover);
        mRatBook = (RatingBar) headerCommentDetail.findViewById(R.id.ratingBar_book);
        mCardBook = (CardView) headerCommentDetail.findViewById(R.id.card_book);
        mTvAgreeCount = (TextView) headerCommentDetail.findViewById(R.id.tv_agree_count);
        mTvDisagreeCount = (TextView) headerCommentDetail.findViewById(R.id.tv_disagree_count);
        mCardBook.setOnClickListener(this);
        mRatBook.setMax(5);
        // 神评
        mRvBestComment = (RecyclerView) mHeaderBestComment.findViewById(R.id.rv_best_comment);
        mRvBestComment.setLayoutManager(new LinearLayoutManager(this));
        mBaseCommentAdapter = new BaseCommentAdapter(R.layout.item_best_cooment, mBestComments);
        mRvBestComment.setAdapter(mBaseCommentAdapter);
        // 评论
        mTvCommentCount = (TextView) headerCommentCount.findViewById(R.id.tv_comment_count);
        mAdapter.addHeaderView(headerCommentDetail);
        mAdapter.addHeaderView(mHeaderBestComment);
        mAdapter.addHeaderView(headerCommentCount);
        mAdapter.setOnLoadMoreListener(this,mRvCommentDetail);
        mSwipeLayout.setOnRefreshListener(this);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        start = 0;
        mSwipeLayout.setRefreshing(true);
        mPresenter.getRefreshData(mDiscussId);
    }

    @Override
    public void onLoadMoreRequested() {
        mPresenter.getMoreData(mDiscussId,start);
    }

    @Override
    public void setRefreshData(CommentDetailBean data) {
        mSwipeLayout.setRefreshing(false);
        mComments = data.getCommentList().getComments();
        mReviewDetail = data.getReviewDetail().getPost();
        mBestComments = data.getBestComment().getComments();
        // 评论详情
        RequestManager glidManager = new GlideImageLoader().getRequestManager(this);
        glidManager.load(Constants.IMG_BASE_URL + mReviewDetail.getAuthor().getAvatar()).into(mIvUserAvatar);
        glidManager.load(Constants.IMG_BASE_URL + mReviewDetail.getBook().getCover()).into(mIvBookCover);
        mTvBookName.setText(mReviewDetail.getBook().getTitle());
        mTvCommentTitle.setText(mReviewDetail.getTitle());
        mRatBook.setRating(getIntent().getFloatExtra(INTENT_BOOK_RATING, 5f));
        mTvCommentTime.setText(TimeFormatUtil.formatTime(mReviewDetail.getCreated()));
        mTvUserName.setText(mReviewDetail.getAuthor().getNickname() + mReviewDetail.getAuthor().getLv());
        mTvCommentContent.setText(mReviewDetail.getContent());
        mTvAgreeCount.setText(mReviewDetail.getLikeCount() + "");
        mTvDisagreeCount.setText(mReviewDetail.getVoteCount() + "");
        // 神评
        mHeaderBestComment.setVisibility(mBestComments == null || mBestComments.size() == 0 ? View.GONE : View.VISIBLE);
        mBaseCommentAdapter.setNewData(mBestComments);
        // 评论
        mTvCommentCount.setText("共" + mReviewDetail.getCommentCount() + "评论");
        mAdapter.setNewData(mComments);
        mAdapter.setEnableLoadMore(!(mComments == null || mComments.size() < 20));
        mRvCommentDetail.setVisibility(View.VISIBLE);
    }

    @Override
    public void setMoreData(CommentListBean data) {
        mSwipeLayout.setRefreshing(false);
        mAdapter.setEnableLoadMore(!(mComments == null || mComments.size() < 20));
        mComments.addAll(data.getComments());
        mAdapter.setNewData(mComments);
        start = start + data.getComments().size();
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.card_book:
                BookDetailActivity.startActivity(this, mReviewDetail.getBook().getTitle(), mReviewDetail.getBook().get_id());
                break;
        }
    }
}
