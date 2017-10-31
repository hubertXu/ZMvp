package com.hubert.xu.zmvp.mvp.view.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseFragment;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/27
 * Desc  :
 */

public class BookShelfFragment extends BaseFragment {

    @BindView(R.id.rv_book_shelf)
    RecyclerView mRvBookShelf;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_book_shelf;
    }

    @Override
    public void initView() {

    }
}
