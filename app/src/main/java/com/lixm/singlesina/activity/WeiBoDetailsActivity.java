package com.lixm.singlesina.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lixm.singlesina.R;
import com.lixm.singlesina.bean.WeiBoDetailsBean;
import com.lixm.singlesina.network.IOKCallBack;
import com.lixm.singlesina.network.OKHttpUtil;
import com.lixm.singlesina.network.RequestParams;
import com.lixm.singlesina.utils.UrlUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeiBoDetailsActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.title_name)
    TextView title_name;
    @BindView(R.id.XRecyclerView)
    XRecyclerView XRecyclerView;
    @BindView(R.id.retweeted_txt)
    TextView retweeted_txt;
    @BindView(R.id.comment_txt)
    TextView comment_txt;
    @BindView(R.id.praise_text)
    TextView praise_text;

    private String uid, id;

    /**
     * @param context
     * @param id      true	int64	需要跳转的微博ID。
     */
    public static void enterActivity(Context context, String id) {
        Intent intent = new Intent(context, WeiBoDetailsActivity.class);
        id="4201905896865856";
        intent.putExtra("id", id);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wei_bo_details);
        ButterKnife.bind(this);
        back_layout.setOnClickListener(this);

        uid = getIntent().getStringExtra("uid");
        id = getIntent().getStringExtra("id");
        statuses_show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_layout:
                finish();
                break;
        }
    }

    public void statuses_show() {
//        access_token	true	string	采用OAuth授权方式为必填参数，OAuth授权后获得。
//        id	true	int64	需要获取的微博ID。
        RequestParams params = new RequestParams(UrlUtils.statuses_show);
        params.addBodyParameter("access_token", mAccessToken.getToken());
//        params.addBodyParameter("uid", uid);
        params.addBodyParameter("id", id);
        OKHttpUtil.httpGet(params, new IOKCallBack() {
            @Override
            public void onException(Exception e) {
            }

            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                WeiBoDetailsBean weiBoDetailsBean=gson.fromJson(result,WeiBoDetailsBean.class);
                retweeted_txt.setText(weiBoDetailsBean.getReposts_count()+"");
            }
        });
    }
}
