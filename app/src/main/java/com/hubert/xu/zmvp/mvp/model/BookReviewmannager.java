package com.hubert.xu.zmvp.mvp.model;

import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.http.RetrofitClient;
import com.hubert.xu.zmvp.http.api.ApiService;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/21
 * Desc  :
 */

public class BookReviewmannager {

    private static final BookReviewmannager ourInstance = new BookReviewmannager();

    public static BookReviewmannager getInstance() {
        return ourInstance;
    }
    public void getBookReviewList(HashMap defaultParamsMap, BaseObserver observer) {
        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);
        apiService.getBookReviewList(defaultParamsMap).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
