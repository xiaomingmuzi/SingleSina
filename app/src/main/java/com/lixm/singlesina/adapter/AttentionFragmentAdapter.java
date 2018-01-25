package com.lixm.singlesina.adapter;

import android.content.Context;
import android.text.Html;
import android.view.View;

import com.lixm.singlesina.R;
import com.lixm.singlesina.adapter.utils.BaseRecyclerViewAdapter;
import com.lixm.singlesina.bean.AttentionBean;
import com.lixm.singlesina.utils.ConstantMethodUtils;
import com.lixm.singlesina.utils.GlideUtils;
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

    public void bindData(List<?> datas) {
        mDatas = datas;
    }

    @Override
    public void getItemView(AttentionViewHolder holder, int position) {

        AttentionBean.StatusesBean statusesBean = (AttentionBean.StatusesBean) mDatas.get(position);
        GlideUtils.getCircleHead(mContext, statusesBean.getUser().getAvatar_large(), holder.head);
        holder.name.setText(statusesBean.getUser().getScreen_name());
        holder.time.setText(TimeUtils.getTimeDiff(statusesBean.getCreated_at()));
        //style="color:red;text-decoration:none;"
        String source = statusesBean.getSource();
        if (source.contains("rel=\"nofollow\"")) {
            source = source.replaceAll("rel=\"nofollow\"", "rel=\"nofollow\" style=\"color:#517EB0;text-decoration:none;\"");
        }
        holder.from.setText(Html.fromHtml(source));
        holder.content1.setText(statusesBean.getText());
        AttentionBean.StatusesBean.RetweetedStatusBean  retweetedStatusBean= statusesBean.getRetweeted_status();
        if (retweetedStatusBean!=null){
            holder.retweeted_item.setVisibility(View.VISIBLE);
            holder.retweeted_name_content.setText("@"+retweetedStatusBean.getUser().getScreen_name()+"："+retweetedStatusBean.getText());
        }else{
            holder.retweeted_item.setVisibility(View.GONE);
        }
        holder.retweeted_txt.setText(statusesBean.getReposts_count() + "");
        holder.comment_txt.setText(statusesBean.getComments_count() + "");
        holder.praise_text.setText(statusesBean.getAttitudes_count() + "");
        if (statusesBean.getPic_urls() == null) {
            holder.picture1.setVisibility(View.GONE);
            holder.one_img_layout.setVisibility(View.GONE);
        } else if (statusesBean.getPic_urls().size() == 0) {
            holder.picture1.setVisibility(View.GONE);
            holder.one_img_layout.setVisibility(View.GONE);
        } else if (statusesBean.getPic_urls().size() == 1) {
            holder.picture1.setVisibility(View.GONE);
            holder.one_img_layout.setVisibility(View.VISIBLE);
            GlideUtils.getRectangleImg(mContext, ConstantMethodUtils.replaceThumbnailUrl(statusesBean.getPic_urls().get(0).getThumbnail_pic()), holder.one_img);
        } else {
            holder.one_img_layout.setVisibility(View.GONE);
            holder.picture1.setVisibility(View.VISIBLE);
            holder.picture1.setAdapter(new PicGridViewAdapter(mContext, statusesBean.getPic_urls()));
        }

    }


}
