package com.hubert.xu.zmvp.mvp.model.entity;

import com.hubert.xu.zmvp.http.BookBaseBean;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/10/11
 * Desc  :
 */

public class BookListDetailBean extends BookBaseBean {

    private BookListBean bookList;

    public BookListBean getBookList() {
        return bookList;
    }

    public void setBookList(BookListBean bookList) {
        this.bookList = bookList;
    }

    public static class BookListBean {

        private String _id;
        private String updated;
        private String title;
        private AuthorBean author;
        private String desc;
        private String gender;
        private String created;
        private Object stickStopTime;
        private boolean isDraft;
        private Object isDistillate;
        private int collectorCount;
        private String shareLink;
        private String id;
        private int total;
        private List<String> tags;
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

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public Object getStickStopTime() {
            return stickStopTime;
        }

        public void setStickStopTime(Object stickStopTime) {
            this.stickStopTime = stickStopTime;
        }

        public boolean isIsDraft() {
            return isDraft;
        }

        public void setIsDraft(boolean isDraft) {
            this.isDraft = isDraft;
        }

        public Object getIsDistillate() {
            return isDistillate;
        }

        public void setIsDistillate(Object isDistillate) {
            this.isDistillate = isDistillate;
        }

        public int getCollectorCount() {
            return collectorCount;
        }

        public void setCollectorCount(int collectorCount) {
            this.collectorCount = collectorCount;
        }

        public String getShareLink() {
            return shareLink;
        }

        public void setShareLink(String shareLink) {
            this.shareLink = shareLink;
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

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public List<BooksBean> getBooks() {
            return books;
        }

        public void setBooks(List<BooksBean> books) {
            this.books = books;
        }

        public static class AuthorBean {
            /**
             * _id : 540c509f15396d056e8809d4
             * avatar : /avatar/16/d0/16d0b32b7707d6c66da4be058f6cea46
             * nickname : 莞莞
             * type : normal
             * lv : 10
             */

            private String _id;
            private String avatar;
            private String nickname;
            private String type;
            private int lv;

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
        }


        public static class BooksBean {


            private BookBean book;
            private String comment;

            public BookBean getBook() {
                return book;
            }

            public void setBook(BookBean book) {
                this.book = book;
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public static class BookBean {
                /**
                 * cat : 古典架空
                 * _id : 58c80c7f882c1f62026fbee0
                 * title : 大帝姬
                 * author : 希行
                 * longIntro : 穿越的薛青发现自己女扮男装在骗婚。不仅如此她还有一个更大的骗局。--------这是一个有很多秘密的人的故事
                 * cover : /agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1477507%2F_1477507_361880.jpg%2F
                 * site : zhuishuvip
                 * majorCate : 古代言情
                 * minorCate : 古典架空
                 * banned : 0
                 * latelyFollower : 5960
                 * wordCount : 1045113
                 * retentionRatio : 54.67
                 */

                private String cat;
                private String _id;
                private String title;
                private String author;
                private String longIntro;
                private String cover;
                private String site;
                private String majorCate;
                private String minorCate;
                private int banned;
                private int latelyFollower;
                private int wordCount;
                private double retentionRatio;

                public String getCat() {
                    return cat;
                }

                public void setCat(String cat) {
                    this.cat = cat;
                }

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

                public String getLongIntro() {
                    return longIntro;
                }

                public void setLongIntro(String longIntro) {
                    this.longIntro = longIntro;
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

                public int getWordCount() {
                    return wordCount;
                }

                public void setWordCount(int wordCount) {
                    this.wordCount = wordCount;
                }

                public double getRetentionRatio() {
                    return retentionRatio;
                }

                public void setRetentionRatio(double retentionRatio) {
                    this.retentionRatio = retentionRatio;
                }
            }
        }
    }
}
