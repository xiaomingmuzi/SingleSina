package com.lixm.singlesina.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lixm.singlesina.R;
import com.lixm.singlesina.bean.UserInfoBean;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SetActivity extends BaseActivity implements View.OnClickListener {


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
    @BindView(R.id.exit_btn)
    Button exitBtn;

    private UserInfoBean userInfoBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        ButterKnife.bind(this);

        mTitle.setText("设置");
        exitBtn.setOnClickListener(this);
        mRightLayout.setVisibility(View.GONE);
        mBackLayout.setOnClickListener(this);
        userInfoBean = UserInfoBean.getInstance();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_layout:
                finish();
                break;
            case R.id.exit_btn:
                userInfoBean.clearCache(this);
                AccessTokenKeeper.clear(this);
                mToastUtils.showToast("退出成功");
                break;
        }
    }
}
