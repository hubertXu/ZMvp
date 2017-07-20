package com.hubert.xu.zmvp.http;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/20
 * Desc  :
 */

public class ApiException extends RuntimeException {
    
    public static final int EXCEPTION_USER_NO_EXIST = 100;
    public static final int EXCEPTION_SERVICE_BUSY = 101;
    private static String message;

    public ApiException(int resultCode) {
        this(getApiExceptionMessage(resultCode));
    }

    public ApiException(String detailMessage) {
        super(detailMessage);
    }

    @Override
    public String getMessage() {
        return message;
    }

    /**
     * 由于服务器传递过来的错误信息直接给用户看的话，用户未必能够理解
     * 需要根据错误码对错误信息进行一个转换，在显示给用户
     * @param code
     * @return
     */
    private static String getApiExceptionMessage(int code){
        switch (code) {
            case EXCEPTION_USER_NO_EXIST:
                message = "该用户不存在";
                break;
            case EXCEPTION_SERVICE_BUSY:
                message = "密码错误";
                break;
            default:
                message = "未知错误";
        }
        return message;
    }
}
