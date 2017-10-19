package com.hubert.xu.zmvp.http.api;

import com.hubert.xu.zmvp.mvp.model.entity.AllRankTypeBean;
import com.hubert.xu.zmvp.mvp.model.entity.BookClassifyBean;
import com.hubert.xu.zmvp.mvp.model.entity.BookClassifyListBean;
import com.hubert.xu.zmvp.mvp.model.entity.BookClassifyLv2Bean;
import com.hubert.xu.zmvp.mvp.model.entity.BookDetailBean;
import com.hubert.xu.zmvp.mvp.model.entity.BookHelpListBean;
import com.hubert.xu.zmvp.mvp.model.entity.BookListBean;
import com.hubert.xu.zmvp.mvp.model.entity.BookListDetailBean;
import com.hubert.xu.zmvp.mvp.model.entity.BookListTagBean;
import com.hubert.xu.zmvp.mvp.model.entity.BookReviewListBean;
import com.hubert.xu.zmvp.mvp.model.entity.BookTagBean;
import com.hubert.xu.zmvp.mvp.model.entity.CommentListBean;
import com.hubert.xu.zmvp.mvp.model.entity.DiscussListBean;
import com.hubert.xu.zmvp.mvp.model.entity.GirlBookListBean;
import com.hubert.xu.zmvp.mvp.model.entity.HotReviewBean;
import com.hubert.xu.zmvp.mvp.model.entity.HotWordBean;
import com.hubert.xu.zmvp.mvp.model.entity.RankingBean;
import com.hubert.xu.zmvp.mvp.model.entity.RecommendBookBean;
import com.hubert.xu.zmvp.mvp.model.entity.RecommendBookListBean;
import com.hubert.xu.zmvp.mvp.model.entity.ReviewDetailBean;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
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
    Observable<BookReviewListBean> getBookReviewList(@QueryMap Map<String, String> map);

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
     *
     * @param rankingId 周榜    改类型排行的_id值
     *                  月榜    改类型排行的monthRank值
     *                  总榜    改类型排行的totalRank值
     * @return
     */
    @GET("/ranking/{rankingId}")
    Observable<RankingBean> getRanking(@Path("rankingId") String rankingId);

    /**
     * 获取分类
     *
     * @return
     */
    @GET("/cats/lv2/statistics")
    Observable<BookClassifyBean> getBookClassify();


    /**
     * 获取二级分类
     *
     * @return
     */
    @GET("/cats/lv2")
    Observable<BookClassifyLv2Bean> getBookClassifyLv2();

    /**
     * 获取当前分类的书籍
     *
     * @param map gender male|female
     *            type   hot(热门)|new(新书)|reputation(好评)|over(完结)
     *            major  一级分类名
     *            minor  二级分类名
     *            limit  50
     * @return
     */
    @GET("/book/by-categories")
    Observable<BookClassifyListBean> getBooksByClassify(@QueryMap HashMap<String, String> map);

    /**
     * 获取主题书单列表
     * 本周最热：    duration=last-seven-days&sort=collectorCount
     * 最新发布：    duration=all&sort=created
     * 最多收藏：    duration=all&sort=collectorCount
     * tag:         都市、古代、架空、重生、玄幻、网游
     * gender:      male、female
     * limit        20
     *
     * @param map
     * @return
     */
    @GET("/book-list")
    Observable<BookListBean> getBookList(@QueryMap HashMap<String, String> map);


    /**
     * 获取主题书单标签列表
     *
     * @return
     */
    @GET("/book-list/tagType")
    Observable<BookTagBean> getBookListTags();

    /**
     * 获取书单详情
     *
     * @return
     */
    @GET("/book-list/{bookListId}")
    Observable<BookListDetailBean> getBookListDetail(@Path("bookListId") String bookListId);

    /**
     * 获取热词
     *
     * @return
     */
    @GET("/book/hot-word")
    Observable<HotWordBean> getHotWord();

    /**
     * 获取书籍详情页
     *
     * @return
     */
    @GET("/book/{bookId}")
    Observable<BookDetailBean> getBookDetail(@Path("bookId") String bookId);


    /**
     * 根据书籍推荐书单
     *
     * @param bookId
     * @param limit
     * @return
     */
    @GET("/book-list/{bookId}/recommend")
    Observable<RecommendBookListBean> getRecommendBookList(@Path("bookId") String bookId, @Query("limit") String limit);

    /**
     * 根据书籍推荐书
     *
     * @param bookId
     * @param limit
     * @return
     */
    @GET("/book/{bookId}/recommend")
    Observable<RecommendBookBean> getRecommendBook(@Path("bookId") String bookId, @Query("limit") String limit);


    /**
     * 获取当前书籍的热门评论
     *
     * @param book
     * @return
     */
    @GET("/post/review/best-by-book")
    Observable<HotReviewBean> getBookHotReview(@Query("book") String book);

    /**
     * 获取书籍详情讨论列表
     * <p>
     * book  bookId
     * sort  updated(默认排序)|created(最新发布)|comment-count(最多评论)
     * type  normal|vote
     * start 0
     * limit 20
     *
     * @return
     */
    @GET("/post/by-book")
    Observable<DiscussListBean> getDisscussionListByBook(@QueryMap HashMap<String, String> map);

    /**
     * 获取书籍详情书评列表
     * <p>
     * book  bookId
     * sort  updated(默认排序)|created(最新发布)|comment-count(最多评论)
     * start 0
     * limit 20
     *
     * @return
     */
    @GET("/post/review/by-book")
    Observable<HotReviewBean> getReviewListByBook(@QueryMap HashMap<String, String> map);

    /**
     * 通过tag获取当前类型书
     *
     * @param map
     * @return
     */
    @GET("/book/by-tags")
    Observable<BookListTagBean> getBookListByTag(@QueryMap HashMap<String, String> map);

    /**
     * 获取书评详情
     *
     * @param dicussionId
     * @return
     */
    @GET("/post/{disscussionId}")
    Observable<ReviewDetailBean> getReviewDetail(@Path("disscussionId") String dicussionId);

    /**
     * 获取神评
     *
     * @param dicussionId
     * @return
     */
    @GET("/post/{disscussionId}/comment/best")
    Observable<CommentListBean> getBestComment(@Path("disscussionId") String dicussionId);

    /**
     * 获取综合讨论区帖子详情内的评论列表
     *
     * @param disscussionId
     * @param map
     * @return
     */
    @GET("/post/{disscussionId}/comment")
    Observable<CommentListBean> getBookDisscussionComments(@Path("disscussionId") String disscussionId, @QueryMap HashMap<String, String> map);

}
