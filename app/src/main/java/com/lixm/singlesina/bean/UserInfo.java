package com.lixm.singlesina.bean;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;

import com.lixm.singlesina.utils.Constants;

/**
 * @author Lixm
 * @date 2017/12/7
 * @detail
 */

public class UserInfo implements Parcelable {
    private String uid;
    private String location;
    private String remark;
    private String description;
    private String gender;
    private String access_token;
    private String expiration;
    private String url;//博客地址
    private String cover_image_phone;
    private String friends_count;
    private String profile_iamge_url;
    private String follow_me;
    private String name;
    private String domain;
    private String followers_count;
    private String online_status;
    private String refresh_token;


    public UserInfo() {
    }

    protected UserInfo(Parcel in) {
        uid = in.readString();
        location = in.readString();
        remark = in.readString();
        description = in.readString();
        gender = in.readString();
        access_token = in.readString();
        expiration = in.readString();
        url = in.readString();
        cover_image_phone = in.readString();
        friends_count = in.readString();
        profile_iamge_url = in.readString();
        follow_me = in.readString();
        name = in.readString();
        domain = in.readString();
        followers_count = in.readString();
        online_status = in.readString();
        refresh_token = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(uid);
        dest.writeString(location);
        dest.writeString(remark);
        dest.writeString(description);
        dest.writeString(gender);
        dest.writeString(access_token);
        dest.writeString(expiration);
        dest.writeString(url);
        dest.writeString(cover_image_phone);
        dest.writeString(friends_count);
        dest.writeString(profile_iamge_url);
        dest.writeString(follow_me);
        dest.writeString(name);
        dest.writeString(domain);
        dest.writeString(followers_count);
        dest.writeString(online_status);
        dest.writeString(refresh_token);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel in) {
            return new UserInfo(in);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };

    public void writeToCache(Context context) {
        if (null != context) {
            SharedPreferences settings = context.getSharedPreferences(Constants.USER_INFO, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString(Constants.UID, uid);
            editor.putString(Constants.LOCATION, location);
            editor.putString(Constants.REMARK, remark);
            editor.putString(Constants.DESCRIPTION, description);
            editor.putString(Constants.GENDER, gender);
            editor.putString(Constants.ACCESS_TOKEN, access_token);
            editor.putString(Constants.EXPIRATION, expiration);
            editor.putString(Constants.URL, url);
            editor.putString(Constants.COVER_IMAGE_PHONE, cover_image_phone);
            editor.putString(Constants.FRIENDS_COUNT, friends_count);
            editor.putString(Constants.PROFILE_IAMGE_URL, profile_iamge_url);
            editor.putString(Constants.FOLLOW_ME, follow_me);
            editor.putString(Constants.NAME, name);
            editor.putString(Constants.DOMAIN, domain);
            editor.putString(Constants.FOLLOWERS_COUNT, friends_count);
            editor.putString(Constants.ONLINE_STATUS, online_status);
            editor.putString(Constants.REFRESH_TOKEN, refresh_token);
            editor.apply();
        }
    }

    public void clearCache(Context context) {
        SharedPreferences settings = context.getSharedPreferences(Constants.USER_INFO, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        editor.apply();
    }

    public void getCache(Context context) {
        SharedPreferences sharedata = context.getSharedPreferences(Constants.USER_INFO, 0);
        uid = sharedata.getString(Constants.UID, null);
        location = sharedata.getString(Constants.LOCATION, null);
        remark = sharedata.getString(Constants.REMARK,null);
        description = sharedata.getString(Constants.DESCRIPTION, null);
        gender = sharedata.getString(Constants.GENDER, null);
        access_token = sharedata.getString(Constants.ACCESS_TOKEN, null);
        expiration = sharedata.getString(Constants.EXPIRATION, null);
        url = sharedata.getString(Constants.URL, null);
        cover_image_phone = sharedata.getString(Constants.COVER_IMAGE_PHONE, null);
        friends_count = sharedata.getString(Constants.FRIENDS_COUNT, null);
        profile_iamge_url = sharedata.getString(Constants.PROFILE_IAMGE_URL, null);
        follow_me = sharedata.getString(Constants.FOLLOW_ME, null);
        name = sharedata.getString(Constants.NAME, null);
        domain = sharedata.getString(Constants.DOMAIN, null);
        friends_count = sharedata.getString(Constants.FRIENDS_COUNT, null);
        followers_count = sharedata.getString(Constants.FOLLOWERS_COUNT, null);
        friends_count = sharedata.getString(Constants.FRIENDS_COUNT, null);
        online_status = sharedata.getString(Constants.ONLINE_STATUS, null);
        refresh_token = sharedata.getString(Constants.REFRESH_TOKEN, null);
    }
}
