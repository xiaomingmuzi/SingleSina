package com.lixm.singlesina.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lixm.singlesina.R;
import com.lixm.singlesina.customview.NoScrollGridView;

/**
 * @author Lixm
 * @date 2018/1/24
 * @detail
 */

public class AttentionViewHolder extends RecyclerView.ViewHolder {
    private View view;
    public ImageView head;
    public TextView name;
    public TextView time;
    public TextView from;
    public TextView content1;
    public View retweeted_item;
    public TextView retweeted_name_content;
    public NoScrollGridView retweeted_picture_view;
    public RelativeLayout one_img_layout;
    public ImageView one_img;
    public TextView one_long_txt;
    public NoScrollGridView picture1;
    public TextView retweeted_txt;
    public TextView comment_txt;
    public TextView praise_text;

    public AttentionViewHolder(View view) {
        super(view);
        this.view = view;
        initView();
    }

    private void initView() {
        head = view.findViewById(R.id.head);
        name = view.findViewById(R.id.name);
        time = view.findViewById(R.id.time);
        from = view.findViewById(R.id.from);
        content1 = view.findViewById(R.id.content1);
        retweeted_item = view.findViewById(R.id.retweeted_item);
        retweeted_name_content=view.findViewById(R.id.retweeted_name_content);
        retweeted_picture_view=view.findViewById(R.id.retweeted_picture_view);
        picture1 = view.findViewById(R.id.picture_view1);
        one_img_layout=view.findViewById(R.id.one_img_layout);
        one_img=view.findViewById(R.id.one_img);
        one_long_txt=view.findViewById(R.id.one_long_txt);
        retweeted_txt = view.findViewById(R.id.retweeted_txt);
        comment_txt = view.findViewById(R.id.comment_txt);
        praise_text = view.findViewById(R.id.praise_text);
    }

}
