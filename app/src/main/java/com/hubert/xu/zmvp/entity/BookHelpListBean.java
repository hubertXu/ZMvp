package com.hubert.xu.zmvp.entity;

import com.hubert.xu.zmvp.http.BookBaseBean;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/22
 * Desc  :
 */

public class BookHelpListBean extends BookBaseBean {

    private List<HelpsBean> helps;

    public List<HelpsBean> getHelps() {
        return helps;
    }

    public void setHelps(List<HelpsBean> helps) {
        this.helps = helps;
    }

    public static class HelpsBean {
        /**
         * _id : 59c1cd4758c2d61a62990904
         * author : {"_id":"56e903c1febd4661455a0692","avatar":"/avatar/7b/e1/7be142f47d8ef8834727b1dd2c7bbbc1","nickname":"追书家的眼镜娘","activityAvatar":"/activities/20170120/4.jpg","type":"official","lv":9,"gender":"female"}
         * likeCount : 1163
         * haveImage : false
         * state : normal
         * updated : 2017-09-22T09:33:56.116Z
         * created : 2017-09-20T02:07:03.922Z
         * commentCount : 9752
         * title : 【追刊】我吃西红柿：位列“五大至尊”之一，重塑全新武侠世界 ‖书评征集奖励
         */

        private String _id;
        private AuthorBean author;
        private int likeCount;
        private boolean haveImage;
        private String state;
        private String updated;
        private String created;
        private int commentCount;
        private String title;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
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

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public static class AuthorBean {
            /**
             * _id : 56e903c1febd4661455a0692
             * avatar : /avatar/7b/e1/7be142f47d8ef8834727b1dd2c7bbbc1
             * nickname : 追书家的眼镜娘
             * activityAvatar : /activities/20170120/4.jpg
             * type : official
             * lv : 9
             * gender : female
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
