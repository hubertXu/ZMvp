package com.hubert.xu.zmvp.mvp.view.fragment;

import android.content.Intent;
import android.view.View;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseFragment;
import com.hubert.xu.zmvp.mvp.view.activity.BookHelpActivity;
import com.hubert.xu.zmvp.mvp.view.activity.BookReviewActivity;
import com.hubert.xu.zmvp.mvp.view.activity.ComplexDiscussActivity;
import com.hubert.xu.zmvp.mvp.view.activity.GirlBooKActivity;

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
                startActivity(new Intent(getActivity(), BookReviewActivity.class));
                break;
            case R.id.card_book_shortage:
                startActivity(new Intent(getActivity(), BookHelpActivity.class));
                break;
            case R.id.card_female:
                startActivity(new Intent(getActivity(), GirlBooKActivity.class));
                break;
            case R.id.card_original:
                break;
        }
    }
}
