package com.hubert.xu.zmvp.entity;

import com.hubert.xu.zmvp.http.BookBaseBean;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/29
 * Desc  :
 */

public class DiscussListBean extends BookBaseBean {

    /**
     * posts : [{"_id":"5995b730388e7eac27762940","author":{"_id":"576358780d1e0c3569a5eab1","avatar":"/avatar/44/db/44db95822989c2e5db85ca64481582c2","nickname":"小安","activityAvatar":"/activities/20170120/2.jpg","type":"moderator","lv":9,"gender":"male"},"type":"normal","likeCount":14,"block":"ramble","haveImage":false,"state":"distillate","updated":"2017-08-26T02:47:10.507Z","created":"2017-08-17T15:33:04.632Z","commentCount":58,"voteCount":0,"title":"【试毒】一个评价书好坏的系列，纯属安个人观点，勿喷，谢"},{"_id":"598525cc5ab667d77a8cb725","author":{"_id":"576358780d1e0c3569a5eab1","avatar":"/avatar/44/db/44db95822989c2e5db85ca64481582c2","nickname":"小安","activityAvatar":"/activities/20170120/2.jpg","type":"moderator","lv":9,"gender":"male"},"type":"normal","likeCount":31,"block":"ramble","haveImage":false,"state":"distillate","updated":"2017-08-24T17:24:01.317Z","created":"2017-08-05T01:56:28.124Z","commentCount":185,"voteCount":0,"title":"《论神书》"},{"_id":"597b60726a0864cd3c40a81c","author":{"_id":"578dbaef321ceaed636a864d","avatar":"/avatar/8a/78/8a788783dee1476ed21b7c1d7e9cb80f","nickname":"tik","activityAvatar":"","type":"normal","lv":7,"gender":"male"},"type":"normal","likeCount":19,"block":"ramble","haveImage":false,"state":"distillate","updated":"2017-08-26T04:54:20.298Z","created":"2017-07-28T16:04:02.761Z","commentCount":38,"voteCount":0,"title":"【杂谈】论网文的产业化和商业化发展"},{"_id":"5964f8466c4ea405332fde57","author":{"_id":"572612f9335a528553191e03","avatar":"/avatar/b1/9e/b19e8be4211c774cf16b4e4741e7466a","nickname":"素衣","activityAvatar":"/activities/20170120/5.jpg","type":"normal","lv":8,"gender":"female"},"type":"normal","likeCount":37,"block":"ramble","haveImage":true,"state":"distillate","updated":"2017-08-20T07:54:40.706Z","created":"2017-07-11T16:09:42.629Z","commentCount":401,"voteCount":0,"title":"夏至随感"},{"_id":"59508e875e5ebfdb6133a26e","author":{"_id":"561c99e1996f6c7e05c89524","avatar":"/avatar/87/1b/871bb1d72685dfdaa264ff6d0b663dec","nickname":"杯子不杯具","activityAvatar":"/activities/20170120/1.jpg","type":"moderator","lv":10,"gender":"female"},"type":"normal","likeCount":300,"block":"ramble","haveImage":false,"state":"distillate","updated":"2017-08-15T13:29:52.958Z","created":"2017-06-26T04:33:11.760Z","commentCount":434,"voteCount":0,"title":"【杂谈】读者是否对书籍有近乡情怯"},{"_id":"593e4dbc24feb9c95574145e","author":{"_id":"575284f789c4b6f16b2813de","avatar":"/avatar/b5/81/b581622cebf200841fbcabd2d177be5c","nickname":"青衣沽酒","activityAvatar":"/activities/20170120/4.jpg","type":"author","lv":9,"gender":"male"},"type":"normal","likeCount":148,"block":"ramble","haveImage":false,"state":"distillate","updated":"2017-08-24T14:30:13.381Z","created":"2017-06-12T08:15:56.720Z","commentCount":478,"voteCount":0,"title":"一酒千殇：于原创区而相识，因陪伴而共勉《执棋天下》走过的路"},{"_id":"5939680d358093e23a9a3b78","author":{"_id":"53346f375d5f0f9c7e00a440","avatar":"/avatar/82/51/825184d0a65a76906412fed1fcacbe5a","nickname":"逼乎者也","activityAvatar":"","type":"normal","lv":10,"gender":"male"},"type":"normal","likeCount":82,"block":"ramble","haveImage":false,"state":"distillate","updated":"2017-08-26T05:04:13.540Z","created":"2017-06-08T15:06:53.190Z","commentCount":123,"voteCount":0,"title":"【网文的出路在哪】"},{"_id":"5933f69b9e98ccc932b79634","author":{"_id":"5380ac1f605226f308025a57","avatar":"/avatar/ab/fc/abfc54dbbfeb5f85466bc232c20e8324","nickname":"涛声ttcl","activityAvatar":"/activities/20170120/4.jpg","type":"doyen","lv":10,"gender":"male"},"type":"normal","likeCount":85,"block":"ramble","haveImage":false,"state":"distillate","updated":"2017-08-26T04:34:20.197Z","created":"2017-06-04T12:01:31.111Z","commentCount":135,"voteCount":0,"title":"「电影」不只是好电影《摔跤吧！爸爸》"},{"_id":"592cde2ef46fbbc1421bd83b","author":{"_id":"539cbe77f939e4041593d3b7","avatar":"/avatar/fd/d8/fdd8b32c005cfb9c56f358558c63b5b5","nickname":"·······ᗦ","activityAvatar":"","type":"normal","lv":10,"gender":"male"},"type":"normal","likeCount":369,"block":"ramble","haveImage":false,"state":"distillate","updated":"2017-08-25T02:44:01.251Z","created":"2017-05-30T02:51:26.168Z","commentCount":300,"voteCount":0,"title":"【杂谈】论多人金手指小说的漏洞"},{"_id":"5926b6a4285ea92f0f90d2f2","author":{"_id":"540732a50614f2ee79b196e2","avatar":"/avatar/93/0d/930de566a93b7f8479272d09dbb85e23","nickname":"灰色","activityAvatar":"/activities/20170120/3.jpg","type":"normal","lv":9,"gender":"female"},"type":"normal","likeCount":882,"block":"ramble","haveImage":false,"state":"distillate","updated":"2017-08-29T03:37:28.535Z","created":"2017-05-25T10:49:08.640Z","commentCount":876,"voteCount":0,"title":"【吐槽】\u2014\u2014给我一本能看下去的书！"},{"_id":"59230fbff2498a5c7399ca18","author":{"_id":"5776c4ea905f893908241ab5","avatar":"/avatar/d0/20/d020f6b1da8401bc81a6d360579446d6","nickname":"武装党卫军旗队长","activityAvatar":"/activities/20170120/1.jpg","type":"normal","lv":8,"gender":"male"},"type":"normal","likeCount":21,"block":"ramble","haveImage":false,"state":"distillate","updated":"2017-08-25T09:31:35.853Z","created":"2017-05-22T16:20:15.981Z","commentCount":72,"voteCount":0,"title":"【杂谈】有关战争小说巷战的一些看法"},{"_id":"591f2bfb4a2c0d5c69c2e409","author":{"_id":"576358780d1e0c3569a5eab1","avatar":"/avatar/44/db/44db95822989c2e5db85ca64481582c2","nickname":"小安","activityAvatar":"/activities/20170120/2.jpg","type":"moderator","lv":9,"gender":"male"},"type":"normal","likeCount":13,"block":"ramble","haveImage":false,"state":"distillate","updated":"2017-08-28T12:52:49.155Z","created":"2017-05-19T17:31:39.601Z","commentCount":27,"voteCount":0,"title":"【杂谈】初夏的夜，并没有你的身影【情人节长篇】"},{"_id":"591ae48f74ea8be26e479fe9","author":{"_id":"589b3e7ef419297b299b3ac3","avatar":"/avatar/e2/52/e25247e9b743bf6d8acdfac9984146cc","nickname":"简简姑娘","activityAvatar":"","type":"normal","lv":7,"gender":"female"},"type":"normal","likeCount":18,"block":"ramble","haveImage":false,"state":"distillate","updated":"2017-08-22T17:15:55.862Z","created":"2017-05-16T11:37:51.013Z","commentCount":27,"voteCount":0,"title":"【杂谈】不将就的感情"},{"_id":"591481fcb75e1488277b3516","author":{"_id":"53ac3fa1309725fd11aca499","avatar":"/avatar/24/de/24deabcd3a2a20c0e787c530daad93db","nickname":"何必等一片海","activityAvatar":"","type":"normal","lv":10,"gender":"female"},"type":"normal","likeCount":29,"block":"ramble","haveImage":false,"state":"distillate","updated":"2017-08-26T09:59:45.737Z","created":"2017-05-11T15:23:40.830Z","commentCount":50,"voteCount":0,"title":"【杂谈】一论耳根及其\u201c仙魔天念\u201d四作。"},{"_id":"590824595d4f05743d26ef4c","author":{"_id":"56e9531a853f91486edda265","avatar":"/avatar/b9/6d/b96d9bd14bc3dc6ab57cdf291bad4ff7","nickname":"早安安安","activityAvatar":"/activities/20170120/5.jpg","type":"doyen","lv":10,"gender":"female"},"type":"normal","likeCount":114,"block":"ramble","haveImage":false,"state":"distillate","updated":"2017-08-06T12:52:01.370Z","created":"2017-05-02T06:16:57.925Z","commentCount":305,"voteCount":0,"title":"越看越饿的美食文"},{"_id":"58ffe3224f7d1c8d0facd936","author":{"_id":"5746afeda567b3f132677b6e","avatar":"/avatar/21/33/2133b70472456953342a6c8706b9fbaf","nickname":"槿妍\u202e『间人察视』","activityAvatar":"/activities/20170120/1.jpg","type":"moderator","lv":9,"gender":"female"},"type":"normal","likeCount":27,"block":"ramble","haveImage":true,"state":"distillate","updated":"2017-07-29T15:49:14.775Z","created":"2017-04-26T00:00:34.707Z","commentCount":102,"voteCount":0,"title":"【女频】（杂谈类）读快穿逆袭文有感"},{"_id":"58f058650c1d1f1342710011","author":{"_id":"58334c7bcd4a2147389ab7f0","avatar":"/avatar/f6/0d/f60dbe16c1de45c89b4298981e43ff84","nickname":"桃花颖落","activityAvatar":"/activities/20170120/3.jpg","type":"moderator","lv":9,"gender":"female"},"type":"normal","likeCount":54,"block":"ramble","haveImage":false,"state":"distillate","updated":"2017-08-27T16:52:41.070Z","created":"2017-04-14T05:04:37.782Z","commentCount":102,"voteCount":0,"title":"《左不过高冷罢了》光转流年，与你白首"},{"_id":"58dd97acbc8d850e0c1fc712","author":{"_id":"58334c7bcd4a2147389ab7f0","avatar":"/avatar/f6/0d/f60dbe16c1de45c89b4298981e43ff84","nickname":"桃花颖落","activityAvatar":"/activities/20170120/3.jpg","type":"moderator","lv":9,"gender":"female"},"type":"normal","likeCount":43,"block":"ramble","haveImage":false,"state":"distillate","updated":"2017-07-17T11:10:35.673Z","created":"2017-03-30T23:41:32.150Z","commentCount":197,"voteCount":0,"title":"【浅谈】《亲爱的阿基米德》言溯"},{"_id":"58d6be136e5c1524028365b2","author":{"_id":"575ad7ef7bdce73640042b90","avatar":"/avatar/c5/77/c5777f748cddf238f377b16ea9a206d6","nickname":"污女团-梦了，无痕","activityAvatar":"/activities/20170120/4.jpg","type":"normal","lv":9,"gender":"female"},"type":"normal","likeCount":40,"block":"ramble","haveImage":false,"state":"distillate","updated":"2017-08-10T00:53:46.931Z","created":"2017-03-25T18:59:31.472Z","commentCount":89,"voteCount":0,"title":"我的初恋"},{"_id":"58d489de30f5b37c7f5c7d62","author":{"_id":"53fdff7c35109bd521d9df26","avatar":"/avatar/8a/39/8a393cdfd0aa7cc6829495bb68aaf018","nickname":"永青一页·露露缇雅","activityAvatar":"/activities/20170120/3.jpg","type":"doyen","lv":9,"gender":"male"},"type":"normal","likeCount":135,"block":"ramble","haveImage":false,"state":"distillate","updated":"2017-08-27T15:19:12.864Z","created":"2017-03-24T02:52:14.430Z","commentCount":316,"voteCount":0,"title":"【杂谈】聊一聊爱国"}]
     * ok : true
     */

    private List<PostsBean> posts;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<PostsBean> getPosts() {
        return posts;
    }

    public void setPosts(List<PostsBean> posts) {
        this.posts = posts;
    }

    public class PostsBean {
        /**
         * _id : 5995b730388e7eac27762940
         * author : {"_id":"576358780d1e0c3569a5eab1","avatar":"/avatar/44/db/44db95822989c2e5db85ca64481582c2","nickname":"小安","activityAvatar":"/activities/20170120/2.jpg","type":"moderator","lv":9,"gender":"male"}
         * type : normal
         * likeCount : 14
         * block : ramble
         * haveImage : false
         * state : distillate
         * updated : 2017-08-26T02:47:10.507Z
         * created : 2017-08-17T15:33:04.632Z
         * commentCount : 58
         * voteCount : 0
         * title : 【试毒】一个评价书好坏的系列，纯属安个人观点，勿喷，谢
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

        public class AuthorBean {
            /**
             * _id : 576358780d1e0c3569a5eab1
             * avatar : /avatar/44/db/44db95822989c2e5db85ca64481582c2
             * nickname : 小安
             * activityAvatar : /activities/20170120/2.jpg
             * type : moderator
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
