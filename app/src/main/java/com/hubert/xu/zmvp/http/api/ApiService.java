package com.hubert.xu.zmvp.http.api;

import com.hubert.xu.zmvp.entity.TTBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/14
 * Desc  : Api接口
 */

public interface ApiService {

    /**
     * 获取综合讨论区帖子列表
     *
     * @param block      remale:综合讨论区
     *                   original:原创区
     * @param duration   all
     * @param sort       updated:默认排序
     *                   created:最新发布
     *                   coment-count:最多评论
     * @param type       all
     * @param start      0
     * @param limit      20
     * @param distillate true|false(是否精品)
     * @return
     */
    @GET("/post/by-block")
    Observable<TTBean> getComplexDiscussList(@Query("block") String block, @Query("duration") String duration, @Query("sort") String sort, @Query("type") String type, @Query("start") String start, @Query("limit") String limit, @Query("distillate") String distillate);
}
