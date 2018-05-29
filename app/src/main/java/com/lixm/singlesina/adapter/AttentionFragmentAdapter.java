package com.lixm.singlesina.adapter;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lixm.singlesina.R;
import com.lixm.singlesina.activity.WeiBoDetailsActivity;
import com.lixm.singlesina.adapter.utils.BaseRecyclerViewAdapter;
import com.lixm.singlesina.bean.AttentionBean;
import com.lixm.singlesina.bean.PicUrlsBean;
import com.lixm.singlesina.customview.NoScrollGridView;
import com.lixm.singlesina.utils.ConstantMethodUtils;
import com.lixm.singlesina.utils.GlideUtils;
import com.lixm.singlesina.utils.TimeUtils;
import com.lixm.singlesina.utils.UIUtils;
import com.lixm.singlesina.utils.WindowUtils;

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

        final AttentionBean.StatusesBean statusesBean = (AttentionBean.StatusesBean) mDatas.get(position);
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
        AttentionBean.StatusesBean.RetweetedStatusBean retweetedStatusBean = statusesBean.getRetweeted_status();
        if (retweetedStatusBean != null) {
            holder.retweeted_item.setVisibility(View.VISIBLE);
            holder.retweeted_name_content.setText("@" + retweetedStatusBean.getUser().getScreen_name() + "：" + retweetedStatusBean.getText());
            handlePic(holder.retweeted_picture_view, holder.re_one_img_layout, holder.re_one_img, holder.re_one_long_txt, retweetedStatusBean.getPic_urls());
        } else {
            holder.retweeted_item.setVisibility(View.GONE);
        }
        holder.retweeted_txt.setText(statusesBean.getReposts_count() == 0 ? "转发" : statusesBean.getReposts_count() + "");
        holder.comment_txt.setText(statusesBean.getComments_count() == 0 ? "评论" : statusesBean.getComments_count() + "");
        holder.praise_text.setText(statusesBean.getAttitudes_count() == 0 ? "点赞" : statusesBean.getAttitudes_count() + "");

        handlePic(holder.picture1, holder.one_img_layout, holder.one_img, holder.one_long_txt, statusesBean.getPic_urls());

        holder.view.setOnClickListener(new View.OnClickListener() {//原创布局
            @Override
            public void onClick(View v) {
                WeiBoDetailsActivity.enterActivity(mContext,statusesBean.getIdstr());
            }
        });

        holder.retweeted_item.setOnClickListener(new View.OnClickListener() {//转发布局
            @Override
            public void onClick(View v) {

            }
        });

    }

    /**
     * 处理多张图片，单张图片
     *
     * @param pictureGrid
     * @param oneLayout
     * @param one_img
     * @param oneLong
     * @param list
     */
    private void handlePic(NoScrollGridView pictureGrid, RelativeLayout oneLayout, ImageView one_img, TextView oneLong, List<PicUrlsBean> list) {
        if (list == null) {
            pictureGrid.setVisibility(View.GONE);
            oneLayout.setVisibility(View.GONE);
        } else if (list.size() == 0) {
            pictureGrid.setVisibility(View.GONE);
            oneLayout.setVisibility(View.GONE);
        } else if (list.size() == 1) {
            pictureGrid.setVisibility(View.GONE);
            oneLayout.setVisibility(View.VISIBLE);
            GlideUtils.getRectangleImg(mContext, ConstantMethodUtils.replaceThumbnailUrl(list.get(0).getThumbnail_pic()), one_img);
        } else {
            oneLayout.setVisibility(View.GONE);
            LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) pictureGrid.getLayoutParams();
            pictureGrid.setVisibility(View.VISIBLE);
            if (list.size() == 4) {
                int windWidth = WindowUtils.getInstense(mContext).getWidth();//屏幕宽度 px
                int baseWidth = windWidth - UIUtils.dip2px(40);
                params.width=baseWidth / 3*2+20;
                pictureGrid.setNumColumns(2);
            } else {
                params.width= RelativeLayout.LayoutParams.MATCH_PARENT;
                pictureGrid.setNumColumns(3);
            }
            pictureGrid.setAdapter(new PicGridViewAdapter(mContext, list));
        }
    }


}
