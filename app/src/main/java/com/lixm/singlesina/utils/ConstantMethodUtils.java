package com.lixm.singlesina.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Lixm
 * @date 2018/1/25
 * @detail
 */

public class ConstantMethodUtils {
    /**
     * 读取assets下的txt文件，返回utf-8 String
     * @param context
     * @param fileName 不包括后缀
     * @return
     */
    public static String readAssetsTxt(Context context, String fileName){
        try {
            //Return an AssetManager instance for your application's package
            InputStream is = context.getAssets().open(fileName+".txt");
            int size = is.available();
            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            // Convert the buffer into a string.
            String text = new String(buffer, "utf-8");
            // Finally stick the string into the text view.
            return text;
        } catch (IOException e) {
            // Should never happen!
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
        return "";
    }

    public static String replaceThumbnailUrl(String url){
        String newUrl="";
        if (url!=null && url.contains("thumbnail")){
            newUrl=url.replace("thumbnail","bmiddle");
        }
        return newUrl;
    }

}
