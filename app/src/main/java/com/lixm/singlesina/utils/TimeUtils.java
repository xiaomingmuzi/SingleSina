package com.lixm.singlesina.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Lixm
 * @date 2018/1/24
 * @detail  时间相关工具类
 */

public class TimeUtils {
    public static String getTimeDiff(String time) {
        long diff = 0;
        String str = "";
        try {
            SimpleDateFormat format = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss");
            if (time == null || "".equals(time)) {
                return "";
            }
            Date date = new Date(time);
            diff = new Date().getTime() - date.getTime();
            if (diff > 86400000) {// 24 * 60 * 60 * 1000=86400000 毫秒
                int index = time.indexOf("-") + 1;
                str = time.substring(index, time.lastIndexOf(":"));
            } else if (diff > 3600000) {// 1 * 60 * 60 * 1000=3600000 毫秒
                str = (int) Math.floor(diff / 3600000f) + "小时前";
            } else if (diff > 60000) {// 1 * 60 * 1000=60000 毫秒
                str = (int) Math.floor(diff / 60000) + "分钟前";
            } else {
                str = "刚刚";
            }
        } catch (Exception e) {
        }
        return str;
    }

}
