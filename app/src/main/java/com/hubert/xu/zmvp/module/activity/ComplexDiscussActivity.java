package com.hubert.xu.zmvp.module.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseActivity;
import com.hubert.xu.zmvp.module.fragment.FineFragment;
import com.hubert.xu.zmvp.module.fragment.OriginalFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/16
 * Desc  :
 */

public class ComplexDiscussActivity extends BaseActivity {
    @BindView(R.id.tablayout_complex_discuss)
    TabLayout mTablayoutComplexDiscuss;
    @BindView(R.id.vp_complex_discuss)
    ViewPager mVpComplexDiscuss;


    @Override
    protected void initView() {
        mVpComplexDiscuss.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            private String[] tabTitles = new String[]{getString(R.string.original), getString(R.string.fine)};

            @Override
            public Fragment getItem(int position) {
                return position == 0 ? OriginalFragment.newInstance() : FineFragment.newInstance();
            }

            @Override
            public int getCount() {
                return tabTitles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tabTitles[position];
            }
        });
        mTablayoutComplexDiscuss.setupWithViewPager(mVpComplexDiscuss);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_complex_discuss;
    }


    @OnClick(R.id.tv_sorting)
    public void onViewClicked() {
    }
}
