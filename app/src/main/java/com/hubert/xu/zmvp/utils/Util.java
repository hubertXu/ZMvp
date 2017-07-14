package com.hubert.xu.zmvp.utils;

import android.content.Context;

/**
 * author: XQ
 * time  : 2017/2/4
 * desc  : Utils初始化相关
 */

public class Util {

    private static Context context;

    private Util() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        Util.context = context.getApplicationContext();
    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static Context getContext() {
        if (context != null) return context;
        throw new NullPointerException("u should init first");
    }
}