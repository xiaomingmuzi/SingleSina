package com.lixm.singlesina.adapter.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * @author Lixm
 * @date 2018/1/24
 * @detail
 */

public abstract class BaseObjectListAdapter extends BaseAdapter {
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected List<? extends Object> mDatas;//数据集合

    public BaseObjectListAdapter() {
    }

    public BaseObjectListAdapter(Context mContext, List<? extends Object> mDatas) {
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
        if (mDatas != null)
            this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas==null?0:mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public List<? extends  Object> getDatas(){
        return mDatas;
    }

    public abstract View getItemView(int position,View convertView,ViewGroup parent);


    protected  View getConView(View convertView,int resid){
        if (null==convertView){
            convertView=mInflater.inflate(resid,null);
        }
        return convertView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getItemView(position,convertView,parent);
    }


}
