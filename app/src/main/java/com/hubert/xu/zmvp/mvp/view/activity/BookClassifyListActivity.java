package com.hubert.xu.zmvp.mvp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;

import com.afollestad.materialdialogs.MaterialDialog;
import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseActivity;
import com.hubert.xu.zmvp.mvp.model.entity.BookclassifyLocalBean;
import com.hubert.xu.zmvp.mvp.view.fragment.BookClassifyListFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/30
 * Desc  :
 */

public class BookClassifyListActivity extends BaseActivity {

    private static final String INTENT_BOOK_LIST_DATA = "intent_book_list_data";
    private static final String INTENT_BOOK_LIST_BUNDLE = "intent_book_list_bundle";
    @BindView(R.id.tablayout_book_list)
    TabLayout mTablayoutBookList;
    @BindView(R.id.vp_book_list)
    ViewPager mVpBookList;
    private BookclassifyLocalBean.LocalBookClassifyBean mData;
    private int mTabPosition;
    private HashMap<Integer, Integer> selectType = new HashMap<Integer, Integer>() {
        {
            put(0, 0);
            put(1, 0);
            put(2, 0);
            put(3, 0);
        }
    };
    SparseArray<GetLv2BookListDataLisenter> getLv2BookListDataLisenters = new SparseArray<>();
    private boolean mMenuVisible = true;


    public interface GetLv2BookListDataLisenter {
        void getLv2BookListData(String lv2Type);
    }

    public static void startActivity(Context context, BookclassifyLocalBean.LocalBookClassifyBean data) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(INTENT_BOOK_LIST_DATA, data);
        context.startActivity(new Intent(context, BookClassifyListActivity.class)
                .putExtra(INTENT_BOOK_LIST_BUNDLE, bundle));
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_book_classify_list;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mData = (BookclassifyLocalBean.LocalBookClassifyBean) getIntent().getBundleExtra(INTENT_BOOK_LIST_BUNDLE).get(INTENT_BOOK_LIST_DATA);
        if (mData != null && mData.getLv2ClassifyNames() != null && mData.getLv2ClassifyNames().size() == 0) {
            mMenuVisible = false;
            supportInvalidateOptionsMenu();
            mTvTitle.setText(mData.getName());
        }
        String[] bookClassifys = getResources().getStringArray(R.array.book_classify);
        List<BookClassifyListFragment> fragments = new ArrayList<>();
        for (int i = 0; i < bookClassifys.length; i++) {
            fragments.add(BookClassifyListFragment.newInstance(mData.getName(), mData.getType(), mData.getLv2ClassifyNames().size() == 0 ? "" : mData.getLv2ClassifyNames().get(0), getResources().getStringArray(R.array.book_classify_type)[i]));
        }
        mVpBookList.setOffscreenPageLimit(3);
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
        mTablayoutBookList.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mTabPosition = tab.getPosition();
                mVpBookList.setCurrentItem(mTabPosition, false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_filter, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_filter) {
            new MaterialDialog.Builder(BookClassifyListActivity.this)
                    .items(mData.getLv2ClassifyNames())
                    .itemsCallbackSingleChoice(selectType.get(mTabPosition), (dialog, itemView, which, text) -> {
                        selectType.put(mTabPosition, which);
                        getLv2BookListDataLisenters.get(mTabPosition).getLv2BookListData(text.toString());
                        return true;
                    })
                    .show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.action_filter);
        if (mMenuVisible) {
            item.setVisible(true);
        } else {
            item.setVisible(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public void setGetBookListDataLisenter(GetLv2BookListDataLisenter getLv2BookListDataLisenter) {
        getLv2BookListDataLisenters.put(mTablayoutBookList.getSelectedTabPosition(), getLv2BookListDataLisenter);
    }
}
