package com.hubert.xu.zmvp.http;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/20
 * Desc  :
 */

public class ApiException extends RuntimeException {

    public static final String ERROR_MSG_SOCKETTIMEOUTEXCEPTION = "网络链接超时，请检查您的网络状态，稍后重试！";
    public static final String ERROR_MSG_CONNECTEXCEPTION = "网络链接异常，请检查您的网络状态";
    public static final String ERROR_MSG_UNKONWNHOSTEXCEPTION = "网络异常，请检查您的网络状态";
}
