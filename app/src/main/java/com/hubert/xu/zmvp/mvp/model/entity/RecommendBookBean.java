package com.hubert.xu.zmvp.mvp.model.entity;

import com.hubert.xu.zmvp.http.BookBaseBean;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/10/12
 * Desc  :
 */

public class RecommendBookBean extends BookBaseBean {


    private List<BooksBean> books;

    public List<BooksBean> getBooks() {
        return books;
    }

    public void setBooks(List<BooksBean> books) {
        this.books = books;
    }

    public static class BooksBean {
        /**
         * _id : 52a5d936de9853034500e1e6
         * title : 洪荒不朽
         * author : 小七泡泡
         * site : zhuishuvip
         * cover : /agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F684504%2F_684504_555696.jpg%2F
         * shortIntro : 自盘古开天来，世间万物无不在追寻着不朽的道路，道祖鸿钧，魔主罗睺，盘古三清，佛教二主，龙祖始凤，五德麒麟······问世间谁能不朽？ 　　一个重生而来的主角，将如何在这方世界之中纵横，找到一条属于他自己的通天大道！且看主角纵横诸天万界！   PS：小七也创建了一个群，有兴趣的兄弟，可以加一下。    不朽群：182482212（满）  不朽新群：182483732（火热招人中）
         * lastChapter : 第七百章  不朽种子（大结局）
         * retentionRatio : 23.81
         * latelyFollower : 1237
         * majorCate : 仙侠
         * minorCate : 洪荒封神
         */

        private String _id;
        private String title;
        private String author;
        private String site;
        private String cover;
        private String shortIntro;
        private String lastChapter;
        private double retentionRatio;
        private int latelyFollower;
        private String majorCate;
        private String minorCate;

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

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getShortIntro() {
            return shortIntro;
        }

        public void setShortIntro(String shortIntro) {
            this.shortIntro = shortIntro;
        }

        public String getLastChapter() {
            return lastChapter;
        }

        public void setLastChapter(String lastChapter) {
            this.lastChapter = lastChapter;
        }

        public double getRetentionRatio() {
            return retentionRatio;
        }

        public void setRetentionRatio(double retentionRatio) {
            this.retentionRatio = retentionRatio;
        }

        public int getLatelyFollower() {
            return latelyFollower;
        }

        public void setLatelyFollower(int latelyFollower) {
            this.latelyFollower = latelyFollower;
        }

        public String getMajorCate() {
            return majorCate;
        }

        public void setMajorCate(String majorCate) {
            this.majorCate = majorCate;
        }

        public String getMinorCate() {
            return minorCate;
        }

        public void setMinorCate(String minorCate) {
            this.minorCate = minorCate;
        }
    }
}
