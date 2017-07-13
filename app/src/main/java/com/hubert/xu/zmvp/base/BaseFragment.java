package com.hubert.xu.zmvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * author: XQ
 * time  : 2016/2/22
 * desc  :
 */
public abstract class BaseFragment extends Fragment {
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

    public abstract void init();

    public abstract void initListener();

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
        init();
        initListener();
    }
}
