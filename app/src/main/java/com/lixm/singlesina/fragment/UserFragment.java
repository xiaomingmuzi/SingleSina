package com.lixm.singlesina.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.google.gson.Gson;
import com.lixm.singlesina.R;
import com.lixm.singlesina.bean.UserInfoBean;
import com.lixm.singlesina.utils.GlideCircleTransform;
import com.lixm.singlesina.utils.LogUtil;
import com.lixm.singlesina.utils.UrlUtils;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.auth.sso.SsoHandler;

import java.io.IOException;
import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Lixm
 * @date 2017/12/7
 * @detail
 */

public class UserFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.back_layout)
    RelativeLayout mBackLayout;
    @BindView(R.id.back_txt)
    TextView mBackTxt;
    @BindView(R.id.back_img)
    ImageView mBackImg;
    @BindView(R.id.title_name)
    TextView mTitle;
    @BindView(R.id.right_layout)
    RelativeLayout mRightLayout;
    @BindView(R.id.right_img)
    ImageView mRightImg;
    @BindView(R.id.right_txt)
    TextView mRightTxt;
    @BindView(R.id.head_img)
    ImageView mHeadImg;
    @BindView(R.id.btn_register)
    TextView mBtnRegister;
    @BindView(R.id.btn_login)
    TextView mBtnLogin;
    @BindView(R.id.no_login_layout)
    RelativeLayout mNoLoginLayout;

    @BindView(R.id.user_login_layout)
    ScrollView mLoginLayout;
    @BindView(R.id.user_head)
    ImageView mUserHead;
    @BindView(R.id.user_name)
    TextView mUserName;
    @BindView(R.id.user_des)
    TextView mUserDes;
    @BindView(R.id.vip_layout)
    LinearLayout mVipLayout;
    @BindView(R.id.statuses_count)
    TextView mStatusesCount;
    @BindView(R.id.friends_count)
    TextView mFriendsCount;
    @BindView(R.id.followers_count)
    TextView mFollowersCount;

    private UserInfoBean userInfoBean;
    private Unbinder unbinder;
    /**
     * 封装了 "access_token"，"expires_in"，"refresh_token"，并提供了他们的管理功能
     */
    private Oauth2AccessToken mAccessToken;
    /**
     * 注意：SsoH
     * andler 仅当 SDK 支持 SSO 时有效
     */
    private SsoHandler mSsoHandler;
    private String CALLBACK_LOGING = "CALLBACK_LOGING";


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, null);
        unbinder = ButterKnife.bind(this, view);

        mBackLayout.setVisibility(View.GONE);
        mTitle.setText("我");
        mRightLayout.setVisibility(View.VISIBLE);
        mRightImg.setVisibility(View.GONE);
        mRightTxt.setText("设置");

        userInfoBean=new UserInfoBean();
        // 创建微博实例
        mSsoHandler = new SsoHandler(getActivity());
        // 从 SharedPreferences 中读取上次已保存好 AccessToken 等信息，
        // 第一次启动本应用，AccessToken 不可用
        mAccessToken = AccessTokenKeeper.readAccessToken(getContext());
        if (mAccessToken.isSessionValid()) {
            updateTokenView(true);
        }

        getActivity().registerReceiver(receiver, new IntentFilter(CALLBACK_LOGING));
        initListener();

        return view;
    }

    private void initListener() {
        mBtnLogin.setOnClickListener(this);
        mBtnRegister.setOnClickListener(this);
        mVipLayout.setOnClickListener(this);
        mBackLayout.setOnClickListener(this);
        mRightLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                LogUtil.i("开始登录");
                mSsoHandler.authorize(new SelfWbAuthListener());
                break;
            case R.id.btn_register:
                Toast.makeText(getContext(), "注册", Toast.LENGTH_SHORT).show();
                break;
            case R.id.vip_layout:
                Toast.makeText(getContext(), "vip", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    private void changeView() {
        mNoLoginLayout.setVisibility(View.GONE);
        mLoginLayout.setVisibility(View.VISIBLE);
        Glide.with(getContext()).load(userInfoBean.getAvatar_large()).transform(new GlideCircleTransform(getContext())).centerCrop().error(R.mipmap.default_head).placeholder(R.mipmap.default_head).into(mUserHead);
        mUserName.setText(userInfoBean.getName());
        mUserDes.setText("简介:" + userInfoBean.getDescription());
        mStatusesCount.setText(userInfoBean.getStatuses_count()+"");
        mFriendsCount.setText(userInfoBean.getFriends_count()+"");
        mFollowersCount.setText(userInfoBean.getFollowers_count()+"");
        mBackLayout.setVisibility(View.VISIBLE);
        mBackTxt.setVisibility(View.VISIBLE);
        mBackTxt.setText("添加好友");
        mBackImg.setVisibility(View.GONE);
        mRightLayout.setVisibility(View.VISIBLE);
        mRightImg.setVisibility(View.GONE);
        mRightTxt.setText("设置");
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction() == CALLBACK_LOGING) {
                onActivityResult(intent.getIntExtra("requestCode", 0), intent.getIntExtra("resultCode", 0), intent);
            }
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //SSO授权回调
        //todo 发起SSO登陆的activity必须重写onActivity
        LogUtil.w("====onActivityResult=====");
        if (mSsoHandler != null) {
            mSsoHandler.authorizeCallBack(requestCode, resultCode, data);
        }
    }

    private class SelfWbAuthListener implements com.sina.weibo.sdk.auth.WbAuthListener {

        @Override
        public void onFailure(WbConnectErrorMessage wbConnectErrorMessage) {
            LogUtil.i("授权失败:" + wbConnectErrorMessage.getErrorMessage());
        }

        @Override
        public void onSuccess(final Oauth2AccessToken token) {
            LogUtil.i("授权成功");
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mAccessToken = token;
                    if (mAccessToken.isSessionValid()) {
                        // 显示 Token
                        updateTokenView(false);
                        // 保存 Token 到 SharedPreferences
                        AccessTokenKeeper.writeAccessToken(getActivity(), mAccessToken);

                        getUserInfo(mAccessToken);
                        Toast.makeText(getActivity(),
                                "获取token成功", Toast.LENGTH_SHORT).show();
                    } else {
                        LogUtil.e("签名错误");
                    }
                }
            });
        }

        @Override
        public void cancel() {
            Toast.makeText(getActivity(),
                    "授权被取消", Toast.LENGTH_LONG).show();
        }


    }

    /**
     * 显示当前 Token 信息。
     *
     * @param hasExisted 配置文件中是否已存在 token 信息并且合法
     */
    private void updateTokenView(boolean hasExisted) {
        String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(
                new java.util.Date(mAccessToken.getExpiresTime()));
        String format = getString(R.string.weibosdk_demo_token_to_string_format_1);
        LogUtil.i("获取的token为：" + String.format(format, mAccessToken.getToken(), date));

        String message = String.format(format, mAccessToken.getToken(), date);
        if (hasExisted) {
            message = getString(R.string.weibosdk_demo_token_has_existed) + "\n" + message;
            userInfoBean.getCache(getContext());
            if (!TextUtils.isEmpty(userInfoBean.getIdstr())){
             changeView();
            }else getUserInfo(mAccessToken);
        }
    }

    private void getUserInfo(Oauth2AccessToken mAccessToken) {
        OkHttpClient client = new OkHttpClient();
        String url = UrlUtils.show + "?access_token=" + mAccessToken.getToken() + "&uid=" + mAccessToken.getUid();
        LogUtil.i("接口开始：" + url);
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) LogUtil.e("Unexpected code " + response);
                Headers responseHeaders = response.headers();
                for (int i = 0; i < responseHeaders.size(); i++) {
                    LogUtil.i(responseHeaders.name(i) + "：" + responseHeaders.value(i));
                }
                String content = response.body().string();
                LogUtil.i("返回内容为：" + content);
                userInfoBean = new Gson().fromJson(content, UserInfoBean.class);
                if (userInfoBean != null && !TextUtils.isEmpty(userInfoBean.getIdstr())) {
                    userInfoBean.writeToCache(getContext());
//                    changeView();
                    handler.sendEmptyMessage(CHANGE_VIEW);
                }
            }
        });
    }


    private final int CHANGE_VIEW = 0X01;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CHANGE_VIEW:
                    changeView();
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
