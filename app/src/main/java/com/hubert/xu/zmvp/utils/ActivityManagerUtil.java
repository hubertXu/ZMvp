package com.hubert.xu.zmvp.utils;

import android.app.Activity;

import java.util.Stack;

/**
 * author: xq
 * time  : 2017/7/4
 * desc  :
 */

public class ActivityManagerUtil {

    private Stack<Activity> activityStack = new Stack<>();


    public static class ActivityManagerUtilsHolder {
        public static ActivityManagerUtil instance = new ActivityManagerUtil();
    }

    public static ActivityManagerUtil newInstance() {
        return ActivityManagerUtilsHolder.instance;
    }

    /**
     * 将Activity加入栈
     *
     * @param activity
     */
    public void addToStack(Activity activity) {
        activityStack.add(activity);
    }

    /**
     * 将Activity从栈中移除
     *
     * @param activity
     */
    public void removeFromStack(Activity activity) {
        if (activityStack != null && activityStack.size() > 0){
            if (activity != null) {
                activityStack.remove(activity);
                activity.finish();
            }
        }
    }

    /**
     * 获取栈顶的Activity
     *
     * @return
     */
    public Activity getLastActivity() {
        return activityStack.lastElement();
    }


    /**
     * 结束指定Activity
     *
     * @param activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
        }
    }

    /**
     * 结束指定类名的Activity
     *
     * @param cls
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)){
                finishActivity(activity);
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        try {
            for (Activity activity : activityStack) {
                if (null != activity) {
                    activity.finish();
                }
            }
            activityStack.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 退出应用程序
     */
    public void exitApp() {
        try {
            finishAllActivity();
            System.exit(0);
            android.os.Process.killProcess(android.os.Process.myPid());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
