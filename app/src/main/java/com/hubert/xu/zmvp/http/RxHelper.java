package com.hubert.xu.zmvp.http;

import android.support.annotation.NonNull;

import com.gc.materialdesign.widgets.Dialog;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.util.concurrent.TimeUnit;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/20
 * Desc  : RxLifecycle绑定工具类
 */

public class RxHelper {


    private static <T> LifecycleTransformer<T> bindToLifecycle(LifecycleProvider provider) {
        if (provider instanceof RxAppCompatActivity) {
            return ((RxAppCompatActivity) provider).bindToLifecycle();
        } else if (provider instanceof RxFragment) {
            return ((RxFragment) provider).bindToLifecycle();
        } else {
            throw new IllegalArgumentException("class must extents RxAppCompatActivity or RxFragment");
        }
    }

    private static <T> LifecycleTransformer<T> bindToLifecycle(LifecycleProvider provider, ActivityEvent event) {
        if (provider instanceof RxAppCompatActivity) {
            return ((RxAppCompatActivity) provider).bindUntilEvent(event);
        } else {
            throw new IllegalArgumentException("class must extents RxAppCompatActivity");
        }
    }

    private static <T> LifecycleTransformer<T> bindToLifecycle(LifecycleProvider provider, FragmentEvent event) {
        if (provider instanceof RxFragment) {
            return ((RxFragment) provider).bindUntilEvent(event);
        } else {
            throw new IllegalArgumentException("class must extents RxFragment");
        }
    }

    public static <T> ObservableTransformer<T, T> applySchedulers(final LifecycleProvider provider) {
        return upstream -> upstream
                .retryWhen(new RetryWithDelay())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxHelper.<T>bindToLifecycle(provider));
    }

    public static <T> ObservableTransformer<T, T> applySchedulers(final LifecycleProvider provider, final ActivityEvent event) {
        return upstream -> upstream
                .retryWhen(new RetryWithDelay())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxHelper.<T>bindToLifecycle(provider, event));
    }

    public static <T> ObservableTransformer<T, T> applySchedulers(final LifecycleProvider provider, final FragmentEvent event) {
        return upstream -> upstream
                .retryWhen(new RetryWithDelay())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxHelper.<T>bindToLifecycle(provider, event));
    }

    public static <T> ObservableTransformer<T, T> applySchedulers(final LifecycleProvider provider, @NonNull final Dialog dialog) {
        return upstream -> upstream
                .delay(1, TimeUnit.SECONDS)
                .retryWhen(new RetryWithDelay())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(disposable -> {
                    dialog.setOnCancelListener(dialog1 -> disposable.dispose());
                    dialog.show();
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate(() -> dialog.dismiss())
                .compose(RxHelper.<T>bindToLifecycle(provider));
    }

    public static <T> ObservableTransformer<T, T> applySchedulers(final LifecycleProvider provider, final ActivityEvent event, @NonNull final Dialog dialog) {
        return upstream -> upstream
                .delay(1, TimeUnit.SECONDS)
                .retryWhen(new RetryWithDelay())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(disposable -> {
                    dialog.setOnCancelListener(dialog1 -> disposable.dispose());
                    dialog.show();
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate(() -> dialog.dismiss())
                .compose(RxHelper.<T>bindToLifecycle(provider, event));
    }

    public static <T> ObservableTransformer<T, T> applySchedulers(final LifecycleProvider provider, final FragmentEvent event, @NonNull final Dialog dialog) {
        return upstream -> upstream
                .delay(1, TimeUnit.SECONDS)
                .retryWhen(new RetryWithDelay(2,5000))
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(disposable -> {
                    dialog.setOnCancelListener(dialog1 -> disposable.dispose());
                    dialog.show();
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate(() -> dialog.dismiss())
                .compose(RxHelper.<T>bindToLifecycle(provider, event));
    }}
