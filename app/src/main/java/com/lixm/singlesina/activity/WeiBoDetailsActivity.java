package com.lixm.singlesina.activity;

import android.os.Bundle;

import com.lixm.singlesina.R;

import butterknife.ButterKnife;

public class WeiBoDetailsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wei_bo_details);
        ButterKnife.bind(this);
    }
}
