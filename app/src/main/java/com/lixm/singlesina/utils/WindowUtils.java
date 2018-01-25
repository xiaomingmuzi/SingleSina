package com.lixm.singlesina.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * @author Lixm
 * @date 2017/12/11
 * @detail 获取屏幕宽度和高度
 */
public class WindowUtils {

	static Context context;
	static WindowUtils WindowUtils;
	private static int screenWidth;
	private static int screenHeight;
	
	public static WindowUtils getInstense(Context context){
		if (WindowUtils==null) {
			WindowUtils=new WindowUtils();
			WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
			DisplayMetrics dm = new DisplayMetrics();
			wm.getDefaultDisplay().getMetrics(dm);    
		    screenWidth = dm.widthPixels;    
		    screenHeight = dm.heightPixels;  
		}
		return WindowUtils;
	};
	
	public int getWidth(){
		return screenWidth;
	};
	public int getHeight(){
		return screenHeight;
	};
}
