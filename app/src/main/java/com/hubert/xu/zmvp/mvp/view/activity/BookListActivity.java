package com.hubert.xu.zmvp.mvp.view.activity;

import android.content.Context;
import android.content.Intent;
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


    private static final String INTENT_CLASSIFY_NAME = "INTENT_CLASSIFY_NAME";
    private static final String INTENT_LV2CLASSIFY_NAME = "INTENT_CLASSIFY_NAME";
    @BindView(R.id.tablayout_book_list)
    TabLayout mTablayoutBookList;
    @BindView(R.id.vp_book_list)
    ViewPager mVpBookList;


    public static void startActivity(Context context, String classifyName, List<String> lv2ClassifyNames) {
        context.startActivity(new Intent(context, BookListActivity.class)
                .putExtra(INTENT_CLASSIFY_NAME, classifyName)
                .putStringArrayListExtra(INTENT_LV2CLASSIFY_NAME, (ArrayList<String>) lv2ClassifyNames));
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_book_list;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        ArrayList<String> lv2ClassifyNames = intent.getStringArrayListExtra(INTENT_LV2CLASSIFY_NAME);
        mTvTitle.setText(intent.getStringExtra(INTENT_CLASSIFY_NAME));
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
        mToolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId()==R.id.action_book_classify){

            }
            return false;
        });
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_book_list, menu);
        return true;
    }
}
