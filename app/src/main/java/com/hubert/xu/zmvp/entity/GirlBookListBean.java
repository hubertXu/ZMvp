package com.hubert.xu.zmvp.entity;

import com.hubert.xu.zmvp.http.BookBaseBean;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/22
 * Desc  :
 */

public class GirlBookListBean extends BookBaseBean {

    private List<PostsBean> posts;

    public List<PostsBean> getPosts() {
        return posts;
    }

    public void setPosts(List<PostsBean> posts) {
        this.posts = posts;
    }

    public static class PostsBean {
        /**
         * _id : 59c31b9307c5fa2962bdeefd
         * author : {"_id":"5559b73846fb7ff0496ccc97","avatar":"/avatar/e9/0d/e90d9e4bbd80560961a2f9b043025f2d","nickname":"追书家的小姝姝","activityAvatar":"/activities/20170120/3.jpg","type":"official","lv":6,"gender":"female"}
         * type : normal
         * likeCount : 101
         * block : ramble
         * haveImage : true
         * state : distillate
         * updated : 2017-09-22T10:24:49.301Z
         * created : 2017-09-21T01:53:23.440Z
         * commentCount : 676
         * voteCount : 0
         * title : 《龙王传说》三少正版授权，追书携手推荐，下载必得追书券！
         */

        private String _id;
        private AuthorBean author;
        private String type;
        private int likeCount;
        private String block;
        private boolean haveImage;
        private String state;
        private String updated;
        private String created;
        private int commentCount;
        private int voteCount;
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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public String getBlock() {
            return block;
        }

        public void setBlock(String block) {
            this.block = block;
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

        public int getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(int voteCount) {
            this.voteCount = voteCount;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public static class AuthorBean {
            /**
             * _id : 5559b73846fb7ff0496ccc97
             * avatar : /avatar/e9/0d/e90d9e4bbd80560961a2f9b043025f2d
             * nickname : 追书家的小姝姝
             * activityAvatar : /activities/20170120/3.jpg
             * type : official
             * lv : 6
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
