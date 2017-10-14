package com.hubert.xu.zmvp.mvp.model.entity;

import com.hubert.xu.zmvp.http.BookBaseBean;

/**
 * Author: Hubert.Xu
 * Date  : 2017/10/12
 * Desc  :
 */

public class LocalBookdetailBean extends BookBaseBean {

    private BookDetailBean bookDetail;
    private RecommendBookListBean bookList;
    private RecommendBookBean recommendBook;
    private  HotReviewBean hotReview;

    public void setBookList(RecommendBookListBean bookList) {
        this.bookList = bookList;
    }

    public void setRecommendBook(RecommendBookBean recommendBook) {
        this.recommendBook = recommendBook;
    }

    public void setHotReview(HotReviewBean hotReview) {
        this.hotReview = hotReview;
    }

    public RecommendBookListBean getBookList() {
        return bookList;
    }

    public RecommendBookBean getRecommendBook() {
        return recommendBook;
    }

    public HotReviewBean getHotReview() {
        return hotReview;
    }

    public void setBookDetail(BookDetailBean bookDetail) {
        this.bookDetail = bookDetail;
    }

    public BookDetailBean getBookDetail() {
        return bookDetail;
    }
}
