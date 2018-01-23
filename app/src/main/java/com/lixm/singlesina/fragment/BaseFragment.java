package com.lixm.singlesina.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.lixm.singlesina.bean.UserInfoBean;
import com.lixm.singlesina.utils.LogUtil;
import com.lixm.singlesina.utils.ToastUtils;

import butterknife.Unbinder;

/**
 * @author Lixm
 * @date 2017/12/7
 * @detail
 */

public class BaseFragment extends Fragment {

    public ToastUtils mToastUtils;
    public Unbinder mUnbinder;
    public UserInfoBean mUserInfoBean;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mToastUtils = ToastUtils.getInstance(getContext());
        mUserInfoBean=UserInfoBean.getInstance();
        LogUtil.w("BaseFragment  onCreate  " + (mToastUtils == null));
    }


    @Override
    public void onResume() {
        super.onResume();
        mUserInfoBean = mUserInfoBean.getCache(getContext());
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder!=null)
            mUnbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.w("BaseFragment  onDestroyView  " + (mToastUtils == null));
        mToastUtils.destory();
    }
}
