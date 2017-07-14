package com.hubert.xu.zmvp.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * author: Hubert.Xu
 * time  : 2017/7/14
 * desc  :
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(itemView);
    }

    protected abstract void bind(T t);
}
