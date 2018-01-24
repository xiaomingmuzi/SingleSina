package com.lixm.singlesina.adapter;

import android.content.Context;
import android.text.Html;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import com.lixm.singlesina.R;
import com.lixm.singlesina.adapter.utils.BaseRecyclerViewAdapter;
import com.lixm.singlesina.adapter.utils.ViewHolder;
import com.lixm.singlesina.bean.AttentionBean;
import com.lixm.singlesina.utils.GlideCircleTransform;
import com.lixm.singlesina.utils.TimeUtils;

import java.util.List;


/**
 * @author Lixm
 * @date 2018/1/24
 * @detail 关注列表适配器
 */

public class AttentionFragmentAdapter extends BaseRecyclerViewAdapter {

    public AttentionFragmentAdapter(Context mContext, List<?> mDatas) {
        super(mContext, mDatas, R.layout.attention_item);
    }

    public void bindData(List<?> datas){
        mDatas=datas;
    }

    @Override
    public void getItemView(ViewHolder holder, int position) {

        AttentionBean.StatusesBean statusesBean= (AttentionBean.StatusesBean) mDatas.get(position);
        Glide.with(mContext)
                .load(statusesBean.getUser().getProfile_image_url())
//                .load("http://images.shichai.cnfol.com/original/201611/20161129113736719.jpg")
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .transform(new GlideCircleTransform(mContext))
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .error(R.mipmap.default_head)
                .placeholder(R.mipmap.default_head)
                .into(holder.head);
        holder.name.setText(statusesBean.getUser().getScreen_name());
        holder.time.setText(TimeUtils.getTimeDiff(statusesBean.getCreated_at()));
        holder.from.setText(Html.fromHtml(statusesBean.getSource()));
        holder.content1.setText(statusesBean.getText());
        holder.retweeted_txt.setText(statusesBean.getReposts_count()+"");
        holder. comment_txt.setText(statusesBean.getComments_count()+"");
        holder. praise_text.setText(statusesBean.getAttitudes_count()+"");

    }

//    public AttentionFragmentAdapter(Context mContext, List<?> mDatas) {
//        super(mContext, mDatas);
//    }
//
//    @Override
//    public View getItemView(int position, View convertView, ViewGroup parent) {
//        convertView = getConView(convertView, R.layout.attention_item);
//        ImageView head = ViewHolder.get(convertView, R.id.head);
//        TextView name = ViewHolder.get(convertView, R.id.name);
//        TextView time = ViewHolder.get(convertView, R.id.time);
//        TextView from = ViewHolder.get(convertView, R.id.from);
//        TextView content1=ViewHolder.get(convertView,R.id.content1);
//        View retweeted_item=ViewHolder.get(convertView,R.id.retweeted_item);
//        GridView picture1=ViewHolder.get(convertView,R.id.picture_view1);
//        TextView retweeted_txt=ViewHolder.get(convertView,R.id.retweeted_txt);
//        TextView comment_txt=ViewHolder.get(convertView,R.id.comment_txt);
//        TextView praise_text=ViewHolder.get(convertView,R.id.praise_text);
//
//        AttentionBean.StatusesBean statusesBean= (AttentionBean.StatusesBean) mDatas.get(position);
//        Glide.with(mContext)
//                .load(statusesBean.getUser().getProfile_image_url())
////                .load("http://images.shichai.cnfol.com/original/201611/20161129113736719.jpg")
//                .skipMemoryCache(true)
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
//                .transform(new GlideCircleTransform(mContext))
//                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
//                .error(R.mipmap.default_head)
//                .placeholder(R.mipmap.default_head)
//                .into(head);
//        name.setText(statusesBean.getUser().getScreen_name());
//        time.setText(statusesBean.getCreated_at());
//        from.setText(Html.fromHtml(statusesBean.getSource()));
//        content1.setText(statusesBean.getText());
//        retweeted_txt.setText(statusesBean.getReposts_count()+"");
//        comment_txt.setText(statusesBean.getComments_count()+"");
//        praise_text.setText(statusesBean.getAttitudes_count()+"");
//        return convertView;
//    }


}
