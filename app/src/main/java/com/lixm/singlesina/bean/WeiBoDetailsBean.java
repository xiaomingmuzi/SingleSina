package com.lixm.singlesina.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author Lixm
 * @date 2018/1/30
 * @detail  微博详情返回bean
 */

public class WeiBoDetailsBean implements Serializable {

    /**
     * created_at : Tue Jan 30 15:04:56 +0800 2018
     * id : 4201905896865856
     * idstr : 4201905896865856
     * mid : 4201905896865856
     * can_edit : false
     * text : 内心@3CE彩妆冰封新春 http://t.cn/z8At1ay ​
     * textLength : 40
     * source_allowclick : 0
     * source_type : 2
     * source : <a href="http://weibo.com/" rel="nofollow">iPhone客户端</a>
     * favorited : false
     * truncated : false
     * in_reply_to_status_id :
     * in_reply_to_user_id :
     * in_reply_to_screen_name :
     * pic_urls : [{"thumbnail_pic":"http://wx3.sinaimg.cn/thumbnail/910c84fbly1fnynbtd87ej20kf0kfabu.jpg"},{"thumbnail_pic":"http://wx1.sinaimg.cn/thumbnail/910c84fbly1fnynbtk118j20gs0gs75i.jpg"}]
     * thumbnail_pic : http://wx3.sinaimg.cn/thumbnail/910c84fbly1fnynbtd87ej20kf0kfabu.jpg
     * bmiddle_pic : http://wx3.sinaimg.cn/bmiddle/910c84fbly1fnynbtd87ej20kf0kfabu.jpg
     * original_pic : http://wx3.sinaimg.cn/large/910c84fbly1fnynbtd87ej20kf0kfabu.jpg
     * geo : {"type":"Point","coordinates":[39.91954,116.463608]}
     * is_paid : false
     * mblog_vip_type : 0
     * user : {"id":2433516795,"idstr":"2433516795","class":1,"screen_name":"晓明木子","name":"晓明木子","province":"11","city":"5","location":"北京 朝阳区","description":"我就是我，我还是我！","url":"http://blog.sina.com.cn/u/2433516795","profile_image_url":"http://tvax2.sinaimg.cn/crop.1.0.510.510.50/910c84fbly8fdj1oai762j20e80e6jrp.jpg","cover_image_phone":"http://ww2.sinaimg.cn/crop.0.0.640.640.640/910c84fbjw1f7fbmqcibvj20yi0yi0zk.jpg","profile_url":"lxm1013","domain":"lxm1013","weihao":"","gender":"f","followers_count":212,"friends_count":892,"pagefriends_count":31,"statuses_count":1188,"favourites_count":27,"created_at":"Sat Oct 29 23:21:14 +0800 2011","following":false,"allow_all_act_msg":false,"geo_enabled":true,"verified":false,"verified_type":-1,"remark":"","insecurity":{"sexual_content":false},"ptype":0,"allow_all_comment":true,"avatar_large":"http://tvax2.sinaimg.cn/crop.1.0.510.510.180/910c84fbly8fdj1oai762j20e80e6jrp.jpg","avatar_hd":"http://tvax2.sinaimg.cn/crop.1.0.510.510.1024/910c84fbly8fdj1oai762j20e80e6jrp.jpg","verified_reason":"","verified_trade":"","verified_reason_url":"","verified_source":"","verified_source_url":"","follow_me":false,"like":false,"like_me":false,"online_status":0,"bi_followers_count":38,"lang":"zh-cn","star":0,"mbtype":0,"mbrank":0,"block_word":0,"block_app":0,"credit_score":80,"user_ability":2,"avatargj_id":"gj_vip_011","urank":25,"story_read_state":-1,"vclub_member":0}
     * annotations : [{"place":{"poiid":"B2094654D06BA1FB449B","title":"世纪财富中心","type":"checkin"},"client_mblogid":"iPhone-919A3D18-CC0C-4E84-A6A5-B7F946CC3FDC"},{"mapi_request":true}]
     * reposts_count : 0
     * comments_count : 0
     * attitudes_count : 0
     * pending_approval_count : 0
     * isLongText : false
     * mlevel : 0
     * visible : {"type":0,"list_id":0}
     * biz_ids : [100101]
     * biz_feature : 4294967300
     * hasActionTypeCard : 0
     * darwin_tags : []
     * hot_weibo_tags : []
     * text_tag_tips : []
     * userType : 0
     * more_info_type : 0
     * positive_recom_flag : 0
     * content_auth : 0
     * gif_ids :
     * is_show_bulletin : 2
     * comment_manage_info : {"comment_manage_button":1,"comment_permission_type":0,"approval_comment_type":0}
     */

