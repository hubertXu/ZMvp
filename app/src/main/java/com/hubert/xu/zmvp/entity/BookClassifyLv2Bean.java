package com.hubert.xu.zmvp.entity;

import com.hubert.xu.zmvp.http.BookBaseBean;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/29
 * Desc  :
 */

public class BookClassifyLv2Bean extends BookBaseBean{

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
         * major : 玄幻
         * mins : ["东方玄幻","异界大陆","异界争霸","远古神话"]
         */

        private String major;
        private List<String> mins;

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public List<String> getMins() {
            return mins;
        }

        public void setMins(List<String> mins) {
            this.mins = mins;
        }
    }


    public static class FemaleBean {
        /**
         * major : 古代言情
         * mins : ["穿越时空","古代历史","古典架空","宫闱宅斗","经商种田"]
         */

        private String major;
        private List<String> mins;

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public List<String> getMins() {
            return mins;
        }

        public void setMins(List<String> mins) {
            this.mins = mins;
        }
    }


    public static class PictureBean {
        /**
         * major : 热血
         * mins : []
         */

        private String major;
        private List<?> mins;

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public List<?> getMins() {
            return mins;
        }

        public void setMins(List<?> mins) {
            this.mins = mins;
        }
    }


    public static class PressBean {
        /**
         * major : 出版小说
         * mins : []
         */

        private String major;
        private List<?> mins;

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public List<?> getMins() {
            return mins;
        }

        public void setMins(List<?> mins) {
            this.mins = mins;
        }
    }
}
