package com.hubert.xu.zmvp.mvp.view.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseActivity;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.mvp.view.fragment.FineFragment;
import com.hubert.xu.zmvp.mvp.view.fragment.OriginalFragment;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/8/16
 * Desc  : 综合讨论Activity
 */

public class ComplexDiscussActivity extends BaseActivity {

    @BindView(R.id.tablayout_complex_discuss)
    TabLayout mTablayoutComplexDiscuss;
    @BindView(R.id.vp_complex_discuss)
    ViewPager mVpComplexDiscuss;


    public interface DiscussSortLisenter {

        void refreshComplexDiscussData(String sortType);

    }

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
        mToolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_default_sort:
                    mSortLisenter.refreshComplexDiscussData(Constants.TYPE_SORT_DEFAULT);
                    break;
                case R.id.action_latest_sort:
                    mSortLisenter.refreshComplexDiscussData(Constants.TYPE_SORT_LATEST);
                    break;
                case R.id.action_most_sort:
                    mSortLisenter.refreshComplexDiscussData(Constants.TYPE_SORT_MOST);
                    break;
            }
            return true;
        });
    }

    public DiscussSortLisenter mSortLisenter;

    public void setDiscussSortLisenter(DiscussSortLisenter discussSortLisenter) {
        this.mSortLisenter = discussSortLisenter;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_complex_discuss;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_discuss, menu);
        return true;
    }

}
