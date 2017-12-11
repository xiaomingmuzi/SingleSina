package com.lixm.singlesina.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TabHost;

import com.lixm.singlesina.R;
import com.lixm.singlesina.fragment.FindFragment;
import com.lixm.singlesina.fragment.MainFragment;
import com.lixm.singlesina.fragment.MessageFragment;
import com.lixm.singlesina.fragment.UserFragment;
import com.lixm.singlesina.fragment.WriteFragment;
import com.lixm.singlesina.utils.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {

    @BindView(R.id.radioGroup)
    RadioGroup mRG;
    @BindView(R.id.realTabContent)
    LinearLayout mRealContent;
    @BindView(android.R.id.tabhost)
    FragmentTabHost mTabHost;

    private String CALLBACK_LOGING="CALLBACK_LOGING";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(mContext, getSupportFragmentManager(),
                R.id.realTabContent);

        // 设置显示的标题
        TabHost.TabSpec tabSpecA = mTabHost.newTabSpec("0").setIndicator("A");
        TabHost.TabSpec tabSpecB = mTabHost.newTabSpec("1").setIndicator("B");
        TabHost.TabSpec tabSpecC = mTabHost.newTabSpec("2").setIndicator("C");
        TabHost.TabSpec tabSpecD = mTabHost.newTabSpec("3").setIndicator("D");
        TabHost.TabSpec tabSpecE = mTabHost.newTabSpec("4").setIndicator("E");
        // 添加对象
        mTabHost.addTab(tabSpecA, MainFragment.class, null); // 首页fragment
        mTabHost.addTab(tabSpecB, MessageFragment.class, null); // 消息
        mTabHost.addTab(tabSpecC, WriteFragment.class, null); //写博文
        mTabHost.addTab(tabSpecD, FindFragment.class, null); // 消息
        mTabHost.addTab(tabSpecE, UserFragment.class, null);//我
        mTabHost.setVisibility(View.GONE);

        mRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.Rb_First:
                        mTabHost.setCurrentTab(0);
                        break;
                    case R.id.Rb_Second:
                        mTabHost.setCurrentTab(1);
                        break;
                    case R.id.Rb_Third:
                        mTabHost.setCurrentTab(2);
                        break;
                    case R.id.Rb_Fourth:
                        mTabHost.setCurrentTab(3);
                        break;
                    case R.id.Rb_Fifth:
                        mTabHost.setCurrentTab(4);
                        break;
                }
            }
        });

        int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_APN_SETTINGS);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            //requesting permission
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_APN_SETTINGS}, 1);
        } else {
            //permission is granted and you can change APN settings
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //premission granted by user
                } else {
                    //permission denied by user
                }
            }
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mTabHost.getCurrentTab()==4){
            data.putExtra("requestCode",requestCode);
            data.putExtra("resultCode",resultCode);
            data.setAction(CALLBACK_LOGING);
            sendBroadcast(data);
            LogUtil.w("====activty  onActivityResult=====");
        }
    }
}
