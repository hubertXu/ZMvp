package com.hubert.xu.zmvp.module.fragment;

import android.support.v7.widget.RecyclerView;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseFragment;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/27
 * Desc  :
 */

public class BookShelfFragment extends BaseFragment {

    @BindView(R.id.rl_book_shelf)
    RecyclerView mRlBookShelf;
    Unbinder unbinder;

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_book_shelf;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
