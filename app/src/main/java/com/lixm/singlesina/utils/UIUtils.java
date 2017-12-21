package com.lixm.singlesina.utils;

import android.content.Context;

import com.lixm.singlesina.application.BaseApplication;

/**
 * @author Lixm
 * @date 2017/12/21
 * @detail
 */

public class UIUtils {
    /**
     * 获取上下文Context
     *
     * @return
     */
    public static Context getContext() {
        return BaseApplication.getApplication();
    }
    /**
     * dp转换成像素
     *
     * @param dp
     * @return
     */
    public static int dp2Px(float dp) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    /**
     * dip转换px
     */
    public static int dip2px(int dip) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

    /**
     * pxz转换dip
     */
    public static int px2dip(int px) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     *            （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int sp2px(float spValue) {
        final float fontScale = getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
