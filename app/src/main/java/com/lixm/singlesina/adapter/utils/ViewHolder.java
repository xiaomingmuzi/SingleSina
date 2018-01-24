package com.lixm.singlesina.adapter.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.lixm.singlesina.R;

/**
 * @author Lixm
 * @date 2018/1/24
 * @detail
 */

public class ViewHolder extends RecyclerView.ViewHolder {
    private View view;
    public ImageView head;
    public TextView name;
    public TextView time;
    public TextView from;
    public TextView content1;
    public View retweeted_item;
    public GridView picture1;
    public TextView retweeted_txt;
    public TextView comment_txt;
    public TextView praise_text;

    public ViewHolder(View view) {
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
        picture1 = view.findViewById(R.id.picture_view1);
        retweeted_txt = view.findViewById(R.id.retweeted_txt);
        comment_txt = view.findViewById(R.id.comment_txt);
        praise_text = view.findViewById(R.id.praise_text);
    }

//    public <T extends View> T get(int id){
//        SparseArray<View> viewHolder= (SparseArray<View>) view.getTag();
//        if (viewHolder==null){
//            viewHolder=new SparseArray<View>();
//            view.setTag(viewHolder);
//        }
//        View childView=viewHolder.get(id);
//        if (childView==null){
//            childView=view.findViewById(id);
//            viewHolder.put(id,childView);
//        }
//        return (T) childView;
//    }
}
