package com.hubert.xu.zmvp.http.api;

import com.hubert.xu.zmvp.entity.BookReviewListBean;
import com.hubert.xu.zmvp.entity.DiscussListBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/14
 * Desc  : Api接口
 */

public interface ApiService {

    /**
     * 获取综合讨论区帖子列表
     *
     * @param map block      ramble:综合讨论区
     *            original:原创区
     *            duration   all
     *            sort       updated:默认排序
     *            created:最新发布
     *            coment-count:最多评论
     *            type       all
     *            start      0
     *            limit      20
     *            distillate true|false(是否精品)
     * @return
     */
    @GET("/post/by-block")
    Observable<DiscussListBean> getDiscussList(@QueryMap Map<String, String> map);


    /**
     * 获取书评区书评
     *
     * @param map duration   all
     *            sort       updated(默认排序)
     *            created(最新发布)
     *            helpful(最有用的)
     *            comment-count(最多评论)
     *            type       all(全部类型)、xhqh(玄幻奇幻)、dsyn(都市异能)...
     *            start      0
     *            limit      20
     *            distillate true(精品) 、空字符（全部）
     * @return
     */
    @GET("/post/review")
    Observable<BookReviewListBean> getBookeReviewList(@QueryMap Map<String, String> map);
}
