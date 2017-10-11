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

public class BookClassifyListMananger {
    private static final BookClassifyListMananger ourInstance = new BookClassifyListMananger();

    public static BookClassifyListMananger getInstance() {
        return ourInstance;
    }

    public void getBookClassifyList(HashMap map, BaseObserver observer) {
        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);
        apiService.getBooksByClassify(map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
