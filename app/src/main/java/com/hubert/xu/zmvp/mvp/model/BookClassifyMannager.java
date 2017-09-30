package com.hubert.xu.zmvp.mvp.model;

import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.entity.BookClassifyBean;
import com.hubert.xu.zmvp.entity.BookClassifyLv2Bean;
import com.hubert.xu.zmvp.entity.BookclassifyLocalBean;
import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.http.RetrofitClient;
import com.hubert.xu.zmvp.http.api.ApiService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/21
 * Desc  :
 */

public class BookClassifyMannager {
    private static final BookClassifyMannager ourInstance = new BookClassifyMannager();

    public static BookClassifyMannager getInstance() {
        return ourInstance;
    }

    public void getBookClassify(BaseObserver observer) {
        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);
        Observable.zip(apiService.getBookClassify(), apiService.getBookClassifyLv2(), new BiFunction<BookClassifyBean, BookClassifyLv2Bean, BookclassifyLocalBean>() {
            @Override
            public BookclassifyLocalBean apply(@NonNull BookClassifyBean bookClassifyBean, @NonNull BookClassifyLv2Bean bookClassifyLv2Bean) throws Exception {
                BookclassifyLocalBean bookClassifyLocalData = new BookclassifyLocalBean();
                List<BookclassifyLocalBean.LocalBookClassifyBean> localBookClassifyList = new ArrayList<>();
                localBookClassifyList.add(new BookclassifyLocalBean.LocalBookClassifyBean(Constants.BOOK_TYPE_SIGN, "男生", 0, null));
                for (BookClassifyBean.MaleBean male : bookClassifyBean.getMale()) {
                    for (BookClassifyLv2Bean.MaleBean lv2Male : bookClassifyLv2Bean.getMale()) {
                        if (male.getName().equals(lv2Male.getMajor())) {
                            localBookClassifyList.add(new BookclassifyLocalBean.LocalBookClassifyBean(Constants.BOOK_TYPE_NAME, male.getName(), male.getBookCount(), lv2Male.getMins()));
                        }
                    }
                }
                localBookClassifyList.add(new BookclassifyLocalBean.LocalBookClassifyBean(Constants.BOOK_TYPE_SIGN, "女生", 0, null));
                for (BookClassifyBean.FemaleBean female : bookClassifyBean.getFemale()) {
                    for (BookClassifyLv2Bean.FemaleBean lv2Female : bookClassifyLv2Bean.getFemale()) {
                        if (female.getName().equals(lv2Female.getMajor())) {
                            localBookClassifyList.add(new BookclassifyLocalBean.LocalBookClassifyBean(Constants.BOOK_TYPE_NAME, female.getName(), female.getBookCount(), lv2Female.getMins()));
                        }
                    }
                }
                localBookClassifyList.add(new BookclassifyLocalBean.LocalBookClassifyBean(Constants.BOOK_TYPE_SIGN, "漫画", 0, null));
                for (BookClassifyBean.PictureBean catroon : bookClassifyBean.getPicture()) {
                    localBookClassifyList.add(new BookclassifyLocalBean.LocalBookClassifyBean(Constants.BOOK_TYPE_NAME, catroon.getName(), catroon.getBookCount(), null));
                }
                localBookClassifyList.add(new BookclassifyLocalBean.LocalBookClassifyBean(Constants.BOOK_TYPE_SIGN, "出版", 0, null));
                for (BookClassifyBean.PressBean publication : bookClassifyBean.getPress()) {
                    localBookClassifyList.add(new BookclassifyLocalBean.LocalBookClassifyBean(Constants.BOOK_TYPE_NAME, publication.getName(), publication.getBookCount(), null));
                }
                bookClassifyLocalData.setLocalBookclassifys(localBookClassifyList);
                bookClassifyLocalData.ok = true;
                return bookClassifyLocalData;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
