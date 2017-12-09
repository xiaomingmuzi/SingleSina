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

public class BassApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        WbSdk.install(this,new AuthInfo(this, Constants.APP_KEY, Constants.REDIRECT_URL, Constants.SCOPE));

    }
}
