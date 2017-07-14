package com.hubert.xu.zmvp.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.utils.ActivityManagerUtil;

import java.util.Stack;

import butterknife.ButterKnife;


/**
 * author: XQ
 * time  : 2016/2/22
 * desc  :
 */
public abstract class BaseActivity extends AppCompatActivity {


    public static Stack<BaseActivity> activityManager = new Stack<>();

    private Toolbar mToolbar;
    private ActivityManagerUtil mActivityManagerUtils;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityManager.push(this);
        setContentView(attachLayoutRes());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mActivityManagerUtils = ActivityManagerUtil.newInstance();
        mActivityManagerUtils.addToStack(this);
        initToolbar();
        initData();
        initView();
    }

    protected abstract int attachLayoutRes();

    protected abstract void initData();

    protected abstract void initView();


    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
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
