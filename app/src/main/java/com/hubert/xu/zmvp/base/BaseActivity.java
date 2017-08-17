package com.hubert.xu.zmvp.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.utils.ActivityManagerUtil;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;


/**
 * Author: Hubert.Xu
 * Date  : 2017/7/14
 * Desc  :
 */
public abstract class BaseActivity extends RxAppCompatActivity {

    protected Toolbar mToolbar;
    protected ActivityManagerUtil mActivityManagerUtils;
    private boolean isshowbackIcon = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(attachLayoutRes());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mActivityManagerUtils = ActivityManagerUtil.newInstance();
        mActivityManagerUtils.addToStack(this);
        setToolbar();
        initView();
        initData();
    }

    protected abstract int attachLayoutRes();

    protected abstract void initData();

    protected abstract void initView();


    private void setToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            mToolbar.setTitle(getTitle());
            mToolbar.setNavigationIcon(R.mipmap.back);
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(isShowBackIcon());
            mToolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        }
    }

    protected boolean isShowBackIcon() {
        return isshowbackIcon;
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        ButterKnife.bind(this);
    }

    /**
     * 返回按钮点击事件
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mActivityManagerUtils.removeFromStack(this);
    }
}
