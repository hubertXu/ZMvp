package com.hubert.xu.zmvp.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/14
 * Desc  :
 */
public abstract class BaseFragment extends RxFragment {
    public Context mContext;
    private boolean isFirstLoad = true;
    private boolean isPrepared;
    private boolean isVisible;
    private View mView;
    private Resources mResources;
    private LayoutInflater mInflater;
    private Unbinder mUnbinder;
    protected boolean mIsUseLazyLoad = true;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mContext = activity;
        this.mResources = mContext.getResources();
        this.mInflater = LayoutInflater.from(mContext);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(attachLayoutRes(), container, false);
        mUnbinder = ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isPrepared = true;
        if (mIsUseLazyLoad) {
            lazyLoad();
        } else {
            initView();
        }
    }

    protected abstract int attachLayoutRes();


    public abstract void initView();


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void onVisible() {
        if (!mIsUseLazyLoad) {
            return;
        }
        lazyLoad();
    }

    protected void onInvisible() {

    }

    protected void lazyLoad() {
        if (!isFirstLoad || !isPrepared || !isVisible) {
            return;
        }
        isFirstLoad = false;
        initView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
