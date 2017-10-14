package com.hubert.xu.zmvp.mvp.model.entity;

import com.hubert.xu.zmvp.http.BookBaseBean;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/10/12
 * Desc  :
 */

public class RecommendBookListBean extends BookBaseBean {


    private List<BooklistsBean> booklists;

    public List<BooklistsBean> getBooklists() {
        return booklists;
    }

    public void setBooklists(List<BooklistsBean> booklists) {
        this.booklists = booklists;
    }

    public static class BooklistsBean {
        /**
         * id : 556214c12c51bc94165a2ef8
         * title : 》网游同人洪荒都市系统末世《
         * author : 贫道申公豹
         * desc : 都是我看过的或者别人推荐我看的。里面有超过二百本小说问你怕不怕，看玩全部推荐的你已经超神了……里面有你喜欢的就帮忙收藏一下。我推荐的都是长篇的或完结的，不会乱凑数目的。
         * bookCount : 240
         * collectorCount : 6576
         * cover : /agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F42006%2F_42006_885730.jpg%2F
         */

        private String id;
        private String title;
        private String author;
        private String desc;
        private int bookCount;
        private int collectorCount;
        private String cover;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getBookCount() {
            return bookCount;
        }

        public void setBookCount(int bookCount) {
            this.bookCount = bookCount;
        }

        public int getCollectorCount() {
            return collectorCount;
        }

        public void setCollectorCount(int collectorCount) {
            this.collectorCount = collectorCount;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }
    }
}
