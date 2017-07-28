package com.hubert.xu.zmvp.module.activity;

import android.content.Intent;
import android.widget.TextView;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseActivity;
import com.hubert.xu.zmvp.constant.Constants;
import com.hubert.xu.zmvp.utils.SPUtil;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/25
 * Desc  :
 */

public class SplashActivity extends BaseActivity {
    @BindView(R.id.tv_skip)
    TextView mTvSkip;

    @Override
    protected void initData() {
        if (SPUtil.getInstance().getBoolean(Constants.IS_FIREST_START, false)) {
            startActivity(new Intent(SplashActivity.this, GuideActivity.class));
        } else {
            Observable.timer(2, TimeUnit.SECONDS, AndroidSchedulers.mainThread()).map(aLong -> {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
                return null;
            }).subscribe(new Observer<Object>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onNext(@NonNull Object o) {

                }

                @Override
                public void onError(@NonNull Throwable e) {

                }

                @Override
                public void onComplete() {

                }
            });
        }
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_splash;
    }

    @OnClick(R.id.tv_skip)
    public void onViewClicked() {
    }
}
