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

public class BookHelpMannager {
    private static final BookHelpMannager ourInstance = new BookHelpMannager();

    public static BookHelpMannager getInstance() {
        return ourInstance;
    }
    public void getBookHelpList(HashMap defaultParamsMap, BaseObserver observer) {
        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);
        apiService.getBookHelpList(defaultParamsMap).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
