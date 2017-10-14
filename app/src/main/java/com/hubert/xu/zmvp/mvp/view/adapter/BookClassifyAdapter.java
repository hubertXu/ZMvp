package com.hubert.xu.zmvp.mvp.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.util.MultiTypeDelegate;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.mvp.model.entity.BookclassifyLocalBean;

import java.util.List;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/30
 * Desc  :
 */

public class BookClassifyAdapter extends BaseQuickAdapter<BookclassifyLocalBean.LocalBookClassifyBean, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public BookClassifyAdapter(List<BookclassifyLocalBean.LocalBookClassifyBean> data) {
        super(data);
        setMultiTypeDelegate(new MultiTypeDelegate<BookclassifyLocalBean.LocalBookClassifyBean>() {
            @Override
            protected int getItemType(BookclassifyLocalBean.LocalBookClassifyBean localBookClassifyBean) {
                return localBookClassifyBean.getSign();
            }
        });
        getMultiTypeDelegate().registerItemType(Constants.BOOK_TYPE_SIGN, R.layout.item_book_classify_sign).registerItemType(Constants.BOOK_TYPE_NAME, R.layout.item_book_classify_name);
    }

    @Override
    protected void convert(BaseViewHolder helper, BookclassifyLocalBean.LocalBookClassifyBean item) {
        switch (helper.getItemViewType()) {
            case Constants.BOOK_TYPE_NAME:
                helper.setText(R.id.tv_book_classify_name, item.getName())
                        .setText(R.id.tv_book_classify_count, item.getBookCount()+"");
                break;
            case Constants.BOOK_TYPE_SIGN:
                helper.setText(R.id.tv_book_sign, item.getName());
                break;
        }
    }
}
