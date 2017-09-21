package com.hubert.xu.zmvp.mvp.view.activity;

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
    int countTime = 3;
    private Disposable mDisposable;

    @Override
    protected void initData() {
        if (SPUtil.getInstance().getBoolean(Constants.IS_FIREST_START, false)) {
            startActivity(new Intent(SplashActivity.this, GuideActivity.class));
        } else {
            Observable.interval(0, 1, TimeUnit.SECONDS)
                    .map(aLong -> countTime - aLong.intValue())
                    .take(countTime + 1)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Integer>() {

                        @Override
                        public void onSubscribe(@NonNull Disposable d) {
                            mDisposable = d;
                        }

                        @Override
                        public void onNext(@NonNull Integer integer) {
                            mTvSkip.setText(getString(R.string.skip) + " " + integer);
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {

                        }

                        @Override
                        public void onComplete() {
                            skip();
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
        mTvSkip.setClickable(false);
        skip();
    }

    private void skip() {
        mDisposable.dispose();
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

}
