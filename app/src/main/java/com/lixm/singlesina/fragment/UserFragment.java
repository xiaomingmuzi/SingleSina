package com.lixm.singlesina.fragment;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
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
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;
import com.google.gson.Gson;
import com.lixm.singlesina.R;
import com.lixm.singlesina.activity.SetActivity;
import com.lixm.singlesina.bean.UserInfoBean;
import com.lixm.singlesina.customview.UserItemView;
import com.lixm.singlesina.glide.ProgressInterceptor;
import com.lixm.singlesina.interfaces.ProgressListener;
import com.lixm.singlesina.utils.GlideCircleTransform;
import com.lixm.singlesina.utils.LogUtil;
import com.lixm.singlesina.utils.UrlUtils;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.auth.sso.SsoHandler;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
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
    private int[] ids = new int[]{R.id.item_friend_layout, R.id.item_picture_layout, R.id.item_praise_layout, R.id.item_wallet_layout, R.id.item_sport_layout,
            R.id.item_no_gprs_layout, R.id.item_friend_service_layout, R.id.item_friend_top_layout, R.id.item_custom_layout, R.id.item_drafts_layout};
    private ArrayList<UserItemView> userItemViews;

    private UserInfoBean userInfoBean;
    private ProgressDialog progressDialog;
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
    private final int CHANGE_VIEW = 0X01;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, null);
        mUnbinder = ButterKnife.bind(this, view);
        mBackLayout.setVisibility(View.GONE);
        mTitle.setText("我");
        mRightLayout.setVisibility(View.VISIBLE);
        mRightImg.setVisibility(View.GONE);
        mRightTxt.setText("设置");

        userInfoBean = UserInfoBean.getInstance();
        // 创建微博实例
        mSsoHandler = new SsoHandler(getActivity());
        // 从 SharedPreferences 中读取上次已保存好 AccessToken 等信息，
        // 第一次启动本应用，AccessToken 不可用
        mAccessToken = AccessTokenKeeper.readAccessToken(getContext());
        if (mAccessToken.isSessionValid()) {
            updateTokenView(true);
        }
        progressDialog=new ProgressDialog(getActivity());
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        getActivity().registerReceiver(receiver, new IntentFilter(CALLBACK_LOGING));
        userItemViews=new ArrayList<>();
        for (int i=0;i<ids.length;i++){
            UserItemView userItemView=view.findViewById(ids[i]);
            userItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int i=0;i<ids.length;i++){
                        if (v.getId()==ids[i]){

                        }
                    }
                }
            });
            userItemViews.add(userItemView);
        }
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
                mToastUtils.showToast("注册");
                break;
            case R.id.vip_layout:
                mToastUtils.showToast("欢迎购买VIP服务");
//                ToastUtils.getInstance(getContext()).showToast("欢迎购买VIP服务");
                break;
            case R.id.right_layout:
                getContext().startActivity(new Intent(getActivity(), SetActivity.class));
                break;
            case R.id.back_layout:
                mToastUtils.showToast("添加好友");
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        userInfoBean = userInfoBean.getCache(getContext());
        if (!TextUtils.isEmpty(userInfoBean.getIdstr())) {
            changeViewToLogin();
        } else changeViewNoLogin();
    }

    private void changeViewToLogin() {
        mNoLoginLayout.setVisibility(View.GONE);
        mLoginLayout.setVisibility(View.VISIBLE);
        ProgressInterceptor.addListener("http://images.shichai.cnfol.com/original/201611/20161129113736719.jpg", new ProgressListener() {
            @Override
            public void onProgress(int progress) {
                progressDialog.setProgress(progress);
            }
        });
        Glide.with(getContext())
//                .load(userInfoBean.getAvatar_large())
                .load("http://images.shichai.cnfol.com/original/201611/20161129113736719.jpg")
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .transform(new GlideCircleTransform(getContext()))
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .error(R.mipmap.default_head)
                .placeholder(R.mipmap.default_head)
                .into(new GlideDrawableImageViewTarget(mUserHead){
                    @Override
                    public void onLoadStarted(Drawable placeholder) {
                        super.onLoadStarted(placeholder);
                        progressDialog.show();
                    }

                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> animation) {
                        super.onResourceReady(resource, animation);
                        progressDialog.dismiss();
                        ProgressInterceptor.removeListener("http://images.shichai.cnfol.com/original/201611/20161129113736719.jpg");
                    }
                });
        mUserName.setText(userInfoBean.getName());
        mUserDes.setText("简介:" + userInfoBean.getDescription());
        mStatusesCount.setText(userInfoBean.getStatuses_count() + "");
        mFriendsCount.setText(userInfoBean.getFriends_count() + "");
        mFollowersCount.setText(userInfoBean.getFollowers_count() + "");
        mBackLayout.setVisibility(View.VISIBLE);
        mBackTxt.setVisibility(View.VISIBLE);
        mBackTxt.setText("添加好友");
        mBackImg.setVisibility(View.GONE);
        mRightLayout.setVisibility(View.VISIBLE);
        mRightImg.setVisibility(View.GONE);
        mRightTxt.setText("设置");
    }

    private void changeViewNoLogin() {
        mNoLoginLayout.setVisibility(View.VISIBLE);
        mLoginLayout.setVisibility(View.GONE);
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
            userInfoBean = userInfoBean.getCache(getContext());
            if (!TextUtils.isEmpty(userInfoBean.getIdstr())) {
                changeViewToLogin();
            } else getUserInfo(mAccessToken);
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


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CHANGE_VIEW:
                    changeViewToLogin();
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