    private String created_at;
    private long id;
    private String idstr;
    private String mid;
    private boolean can_edit;
    private String text;
    private int textLength;
    private int source_allowclick;
    private int source_type;
    private String source;
    private boolean favorited;
    private boolean truncated;
    private String in_reply_to_status_id;
    private String in_reply_to_user_id;
    private String in_reply_to_screen_name;
    private String thumbnail_pic;
    private String bmiddle_pic;
    private String original_pic;
    private GeoBean geo;
    private boolean is_paid;
    private int mblog_vip_type;
    private UserBean user;
    private int reposts_count;
    private int comments_count;
    private int attitudes_count;
    private int pending_approval_count;
    private boolean isLongText;
    private int mlevel;
    private VisibleBean visible;
    private long biz_feature;
    private int hasActionTypeCard;
    private int userType;
    private int more_info_type;
    private int positive_recom_flag;
    private int content_auth;
    private String gif_ids;
    private int is_show_bulletin;
    private CommentManageInfoBean comment_manage_info;
    private List<PicUrlsBean> pic_urls;
    private List<AnnotationsBean> annotations;
    private List<Integer> biz_ids;
    private List<?> darwin_tags;
    private List<?> hot_weibo_tags;
    private List<?> text_tag_tips;

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdstr() {
        return idstr;
    }

