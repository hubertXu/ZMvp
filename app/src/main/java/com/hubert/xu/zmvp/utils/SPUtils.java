package com.hubert.xu.zmvp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

/**
 * author: XQ
 * time  : 2016/12/17
 * desc  :
 */

public class SPUtils {
    private static SharedPreferences sp;
    private static SharedPreferences.Editor editor;

    public static void init(Context context, String spName) {
        sp = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    /**
     * 保存数据
     *
     * @param key
     * @param object
     */
    public static void putData(String key, Object object) {
        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else {
            throw new IllegalArgumentException("not support object");
        }
        editor.apply();
    }

    /**
     * 获取数据，根据默认值，调用相应的方法
     *
     * @param key
     * @param defaultObject
     * @return
     */
    public static Object getData(String key, Object defaultObject) {
        if (defaultObject instanceof String) {
            return sp.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sp.getLong(key, (Long) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sp.getFloat(key, (Float) defaultObject);
        } else {
            throw new IllegalArgumentException("not support object");
        }
    }


    /**
     * 存储String类型
     *
     * @param key
     * @param value
     */
    public static void putString(String key, String value) {
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * 存储boolean类型
     *
     * @param key
     * @param value
     */
    public static void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.apply();
    }


    /**
     * 存储int类型
     *
     * @param key
     * @param value
     */
    public static void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.apply();
    }

    /**
     * 存储long类型
     *
     * @param key
     * @param value
     */
    public static void putLong(String key, long value) {
        editor.putLong(key, value);
        editor.apply();
    }

    /**
     * 存储float类型
     *
     * @param key
     * @param value
     */
    public static void putFloat(String key, float value) {
        editor.putFloat(key, value);
        editor.apply();
    }

    /**
     * 获取String类型,不带默认值
     *
     * @param key
     * @return
     */
    public static String getString(String key, String defaultValue) {
        return sp.getString(key, defaultValue);
    }

    /**
     * 获取boolean类型 不带默认值
     *
     * @param key
     * @return
     */
    public static boolean getBoolean(String key, boolean defaultValue) {
        return sp.getBoolean(key, defaultValue);
    }

    /**
     * 获取int类型 不带默认值
     *
     * @param key
     * @return
     */
    public static int getInt(String key, int defaultValue) {
        return sp.getInt(key, defaultValue);
    }

    /**
     * 获取long类型 不带默认值
     *
     * @param key
     * @return
     */
    public static long getLong(String key, long defaultValue) {
        return sp.getLong(key, defaultValue);
    }


    /**
     * 获取float类型 不带默认值
     *
     * @param key
     * @return
     */
    public static float getFloat(String key, float defaultValue) {
        return sp.getFloat(key, defaultValue);
    }


    /**
     * 清楚指定key的数据
     *
     * @param key
     */
    public static void remove(String key) {
        editor.remove(key).apply();
    }

    /**
     * sp是否存在该key
     *
     * @param key
     * @return
     */
    public static boolean contains(String key) {
        return sp.contains(key);
    }

    /**
     * 获取sp所有键值对
     *
     * @return
     */
    public static Map<String, ?> getAll() {
        return sp.getAll();
    }

    /**
     * 清除sp中所有数据
     * commit() or apply() ?
     * make change as needed,now use aply()
     */
    public static boolean clear() {
        return editor.clear().commit();
    }
}
