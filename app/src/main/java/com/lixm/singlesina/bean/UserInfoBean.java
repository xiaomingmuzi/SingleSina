package com.lixm.singlesina.bean;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;

import com.lixm.singlesina.utils.Constants;

import java.util.List;

/**
 * @author Lixm
 * @date 2017/12/11
 * @detail
 */

public class UserInfoBean  implements Parcelable{

    /**
     * id : 2433516795
     * idstr : 2433516795
     * class : 1
     * screen_name : 晓明木子
     * name : 晓明木子
     * province : 11
     * city : 5
     * location : 北京 朝阳区
     * description : 我就是我，我还是我！
     * url : http://blog.sina.com.cn/u/2433516795
     * profile_image_url : http://tvax2.sinaimg.cn/crop.1.0.510.510.50/910c84fbly8fdj1oai762j20e80e6jrp.jpg
     * cover_image_phone : http://ww2.sinaimg.cn/crop.0.0.640.640.640/910c84fbjw1f7fbmqcibvj20yi0yi0zk.jpg
     * profile_url : lxm1013
     * domain : lxm1013
     * weihao :
     * gender : f
     * followers_count : 214
     * friends_count : 887
     * pagefriends_count : 31
     * statuses_count : 1179
     * favourites_count : 27
     * created_at : Sat Oct 29 23:21:14 +0800 2011
     * following : false
     * allow_all_act_msg : false
     * geo_enabled : true
     * verified : false
     * verified_type : -1
     * remark :
     * insecurity : {"sexual_content":false}
     * status : {"created_at":"Sun Dec 10 22:15:20 +0800 2017","id":4183532429479181,"mid":"4183532429479181","idstr":"4183532429479181","can_edit":false,"text":"大红灯笼高高挂，红红火火的，跟过年很配哦","source_allowclick":0,"source_type":2,"source":"<a href=\"http://weibo.com/\" rel=\"nofollow\">iPhone客户端<\/a>","favorited":false,"truncated":false,"in_reply_to_status_id":"","in_reply_to_user_id":"","in_reply_to_screen_name":"","pic_urls":[],"geo":null,"is_paid":false,"mblog_vip_type":0,"annotations":[{"mapi_request":true}],"reposts_count":0,"comments_count":0,"attitudes_count":0,"pending_approval_count":0,"isLongText":false,"mlevel":0,"visible":{"type":0,"list_id":0},"biz_feature":0,"hasActionTypeCard":0,"darwin_tags":[],"hot_weibo_tags":[],"text_tag_tips":[],"userType":0,"more_info_type":0,"positive_recom_flag":0,"gif_ids":"","is_show_bulletin":2,"comment_manage_info":{"comment_permission_type":-1,"approval_comment_type":0}}
     * ptype : 0
     * allow_all_comment : true
     * avatar_large : http://tvax2.sinaimg.cn/crop.1.0.510.510.180/910c84fbly8fdj1oai762j20e80e6jrp.jpg
     * avatar_hd : http://tvax2.sinaimg.cn/crop.1.0.510.510.1024/910c84fbly8fdj1oai762j20e80e6jrp.jpg
     * verified_reason :
     * verified_trade :
     * verified_reason_url :
     * verified_source :
     * verified_source_url :
     * follow_me : false
     * like : false
     * like_me : false
     * online_status : 0
     * bi_followers_count : 38
     * lang : zh-cn
     * star : 0
     * mbtype : 2
     * mbrank : 1
     * block_word : 0
     * block_app : 0
     * credit_score : 80
     * user_ability : 2
     * avatargj_id : gj_vip_011
     * urank : 25
     * story_read_state : -1
     * vclub_member : 0
     */

