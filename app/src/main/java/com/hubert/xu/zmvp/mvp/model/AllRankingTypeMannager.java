package com.hubert.xu.zmvp.mvp.model;

import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.entity.AllRankTypeBean;
import com.hubert.xu.zmvp.entity.LocalAllRankingTypeBean;
import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.http.RetrofitClient;
import com.hubert.xu.zmvp.http.api.ApiService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/21
 * Desc  :
 */

public class AllRankingTypeMannager {
    private static final AllRankingTypeMannager ourInstance = new AllRankingTypeMannager();

    public static AllRankingTypeMannager getInstance() {
        return ourInstance;
    }

    public void getAllRankingType(BaseObserver observer) {
        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);
        apiService.getAllRankingTypes().map(new Function<AllRankTypeBean, LocalAllRankingTypeBean>() {
            @Override
            public LocalAllRankingTypeBean apply(@NonNull AllRankTypeBean allRankTypeBean) throws Exception {
                LocalAllRankingTypeBean localAllRankingTypeBean = new LocalAllRankingTypeBean();
                localAllRankingTypeBean.ok = true;
                List<LocalAllRankingTypeBean.RankingBean> rankings = new ArrayList<>();
                rankings.add(new LocalAllRankingTypeBean.RankingBean(Constants.BOOK_TYPE_SIGN, "男生"));
                for (AllRankTypeBean.MaleBean male : allRankTypeBean.getMale()) {
                    LocalAllRankingTypeBean.RankingBean ranking = new LocalAllRankingTypeBean.RankingBean(Constants.BOOK_TYPE_NAME, male.getTitle());
                    ranking.set_id(male.get_id());
                    ranking.setCollapse(male.isCollapse());
                    ranking.setCover(male.getCover());
                    ranking.setMonthRank(male.getMonthRank());
                    ranking.setShortTitle(male.getShortTitle());
                    ranking.setTotalRank(male.getTotalRank());
                    rankings.add(ranking);
                }
                rankings.add(new LocalAllRankingTypeBean.RankingBean(Constants.BOOK_TYPE_SIGN, "女生"));
                for (AllRankTypeBean.FemaleBean female : allRankTypeBean.getFemale()) {
                    LocalAllRankingTypeBean.RankingBean ranking = new LocalAllRankingTypeBean.RankingBean(Constants.BOOK_TYPE_NAME, female.getTitle());
                    ranking.set_id(female.get_id());
                    ranking.setCollapse(female.isCollapse());
                    ranking.setCover(female.getCover());
                    ranking.setMonthRank(female.getMonthRank());
                    ranking.setShortTitle(female.getShortTitle());
                    ranking.setTotalRank(female.getTotalRank());
                    rankings.add(ranking);
                }
                localAllRankingTypeBean.setRanking(rankings);
                return localAllRankingTypeBean;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
