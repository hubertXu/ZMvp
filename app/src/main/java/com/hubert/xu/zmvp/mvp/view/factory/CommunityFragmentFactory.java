package com.hubert.xu.zmvp.mvp.view.factory;

import android.util.SparseArray;

import com.hubert.xu.zmvp.base.BaseFragment;
import com.hubert.xu.zmvp.mvp.view.fragment.BookHelpFragment;
import com.hubert.xu.zmvp.mvp.view.fragment.BookReviewFragment;
import com.hubert.xu.zmvp.mvp.view.fragment.ComplexDiscussFragment;
import com.hubert.xu.zmvp.mvp.view.fragment.GirlBookFragment;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/27
 * Desc  :
 */

public class CommunityFragmentFactory {
    private static SparseArray<BaseFragment> fragmentMaps = new SparseArray<>(3);

    public static BaseFragment getFragment(int position) {
        BaseFragment fragment = fragmentMaps.get(position);
        if (fragment == null) {
            switch (position) {
                case 0:
                    fragment = new ComplexDiscussFragment();
                    break;
                case 1:
                    fragment = new BookHelpFragment();
                    break;
                case 2:
                    fragment = new GirlBookFragment();
                    break;
                case 3:
                    fragment = new BookReviewFragment();
                    break;
                default:
                    break;
            }
            fragmentMaps.put(position, fragment);
        }
        return fragment;
    }
}
