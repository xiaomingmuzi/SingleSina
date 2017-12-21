package com.lixm.singlesina.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lixm.singlesina.R;
import com.lixm.singlesina.utils.LogUtil;
import com.lixm.singlesina.utils.UIUtils;


/**
 * @author Lixm
 * @date 2017/12/21
 * @detail
 */

public class GestureLineView extends View {

    private Context mContext;
    private Paint mPaint;
    private Canvas mCanvas;
    private int width;
    private int height;
    private float rightPoi = 0;
    private float leftPoi = 0;
    private float lineWidth = 0;
    private float startPadding;

    private int startColr;
    private int endColor;
    private float centerPadding;
    private int radius;

    public GestureLineView(Context context) {
        this(context, null);
    }

    public GestureLineView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GestureLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;

        final TypedArray attributes=context.getTheme().obtainStyledAttributes(attrs,R.styleable.GestureLineView,defStyleAttr,0);
        startColr=attributes.getColor(R.styleable.GestureLineView_start_color,getResources().getColor(R.color.line_start));
        endColor=attributes.getColor(R.styleable.GestureLineView_end_color,getResources().getColor(R.color.line_end));
        centerPadding=attributes.getDimension(R.styleable.GestureLineView_center_padding,60);
        radius= (int) attributes.getDimension(R.styleable.GestureLineView_radius,UIUtils.dip2px(2));

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setAntiAlias(true);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (width == 0) {
            width = getMeasuredWidth();
            height = getMeasuredHeight();
            rightPoi = width / 2 - centerPadding;
            startPadding = getPaddingStart();
            leftPoi = startPadding;
            lineWidth = rightPoi - leftPoi;
            LinearGradient linearGradient = new LinearGradient(leftPoi, height / 2, rightPoi, height / 2, startColr, endColor, Shader.TileMode.CLAMP);
            mPaint.setShader(linearGradient);
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mCanvas == null)
            this.mCanvas = canvas;
        LogUtil.i("========width：" + width + "  rightPoi：" + rightPoi + "  lefrPoi：" + leftPoi);
        RectF rectF = new RectF(leftPoi, 0, rightPoi, height);
        canvas.drawRoundRect(rectF, radius, radius, mPaint);
    }

    /**
     * @param forward 0： 1页滑到0页   1:0页滑到1页
     * @param dis     变化的距离
     */
    public void slidDistance(int forward, float dis) {
        if (forward == 1) {
            if (dis < 0.5) {
                rightPoi = startPadding + lineWidth + (lineWidth + 2 * centerPadding) * 2 * dis;
            } else if (dis == 0.5) {
                rightPoi = startPadding + lineWidth + (lineWidth + 2 * centerPadding) * 2 * dis;
                leftPoi = startPadding + (lineWidth + 2 * centerPadding) * (2 * dis - 1);
            } else {
                leftPoi = startPadding + (lineWidth + 2 * centerPadding) * (2 * dis - 1);
            }
        } else {
            if (dis > 0.5) {
                leftPoi = startPadding + (lineWidth + 2 * centerPadding) * (2 * dis - 1);
            } else if (dis == 0.5) {
                leftPoi = startPadding + (lineWidth + 2 * centerPadding) * (2 * dis - 1);
                rightPoi = startPadding + lineWidth + (lineWidth + 2 * centerPadding) * 2 * dis;
            } else {
                rightPoi = startPadding + lineWidth + (lineWidth + 2 * centerPadding) * 2 * dis;
            }
        }
        postInvalidate();
    }

}
