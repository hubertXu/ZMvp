package com.hubert.xu.zmvp.mvp.view.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseFragment;
import com.hubert.xu.zmvp.mvp.view.factory.CommunityFragmentFactory;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/28
 * Desc  :
 */

public class CommunityFragment extends BaseFragment {

    @BindView(R.id.tablayout_community)
    TabLayout mTablayoutCommunity;
    @BindView(R.id.vp_community)
    ViewPager mVpCommunity;


    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_community;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        mVpCommunity.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            String[] titles = {getString(R.string.complex_discuss), getString(R.string.book_help), getString(R.string.girl), getString(R.string.book_review)};

            @Override
            public Fragment getItem(int position) {
                return CommunityFragmentFactory.getFragment(position);
            }

            @Override
            public int getCount() {
                return titles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
        mTablayoutCommunity.setupWithViewPager(mVpCommunity);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }
}
