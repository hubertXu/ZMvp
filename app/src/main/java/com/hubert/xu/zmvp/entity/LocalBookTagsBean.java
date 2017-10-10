package com.hubert.xu.zmvp.entity;

import com.hubert.xu.zmvp.http.BookBaseBean;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/10/10
 * Desc  :
 */

public class LocalBookTagsBean extends BookBaseBean {


    List<BookTag> bookTags;

    public void setBookTags(List<BookTag> bookTags) {
        this.bookTags = bookTags;
    }

    public List<BookTag> getBookTags() {
        return bookTags;
    }

    public static class BookTag {
        private String name;
        private int sign;
        private boolean selsect;

        public BookTag(String name, int sign) {
            this.name = name;
            this.sign = sign;
        }

        public void setSelsect(boolean selsect) {
            this.selsect = selsect;
        }

        public boolean isSelsect() {
            return selsect;
        }


        public String getName() {
            return name;
        }

        public int getSign() {
            return sign;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSign(int sign) {
            this.sign = sign;
        }
    }
}
