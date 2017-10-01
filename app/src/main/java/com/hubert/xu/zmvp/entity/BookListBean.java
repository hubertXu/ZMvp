package com.hubert.xu.zmvp.entity;

import com.hubert.xu.zmvp.http.BookBaseBean;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/30
 * Desc  :
 */

public class BookListBean extends BookBaseBean {

    /**
     * total : 40822
     * books : [{"_id":"5816b415b06d1d32157790b1","title":"圣墟","author":"辰东","shortIntro":"在破败中崛起，在寂灭中复苏。沧海成尘，雷电枯竭，那一缕幽雾又一次临近大地，世间的枷锁被打开了，一个全新的世界就此揭开神秘的一角\u2026\u2026","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1228859%2F_1228859_441552.jpg%2F","site":"zhuishuvip","majorCate":"玄幻","minorCate":"东方玄幻","sizetype":-1,"superscript":"","contentType":"txt","allowMonthly":false,"banned":0,"latelyFollower":303279,"retentionRatio":73.63,"lastChapter":"第667章 洗劫一空","tags":["玄幻","东方玄幻"]},{"_id":"56928442c49f3bce42b7f521","title":"龙王传说","author":"唐家三少","shortIntro":"伴随着魂导科技的进步，斗罗大陆上的人类征服了海洋，又发现了两片大陆。魂兽也随着人类魂师的猎杀无度走向灭亡，沉睡无数年的魂兽之王在星斗大森林最后的净土苏醒，它要带领仅存的族人，向人类复仇！唐舞麟立志要成为一名强大的魂师，可当武魂觉醒时，苏醒的，却是\u2026\u2026旷世之才，龙王之争，我们的龙王传说，将由此开始。","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F891697%2F_891697_378164.jpg%2F","site":"zhuishuvip","majorCate":"玄幻","minorCate":"东方玄幻","sizetype":-1,"superscript":"","contentType":"txt","allowMonthly":false,"banned":0,"latelyFollower":205787,"retentionRatio":70.5,"lastChapter":"第1326章 唐门主留下来","tags":["玄幻","异界大陆","阴差阳错"]},{"_id":"53e56ee335f79bb626a496c9","title":"帝霸","author":"厌笔萧生","shortIntro":"千万年前，李七夜栽下一株翠竹。\n八百万年前，李七夜养了一条鲤鱼。\n五百万年前，李七夜收养一个小女孩。\n\u2026\u2026\u2026\u2026\u2026\u2026\u2026\u2026\u2026\u2026\n今天，李七夜一觉醒来，翠竹修练成神灵，鲤鱼化作金龙，小女孩成为九界女帝。\n这是一个养成的故事，一个不死的人族小子养成了妖神、养成了仙兽、养成了女帝的故事","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F41584%2F_41584_123902.jpg%2F","site":"zhuishuvip","majorCate":"玄幻","minorCate":"东方玄幻","sizetype":-1,"superscript":"","contentType":"txt","allowMonthly":false,"banned":0,"latelyFollower":135334,"retentionRatio":70.49,"lastChapter":"第2722章 窥天机","tags":["玄幻","东方玄幻","热血","架空","巅峰","传奇"]}]
     */

    private int total;
    private List<BooksBean> books;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<BooksBean> getBooks() {
        return books;
    }

    public void setBooks(List<BooksBean> books) {
        this.books = books;
    }

    public static class BooksBean {
        /**
         * _id : 5816b415b06d1d32157790b1
         * title : 圣墟
         * author : 辰东
         * shortIntro : 在破败中崛起，在寂灭中复苏。沧海成尘，雷电枯竭，那一缕幽雾又一次临近大地，世间的枷锁被打开了，一个全新的世界就此揭开神秘的一角……
         * cover : /agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1228859%2F_1228859_441552.jpg%2F
         * site : zhuishuvip
         * majorCate : 玄幻
         * minorCate : 东方玄幻
         * sizetype : -1
         * superscript :
         * contentType : txt
         * allowMonthly : false
         * banned : 0
         * latelyFollower : 303279
         * retentionRatio : 73.63
         * lastChapter : 第667章 洗劫一空
         * tags : ["玄幻","东方玄幻"]
         */

        private String _id;
        private String title;
        private String author;
        private String shortIntro;
        private String cover;
        private String site;
        private String majorCate;
        private String minorCate;
        private int sizetype;
        private String superscript;
        private String contentType;
        private boolean allowMonthly;
        private int banned;
        private int latelyFollower;
        private double retentionRatio;
        private String lastChapter;
        private List<String> tags;

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

        public String getShortIntro() {
            return shortIntro;
        }

        public void setShortIntro(String shortIntro) {
            this.shortIntro = shortIntro;
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

        public int getSizetype() {
            return sizetype;
        }

        public void setSizetype(int sizetype) {
            this.sizetype = sizetype;
        }

        public String getSuperscript() {
            return superscript;
        }

        public void setSuperscript(String superscript) {
            this.superscript = superscript;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public boolean isAllowMonthly() {
            return allowMonthly;
        }

        public void setAllowMonthly(boolean allowMonthly) {
            this.allowMonthly = allowMonthly;
        }

        public int getBanned() {
            return banned;
        }

        public void setBanned(int banned) {
            this.banned = banned;
        }

        public int getLatelyFollower() {
            return latelyFollower;
        }

        public void setLatelyFollower(int latelyFollower) {
            this.latelyFollower = latelyFollower;
        }

        public double getRetentionRatio() {
            return retentionRatio;
        }

        public void setRetentionRatio(double retentionRatio) {
            this.retentionRatio = retentionRatio;
        }

        public String getLastChapter() {
            return lastChapter;
        }

        public void setLastChapter(String lastChapter) {
            this.lastChapter = lastChapter;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }
    }
}
