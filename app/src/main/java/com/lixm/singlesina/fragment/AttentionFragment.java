package com.lixm.singlesina.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lixm.singlesina.R;
import com.lixm.singlesina.network.IOKCallBack;
import com.lixm.singlesina.network.OKHttpUtil;
import com.lixm.singlesina.network.RequestParams;
import com.lixm.singlesina.utils.UrlUtils;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;

import butterknife.ButterKnife;

/**
 * @author Lixm
 * @date 2017/12/18
 * @detail
 */

public class AttentionFragment extends BaseFragment {
    private Oauth2AccessToken mAccessToken;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attention, null);
        mUnbinder = ButterKnife.bind(this, view);
        if (!TextUtils.isEmpty(mUserInfoBean.getIdstr())) {
            mAccessToken = AccessTokenKeeper.readAccessToken(getContext());
            home_timeline();
        }
        return view;
    }

    private void home_timeline() {
        RequestParams params = new RequestParams(UrlUtils.home_timeline);
        params.addBodyParameter("access_token", mAccessToken.getToken());
//        params.addBodyParameter("since_id", "");//若指定此参数，则返回ID比since_id大的微博（即比since_id时间晚的微博），默认为0。
//        params.addBodyParameter("max_id", "");//若指定此参数，则返回ID小于或等于max_id的微博，默认为0。
//        params.addBodyParameter("count", "");//单页返回的记录条数，最大不超过100，默认为20。
//        params.addBodyParameter("page", "");//	返回结果的页码，默认为1。
//        params.addBodyParameter("base_app", "");//是否只获取当前应用的数据。0为否（所有数据），1为是（仅当前应用），默认为0。
//        params.addBodyParameter("feature", "");//过滤类型ID，0：全部、1：原创、2：图片、3：视频、4：音乐，默认为0。
//        params.addBodyParameter("trim_user", "");//返回值中user字段开关，0：返回完整user字段、1：user字段仅返回user_id，默认为0。
        OKHttpUtil.httpGet(params, new IOKCallBack() {
            @Override
            public void onException(Exception e) {

            }

            @Override
            public void onSuccess(String result) {

            }
        });
    }
}