    private long id;
    private String idstr;
    private int classX;
    private String screen_name;
    private String name;
    private String province;
    private String city;
    private String location;
    private String description;
    private String url;
    private String profile_image_url;
    private String cover_image_phone;
    private String profile_url;
    private String domain;
    private String weihao;
    private String gender;
    private int followers_count;
    private int friends_count;
    private int pagefriends_count;
    private int statuses_count;
    private int favourites_count;
    private String created_at;
    private boolean following;
    private boolean allow_all_act_msg;
    private boolean geo_enabled;
    private boolean verified;
    private int verified_type;
    private String remark;
    private InsecurityBean insecurity;
    private StatusBean status;
    private int ptype;
    private boolean allow_all_comment;
    private String avatar_large;
    private String avatar_hd;
    private String verified_reason;
    private String verified_trade;
    private String verified_reason_url;
    private String verified_source;
    private String verified_source_url;
    private boolean follow_me;
    private boolean like;
    private boolean like_me;
    private int online_status;
    private int bi_followers_count;
    private String lang;
    private int star;
    private int mbtype;
    private int mbrank;
    private int block_word;
    private int block_app;
    private int credit_score;
    private int user_ability;
    private String avatargj_id;
    private int urank;
    private int story_read_state;
    private int vclub_member;

    public UserInfoBean() {
    }

    protected UserInfoBean(Parcel in) {
        id = in.readLong();
        idstr = in.readString();
        classX = in.readInt();
        screen_name = in.readString();
        name = in.readString();
        province = in.readString();
        city = in.readString();
        location = in.readString();
        description = in.readString();
        url = in.readString();
        profile_image_url = in.readString();
        cover_image_phone = in.readString();
        profile_url = in.readString();
        domain = in.readString();
        weihao = in.readString();
        gender = in.readString();
        followers_count = in.readInt();
        friends_count = in.readInt();
        pagefriends_count = in.readInt();
        statuses_count = in.readInt();
        favourites_count = in.readInt();
        created_at = in.readString();
        following = in.readByte() != 0;
        allow_all_act_msg = in.readByte() != 0;
        geo_enabled = in.readByte() != 0;
        verified = in.readByte() != 0;
        verified_type = in.readInt();
        remark = in.readString();
        ptype = in.readInt();
        allow_all_comment = in.readByte() != 0;
        avatar_large = in.readString();
        avatar_hd = in.readString();
        verified_reason = in.readString();
        verified_trade = in.readString();
        verified_reason_url = in.readString();
        verified_source = in.readString();
        verified_source_url = in.readString();
        follow_me = in.readByte() != 0;
        like = in.readByte() != 0;
        like_me = in.readByte() != 0;
        online_status = in.readInt();
        bi_followers_count = in.readInt();
        lang = in.readString();
        star = in.readInt();
        mbtype = in.readInt();
        mbrank = in.readInt();
        block_word = in.readInt();
        block_app = in.readInt();
        credit_score = in.readInt();
        user_ability = in.readInt();
        avatargj_id = in.readString();
        urank = in.readInt();
        story_read_state = in.readInt();
        vclub_member = in.readInt();
    }

    public static final Creator<UserInfoBean> CREATOR = new Creator<UserInfoBean>() {
        @Override
        public UserInfoBean createFromParcel(Parcel in) {
            return new UserInfoBean(in);
        }

        @Override
        public UserInfoBean[] newArray(int size) {
            return new UserInfoBean[size];
        }
    };

    public void writeToCache(Context context) {
        if (null != context) {
            SharedPreferences settings = context.getSharedPreferences(Constants.USER_INFO, 0);
            SharedPreferences.Editor editor = settings.edit();

            editor.putString(Constants.UID, idstr);
            editor.putString(Constants.NAME, name);
            editor.putString(Constants.LOCATION, location);
            editor.putString(Constants.DESCRIPTION, description);
            editor.putString(Constants.URL, url);
            editor.putString(Constants.PROFILE_IAMGE_URL, profile_image_url);
            editor.putString(Constants.COVER_IMAGE_PHONE, cover_image_phone);
            editor.putString(Constants.AVATAR_LARGE, avatar_large);
            editor.putInt(Constants.FOLLOWERS_COUNT, followers_count);
            editor.putInt(Constants.FRIENDS_COUNT, friends_count);
            editor.putString(Constants.REMARK, remark);
            editor.putString(Constants.GENDER, gender);
            editor.putString(Constants.DOMAIN, domain);
            editor.putInt(Constants.ONLINE_STATUS, online_status);
            editor.apply();
        }
    }

