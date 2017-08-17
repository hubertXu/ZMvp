package com.hubert.xu.zmvp.module.fragment;

import android.content.Intent;
import android.view.View;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseFragment;
import com.hubert.xu.zmvp.module.activity.ComplexDiscussActivity;

import butterknife.OnClick;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/28
 * Desc  :
 */

public class CommunityFragment extends BaseFragment {

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_community;
    }

    @Override
    public void initData() {
    }

    @Override
    public void initView() {

    }

    @OnClick({R.id.card_complex_discuss, R.id.card_book_review, R.id.card_book_shortage, R.id.card_female, R.id.card_original})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.card_complex_discuss:
                startActivity(new Intent(getActivity(), ComplexDiscussActivity.class));
                break;
            case R.id.card_book_review:
                break;
            case R.id.card_book_shortage:
                break;
            case R.id.card_female:
                break;
            case R.id.card_original:
                break;
        }
    }
}
