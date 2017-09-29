package com.hubert.xu.zmvp.mvp.presenter;

import com.hubert.xu.zmvp.entity.BookClassifyBean;
import com.hubert.xu.zmvp.http.BaseObserver;
import com.hubert.xu.zmvp.mvp.contract.BookClassifyContract;
import com.hubert.xu.zmvp.mvp.model.BookClassifyMannager;

import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/29
 * Desc  :
 */

public class BookClassifyPresenter implements BookClassifyContract.Presenter {


    private BookClassifyContract.View mView;

    public BookClassifyPresenter(BookClassifyContract.View view) {
        mView = view;
    }

    @Override
    public void getData() {
        BookClassifyMannager.getInstance().getBookClassify(new BaseObserver<BookClassifyBean>() {
            @Override
            public void subscribe(Disposable d) {

            }

            @Override
            public void next(BookClassifyBean bookClassifyBean) {
       /*         List<BookClassifyBean.MaleBean> males = bookClassifyBean.getMale();
                for (BookClassifyBean.MaleBean male : males) {
                    male.setSign(Constants.RANKING_TYPE_NAME);
                }
                males.add(0, new BookClassifyBean.MaleBean("男生", 0, 0, "", Constants.RANKING_TYPE_SIGN));
                LogUtil.info(new Gson().toJson(bookClassifyBean.getMale(),BookClassifyBean.MaleBean.class));*/
                mView.setData(bookClassifyBean);
            }

            @Override
            public void error(Throwable e) {
                mView.showError();
            }

            @Override
            public void completed() {

            }
        });
    }
}
