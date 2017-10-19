package com.hubert.xu.zmvp.mvp.model.entity;

import com.hubert.xu.zmvp.http.BookBaseBean;

import java.util.List;

/**
 * author: XQ
 * time  : 2017/10/19
 * desc  :
 */

public class CommentListBean  extends BookBaseBean{


    private List<CommentsBean> comments;

    public List<CommentsBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentsBean> comments) {
        this.comments = comments;
    }

    public static class CommentsBean {
        /**
         * _id : 56a34c379e0da81a52666e19
         * content : 道友你成功吓退了我看这本书的欲望
         * author : {"_id":"561ba7e81ed583366b863831","avatar":"/avatar/bb/da/bbda744ac80fd7b28925299980432aef","nickname":"梁山好汉","activityAvatar":"","type":"normal","lv":9,"gender":"male"}
         * floor : 26
         * replyAuthor : null
         * likeCount : 493
         * created : 2016-01-23T09:47:35.430Z
         * replyTo : null
         */

        private String _id;
        private String content;
        private AuthorBean author;
        private int floor;
        private Object replyAuthor;
        private int likeCount;
        private String created;
        private Object replyTo;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public int getFloor() {
            return floor;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }

        public Object getReplyAuthor() {
            return replyAuthor;
        }

        public void setReplyAuthor(Object replyAuthor) {
            this.replyAuthor = replyAuthor;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public Object getReplyTo() {
            return replyTo;
        }

        public void setReplyTo(Object replyTo) {
            this.replyTo = replyTo;
        }

        public static class AuthorBean {
            /**
             * _id : 561ba7e81ed583366b863831
             * avatar : /avatar/bb/da/bbda744ac80fd7b28925299980432aef
             * nickname : 梁山好汉
             * activityAvatar :
             * type : normal
             * lv : 9
             * gender : male
             */

            private String _id;
            private String avatar;
            private String nickname;
            private String activityAvatar;
            private String type;
            private int lv;
            private String gender;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getActivityAvatar() {
                return activityAvatar;
            }

            public void setActivityAvatar(String activityAvatar) {
                this.activityAvatar = activityAvatar;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public int getLv() {
                return lv;
            }

            public void setLv(int lv) {
                this.lv = lv;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }
        }
    }
}
