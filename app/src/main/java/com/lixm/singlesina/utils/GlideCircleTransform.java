package com.lixm.singlesina.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/**
 * Created by zhuxuanmuyu on 2017/12/11.
 */

public class GlideCircleTransform extends BitmapTransformation {
    public GlideCircleTransform(Context context) {
        super(context);
    }

    @Override protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        int diameter=Math.min(toTransform.getWidth(),toTransform.getHeight());
        Bitmap toReuse=pool.get(outWidth,outHeight, Bitmap.Config.ARGB_8888);
        Bitmap result;
        if (toReuse!=null)
            result=toReuse;
        else result=Bitmap.createBitmap(diameter,diameter, Bitmap.Config.ARGB_8888);

        int dx=(toTransform.getWidth()-diameter)/2;//计算偏移量
        int dy=(toTransform.getHeight()-diameter)/2;
        Canvas canvas=new Canvas(result);
        Paint paint=new Paint();
        BitmapShader shader=new BitmapShader(toTransform,BitmapShader.TileMode.CLAMP,BitmapShader.TileMode.CLAMP);
        if (dx!=0 || dy!=0){
            Matrix matrix=new Matrix();
            matrix.setTranslate(-dx,-dy);
            shader.setLocalMatrix(matrix);
        }
        paint.setShader(shader);
        paint.setAntiAlias(true);
        float radius= diameter/2f;
        canvas.drawCircle(radius,radius,radius,paint);
        if (toReuse!=null && !pool.put(toReuse))
            toReuse.recycle();
        return result;
    }

    private static Bitmap circleCrop(BitmapPool pool, Bitmap source) {
        if (source == null) return null;

        int size = Math.min(source.getWidth(), source.getHeight());
        int x = (source.getWidth() - size) / 2;
        int y = (source.getHeight() - size) / 2;

        // TODO this could be acquired from the pool too
        Bitmap squared = Bitmap.createBitmap(source, x, y, size, size);

        Bitmap result = pool.get(size, size, Bitmap.Config.ARGB_8888);
        if (result == null) {
            result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        float r = size / 2f;
        canvas.drawCircle(r, r, r, paint);
        return result;
    }

    @Override public String getId() {
        return getClass().getName();
    }
}
