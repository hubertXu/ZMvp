package com.hubert.xu.zmvp.module.splash;

import android.content.Intent;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseActivity;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.module.activity.GuideActivity;
import com.hubert.xu.zmvp.module.activity.MainActivity;
import com.hubert.xu.zmvp.utils.SPUtil;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/25
 * Desc  :
 */

public class SplashActivity extends BaseActivity {
    @Override
    protected void initData() {
        if (SPUtil.getBoolean(Constants.IS_FIREST_START, false)) {
            startActivity(new Intent(SplashActivity.this, GuideActivity.class));
        } else {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        }
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_splash;
    }
}
