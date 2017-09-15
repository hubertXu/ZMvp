package com.hubert.xu.zmvp.module.model;

import com.hubert.xu.zmvp.entity.DiscussBean;
import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.http.RetrofitClient;
import com.hubert.xu.zmvp.http.api.ApiService;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;

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

    public void getOriginalList(HashMap<String, String> fineParamsMap, HashMap defaultParamsMap, BaseObserver observer) {
        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);
        Observable.zip(apiService.getDiscussList(fineParamsMap), apiService.getDiscussList(defaultParamsMap), new BiFunction<DiscussBean, DiscussBean, DiscussBean>() {

            @Override
            public DiscussBean apply(@NonNull DiscussBean dicussData, @NonNull DiscussBean discussData1) throws Exception {
                List<DiscussBean.PostsBean> dicussList = dicussData.getPosts();
                dicussList.addAll(discussData1.getPosts());
                DiscussBean discussData = new DiscussBean();
                discussData.ok = true;
                discussData.setPosts(dicussList);
                return discussData;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
