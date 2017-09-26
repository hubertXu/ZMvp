package com.hubert.xu.zmvp.mvp.view.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseFragment;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/25
 * Desc  :
 */

public class GirlBookFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.rv_book_girl)
    RecyclerView mRvBookGirl;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;

    @Override
    public void onRefresh() {

    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_girl_book;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }


}
