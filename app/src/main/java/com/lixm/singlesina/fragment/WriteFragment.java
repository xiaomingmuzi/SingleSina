package com.lixm.singlesina.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lixm.singlesina.R;

/**
 * @author Lixm
 * @date 2017/12/7
 * @detail
 */

public class WriteFragment extends BaseFragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_write, null);
    }
}
