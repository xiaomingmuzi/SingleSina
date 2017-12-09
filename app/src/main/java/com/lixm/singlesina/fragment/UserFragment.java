package com.lixm.singlesina.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lixm.singlesina.R;
import com.lixm.singlesina.utils.LogUtil;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.auth.sso.SsoHandler;

import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author Lixm
 * @date 2017/12/7
 * @detail
 */

public class UserFragment extends BaseFragment {

    @BindView(R.id.back_layout)
    RelativeLayout mBackLayout;
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

    private Unbinder unbinder;
    /** 封装了 "access_token"，"expires_in"，"refresh_token"，并提供了他们的管理功能  */
    private Oauth2AccessToken mAccessToken;
    /** 注意：SsoH
     * andler 仅当 SDK 支持 SSO 时有效 */
    private SsoHandler mSsoHandler;
    private String CALLBACK_LOGING="CALLBACK_LOGING";



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_user, null);
        unbinder= ButterKnife.bind(this,view);

        mBackLayout.setVisibility(View.GONE);
        mTitle.setText("我");
        mRightLayout.setVisibility(View.VISIBLE);
        mRightImg.setVisibility(View.GONE);
        mRightTxt.setText("设置");

        // 创建微博实例
        mSsoHandler = new SsoHandler(getActivity());
        // 从 SharedPreferences 中读取上次已保存好 AccessToken 等信息，
        // 第一次启动本应用，AccessToken 不可用
        mAccessToken = AccessTokenKeeper.readAccessToken(getContext());
        if (mAccessToken.isSessionValid()) {
            updateTokenView(true);
        }

        getActivity().registerReceiver(receiver,new IntentFilter(CALLBACK_LOGING));

        return view;
    }

private BroadcastReceiver receiver=new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction()==CALLBACK_LOGING){
            onActivityResult(intent.getIntExtra("requestCode",0),intent.getIntExtra("resultCode",0),intent);
        }
    }
};

    @OnClick
    public void setmBtnLogin(){
//        Toast.makeText(getContext(),"登录",Toast.LENGTH_SHORT).show();
        LogUtil.i("开始登录");
        mSsoHandler.authorize(new SelfWbAuthListener());
    }

    @OnClick
    public void setmBtnRegister(){
        Toast.makeText(getContext(),"注册",Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //SSO授权回调
        //todo 发起SSO登陆的activity必须重写onActivity
        LogUtil.w("====onActivityResult=====");
        if (mSsoHandler!=null){
            mSsoHandler.authorizeCallBack(requestCode,resultCode,data);
        }
    }

    private class SelfWbAuthListener implements com.sina.weibo.sdk.auth.WbAuthListener{

        @Override
        public void onFailure(WbConnectErrorMessage wbConnectErrorMessage) {
            LogUtil.i("授权失败:"+wbConnectErrorMessage.getErrorMessage());
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
                        Toast.makeText(getActivity(),
                                "获取token成功", Toast.LENGTH_SHORT).show();
                    }else {
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
        LogUtil.i("获取的token为："+String.format(format, mAccessToken.getToken(), date));

        String message = String.format(format, mAccessToken.getToken(), date);
        if (hasExisted) {
            message = getString(R.string.weibosdk_demo_token_has_existed) + "\n" + message;
        }
        LogUtil.i("获取的token为："+message);
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
