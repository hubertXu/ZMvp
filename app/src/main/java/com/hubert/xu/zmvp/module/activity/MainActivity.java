package com.hubert.xu.zmvp.module.activity;

import com.hubert.xu.zmvp.R;
import com.hubert.xu.zmvp.base.BaseActivity;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;

public class MainActivity extends BaseActivity {


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Flowable.create((FlowableOnSubscribe<String>) e -> {

        }, BackpressureStrategy.ERROR).subscribe(new Subscriber<String>() {

            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_main;
    }
}
