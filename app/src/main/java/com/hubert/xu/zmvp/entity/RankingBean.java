package com.hubert.xu.zmvp.entity;

import com.google.gson.annotations.SerializedName;
import com.hubert.xu.zmvp.http.BookBaseBean;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/28
 * Desc  :
 */


public class RankingBean extends BookBaseBean {
    /**
     * _id : 54d42d92321052167dfb75e3
     * updated : 2017-09-27T21:20:14.353Z
     * title : 追书最热榜 Top100
     * tag : zhuishuLatelyFollowerMale
     * cover : /ranking-cover/142319144267827
     * icon : /cover/148945782817557
     * __v : 1101
     * monthRank : 564d820bc319238a644fb408
     * totalRank : 564d8494fe996c25652644d2
     * shortTitle : 最热榜
     * created : 2017-09-28T08:20:42.279Z
     * isSub : false
     * collapse : false
     * new : true
     * gender : male
     * priority : 250
     * books : [{"_id":"5816b415b06d1d32157790b1","title":"圣墟","author":"辰东","shortIntro":"在破败中崛起，在寂灭中复苏。沧海成尘，雷电枯竭，那一缕幽雾又一次临近大地，世间的枷锁被打开了，一个全新的世界就此揭开神秘的一角\u2026\u2026","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1228859%2F_1228859_441552.jpg%2F","site":"zhuishuvip","banned":0,"latelyFollower":304596,"retentionRatio":"73.6"},{"_id":"57206c3539a913ad65d35c7b","title":"一念永恒","author":"耳根","shortIntro":"一念成沧海，一念化桑田。一念斩千魔，一念诛万仙。唯我念\u2026\u2026永恒这是耳根继《仙逆》《求魔》《我欲封天》后，创作的第四部长篇小说《一念永恒》","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1127281%2F_1127281_685974.jpg%2F","site":"zhuishuvip","banned":0,"latelyFollower":246045,"retentionRatio":"70.82"}]
     * id : 54d42d92321052167dfb75e3
     * total : 122
     */

    private String _id;
    private String updated;
    private String title;
    private String tag;
    private String cover;
    private String icon;
    private int __v;
    private String monthRank;
    private String totalRank;
    private String shortTitle;
    private String created;
    private boolean isSub;
    private boolean collapse;
    @SerializedName("new")
    private boolean newX;
    private String gender;
    private int priority;
    private String id;
    private int total;
    private List<BooksBean> books;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public String getMonthRank() {
        return monthRank;
    }

    public void setMonthRank(String monthRank) {
        this.monthRank = monthRank;
    }

    public String getTotalRank() {
        return totalRank;
    }

    public void setTotalRank(String totalRank) {
        this.totalRank = totalRank;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public boolean isIsSub() {
        return isSub;
    }

    public void setIsSub(boolean isSub) {
        this.isSub = isSub;
    }

    public boolean isCollapse() {
        return collapse;
    }

    public void setCollapse(boolean collapse) {
        this.collapse = collapse;
    }

    public boolean isNewX() {
        return newX;
    }

    public void setNewX(boolean newX) {
        this.newX = newX;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
         * banned : 0
         * latelyFollower : 304596
         * retentionRatio : 73.6
         */

        private String _id;
        private String title;
        private String author;
        private String shortIntro;
        private String cover;
        private String site;
        private int banned;
        private int latelyFollower;
        private String retentionRatio;

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

        public String getRetentionRatio() {
            return retentionRatio;
        }

        public void setRetentionRatio(String retentionRatio) {
            this.retentionRatio = retentionRatio;
        }
    }
}
