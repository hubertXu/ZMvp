package com.hubert.xu.zmvp.http.api;

import com.hubert.xu.zmvp.entity.DiscussBean;

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
     * @param map
     *        block      ramble:综合讨论区
     *                   original:原创区
     *        duration   all
     *        sort       updated:默认排序
     *                   created:最新发布
     *                   coment-count:最多评论
     *        type       all
     *        start      0
     *        limit      20
     *        distillate true|false(是否精品)
     * @return
     */
    @GET("/post/by-block")
    Observable<DiscussBean> getDiscussList(@QueryMap Map<String,String> map);
}
