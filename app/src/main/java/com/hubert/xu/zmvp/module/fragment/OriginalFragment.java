package com.hubert.xu.zmvp.module.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseFragment;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/17
 * Desc  :
 */

public class OriginalFragment extends BaseFragment {
    @BindView(R.id.rv_original)
    RecyclerView mRvOriginal;

    public static OriginalFragment newInstance() {
        Bundle args = new Bundle();
        OriginalFragment fragment = new OriginalFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_original;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }
}
