package com.lixm.singlesina.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by zhuxuanmuyu on 2017/12/16.
 */

public class ToastUtils {

    private Toast mToast;


    //使用volatile关键字保其可见性
    volatile private static ToastUtils instance = null;

    private ToastUtils(Context context) {
        LogUtil.w("创建Toast对象");
        mToast = Toast.makeText(context.getApplicationContext(), null, Toast.LENGTH_SHORT);
    }

    public static ToastUtils getInstance(Context context) {
        try {
            if (instance != null) {//懒汉式
            } else {
                Thread.sleep(300);
                synchronized (ToastUtils.class) {
                    if (instance == null)//二次检查
                        instance = new ToastUtils(context);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return instance;
    }

    /**
     * 显示Toast
     *
     * @param toastMsg
     */
    public void showToast(int toastMsg) {
        mToast.setText(toastMsg);
        mToast.show();
    }

    /**
     * @param toastMsg
     */
    public void showToast(String toastMsg) {
        mToast.setText(toastMsg);
        mToast.show();
    }

    /**
     * 取消toast，在activity的destory方法中调用
     */
    public void destory() {
        if (null != mToast) {
            mToast.cancel();
            mToast = null;
        }
        instance = null;
    }
}
