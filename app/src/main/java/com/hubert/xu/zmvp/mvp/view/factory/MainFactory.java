package com.hubert.xu.zmvp.mvp.view.factory;

import android.util.SparseArray;

import com.hubert.xu.zmvp.base.BaseFragment;
import com.hubert.xu.zmvp.mvp.view.fragment.BookShelfFragment;
import com.hubert.xu.zmvp.mvp.view.fragment.CommunityFragment;
import com.hubert.xu.zmvp.mvp.view.fragment.FindFragment;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/27
 * Desc  :
 */

public class MainFactory {
    private static SparseArray<BaseFragment> fragmentMaps = new SparseArray<>(3);

    public static BaseFragment getFragment(int position) {
        BaseFragment fragment = fragmentMaps.get(position);
        if (fragment == null) {
            switch (position) {
                case 0:
                    fragment = new BookShelfFragment();
                    break;
                case 1:
                    fragment = new CommunityFragment();
                    break;
                case 2:
                    fragment = new FindFragment();
                    break;
            }
            fragmentMaps.put(position, fragment);
        }
        return fragment;
    }
}
