package com.hubert.xu.zmvp.mvp.view.fragment;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.afollestad.materialdialogs.MaterialDialog;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseFragment;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.mvp.view.factory.CommunityFragmentFactory;

import java.util.HashMap;

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
    @BindView(R.id.fab_more)
    FloatingActionButton mFabMore;

    private int mTabPosition;
    private HashMap<Integer, Integer> selectType = new HashMap<Integer, Integer>() {
        {
            put(0, 0);
            put(1, 0);
            put(2, 0);
            put(3, 0);
        }
    };

    HashMap<Integer, DiscussSortLisenter> discussSortLisenters = new HashMap<>();


    public interface DiscussSortLisenter {
        void refreshComplexDiscussData(String sortType);
    }

    @Override
    protected int attachLayoutRes() {
        mIsUseLazyLoad = false;
        return R.layout.fragment_community;
    }

    @Override
    public void initView() {
        mVpCommunity.setOffscreenPageLimit(3);
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
        mTablayoutCommunity.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mTabPosition = tab.getPosition();
                mVpCommunity.setCurrentItem(mTabPosition, false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mFabMore.setOnClickListener(v -> {
            if (mTabPosition == 3) {
                new MaterialDialog.Builder(mContext)
                        .items(R.array.book_type)
                        .itemsCallbackSingleChoice(selectType.get(mTabPosition), (dialog, itemView, which, text) -> {
                            selectType.put(mTabPosition, which);
                            discussSortLisenters.get(mTabPosition).refreshComplexDiscussData(Constants.bookTypeList.get(which));
                            return true;
                        })
                        .show();
            } else {
                new MaterialDialog.Builder(mContext)
                        .items(R.array.sort_type)
                        .itemsCallbackSingleChoice(selectType.get(mTabPosition), (dialog, itemView, which, text) -> {
                            selectType.put(mTabPosition, which);
                            discussSortLisenters.get(mTabPosition).refreshComplexDiscussData(Constants.sortType.get(which));
                            return true;
                        })
                        .show();
            }
        });
    }


    public void setDiscussSortLisenter(DiscussSortLisenter discussSortLisenter) {
        discussSortLisenters.put(mTabPosition, discussSortLisenter);
    }
}
