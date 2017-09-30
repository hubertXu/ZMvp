package com.hubert.xu.zmvp.mvp.view.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Menu;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseActivity;
import com.hubert.xu.zmvp.mvp.view.fragment.BookListFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/30
 * Desc  :
 */

public class BookListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.tablayout_book_list)
    TabLayout mTablayoutBookList;
    @BindView(R.id.vp_book_list)
    ViewPager mVpBookList;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_book_list;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        String[] bookClassifys = getResources().getStringArray(R.array.book_classify);
        List<BookListFragment> fragments = new ArrayList<>();
        for (int i = 0; i < bookClassifys.length; i++) {
            fragments.add(BookListFragment.newInstance());
        }
        mVpBookList.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return bookClassifys.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return bookClassifys[position];
            }
        });
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        return super.onMenuOpened(featureId, menu);
    }


}
