package com.lixm.singlesina.adapter.utils;

import android.util.SparseArray;
import android.view.View;

/**
 * @author Lixm
 * @date 2018/1/25
 * @detail 配合{@link com.lixm.singlesina.adapter.utils.BaseObjectListAdapter}一起使用
 */

public class BaseObjectListViewHolder {

    public static <T extends View> T get(View convertView, int id) {

        SparseArray<View> viewHolder = (SparseArray<View>) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new SparseArray<View>();
            convertView.setTag(viewHolder);
        }
        View childView = viewHolder.get(id);
        if (childView == null) {
            childView = convertView.findViewById(id);
            viewHolder.put(id, childView);
        }
        return (T) childView;
    }
}
