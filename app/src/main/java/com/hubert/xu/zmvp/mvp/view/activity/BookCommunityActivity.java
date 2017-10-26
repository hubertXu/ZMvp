package com.hubert.xu.zmvp.mvp.view.activity;

import android.content.Context;
import android.content.Intent;
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
import com.hubert.xu.zmvp.mvp.view.fragment.CommunityCommentFragment;
import com.hubert.xu.zmvp.mvp.view.fragment.CommunityDiscussFragment;
import com.hubert.xu.zmvp.mvp.view.lisenter.DiscussSortLisenter;

import butterknife.BindView;

/**
 * Author: Hubert.Xu
 * Date  : 2017/10/25
 * Desc  :
 */

public class BookCommunityActivity extends BaseActivity {

    private static final String INTENT_BOOK_NAME = "intent_book_name";
    private static final String INTENT_BOOK_ID = "intent_book_id";
    @BindView(R.id.tablayout_book_community)
    TabLayout mTablayoutBookCommunity;
    @BindView(R.id.vp_book_community)
    ViewPager mVpBookCommunity;


    public static void startActivity(Context context, String bookName, String bookId) {
        context.startActivity(new Intent(context, BookCommunityActivity.class)
                .putExtra(INTENT_BOOK_NAME, bookName)
                .putExtra(INTENT_BOOK_ID, bookId));
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_book_community;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTvTitle.setText(getIntent().getStringExtra(INTENT_BOOK_NAME));
        String[] titles = {getString(R.string.complex_discuss), getString(R.string.book_review)};
        mVpBookCommunity.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return CommunityDiscussFragment.newInstance(getIntent().getStringExtra(INTENT_BOOK_ID));
                    case 1:
                        return CommunityCommentFragment.newInstance(getIntent().getStringExtra(INTENT_BOOK_ID));
                    default:
                        break;
                }
                return CommunityDiscussFragment.newInstance(getIntent().getStringExtra(INTENT_BOOK_ID));
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
        mTablayoutBookCommunity.setupWithViewPager(mVpBookCommunity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sort, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_sort) {
            new MaterialDialog.Builder(this).items(getResources()
                    .getStringArray(R.array.discuss_sort))
                    .itemsCallback((dialog, itemView, position, text) -> discussSortLisenters.get(mTablayoutBookCommunity.getSelectedTabPosition()).refreshDiscussData(position == 0 ? "updated" : position == 1 ? "created" : "comment-count")).show();

        }
        return super.onOptionsItemSelected(item);
    }

    SparseArray<DiscussSortLisenter> discussSortLisenters = new SparseArray<>();


    public void addDiscussSortLisenter(DiscussSortLisenter discussSortLisenter) {
        discussSortLisenters.put(mTablayoutBookCommunity.getSelectedTabPosition(), discussSortLisenter);
    }
}
