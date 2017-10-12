package com.hubert.xu.zmvp.mvp.model.entity;

import com.hubert.xu.zmvp.http.BookBaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/30
 * Desc  :
 */

public class BookclassifyLocalBean extends BookBaseBean {


    private List<LocalBookClassifyBean> localBookclassifys;

    public List<LocalBookClassifyBean> getLocalBookclassifys() {
        return localBookclassifys;
    }

    public void setLocalBookclassifys(List<LocalBookClassifyBean> localBookclassifys) {
        this.localBookclassifys = localBookclassifys;
    }

    public static class LocalBookClassifyBean implements Serializable {

        private int sign;
        private String name;
        private int bookCount;
        private List<String> lv2ClassifyNames;
        private String type;


        public LocalBookClassifyBean(int sign, String type, String name, int bookCount, List<String> lv2ClassifyNames) {
            this.sign = sign;
            this.name = name;
            this.type = type;
            this.bookCount = bookCount;
            this.lv2ClassifyNames = lv2ClassifyNames;
        }

        public void setLv2ClassifyNames(List<String> lv2ClassifyNames) {
            this.lv2ClassifyNames = lv2ClassifyNames;
        }

        public List<String> getLv2ClassifyNames() {
            return lv2ClassifyNames;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public int getSign() {
            return sign;
        }

        public String getName() {
            return name;
        }

        public int getBookCount() {
            return bookCount;
        }

        public void setSign(int sign) {
            this.sign = sign;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setBookCount(int bookCount) {
            this.bookCount = bookCount;
        }
    }
}
