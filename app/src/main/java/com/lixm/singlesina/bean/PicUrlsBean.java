package com.lixm.singlesina.bean;

import java.io.Serializable;

/**
 * @author Lixm
 * @date 2018/1/30
 * @detail
 */

public class PicUrlsBean implements Serializable {
    /**
     * thumbnail_pic : http://wx1.sinaimg.cn/thumbnail/006HMUtTly1fnslk6k47hj30by0by0tk.jpg
     */

    private String thumbnail_pic;

    public String getThumbnail_pic() {
        return thumbnail_pic;
    }

    public void setThumbnail_pic(String thumbnail_pic) {
        this.thumbnail_pic = thumbnail_pic;
    }
}
