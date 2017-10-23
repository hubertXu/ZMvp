package com.hubert.xu.zmvp.mvp.model.entity;

import com.hubert.xu.zmvp.http.BookBaseBean;

/**
 * author: XQ
 * time  : 2017/10/21
 * desc  :
 */

public class CommentDetailBean extends BookBaseBean {

    private ReviewDetailBean reviewDetail;
    private CommentListBean BestComment;
    private CommentListBean commentList;

    public void setReviewDetail(ReviewDetailBean reviewDetail) {
        this.reviewDetail = reviewDetail;
    }

    public void setBestComment(CommentListBean bestComment) {
        BestComment = bestComment;
    }

    public void setCommentList(CommentListBean commentList) {
        this.commentList = commentList;
    }

    public ReviewDetailBean getReviewDetail() {
        return reviewDetail;
    }

    public CommentListBean getBestComment() {
        return BestComment;
    }

    public CommentListBean getCommentList() {
        return commentList;
    }
}
