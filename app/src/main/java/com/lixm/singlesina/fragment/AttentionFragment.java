package com.lixm.singlesina.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lixm.singlesina.R;
import com.lixm.singlesina.adapter.AttentionFragmentAdapter;
import com.lixm.singlesina.bean.AttentionBean;
import com.lixm.singlesina.network.IOKCallBack;
import com.lixm.singlesina.network.OKHttpUtil;
import com.lixm.singlesina.network.RequestParams;
import com.lixm.singlesina.utils.ConstantMethodUtils;
import com.lixm.singlesina.utils.Constants;
import com.lixm.singlesina.utils.LogUtil;
import com.lixm.singlesina.utils.NetWorkHelper;
import com.lixm.singlesina.utils.UrlUtils;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Lixm
 * @date 2017/12/18
 * @detail
 */

public class AttentionFragment extends BaseFragment implements XRecyclerView.LoadingListener {

    @BindView(R.id.recyclerView)
    XRecyclerView mRecyclerView;

    private Oauth2AccessToken mAccessToken;
    private List<AttentionBean.StatusesBean> statuses;
    private AttentionFragmentAdapter mAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attention, null);
        mUnbinder = ButterKnife.bind(this, view);
        LogUtil.w("mUserInfoBean.getIdstr()：" + mUserInfoBean.getIdstr());
//        String data="Wed Jan 24 20:33:50 +0800 2018";
//        LogUtil.w(TimeUtils.getTimeDiff(data));
        if (!TextUtils.isEmpty(mUserInfoBean.getIdstr())) {
            mAccessToken = AccessTokenKeeper.readAccessToken(getContext());
            mRecyclerView.setLoadingListener(this);
            //添加Android自带的分割线
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
            dividerItemDecoration.setDrawable(getActivity().getDrawable(R.drawable.recycler_devider));
            mRecyclerView.addItemDecoration(dividerItemDecoration);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            mRecyclerView.setLayoutManager(layoutManager);
            mRecyclerView.setPullRefreshEnabled(true);
            statuses = new ArrayList<>();
            mAdapter = new AttentionFragmentAdapter(getActivity(), statuses);
            mRecyclerView.setAdapter(mAdapter);
            home_timeline();
        }

        return view;
    }

    private void home_timeline() {
//        RequestParams params = new RequestParams(UrlUtils.home_timeline);
//        params.addBodyParameter("access_token", mAccessToken.getToken());
////        params.addBodyParameter("since_id", "");//若指定此参数，则返回ID比since_id大的微博（即比since_id时间晚的微博），默认为0。
////        params.addBodyParameter("max_id", "");//若指定此参数，则返回ID小于或等于max_id的微博，默认为0。
////        params.addBodyParameter("count", "");//单页返回的记录条数，最大不超过100，默认为20。
////        params.addBodyParameter("page", "");//	返回结果的页码，默认为1。
////        params.addBodyParameter("base_app", "");//是否只获取当前应用的数据。0为否（所有数据），1为是（仅当前应用），默认为0。
////        params.addBodyParameter("feature", "");//过滤类型ID，0：全部、1：原创、2：图片、3：视频、4：音乐，默认为0。
////        params.addBodyParameter("trim_user", "");//返回值中user字段开关，0：返回完整user字段、1：user字段仅返回user_id，默认为0。
//        OKHttpUtil.httpGet(params, new IOKCallBack() {
//            @Override
//            public void onException(Exception e) {
//                if (NetWorkHelper.isNetActive())
//                    mToastUtils.showToast(getString(R.string.data_error));
//                else mToastUtils.showToast(getString(R.string.net_error));
//            }
//
//            @Override
//            public void onSuccess(String result) {
                try {
                    Gson gson = new Gson();
                    AttentionBean attentionBean = gson.fromJson(ConstantMethodUtils.readAssetsTxt(getActivity(),"content"), AttentionBean.class);
                    statuses = attentionBean.getStatuses();
                    mAdapter.bindData(statuses);
                    mAdapter.notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
//            }
//        });
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}


//    JSONObject jsonObject = new JSONObject(result);
//                    JSONArray jsonArray = jsonObject.optJSONArray("statuses");
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        JSONObject jso = jsonArray.optJSONObject(i);
//                        AttentionUserBean attentionUserBean = new AttentionUserBean();
//                        attentionUserBean.setCreated_at(jso.optString("created_at"));
//                        attentionUserBean.setId(jso.optInt("id") + "");
//                        attentionUserBean.setMid(jso.optInt("mid") + "");
//                        attentionUserBean.setIdstr(jso.optInt("idstr") + "");
//                        attentionUserBean.setText(jso.optString("text"));
//                        attentionUserBean.setSource_allowclick(jso.optInt("source_allowclick"));
//                        attentionUserBean.setSource_type(jso.optInt("source_type"));
//                        attentionUserBean.setSource(jso.optString("source"));
//                        attentionUserBean.setFavorited(jso.optBoolean("favorited"));
//                        attentionUserBean.setTruncated(jso.optBoolean("truncated"));
//                        JSONArray array = jso.optJSONArray("pic_urls");
//                        ArrayList<String> pic_urls = new ArrayList<>();
//                        for (int j = 0; j < array.length(); j++) {
//                            pic_urls.add(array.optString(j));
//                        }
//                        attentionUserBean.setPic_urls(pic_urls);
//
//                        JSONObject userObject=jso.optJSONObject("user");
////                        UserBean userBean=new UserBean();
////                        userBean.setId(userObject.optInt("id"));
////                        userBean.setIdstr(userObject.optString("idstr"));
////                        userBean.setClassX(userObject.optInt("class"));
////                        userBean.setScreen_name(userObject.optString("screen_name"));
////                        userBean.setName(userObject.optString("name"));
////                        userBean.setProvince(userObject.optString("province"));
////                        userBean.setCity(userObject.optString("city"));
////                        userBean.setLocation(userObject.optString("location"));
////                        userBean.setDescription(userObject.optString("description"));
////                        userBean.setUrl(userObject.optString("url"));
////                        userBean.setProfile_image_url(userObject.optString("profile_image_url"));
////                        userBean.setCover_image(userObject.optString("cover_image"));
////                        userBean.setProfile_url(userObject.optString("profile_url"));
////                        userBean.setDomain(userObject.optString("domain"));
////                        userBean.setWeihao(userObject.optString("weihao"));
////                        userBean.setGender(userObject.optString("gender"));
////                        userBean.setFollowers_count(userObject.optInt("followers_count"));
////                        userBean.setFriends_count(userObject.optInt("friends_count"));
////                        userBean.setPagefriends_count(userObject.optInt("pagefriends_count"));
//                        Gson gson=new Gson();
//                        UserBean userBean=gson.fromJson(userObject.toString(),UserBean.class);
//                        attentionUserBean.setUserBean(userBean);
//
//                    }
