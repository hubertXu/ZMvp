package com.hubert.xu.zmvp.mvp.view.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseActivity;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.mvp.model.entity.LocalBookTagsBean;
import com.hubert.xu.zmvp.mvp.contract.BookListTagContract;
import com.hubert.xu.zmvp.mvp.presenter.BookTagsPresenter;
import com.hubert.xu.zmvp.mvp.view.adapter.BookTagAdatper;
import com.hubert.xu.zmvp.mvp.view.fragment.BookListFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/10/10
 * Desc  :
 */

public class BookListActivity extends BaseActivity implements BookListTagContract.View, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.tablayout_book_list)
    TabLayout mTablayoutBookList;
    @BindView(R.id.vp_book_list)
    ViewPager mVpBookList;
    private PopupWindow mPopupWindow;
    private BookTagAdatper mAdapter;
    private BookTagsPresenter mBookTagsPresenter;
    private RecyclerView mRvBookTag;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private boolean isFirstDataPrepare = true;
    private int mTagSelectPosition;
    private String gender = "";
    private String tag = "";
    HashMap<Integer, TagChangeLisenter> mTagChangeLisenters = new HashMap<>();
    HashMap<Integer, List<LocalBookTagsBean.BookTag>> mTagMaps = new HashMap<>();
    HashMap<Integer, Boolean> isFirstLoadMaps = new HashMap();
    private int mTabPosition;


    public interface TagChangeLisenter {
        void tagChange(String gender, String tag);
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
        mTvTitle.setText(getString(R.string.book_list));
        isFirstLoadMaps.put(0, true);
        isFirstLoadMaps.put(1, true);
        isFirstLoadMaps.put(2, true);
        String[] bookListTabs = getResources().getStringArray(R.array.book_list_tab);
        List<BookListFragment> fragments = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            fragments.add(BookListFragment.newInstance(i));
        }
        mVpBookList.setOffscreenPageLimit(2);
        mVpBookList.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return bookListTabs.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return bookListTabs[position];
            }
        });
        mTablayoutBookList.setupWithViewPager(mVpBookList);
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
        initPop();
        mBookTagsPresenter = new BookTagsPresenter(this);
    }

    private void initPop() {
        mPopupWindow = new PopupWindow(this);
        mPopupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        mPopupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
//        mPopupWindow.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.white)));
        View contentView = LayoutInflater.from(this).inflate(R.layout.pop_tag, null);
        mSwipeRefreshLayout = (SwipeRefreshLayout) contentView.findViewById(R.id.swipe_layout);
        mRvBookTag = (RecyclerView) contentView.findViewById(R.id.rv_book_tag);
        mPopupWindow.setOutsideTouchable(true);
        mRvBookTag.setLayoutManager(new GridLayoutManager(this, 4));
        mPopupWindow.setContentView(contentView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_filter, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_filter) {
            mPopupWindow.showAsDropDown(mToolbar);
            if (isFirstLoadMaps.get(mTabPosition)) {
                onRefresh();
            } else {
                mAdapter.setNewData(mTagMaps.get(mTablayoutBookList.getSelectedTabPosition()));
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTagData(LocalBookTagsBean data) {
        mSwipeRefreshLayout.setRefreshing(false);
        mTagMaps.put(mTablayoutBookList.getSelectedTabPosition(), data.getBookTags());
        if (mAdapter == null) {
            mAdapter = new BookTagAdatper(data.getBookTags());
            mAdapter.setSpanSizeLookup((gridLayoutManager, position) -> data.getBookTags().get(position).getSign() == Constants.BOOK_TYPE_SIGN ? 4 : 1);
            mRvBookTag.setAdapter(mAdapter);
            mAdapter.setOnItemClickListener((adapter, view, position) -> {
                List<LocalBookTagsBean.BookTag> bookTags = mTagMaps.get(mTablayoutBookList.getSelectedTabPosition());
                if (bookTags.get(position).getSign() == Constants.BOOK_TYPE_NAME) {
                    if (position == 1 || position == 2) {
                        bookTags.get(position - 1 == 0 ? 2 : 1).setSelsect(false);
                        gender = position == 1 ? "male" : "famale";
                    } else {
                        if (mTagSelectPosition != 2 && mTagSelectPosition != 1) {
                            bookTags.get(mTagSelectPosition).setSelsect(false);
                            mTagSelectPosition = position;
                            tag = bookTags.get(position).getName();
                        }
                    }
                    bookTags.get(position).setSelsect(true);
                    mPopupWindow.dismiss();
                    mTagMaps.put(mTablayoutBookList.getSelectedTabPosition(), bookTags);
                    mTagChangeLisenters.get(mTablayoutBookList.getSelectedTabPosition()).tagChange(gender, tag);
                }
            });
        }
        mAdapter.setNewData(mTagMaps.get(mTablayoutBookList.getSelectedTabPosition()));
        isFirstLoadMaps.put(mTabPosition,false);
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }

    @Override
    public void onRefresh() {
        mSwipeRefreshLayout.setRefreshing(true);
        mBookTagsPresenter.getTagData();
    }

    public void setTagChangeLisenters(TagChangeLisenter tagChangeLisenter) {
        mTagChangeLisenters.put(mTablayoutBookList.getSelectedTabPosition(), tagChangeLisenter);
    }
}
