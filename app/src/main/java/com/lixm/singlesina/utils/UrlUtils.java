package com.lixm.singlesina.utils;

/**
 * @author Lixm
 * @date 2017/12/11
 * @detail
 */

public class UrlUtils {
    //根据用户ID获取用户信息
    public static String show="https://api.weibo.com/2/users/show.json";
//    获取当前登录用户及其所关注（授权）用户的最新微博
    public static String home_timeline="https://api.weibo.com/2/statuses/home_timeline.json";
    //根据ID跳转到单条微博页
    public static String statuses_show="https://api.weibo.com/2/statuses/show.json";
}
