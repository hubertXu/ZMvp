package com.hubert.xu.zmvp.module.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.widget.Toast;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.vp_main)
    ViewPager mVpMain;
    @BindView(R.id.tablayout_main)
    TabLayout mTablayoutMain;
    /**
     * 两次返回退出
     */
    private long mExitTime;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_main;
    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 3000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            } else {
                mActivityManagerUtils.exitApp();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
