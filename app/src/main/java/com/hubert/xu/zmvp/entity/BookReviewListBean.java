package com.hubert.xu.zmvp.entity;

import com.hubert.xu.zmvp.http.BookBaseBean;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/21
 * Desc  :
 */

public class BookReviewListBean extends BookBaseBean {


    /**
     * reviews : [{"_id":"59ba9104b4cb80352b144a5e","book":{"_id":"50865988d7a545903b000009","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F41615%2F_41615_067553.jpg%2F","title":"斗破苍穹","site":"zhuishuvip","type":"xhqh","latelyFollower":null,"retentionRatio":null},"helpful":{"total":148,"yes":187,"no":39},"likeCount":8,"haveImage":false,"state":"distillate","updated":"2017-09-21T08:28:10.634Z","created":"2017-09-14T14:24:04.767Z","title":"【丙类】关于纳兰嫣然的看法"},{"_id":"59a7b98e48a3b73d6ea55e25","book":{"_id":"50ac662fde1233e062000001","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F23794%2F_23794_790294.jpg%2F","title":"问镜","site":"zhuishuvip","type":"xhqh","latelyFollower":null,"retentionRatio":null},"helpful":{"total":21,"yes":25,"no":4},"likeCount":5,"haveImage":false,"state":"distillate","updated":"2017-09-21T08:01:25.642Z","created":"2017-08-31T07:23:58.843Z","title":"关于仙侠，随便谈谈"},{"_id":"599b7e7f5835fd170e53a81d","book":{"_id":"50874750abf1ced53c000037","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F41622%2F_41622_109607.jpg%2F","title":"恶魔法则","site":"zhuishuvip","type":"xhqh","latelyFollower":null,"retentionRatio":null},"helpful":{"total":16,"yes":24,"no":8},"likeCount":4,"haveImage":false,"state":"distillate","updated":"2017-09-19T19:29:45.135Z","created":"2017-08-22T00:44:47.427Z","title":"相信小五，他会回来的"},{"_id":"5999df059067689d5430ad62","book":{"_id":"51ca3c026f5432ef5000016a","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F41825%2F_41825_044432.jpg%2F","title":"魔王奶爸","site":"zhuishuvip","type":"xhqh","latelyFollower":null,"retentionRatio":null},"helpful":{"total":36,"yes":57,"no":21},"likeCount":2,"haveImage":false,"state":"distillate","updated":"2017-09-19T00:12:14.358Z","created":"2017-08-20T19:12:05.631Z","title":"是本好书，但是不适合我"},{"_id":"5991165ce376b82a5692cac5","book":{"_id":"50874893abf1ced53c00003d","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F80727%2F_80727_739555.jpg%2F","title":"历史的尘埃","site":"zhuishuvip","type":"xhqh","latelyFollower":null,"retentionRatio":null},"helpful":{"total":32,"yes":40,"no":8},"likeCount":1,"haveImage":false,"state":"distillate","updated":"2017-09-19T03:26:34.000Z","created":"2017-08-14T03:17:48.494Z","title":"【历史的尘埃】众人皆苦，唯我孤独"},{"_id":"5989a099973d304a066d5010","book":{"_id":"520da5d2dd2dfa6926000fc0","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F41991%2F_41991_812376.jpg%2F","site":"zhuishuvip","title":"完美世界","type":"xhqh","latelyFollower":null,"retentionRatio":null},"helpful":{"total":101,"yes":121,"no":20},"likeCount":4,"haveImage":false,"state":"distillate","updated":"2017-09-19T14:22:06.074Z","created":"2017-08-08T11:29:29.181Z","title":"【荒天帝：石昊】"},{"_id":"597edc25bbb88ba10b5cd234","book":{"_id":"508646479dacd30e3a000001","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F42314%2F_42314_705796.jpg%2F","title":"将夜","site":"zhuishuvip","type":"xhqh","latelyFollower":null,"retentionRatio":null},"helpful":{"total":55,"yes":71,"no":16},"likeCount":4,"haveImage":false,"state":"distillate","updated":"2017-09-20T11:34:15.884Z","created":"2017-07-31T07:28:37.694Z","title":"青双十载碧褪尽，心可尤还初？"},{"_id":"597d5cb4dd19b8bf1cfc2de4","book":{"_id":"514a653305f5c4c57e000003","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F44350%2F_44350_710406.jpg%2F","title":"九星天辰诀","site":"zhuishuvip","type":"xhqh","latelyFollower":null,"retentionRatio":null},"helpful":{"total":284,"yes":341,"no":57},"likeCount":7,"haveImage":false,"state":"distillate","updated":"2017-09-21T06:38:04.235Z","created":"2017-07-30T04:12:36.247Z","title":"请不要侮辱读者的智商和情商"},{"_id":"59786f87bf6af26c326a99e3","book":{"_id":"5228093b9a23c76822000798","cover":"/agent/http://s1.static.jjwxc.net/frontcover/000/288/288921.jpg","site":"zhuishuvip","title":"你是我学生又怎样","type":"xhqh","latelyFollower":null,"retentionRatio":null},"helpful":{"total":67,"yes":68,"no":1},"likeCount":3,"haveImage":false,"state":"distillate","updated":"2017-09-18T18:03:58.444Z","created":"2017-07-26T10:31:35.205Z","title":"年龄的距离，不是都产生悲剧(ง \u2022̀_\u2022́)ง"},{"_id":"596fd9372b6cc7f91e3c599c","book":{"_id":"5272db44daf0c6a71800efca","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F41762%2F_41762_057841.jpg%2F","site":"zhuishuvip","title":"九阳剑圣","type":"xhqh","latelyFollower":null,"retentionRatio":null},"helpful":{"total":51,"yes":72,"no":21},"likeCount":2,"haveImage":false,"state":"distillate","updated":"2017-09-15T03:46:51.031Z","created":"2017-07-19T22:12:07.972Z","title":"萨满系列之论一波剑圣"},{"_id":"59623c57ad7a209a196e0312","book":{"_id":"51d11e782de6405c45000068","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F41569%2F_41569_056809.jpg%2F","title":"大主宰","site":"zhuishuvip","type":"xhqh","latelyFollower":null,"retentionRatio":null},"helpful":{"total":341,"yes":389,"no":48},"likeCount":21,"haveImage":false,"state":"distillate","updated":"2017-09-14T08:55:31.936Z","created":"2017-07-09T14:23:19.361Z","title":"说说心里话"},{"_id":"59592001512b0d0c3b9744c0","book":{"_id":"523c58dad71313be65001350","cover":"/cover/28/283d7e6b50b16bbcd19eaeb7a88984c0.jpg","site":"w3gsc","title":"谨言","type":"xhqh","latelyFollower":null,"retentionRatio":null},"helpful":{"total":111,"yes":120,"no":9},"likeCount":6,"haveImage":false,"state":"distillate","updated":"2017-09-02T16:27:23.798Z","created":"2017-07-02T16:32:01.126Z","title":"文章很好，但弊端也很明显，不过瑕不掩瑜"},{"_id":"595486f892f11617300132a8","book":{"_id":"5346719e95dbc0ff09000625","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F44249%2F_44249_036807.jpg%2F","title":"一女御皇","site":"zhuishuvip","type":"xhqh","latelyFollower":null,"retentionRatio":null},"helpful":{"total":92,"yes":101,"no":9},"likeCount":5,"haveImage":false,"state":"distillate","updated":"2017-09-19T13:55:06.776Z","created":"2017-06-29T04:50:00.674Z","title":"最爱之一 需要细细品味"},{"_id":"593d2e82bf2f2df40e57678b","book":{"_id":"50975b961db679b876000029","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F22517%2F_22517_365231.jpg%2F","title":"雪中悍刀行","site":"zhuishuvip","type":"xhqh","latelyFollower":null,"retentionRatio":null},"helpful":{"total":0,"yes":155,"no":155},"likeCount":13,"haveImage":false,"state":"distillate","updated":"2017-09-06T14:41:25.397Z","created":"2017-06-11T11:50:26.479Z","title":"【杂谈】还不错，但离所谓神作，差距还很大。"},{"_id":"59378c7441614acc68944cf1","book":{"_id":"53464a58f9d2e29566003229","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F59052%2F_59052_613771.jpg%2F","title":"仙本纯良","site":"zhuishuvip","type":"xhqh","latelyFollower":null,"retentionRatio":null},"helpful":{"total":100,"yes":110,"no":10},"likeCount":10,"haveImage":false,"state":"distillate","updated":"2017-09-19T02:13:39.135Z","created":"2017-06-07T05:17:40.809Z","title":"仙本纯良:奈何还是人"},{"_id":"593414353c68d0026438aae8","book":{"_id":"508646479dacd30e3a000001","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F42314%2F_42314_705796.jpg%2F","title":"将夜","site":"zhuishuvip","type":"xhqh","latelyFollower":null,"retentionRatio":null},"helpful":{"total":205,"yes":236,"no":31},"likeCount":20,"haveImage":false,"state":"distillate","updated":"2017-09-21T06:41:13.335Z","created":"2017-06-04T14:07:49.966Z","title":"【随感】所谓将夜，所谓情"},{"_id":"592da66835394f4f2eab4105","book":{"_id":"508751bef98e8f7446000024","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F41924%2F_41924_539975.jpg%2F","title":"神墓","site":"zhuishuvip","type":"xhqh","latelyFollower":null,"retentionRatio":null},"helpful":{"total":41,"yes":123,"no":82},"likeCount":12,"haveImage":false,"state":"distillate","updated":"2017-09-18T07:13:38.821Z","created":"2017-05-30T17:05:44.625Z","title":"【个人观点，不喜勿碰】没看完神墓却说神墓不好的的朋友请进来看完这些好吗？"},{"_id":"5913fb5931d3f0a97e686050","book":{"_id":"508646479dacd30e3a000001","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F42314%2F_42314_705796.jpg%2F","title":"将夜","site":"zhuishuvip","type":"xhqh","latelyFollower":null,"retentionRatio":null},"helpful":{"total":-2,"yes":15,"no":17},"likeCount":2,"haveImage":false,"state":"distillate","updated":"2017-09-14T08:59:02.003Z","created":"2017-05-11T05:49:13.631Z","title":"看到山山党说宁缺辜负她的一片痴心"},{"_id":"590e485abf0069327b60efee","book":{"_id":"53855a750ac0b3a41e00c7e6","title":"择天记","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F42207%2F_42207_144424.jpg%2F","site":"zhuishuvip","type":"xhqh","latelyFollower":null,"retentionRatio":null},"helpful":{"no":103,"yes":1622,"total":1519},"likeCount":107,"haveImage":false,"state":"distillate","updated":"2017-09-20T16:36:29.720Z","created":"2017-05-06T22:04:10.318Z","title":"虎头蛇尾最厉害的一次。"},{"_id":"5908cc6823fd3a0a0db31fc4","book":{"_id":"5209e0bbd95524701b001e66","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F22554%2F_22554_631422.jpg%2F","site":"zhuishuvip","title":"仙魔变","type":"xhqh","latelyFollower":null,"retentionRatio":null},"helpful":{"total":139,"yes":156,"no":17},"likeCount":11,"haveImage":false,"state":"distillate","updated":"2017-09-20T05:49:24.190Z","created":"2017-05-02T18:14:00.570Z","title":"完完整整的看了很多遍，有些想说的，暂时没想到很完美的标题。"}]
     * ok : true
     */

