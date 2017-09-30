package com.hubert.xu.zmvp.entity;

import com.hubert.xu.zmvp.http.BookBaseBean;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/29
 * Desc  :
 */

public class BookClassifyBean extends BookBaseBean {

    private List<MaleBean> male;
    private List<FemaleBean> female;
    private List<PictureBean> picture;
    private List<PressBean> press;

    public List<MaleBean> getMale() {
        return male;
    }

    public void setMale(List<MaleBean> male) {
        this.male = male;
    }

    public List<FemaleBean> getFemale() {
        return female;
    }

    public void setFemale(List<FemaleBean> female) {
        this.female = female;
    }

    public List<PictureBean> getPicture() {
        return picture;
    }

    public void setPicture(List<PictureBean> picture) {
        this.picture = picture;
    }

    public List<PressBean> getPress() {
        return press;
    }

    public void setPress(List<PressBean> press) {
        this.press = press;
    }

    public static class MaleBean {
        /**
         * name : 玄幻
         * bookCount : 480402
         * monthlyCount : 13370
         * icon : /icon/玄幻_.png
         */

        private String name;
        private int bookCount;
        private int monthlyCount;
        private String icon;
        private int sign;

        public MaleBean(String name, int bookCount, int monthlyCount, String icon, int sign) {
            this.name = name;
            this.bookCount = bookCount;
            this.monthlyCount = monthlyCount;
            this.icon = icon;
            this.sign = sign;
        }

        public void setSign(int sign) {
            this.sign = sign;
        }

        public int getSign() {
            return sign;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getBookCount() {
            return bookCount;
        }

        public void setBookCount(int bookCount) {
            this.bookCount = bookCount;
        }

        public int getMonthlyCount() {
            return monthlyCount;
        }

        public void setMonthlyCount(int monthlyCount) {
            this.monthlyCount = monthlyCount;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }


    public static class FemaleBean {
        /**
         * name : 古代言情
         * bookCount : 443443
         * monthlyCount : 9403
         * icon : /icon/古代言情_.png
         */

        private String name;
        private int bookCount;
        private int monthlyCount;
        private String icon;
        private int sign;

        public FemaleBean(String name, int sign) {
            this.name = name;
            this.sign = sign;
        }

        public void setSign(int sign) {
            this.sign = sign;
        }

        public int getSign() {
            return sign;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getBookCount() {
            return bookCount;
        }

        public void setBookCount(int bookCount) {
            this.bookCount = bookCount;
        }

        public int getMonthlyCount() {
            return monthlyCount;
        }

        public void setMonthlyCount(int monthlyCount) {
            this.monthlyCount = monthlyCount;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }


    public static class PictureBean {
        /**
         * name : 热血
         * bookCount : 330
         * monthlyCount : 0
         * icon : /icon/热血_.png
         */

        private String name;
        private int bookCount;
        private int monthlyCount;
        private String icon;
        private int sign;

        public PictureBean(String name, int sign) {
            this.name = name;
            this.sign = sign;
        }

        public void setSign(int sign) {
            this.sign = sign;
        }

        public int getSign() {
            return sign;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getBookCount() {
            return bookCount;
        }

        public void setBookCount(int bookCount) {
            this.bookCount = bookCount;
        }

        public int getMonthlyCount() {
            return monthlyCount;
        }

        public void setMonthlyCount(int monthlyCount) {
            this.monthlyCount = monthlyCount;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }


    public static class PressBean {
        /**
         * name : 传记名著
         * bookCount : 2801
         * monthlyCount : 0
         * icon : /icon/传记名著_.png
         */

        private String name;
        private int bookCount;
        private int monthlyCount;
        private String icon;
        private int sign;

        public PressBean(String name, int sign) {
            this.name = name;
            this.sign = sign;
        }

        public int getSign() {
            return sign;
        }

        public void setSign(int sign) {
            this.sign = sign;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getBookCount() {
            return bookCount;
        }

        public void setBookCount(int bookCount) {
            this.bookCount = bookCount;
        }

        public int getMonthlyCount() {
            return monthlyCount;
        }

        public void setMonthlyCount(int monthlyCount) {
            this.monthlyCount = monthlyCount;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
