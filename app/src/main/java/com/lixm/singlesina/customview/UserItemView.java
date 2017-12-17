package com.lixm.singlesina.customview;

import android.content.Context;
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

    public UserItemView(Context context) {
        this(context,null);
    }

    public UserItemView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public UserItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_item, null);
        addView(view);
        imageView=findViewById(R.id.item_img);
        itemText1=findViewById(R.id.item_txt);
        itemText2=findViewById(R.id.item_content);
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
