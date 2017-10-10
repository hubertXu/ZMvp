package com.hubert.xu.zmvp.mvp.model;

import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.entity.BookTagBean;
import com.hubert.xu.zmvp.entity.LocalBookTagsBean;
import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.http.RetrofitClient;
import com.hubert.xu.zmvp.http.api.ApiService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/21
 * Desc  :
 */

public class BookTagMananger {
    private static final BookTagMananger ourInstance = new BookTagMananger();

    public static BookTagMananger getInstance() {
        return ourInstance;
    }

    public void getBookTag(BaseObserver observer) {
        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);
        apiService.getBookListTags().map(booktags -> {
            LocalBookTagsBean localBookTagsBean = new LocalBookTagsBean();
            localBookTagsBean.ok = true;
            List<LocalBookTagsBean.BookTag> localBookTags = new ArrayList<>();
            localBookTags.add(new LocalBookTagsBean.BookTag("性别", Constants.BOOK_TYPE_SIGN));
            localBookTags.add(new LocalBookTagsBean.BookTag("男生", Constants.BOOK_TYPE_NAME));
            localBookTags.add(new LocalBookTagsBean.BookTag("女生", Constants.BOOK_TYPE_NAME));
            for (BookTagBean.DataBean data : booktags.getData()) {
                localBookTags.add(new LocalBookTagsBean.BookTag(data.getName(), Constants.BOOK_TYPE_SIGN));
                for (String tag : data.getTags()) {
                    localBookTags.add(new LocalBookTagsBean.BookTag(tag, Constants.BOOK_TYPE_NAME));
                }
            }
            localBookTagsBean.setBookTags(localBookTags);
            return localBookTagsBean;
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
