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

public class AllRankingTypeMannager {
    private static final AllRankingTypeMannager ourInstance = new AllRankingTypeMannager();

    public static AllRankingTypeMannager getInstance() {
        return ourInstance;
    }
    public void getBookHelpList( BaseObserver observer) {
        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);
        apiService.getAllRankingTypes().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