    private boolean ok;
    private List<ReviewsBean> reviews;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<ReviewsBean> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewsBean> reviews) {
        this.reviews = reviews;
    }

    public  class ReviewsBean {
        /**
         * _id : 59ba9104b4cb80352b144a5e
         * book : {"_id":"50865988d7a545903b000009","cover":"/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F41615%2F_41615_067553.jpg%2F","title":"斗破苍穹","site":"zhuishuvip","type":"xhqh","latelyFollower":null,"retentionRatio":null}
         * helpful : {"total":148,"yes":187,"no":39}
         * likeCount : 8
         * haveImage : false
         * state : distillate
         * updated : 2017-09-21T08:28:10.634Z
         * created : 2017-09-14T14:24:04.767Z
         * title : 【丙类】关于纳兰嫣然的看法
         */

        private String _id;
        private BookBean book;
        private HelpfulBean helpful;
        private int likeCount;
        private boolean haveImage;
        private String state;
        private String updated;
        private String created;
        private String title;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public BookBean getBook() {
            return book;
        }

        public void setBook(BookBean book) {
            this.book = book;
        }

        public HelpfulBean getHelpful() {
            return helpful;
        }

        public void setHelpful(HelpfulBean helpful) {
            this.helpful = helpful;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public boolean isHaveImage() {
            return haveImage;
        }

        public void setHaveImage(boolean haveImage) {
            this.haveImage = haveImage;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public  class BookBean {
            /**
             * _id : 50865988d7a545903b000009
             * cover : /agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F41615%2F_41615_067553.jpg%2F
             * title : 斗破苍穹
             * site : zhuishuvip
             * type : xhqh
             * latelyFollower : null
             * retentionRatio : null
             */

            private String _id;
            private String cover;
            private String title;
            private String site;
            private String type;
            private Object latelyFollower;
            private Object retentionRatio;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSite() {
                return site;
            }

            public void setSite(String site) {
                this.site = site;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public Object getLatelyFollower() {
                return latelyFollower;
            }

            public void setLatelyFollower(Object latelyFollower) {
                this.latelyFollower = latelyFollower;
            }

            public Object getRetentionRatio() {
                return retentionRatio;
            }

            public void setRetentionRatio(Object retentionRatio) {
                this.retentionRatio = retentionRatio;
            }
        }


        public  class HelpfulBean {
            /**
             * total : 148
             * yes : 187
             * no : 39
             */

            private int total;
            private int yes;
            private int no;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getYes() {
                return yes;
            }

            public void setYes(int yes) {
                this.yes = yes;
            }

            public int getNo() {
                return no;
            }

            public void setNo(int no) {
                this.no = no;
            }
        }
    }
}
