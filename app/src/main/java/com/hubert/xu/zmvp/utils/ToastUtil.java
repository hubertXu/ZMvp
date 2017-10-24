package com.hubert.xu.zmvp.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;


/**
 * author: XQ
 * time  : 2016/12/17
 * desc  :
 */
public class ToastUtil {
    private static Context mContext;
    private static Toast mToast;
    private static Boolean mIsShowWhenMore = false;
    private static Handler mHandler = new Handler(Looper.getMainLooper());

    public ToastUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public ToastUtil(Boolean isShowWhenMore) {
        mIsShowWhenMore = isShowWhenMore;
    }

    public static ToastUtil with(Boolean isShowWhenMore) {
        return new ToastUtil(isShowWhenMore);
    }

    public static void init(Context context) {
        ToastUtil.mContext = context;
    }

    /**
     * 显示Toast
     *
     * @param text     文本
     * @param duration 时长
     */
    public static void showToast(CharSequence text, int duration) {
        // 当连续弹出Toast时,是要弹出新吐司还是只修改文本内容,默认为只修改内容;
        if (mIsShowWhenMore) {
            cancelToast();
        }
        if (mToast == null) {
            mToast = Toast.makeText(mContext, text, duration);
        } else {
            mToast.setText(text);
            mToast.setDuration(duration);
        }
//        自定义Toast布局，按需设置
//        View view = LayoutInflater.from(mContext).inflate(R.layout.toast_view,null);
//        mToast.setView(view);
        mToast.show();
    }

    /**
     * 显示Toast
     *
     * @param resId    资源id
     * @param duration 时长
     */
    public static void showToast(int resId, int duration) {
        showToast(Util.getContext().getResources().getString(resId), duration);
    }

    /**
     * 显示Toast
     *
     * @param format   格式
     * @param duration 时长
     * @param args     要格式化的参数
     */
    public static void showToast(String format, int duration, Object... args) {
        showToast(String.format(format, args), duration);
    }

    /**
     * 显示Toast
     *
     * @param resId    格式的资源id
     * @param duration 时长
     * @param args     要格式化的参数
     */
    public static void showToast(int resId, int duration, Object... args) {
        showToast(String.format(mContext.getResources().getString(resId), args), duration);
    }

    /**
     * 取消Toast显示
     */
    public static void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
    }

    /**
     * 短时间显示Toast
     *
     * @param message 文本
     */
    public static void showShort(CharSequence message) {
        showToast(message, Toast.LENGTH_SHORT);
    }

    /**
     * 短时间显示Toast
     *
     * @param message 资源id
     */
    public static void showShort(int message) {
        showToast(message, Toast.LENGTH_SHORT);
    }

    /**
     * 长时间显示Toast
     *
     * @param message 文本
     */
    public static void showLong(CharSequence message) {
        showToast(message, Toast.LENGTH_LONG);
    }

    /**
     * 长时间显示Toast
     *
     * @param message 资源id
     */
    public static void showLong(int message) {
        showToast(message, Toast.LENGTH_LONG);
    }

    /**
     * 自定义显示Toast时间
     *
     * @param message  文本
     * @param duration
     */
    public static void show(CharSequence message, int duration) {
        showToast(message, duration);
    }

    /**
     * 自定义显示Toast时间
     *
     * @param message  文本
     */
    public static void show(CharSequence message) {
        showToast(message, Toast.LENGTH_SHORT);
    }

    /**
     * 自定义显示Toast时间
     *
     * @param message  资源id
     * @param duration
     */
    public static void show(int message, int duration) {
        showToast(message, duration);
    }


    /**
     * 安全的显示短Toast
     *
     * @param message 文本
     */
    public static void showShortToastSafely(final CharSequence message) {
        mHandler.post(() -> showToast(message, Toast.LENGTH_SHORT));
    }

    /**
     * 安全的显示短Toast
     *
     * @param message 资源id
     */
    public static void showShortToastSafely(final int message) {
        mHandler.post(() -> showToast(message, Toast.LENGTH_SHORT));
    }


    /**
     * 安全的显示长Toast
     *
     * @param message 文本
     */
    public static void showSLongToastSafely(final CharSequence message) {
        mHandler.post(() -> showToast(message, Toast.LENGTH_LONG));
    }

    /**
     * 安全的显示长Toast
     *
     * @param message 资源id
     */
    public static void showLongToastSafely(final int message) {
        mHandler.post(() -> showToast(message, Toast.LENGTH_LONG));
    }

}
