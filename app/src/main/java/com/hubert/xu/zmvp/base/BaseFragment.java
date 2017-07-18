package com.hubert.xu.zmvp.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.RxFragment;

import butterknife.ButterKnife;

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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = initViews(inflater, container, savedInstanceState);
        ButterKnife.bind(this, view);
        isPrepared = true;
        lazyLoad();
        return view;
    }

    public abstract View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    public abstract void initData();

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
        lazyLoad();
    }

    protected void onInvisible() {

    }

    protected void lazyLoad() {
        if (!isFirstLoad || !isPrepared || !isVisible) {
            return;
        }
        isFirstLoad = false;
        initData();
        initView();
    }
}
