package com.lixm.singlesina.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lixm.singlesina.R;

/**
 * Created by zhuxuanmuyu on 2017/12/17.
 */

public class UserItemView extends RelativeLayout {
    private Context mContext;
    private ImageView imageView,itemRightImg;
    private TextView itemText1,itemText2,itemText3;
    private int imgBg;
    private String text1,text2;

    public UserItemView(Context context) {
        this(context,null);
    }

    public UserItemView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public UserItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        final TypedArray attributes=context.getTheme().obtainStyledAttributes(attrs,R.styleable.UserItemView,defStyleAttr,0);
        imgBg=attributes.getResourceId(R.styleable.UserItemView_img_bg,android.R.drawable.ic_menu_myplaces);
        text1=attributes.getString(R.styleable.UserItemView_text1_content);
        text2=attributes.getString(R.styleable.UserItemView_text2_content);
        attributes.recycle();
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_item, null);
        addView(view);
        imageView=findViewById(R.id.item_img);
        imageView.setBackgroundResource(imgBg);
        itemText1=findViewById(R.id.item_txt);
        itemText1.setText(text1);
        itemText2=findViewById(R.id.item_content);
        itemText2.setText(text2);
        itemText3=findViewById(R.id.item_right_txt);
        itemRightImg=findViewById(R.id.right_img);
    }

    public void setData(int imgId,String text1,String text2,String text3){
        imageView.setBackgroundResource(imgId);
        itemText1.setText(text1);
        itemText2.setText(text2);
        if (TextUtils.isEmpty(text3)){
            itemRightImg.setVisibility(VISIBLE);
            itemText3.setVisibility(GONE);
        }else {
            itemRightImg.setVisibility(GONE);
            itemText3.setVisibility(VISIBLE);
            itemText3.setText(text3);
        }
    }
}
