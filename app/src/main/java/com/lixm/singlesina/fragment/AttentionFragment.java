package com.lixm.singlesina.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lixm.singlesina.R;

import butterknife.ButterKnife;

/**
 * @author Lixm
 * @date 2017/12/18
 * @detail
 */

public class AttentionFragment extends BaseFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attention, null);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }
}
