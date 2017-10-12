package com.hubert.xu.zmvp.mvp.model.entity;

import com.hubert.xu.zmvp.http.BookBaseBean;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/21
 * Desc  :
 */

public class BookReviewListBean extends BookBaseBean {


    private List<ReviewsBean> reviews;

    public List<ReviewsBean> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewsBean> reviews) {
        this.reviews = reviews;
    }

    public static class ReviewsBean {
        /**
         * _id : 59c292c6f15f6dde6414c3e0
         * book : {"_id":"542a5838a5ae10f815039a7f","title":"逆天邪神","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F602085%2F_602085_372106.jpg%2F","site":"zhuishuvip","type":"xhqh","latelyFollower":null,"retentionRatio":null}
         * helpful : {"total":9,"yes":16,"no":7}
         * likeCount : 1
         * haveImage : false
         * state : normal
         * updated : 2017-09-22T00:49:59.075Z
         * created : 2017-09-20T16:09:42.154Z
         * title : 一个看邪神如火星坑的一个新人的一点话
         */

        private String _id;
        private BookBean book;
        private HelpfulBean helpful;
        private int likeCount;
        private boolean haveImage;
        private String state;
        private String updated;
        private String created;
        private String title;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public BookBean getBook() {
            return book;
        }

        public void setBook(BookBean book) {
            this.book = book;
        }

        public HelpfulBean getHelpful() {
            return helpful;
        }

        public void setHelpful(HelpfulBean helpful) {
            this.helpful = helpful;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public boolean isHaveImage() {
            return haveImage;
        }

        public void setHaveImage(boolean haveImage) {
            this.haveImage = haveImage;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public static class BookBean {
            /**
             * _id : 542a5838a5ae10f815039a7f
             * title : 逆天邪神
             * cover : /agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F602085%2F_602085_372106.jpg%2F
             * site : zhuishuvip
             * type : xhqh
             * latelyFollower : null
             * retentionRatio : null
             */

            private String _id;
            private String title;
            private String cover;
            private String site;
            private String type;
            private Object latelyFollower;
            private Object retentionRatio;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getSite() {
                return site;
            }

            public void setSite(String site) {
                this.site = site;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public Object getLatelyFollower() {
                return latelyFollower;
            }

            public void setLatelyFollower(Object latelyFollower) {
                this.latelyFollower = latelyFollower;
            }

            public Object getRetentionRatio() {
                return retentionRatio;
            }

            public void setRetentionRatio(Object retentionRatio) {
                this.retentionRatio = retentionRatio;
            }
        }


        public static class HelpfulBean {
            /**
             * total : 9
             * yes : 16
             * no : 7
             */

            private int total;
            private int yes;
            private int no;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getYes() {
                return yes;
            }

            public void setYes(int yes) {
                this.yes = yes;
            }

            public int getNo() {
                return no;
            }

            public void setNo(int no) {
                this.no = no;
            }
        }
    }
}
