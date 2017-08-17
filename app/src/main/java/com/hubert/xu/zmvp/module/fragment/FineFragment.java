package com.hubert.xu.zmvp.module.fragment;

import android.os.Bundle;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseFragment;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/17
 * Desc  :
 */

public class FineFragment extends BaseFragment {


    public static FineFragment newInstance() {
        Bundle args = new Bundle();
        FineFragment fragment = new FineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_fine;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }
}
