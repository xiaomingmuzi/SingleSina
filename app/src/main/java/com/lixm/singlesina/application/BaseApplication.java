package com.lixm.singlesina.application;

import android.app.Application;

import com.lixm.singlesina.utils.Constants;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;

/**
 * @author Lixm
 * @date 2017/12/7
 * @detail
 */

public class BaseApplication extends Application {
    public static BaseApplication mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
        WbSdk.install(this,new AuthInfo(this, Constants.APP_KEY, Constants.REDIRECT_URL, Constants.SCOPE));

    }

    // 对外暴露上下文
    public static BaseApplication getApplication() {
        return mContext;
    }
}