    public void setIdstr(String idstr) {
        this.idstr = idstr;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public boolean isCan_edit() {
        return can_edit;
    }

    public void setCan_edit(boolean can_edit) {
        this.can_edit = can_edit;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTextLength() {
        return textLength;
    }

    public void setTextLength(int textLength) {
        this.textLength = textLength;
    }

    public int getSource_allowclick() {
        return source_allowclick;
    }

    public void setSource_allowclick(int source_allowclick) {
        this.source_allowclick = source_allowclick;
    }

    public int getSource_type() {
        return source_type;
    }

    public void setSource_type(int source_type) {
        this.source_type = source_type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public boolean isTruncated() {
        return truncated;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    public String getIn_reply_to_status_id() {
        return in_reply_to_status_id;
    }

    public void setIn_reply_to_status_id(String in_reply_to_status_id) {
        this.in_reply_to_status_id = in_reply_to_status_id;
    }

    public String getIn_reply_to_user_id() {
        return in_reply_to_user_id;
    }

    public void setIn_reply_to_user_id(String in_reply_to_user_id) {
        this.in_reply_to_user_id = in_reply_to_user_id;
    }

    public String getIn_reply_to_screen_name() {
        return in_reply_to_screen_name;
    }

    public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
        this.in_reply_to_screen_name = in_reply_to_screen_name;
    }

    public String getThumbnail_pic() {
        return thumbnail_pic;
    }

    public void setThumbnail_pic(String thumbnail_pic) {
        this.thumbnail_pic = thumbnail_pic;
    }

    public String getBmiddle_pic() {
        return bmiddle_pic;
    }

    public void setBmiddle_pic(String bmiddle_pic) {
        this.bmiddle_pic = bmiddle_pic;
    }

    public String getOriginal_pic() {
        return original_pic;
    }

    public void setOriginal_pic(String original_pic) {
        this.original_pic = original_pic;
    }

    public GeoBean getGeo() {
        return geo;
    }

    public void setGeo(GeoBean geo) {
        this.geo = geo;
    }

    public boolean isIs_paid() {
        return is_paid;
    }

    public void setIs_paid(boolean is_paid) {
        this.is_paid = is_paid;
    }

    public int getMblog_vip_type() {
        return mblog_vip_type;
    }

    public void setMblog_vip_type(int mblog_vip_type) {
        this.mblog_vip_type = mblog_vip_type;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public int getReposts_count() {
        return reposts_count;
    }

    public void setReposts_count(int reposts_count) {
        this.reposts_count = reposts_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getAttitudes_count() {
        return attitudes_count;
    }

    public void setAttitudes_count(int attitudes_count) {
        this.attitudes_count = attitudes_count;
    }

    public int getPending_approval_count() {
        return pending_approval_count;
    }

    public void setPending_approval_count(int pending_approval_count) {
        this.pending_approval_count = pending_approval_count;
    }

    public boolean isIsLongText() {
        return isLongText;
    }

    public void setIsLongText(boolean isLongText) {
        this.isLongText = isLongText;
    }

    public int getMlevel() {
        return mlevel;
    }

    public void setMlevel(int mlevel) {
        this.mlevel = mlevel;
    }

    public VisibleBean getVisible() {
        return visible;
    }

    public void setVisible(VisibleBean visible) {
        this.visible = visible;
    }

    public long getBiz_feature() {
        return biz_feature;
    }

    public void setBiz_feature(long biz_feature) {
        this.biz_feature = biz_feature;
    }

    public int getHasActionTypeCard() {
        return hasActionTypeCard;
    }

    public void setHasActionTypeCard(int hasActionTypeCard) {
        this.hasActionTypeCard = hasActionTypeCard;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getMore_info_type() {
        return more_info_type;
    }

    public void setMore_info_type(int more_info_type) {
        this.more_info_type = more_info_type;
    }

    public int getPositive_recom_flag() {
        return positive_recom_flag;
    }

    public void setPositive_recom_flag(int positive_recom_flag) {
        this.positive_recom_flag = positive_recom_flag;
    }

    public int getContent_auth() {
        return content_auth;
    }

    public void setContent_auth(int content_auth) {
        this.content_auth = content_auth;
    }

    public String getGif_ids() {
        return gif_ids;
    }

    public void setGif_ids(String gif_ids) {
        this.gif_ids = gif_ids;
    }

    public int getIs_show_bulletin() {
        return is_show_bulletin;
    }

    public void setIs_show_bulletin(int is_show_bulletin) {
        this.is_show_bulletin = is_show_bulletin;
    }

    public CommentManageInfoBean getComment_manage_info() {
        return comment_manage_info;
    }

    public void setComment_manage_info(CommentManageInfoBean comment_manage_info) {
        this.comment_manage_info = comment_manage_info;
    }

    public List<PicUrlsBean> getPic_urls() {
        return pic_urls;
    }

    public void setPic_urls(List<PicUrlsBean> pic_urls) {
        this.pic_urls = pic_urls;
    }

    public List<AnnotationsBean> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<AnnotationsBean> annotations) {
        this.annotations = annotations;
    }

    public List<Integer> getBiz_ids() {
        return biz_ids;
    }

    public void setBiz_ids(List<Integer> biz_ids) {
        this.biz_ids = biz_ids;
    }

    public List<?> getDarwin_tags() {
        return darwin_tags;
    }

    public void setDarwin_tags(List<?> darwin_tags) {
        this.darwin_tags = darwin_tags;
    }

    public List<?> getHot_weibo_tags() {
        return hot_weibo_tags;
    }

    public void setHot_weibo_tags(List<?> hot_weibo_tags) {
        this.hot_weibo_tags = hot_weibo_tags;
    }

    public List<?> getText_tag_tips() {
        return text_tag_tips;
    }

    public void setText_tag_tips(List<?> text_tag_tips) {
        this.text_tag_tips = text_tag_tips;
    }



    public static class VisibleBean {
        /**
         * type : 0
         * list_id : 0
         */

        private int type;
        private int list_id;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getList_id() {
            return list_id;
        }

        public void setList_id(int list_id) {
            this.list_id = list_id;
        }
    }

    public static class CommentManageInfoBean {
        /**
         * comment_manage_button : 1
         * comment_permission_type : 0
         * approval_comment_type : 0
         */

        private int comment_manage_button;
        private int comment_permission_type;
        private int approval_comment_type;

        public int getComment_manage_button() {
            return comment_manage_button;
        }

        public void setComment_manage_button(int comment_manage_button) {
            this.comment_manage_button = comment_manage_button;
        }

        public int getComment_permission_type() {
            return comment_permission_type;
        }

        public void setComment_permission_type(int comment_permission_type) {
            this.comment_permission_type = comment_permission_type;
        }

        public int getApproval_comment_type() {
            return approval_comment_type;
        }

        public void setApproval_comment_type(int approval_comment_type) {
            this.approval_comment_type = approval_comment_type;
        }
    }

    public static class AnnotationsBean {
        /**
         * place : {"poiid":"B2094654D06BA1FB449B","title":"世纪财富中心","type":"checkin"}
         * client_mblogid : iPhone-919A3D18-CC0C-4E84-A6A5-B7F946CC3FDC
         * mapi_request : true
         */

        private PlaceBean place;
        private String client_mblogid;
        private boolean mapi_request;

        public PlaceBean getPlace() {
            return place;
        }

        public void setPlace(PlaceBean place) {
            this.place = place;
        }

        public String getClient_mblogid() {
            return client_mblogid;
        }

        public void setClient_mblogid(String client_mblogid) {
            this.client_mblogid = client_mblogid;
        }

        public boolean isMapi_request() {
            return mapi_request;
        }

        public void setMapi_request(boolean mapi_request) {
            this.mapi_request = mapi_request;
        }

        public static class PlaceBean {
            /**
             * poiid : B2094654D06BA1FB449B
             * title : 世纪财富中心
             * type : checkin
             */

            private String poiid;
            private String title;
            private String type;

            public String getPoiid() {
                return poiid;
            }

            public void setPoiid(String poiid) {
                this.poiid = poiid;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
