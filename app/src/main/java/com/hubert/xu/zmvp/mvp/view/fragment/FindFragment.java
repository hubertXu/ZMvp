package com.hubert.xu.zmvp.mvp.view.fragment;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseFragment;
import com.hubert.xu.zmvp.mvp.view.activity.AllRankingTypeActivity;
import com.hubert.xu.zmvp.mvp.view.activity.BookClassifyActivity;
import com.hubert.xu.zmvp.mvp.view.activity.BookListActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/28
 * Desc  :
 */

public class FindFragment extends BaseFragment {

    @BindView(R.id.card_ranking)
    CardView mCardRanking;
    @BindView(R.id.card_book_list)
    CardView mCardBookList;
    @BindView(R.id.card_assort)
    CardView mCardAssort;

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_find;
    }


    @Override
    public void initView() {

    }

    @OnClick({R.id.card_ranking, R.id.card_book_list, R.id.card_assort})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.card_ranking:
                startActivity(new Intent(mContext, AllRankingTypeActivity.class));
                break;
            case R.id.card_book_list:
                startActivity(new Intent(mContext, BookListActivity.class));
                break;
            case R.id.card_assort:
                startActivity(new Intent(mContext, BookClassifyActivity.class));
                break;
        }
    }
}
