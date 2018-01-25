package com.lixm.singlesina.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.lixm.singlesina.R;
import com.lixm.singlesina.adapter.utils.BaseObjectListAdapter;
import com.lixm.singlesina.adapter.utils.BaseObjectListViewHolder;
import com.lixm.singlesina.bean.AttentionBean;
import com.lixm.singlesina.utils.ConstantMethodUtils;
import com.lixm.singlesina.utils.GlideUtils;
import com.lixm.singlesina.utils.UIUtils;
import com.lixm.singlesina.utils.WindowUtils;

import java.util.List;

/**
 * @author Lixm
 * @date 2018/1/25
 * @detail
 */

public class PicGridViewAdapter extends BaseObjectListAdapter {

    public PicGridViewAdapter(Context mContext, List<?> mDatas) {
        super(mContext, mDatas);
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        convertView = getConView(convertView, R.layout.pic_grid_item);
        ImageView imageView = BaseObjectListViewHolder.get(convertView, R.id.imageView);
        RelativeLayout longLayout = BaseObjectListViewHolder.get(convertView, R.id.long_img_rl);
        // 图片的填充
        imageView.measure(0, 0);

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        int windWidth = WindowUtils.getInstense(mContext).getWidth();//屏幕宽度 px
        int baseWidth = windWidth - UIUtils.dip2px(40);
        params.height = baseWidth / 3;
        params.width=params.height;
        imageView.setLayoutParams(params);
        GlideUtils.getRectangleImg(mContext, ConstantMethodUtils.replaceThumbnailUrl(((AttentionBean.StatusesBean.PicUrlsBean) mDatas.get(position)).getThumbnail_pic()), imageView);
//        int[] data = GlideUtils.getRectangleImgWithWith(mContext, ((AttentionBean.StatusesBean.PicUrlsBean) mDatas.get(position)).getThumbnail_pic(), imageView);
//        try {
//            if ((data[1] > data[0] && data[1] / data[0] >= 3) || (data[0] > data[1] && data[0] / data[1] >= 3)) {
//                longLayout.setVisibility(View.VISIBLE);
//            } else {
//                longLayout.setVisibility(View.GONE);
//            }
//        } catch (Exception e) {
//            longLayout.setVisibility(View.GONE);
//        }

        return convertView;
    }
}
