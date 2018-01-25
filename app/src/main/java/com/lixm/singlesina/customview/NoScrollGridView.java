package com.lixm.singlesina.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * @author Lixm
 * @date 2018/1/25
 * @detail 自定义GridView 来解决ListView嵌套GridView。GridView显示不全的问题
 */

public class NoScrollGridView extends GridView {

    public NoScrollGridView(Context context) {
        super(context);
    }

    public NoScrollGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoScrollGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec=MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }


}