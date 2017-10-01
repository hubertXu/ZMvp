package com.hubert.xu.zmvp.mvp.model;

import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.http.RetrofitClient;
import com.hubert.xu.zmvp.http.api.ApiService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/21
 * Desc  :
 */

public class RankingMannager {
    private static final RankingMannager ourInstance = new RankingMannager();

    public static RankingMannager getInstance() {
        return ourInstance;
    }

    public void getRankingList(String rankingId, BaseObserver observer) {
        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);
        apiService.getRanking(rankingId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
