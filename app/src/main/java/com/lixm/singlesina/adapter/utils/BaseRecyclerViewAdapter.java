package com.lixm.singlesina.adapter.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author Lixm
 * @date 2018/1/24
 * @detail
 */

public abstract class BaseRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    protected Context mContext;
    protected List<? extends Object> mDatas;
    private LayoutInflater mInflater;
    private int layoutId;

    public BaseRecyclerViewAdapter(Context mContext, List<? extends Object> mDatas, int layoutId) {
        this.mContext = mContext;
        if (mDatas != null)
            this.mDatas = mDatas;
        this.layoutId = layoutId;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(layoutId, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        getItemView(holder, position);
    }

    public abstract void getItemView(ViewHolder holder, int position);

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }
}
