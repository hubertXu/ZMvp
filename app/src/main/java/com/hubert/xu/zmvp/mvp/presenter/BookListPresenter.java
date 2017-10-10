package com.hubert.xu.zmvp.mvp.presenter;

import com.hubert.xu.zmvp.entity.BookListBean;
import com.hubert.xu.zmvp.mvp.contract.BookListContract;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/28
 * Desc  :
 */

public class BookListPresenter implements BookListContract.Presenter {


    private BookListContract.View<BookListBean.BookListsBean> mView;

    public BookListPresenter(BookListContract.View<BookListBean.BookListsBean> view) {
        mView = view;
    }


    @Override
    public void getData() {

    }
}
