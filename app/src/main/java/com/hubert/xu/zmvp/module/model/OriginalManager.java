package com.hubert.xu.zmvp.module.model;

import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.http.RetrofitClient;
import com.hubert.xu.zmvp.http.api.ApiService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/18
 * Desc  :
 */

public class OriginalManager {

    private static final OriginalManager ourInstance = new OriginalManager();

    public static OriginalManager getInstance() {
        return ourInstance;
    }

    private OriginalManager() {
    }

    public void getOriginalList(String block, String sort, int start, int limit, String distillate, BaseObserver observer) {
        Retrofit instance = RetrofitClient.getInstance();
        ApiService apiService = instance.create(ApiService.class);
        apiService.getComplexDiscussList(block, "all", sort, "all", start + "", limit + "", distillate).subscribeOn(Schedulers.io()) .observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
