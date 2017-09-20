package com.hubert.xu.zmvp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Author: Hubert.Xu
 * Date  : 2017/9/20
 * Desc  :
 */

public class TimeFormatUtil {
    public static String formatTime(String updated) {
        String strTimeMap = "";
        updated = updated.replaceAll("[(A-Za-z)]", "");
        try {
            long updatedTime = new SimpleDateFormat("yyyy-mm-ddhh:mm:sss", Locale.CHINA).parse(updated).getTime();
            long currentTime = System.currentTimeMillis();
            long timeMap = currentTime - updatedTime;
            LogUtil.info("updatedTime" + updatedTime + "\n" + "currenTime" + currentTime + "\n" + "timeMap" + timeMap);
            if (timeMap < 1000 * 60) {
                strTimeMap = "刚刚";
            } else if (timeMap < 1000 * 60 * 60) {
                strTimeMap = (int) Math.ceil(timeMap / (1000 * 60)) + "分钟前";
            } else if (timeMap < 1000 * 60 * 60 * 24) {
                strTimeMap = (int) Math.ceil(timeMap / (1000 * 60 * 60)) + "小时前";
            } else if (timeMap < 1000 * 60 * 60 * 24 * 30) {
                strTimeMap = (int) Math.ceil(timeMap / (1000 * 60 * 60 * 24)) + "天前";
            } else if (timeMap < 1000 * 60 * 60 * 24 * 30 * 12) {
                strTimeMap = (int) Math.ceil(timeMap / (1000 * 60 * 60 * 24 * 30)) + "月前";
            } else {
                LogUtil.info(timeMap + "");
                strTimeMap = (int) Math.ceil(timeMap / (1000 * 60 * 60 + 24 * 30 * 12)) + "年前";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return strTimeMap;
    }
}
