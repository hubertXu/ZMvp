package com.hubert.xu.zmvp.utils;

import com.orhanobut.logger.Logger;

/**
 * author: XQ
 * time  : 2017/2/4
 * desc  : 日志工具类
 */

public class LogUtil {
    /**
     * 打印debug信息
     *
     * @param msg 信息内容
     */
    public static void debug(String msg) {
        Logger.d(msg);
    }

    /**
     * 打印debug信息
     *
     * @param msg 信息内容
     */
    public static void debug(Object msg) {
        Logger.d(msg);
    }

    /**
     * 打印debug信息
     *
     * @param tag 标签
     * @param msg 信息内容
     */
    public static void debug(String tag, String msg) {
        Logger.d(tag, msg);
    }

    /**
     * 打印Info信息
     *
     * @param msg 信息内容
     */
    public static void info(String msg) {
        Logger.i(msg);
    }

    /**
     * 打印Warn信息
     *
     * @param msg 信息内容
     */
    public static void warn(String msg) {
        Logger.w(msg);
    }

    /**
     * 打印Error信息
     *
     * @param msg 信息内容
     */
    public static void error(String msg) {
        Logger.e(msg);
    }

    /**
     * 打印Error信息
     *
     * @param t   异常
     * @param msg 信息内容
     */
    public static void error(Throwable t, String msg) {
        Logger.e(t, msg);
    }

    /**
     * 打印JSON信息
     *
     * @param json 信息内容
     */
    public static void json(String json) {
        Logger.json(json);
    }

    /**
     * 打印XML信息
     *
     * @param xml 信息内容
     */
    public static void xml(String xml) {
        Logger.xml(xml);
    }
}
