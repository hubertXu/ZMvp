package com.hubert.xu.zmvp.http.api;

import com.hubert.xu.zmvp.entity.AllRankTypeBean;
import com.hubert.xu.zmvp.entity.BookHelpListBean;
import com.hubert.xu.zmvp.entity.BookReviewListBean;
import com.hubert.xu.zmvp.entity.DiscussListBean;
import com.hubert.xu.zmvp.entity.GirlBookListBean;
import com.hubert.xu.zmvp.entity.RankingBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
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

    /**
     * 获取书荒区帖子列表
     * 全部、默认排序  http://api.zhuishushenqi.com/post/help?duration=all&sort=updated&start=0&limit=20&distillate=
     * 精品、默认排序  http://api.zhuishushenqi.com/post/help?duration=all&sort=updated&start=0&limit=20&distillate=true
     * <p>
     * duration   all
     * sort       updated(默认排序)
     * created(最新发布)
     * comment-count(最多评论)
     * start      0
     * limit      20
     * distillate true(精品) 、空字符（全部）
     *
     * @return
     */
    @GET("/post/help")
    Observable<BookHelpListBean> getBookHelpList(@QueryMap Map<String, String> map);

    /**
     * 获取综合讨论区帖子列表
     *
     * @param map block      ramble:综合讨论区
     *            original:原创区
     *            duration   all girl 女生区
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
    Observable<GirlBookListBean> getGirlBookList(@QueryMap Map<String, String> map);


    /**
     * 获取所有排行榜类型
     *
     * @return
     */
    @GET("/ranking/gender")
    Observable<AllRankTypeBean> getAllRankingTypes();

    /**
     * 获取单一排行
     * @param rankingId
     *        周榜    改类型排行的_id值
     *        月榜    改类型排行的monthRank值
     *        总榜    改类型排行的totalRank值
     * @return
     */
    @GET("/ranking/{rankingId}")
    Observable<RankingBean> getRanking(@Path("rankingId") String rankingId);
}
