package com.hubert.xu.zmvp.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

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
    protected View mViewdividingLine;
    protected ImageButton mIbBack;
    protected TextView mTvTitle;
    protected ImageButton mIbOther;

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
            mTvTitle = (TextView) mToolbar.findViewById(R.id.tv_title);
            mIbBack = (ImageButton) mToolbar.findViewById(R.id.ib_back);
            mViewdividingLine = mToolbar.findViewById(R.id.view_dividing_line);
            mIbOther = (ImageButton) mToolbar.findViewById(R.id.ib_other);
            mTvTitle.setText(getTitle());
            mIbBack.setImageResource(R.drawable.ic_action_back);
            setSupportActionBar(mToolbar);
            // 返回按钮点击事件
            mIbBack.setOnClickListener(v -> finish());
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


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mActivityManagerUtils.removeFromStack(this);
    }
}
