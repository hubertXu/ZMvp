package com.hubert.xu.zmvp.mvp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseActivity;
import com.hubert.xu.zmvp.mvp.view.fragment.RankingFragment;

import butterknife.BindView;

public class RankingActivity extends BaseActivity {

    public static final String INTENT_WEEK = "_id";
    public static final String INTENT_MONTH = "month";
    public static final String INTENT_ALL = "all";
    public static final String INTENT_TITLE = "title";

    @BindView(R.id.tablayout_ranking)
    TabLayout mTablayoutRanking;
    @BindView(R.id.vp_ranking)
    ViewPager mVpRanking;

    public static void startActivity(Context context, String week, String month, String all, String title) {
        context.startActivity(new Intent(context, RankingActivity.class)
                .putExtra(INTENT_WEEK, week)
                .putExtra(INTENT_MONTH, month)
                .putExtra(INTENT_ALL, all)
                .putExtra(INTENT_TITLE, title));
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_ranking;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        String title = intent.getStringExtra(INTENT_TITLE);
        String week = intent.getStringExtra(INTENT_WEEK);
        String month = intent.getStringExtra(INTENT_MONTH);
        String total = intent.getStringExtra(INTENT_ALL);
        mTvTitle.setText(title);
        String[] rankingSort = getResources().getStringArray(R.array.ranking_sort);
        mVpRanking.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return RankingFragment.newInstance(week);
                    case 1:
                        return RankingFragment.newInstance(month);
                    case 2:
                        return RankingFragment.newInstance(total);
                }
                return RankingFragment.newInstance(week);
            }

            @Override
            public int getCount() {
                return rankingSort.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return rankingSort[position];
            }
        });
        mTablayoutRanking.setupWithViewPager(mVpRanking);
        mTablayoutRanking.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVpRanking.setCurrentItem(tab.getPosition(), false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
