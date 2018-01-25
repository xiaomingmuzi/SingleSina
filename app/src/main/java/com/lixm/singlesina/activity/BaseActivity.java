package com.lixm.singlesina.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.lixm.singlesina.R;
import com.lixm.singlesina.utils.StatusBarUtil;
import com.lixm.singlesina.utils.ToastUtils;

/**
 * @author Lixm
 * @date 2017/12/7
 * @detail
 */

public class BaseActivity extends FragmentActivity {

    public Context mContext;
    public ToastUtils mToastUtils;
    private int color_id = R.color.color_fa;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mToastUtils=ToastUtils.getInstance(this);
        StatusBarUtil.setStatusBarColor(this,color_id);
        StatusBarUtil.StatusBarLightMode(this,StatusBarUtil.StatusBarLightMode(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mToastUtils.destory();
    }
}
