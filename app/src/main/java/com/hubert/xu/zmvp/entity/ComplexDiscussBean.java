package com.hubert.xu.zmvp.entity;

import com.hubert.xu.zmvp.http.HttpResult;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/21
 * Desc  :
 */

public class ComplexDiscussBean extends HttpResult {
    public List<PostsBean> posts;

    public static class PostsBean {
        public String _id;
        public String title;
        /**
         * _id : 52f840b982cfcc3a74031693
         * avatar : /avatar/56/a9/56a96462a50ca99f9cf83440899e46f3
         * nickname : 追书首席打杂
         * type : official
         * lv : 9
         * gender : male
         */

        public AuthorBean author;
        public String type;
        public int likeCount;
        public String block;
        public String state;
        public String updated;
        public String created;
        public int commentCount;
        public int voteCount;

        public static class AuthorBean {
            public String _id;
            public String avatar;
            public String nickname;
            public String type;
            public int lv;
            public String gender;
        }
    }
}