    public void clearCache(Context context) {
        SharedPreferences settings = context.getSharedPreferences(Constants.USER_INFO, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        editor.apply();
    }

    public void getCache(Context context) {
        SharedPreferences sharedata = context.getSharedPreferences(Constants.USER_INFO, 0);

        idstr = sharedata.getString(Constants.UID, null);
        name = sharedata.getString(Constants.NAME, null);
        location = sharedata.getString(Constants.LOCATION, null);
        description = sharedata.getString(Constants.DESCRIPTION, null);
        url = sharedata.getString(Constants.URL, null);
        profile_image_url = sharedata.getString(Constants.PROFILE_IAMGE_URL, null);
        cover_image_phone = sharedata.getString(Constants.COVER_IMAGE_PHONE, null);
        avatar_large = sharedata.getString(Constants.AVATAR_LARGE, null);
        followers_count = sharedata.getInt(Constants.FOLLOWERS_COUNT, 0);
        friends_count = sharedata.getInt(Constants.FRIENDS_COUNT, 0);
        remark = sharedata.getString(Constants.REMARK,null);
        gender = sharedata.getString(Constants.GENDER, null);
        domain = sharedata.getString(Constants.DOMAIN, null);
        online_status = sharedata.getInt(Constants.ONLINE_STATUS, 0);
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

    public int getClassX() {
        return classX;
    }

    public void setClassX(int classX) {
        this.classX = classX;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public String getCover_image_phone() {
        return cover_image_phone;
    }

    public void setCover_image_phone(String cover_image_phone) {
        this.cover_image_phone = cover_image_phone;
    }

    public String getProfile_url() {
        return profile_url;
    }

    public void setProfile_url(String profile_url) {
        this.profile_url = profile_url;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getWeihao() {
        return weihao;
    }

    public void setWeihao(String weihao) {
        this.weihao = weihao;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
    }

    public int getFriends_count() {
        return friends_count;
    }

    public void setFriends_count(int friends_count) {
        this.friends_count = friends_count;
    }

    public int getPagefriends_count() {
        return pagefriends_count;
    }

    public void setPagefriends_count(int pagefriends_count) {
        this.pagefriends_count = pagefriends_count;
    }

    public int getStatuses_count() {
        return statuses_count;
    }

    public void setStatuses_count(int statuses_count) {
        this.statuses_count = statuses_count;
    }

    public int getFavourites_count() {
        return favourites_count;
    }

    public void setFavourites_count(int favourites_count) {
        this.favourites_count = favourites_count;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public boolean isFollowing() {
        return following;
    }

    public void setFollowing(boolean following) {
        this.following = following;
    }

    public boolean isAllow_all_act_msg() {
        return allow_all_act_msg;
    }

    public void setAllow_all_act_msg(boolean allow_all_act_msg) {
        this.allow_all_act_msg = allow_all_act_msg;
    }

    public boolean isGeo_enabled() {
        return geo_enabled;
    }

    public void setGeo_enabled(boolean geo_enabled) {
        this.geo_enabled = geo_enabled;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public int getVerified_type() {
        return verified_type;
    }

    public void setVerified_type(int verified_type) {
        this.verified_type = verified_type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public InsecurityBean getInsecurity() {
        return insecurity;
    }

    public void setInsecurity(InsecurityBean insecurity) {
        this.insecurity = insecurity;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public int getPtype() {
        return ptype;
    }

    public void setPtype(int ptype) {
        this.ptype = ptype;
    }

    public boolean isAllow_all_comment() {
        return allow_all_comment;
    }

    public void setAllow_all_comment(boolean allow_all_comment) {
        this.allow_all_comment = allow_all_comment;
    }

    public String getAvatar_large() {
        return avatar_large;
    }

    public void setAvatar_large(String avatar_large) {
        this.avatar_large = avatar_large;
    }

    public String getAvatar_hd() {
        return avatar_hd;
    }

    public void setAvatar_hd(String avatar_hd) {
        this.avatar_hd = avatar_hd;
    }

    public String getVerified_reason() {
        return verified_reason;
    }

    public void setVerified_reason(String verified_reason) {
        this.verified_reason = verified_reason;
    }

    public String getVerified_trade() {
        return verified_trade;
    }

    public void setVerified_trade(String verified_trade) {
        this.verified_trade = verified_trade;
    }

    public String getVerified_reason_url() {
        return verified_reason_url;
    }

    public void setVerified_reason_url(String verified_reason_url) {
        this.verified_reason_url = verified_reason_url;
    }

    public String getVerified_source() {
        return verified_source;
    }

    public void setVerified_source(String verified_source) {
        this.verified_source = verified_source;
    }

    public String getVerified_source_url() {
        return verified_source_url;
    }

    public void setVerified_source_url(String verified_source_url) {
        this.verified_source_url = verified_source_url;
    }

    public boolean isFollow_me() {
        return follow_me;
    }

    public void setFollow_me(boolean follow_me) {
        this.follow_me = follow_me;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public boolean isLike_me() {
        return like_me;
    }

    public void setLike_me(boolean like_me) {
        this.like_me = like_me;
    }

    public int getOnline_status() {
        return online_status;
    }

    public void setOnline_status(int online_status) {
        this.online_status = online_status;
    }

    public int getBi_followers_count() {
        return bi_followers_count;
    }

    public void setBi_followers_count(int bi_followers_count) {
        this.bi_followers_count = bi_followers_count;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getMbtype() {
        return mbtype;
    }

    public void setMbtype(int mbtype) {
        this.mbtype = mbtype;
    }

    public int getMbrank() {
        return mbrank;
    }

    public void setMbrank(int mbrank) {
        this.mbrank = mbrank;
    }

    public int getBlock_word() {
        return block_word;
    }

    public void setBlock_word(int block_word) {
        this.block_word = block_word;
    }

    public int getBlock_app() {
        return block_app;
    }

    public void setBlock_app(int block_app) {
        this.block_app = block_app;
    }

    public int getCredit_score() {
        return credit_score;
    }

    public void setCredit_score(int credit_score) {
        this.credit_score = credit_score;
    }

    public int getUser_ability() {
        return user_ability;
    }

    public void setUser_ability(int user_ability) {
        this.user_ability = user_ability;
    }

    public String getAvatargj_id() {
        return avatargj_id;
    }

    public void setAvatargj_id(String avatargj_id) {
        this.avatargj_id = avatargj_id;
    }

    public int getUrank() {
        return urank;
    }

    public void setUrank(int urank) {
        this.urank = urank;
    }

    public int getStory_read_state() {
        return story_read_state;
    }

    public void setStory_read_state(int story_read_state) {
        this.story_read_state = story_read_state;
    }

    public int getVclub_member() {
        return vclub_member;
    }

    public void setVclub_member(int vclub_member) {
        this.vclub_member = vclub_member;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(idstr);
        dest.writeInt(classX);
        dest.writeString(screen_name);
        dest.writeString(name);
        dest.writeString(province);
        dest.writeString(city);
        dest.writeString(location);
        dest.writeString(description);
        dest.writeString(url);
        dest.writeString(profile_image_url);
        dest.writeString(cover_image_phone);
        dest.writeString(profile_url);
        dest.writeString(domain);
        dest.writeString(weihao);
        dest.writeString(gender);
        dest.writeInt(followers_count);
        dest.writeInt(friends_count);
        dest.writeInt(pagefriends_count);
        dest.writeInt(statuses_count);
        dest.writeInt(favourites_count);
        dest.writeString(created_at);
        dest.writeByte((byte) (following ? 1 : 0));
        dest.writeByte((byte) (allow_all_act_msg ? 1 : 0));
        dest.writeByte((byte) (geo_enabled ? 1 : 0));
        dest.writeByte((byte) (verified ? 1 : 0));
        dest.writeInt(verified_type);
        dest.writeString(remark);
        dest.writeInt(ptype);
        dest.writeByte((byte) (allow_all_comment ? 1 : 0));
        dest.writeString(avatar_large);
        dest.writeString(avatar_hd);
        dest.writeString(verified_reason);
        dest.writeString(verified_trade);
        dest.writeString(verified_reason_url);
        dest.writeString(verified_source);
        dest.writeString(verified_source_url);
        dest.writeByte((byte) (follow_me ? 1 : 0));
        dest.writeByte((byte) (like ? 1 : 0));
        dest.writeByte((byte) (like_me ? 1 : 0));
        dest.writeInt(online_status);
        dest.writeInt(bi_followers_count);
        dest.writeString(lang);
        dest.writeInt(star);
        dest.writeInt(mbtype);
        dest.writeInt(mbrank);
        dest.writeInt(block_word);
        dest.writeInt(block_app);
        dest.writeInt(credit_score);
        dest.writeInt(user_ability);
        dest.writeString(avatargj_id);
        dest.writeInt(urank);
        dest.writeInt(story_read_state);
        dest.writeInt(vclub_member);
    }

    public static class InsecurityBean {
        /**
         * sexual_content : false
         */

        private boolean sexual_content;

        public boolean isSexual_content() {
            return sexual_content;
        }

        public void setSexual_content(boolean sexual_content) {
            this.sexual_content = sexual_content;
        }
    }

    public static class StatusBean {
        /**
         * created_at : Sun Dec 10 22:15:20 +0800 2017
         * id : 4183532429479181
         * mid : 4183532429479181
         * idstr : 4183532429479181
         * can_edit : false
         * text : 大红灯笼高高挂，红红火火的，跟过年很配哦
         * source_allowclick : 0
         * source_type : 2
         * source : <a href="http://weibo.com/" rel="nofollow">iPhone客户端</a>
         * favorited : false
         * truncated : false
         * in_reply_to_status_id :
         * in_reply_to_user_id :
         * in_reply_to_screen_name :
         * pic_urls : []
         * geo : null
         * is_paid : false
         * mblog_vip_type : 0
         * annotations : [{"mapi_request":true}]
         * reposts_count : 0
         * comments_count : 0
         * attitudes_count : 0
         * pending_approval_count : 0
         * isLongText : false
         * mlevel : 0
         * visible : {"type":0,"list_id":0}
         * biz_feature : 0
         * hasActionTypeCard : 0
         * darwin_tags : []
         * hot_weibo_tags : []
         * text_tag_tips : []
         * userType : 0
         * more_info_type : 0
         * positive_recom_flag : 0
         * gif_ids :
         * is_show_bulletin : 2
         * comment_manage_info : {"comment_permission_type":-1,"approval_comment_type":0}
         */

        private String created_at;
        private long id;
        private String mid;
        private String idstr;
        private boolean can_edit;
        private String text;
        private int source_allowclick;
        private int source_type;
        private String source;
        private boolean favorited;
        private boolean truncated;
        private String in_reply_to_status_id;
        private String in_reply_to_user_id;
        private String in_reply_to_screen_name;
        private Object geo;
        private boolean is_paid;
        private int mblog_vip_type;
        private int reposts_count;
        private int comments_count;
        private int attitudes_count;
        private int pending_approval_count;
        private boolean isLongText;
        private int mlevel;
        private VisibleBean visible;
        private int biz_feature;
        private int hasActionTypeCard;
        private int userType;
        private int more_info_type;
        private int positive_recom_flag;
        private String gif_ids;
        private int is_show_bulletin;
        private CommentManageInfoBean comment_manage_info;
        private List<?> pic_urls;
        private List<AnnotationsBean> annotations;
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

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public String getIdstr() {
            return idstr;
        }

        public void setIdstr(String idstr) {
            this.idstr = idstr;
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

        public Object getGeo() {
            return geo;
        }

        public void setGeo(Object geo) {
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

        public int getBiz_feature() {
            return biz_feature;
        }

        public void setBiz_feature(int biz_feature) {
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

        public List<?> getPic_urls() {
            return pic_urls;
        }

        public void setPic_urls(List<?> pic_urls) {
            this.pic_urls = pic_urls;
        }

        public List<AnnotationsBean> getAnnotations() {
            return annotations;
        }

        public void setAnnotations(List<AnnotationsBean> annotations) {
            this.annotations = annotations;
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
             * comment_permission_type : -1
             * approval_comment_type : 0
             */

            private int comment_permission_type;
            private int approval_comment_type;

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
             * mapi_request : true
             */

            private boolean mapi_request;

            public boolean isMapi_request() {
                return mapi_request;
            }

            public void setMapi_request(boolean mapi_request) {
                this.mapi_request = mapi_request;
            }
        }
    }
}
