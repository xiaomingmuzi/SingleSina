package com.lixm.singlesina.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lixm.singlesina.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Lixm
 * @date 2017/12/7
 * @detail
 */

public class MainFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.main_rg)
    RadioGroup mRg;
    @BindView(R.id.attention)
    RadioButton mAttention;
    @BindView(R.id.hot)
    RadioButton mHot;
    @BindView(R.id.main_vp)
    ViewPager mVp;
    private ArrayList<BaseFragment> fragments;
    private MyAdapter myAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);
        mUnbinder = ButterKnife.bind(this, view);
        mRg.setOnCheckedChangeListener(this);
        fragments = new ArrayList<>();
        fragments.add(new AttentionFragment());
        fragments.add(new HotFragment());
        myAdapter = new MyAdapter(getChildFragmentManager());
        mVp.setAdapter(myAdapter);
        mVp.addOnPageChangeListener(this);
        return view;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.attention) {
            mVp.setCurrentItem(0);
            mAttention.setTextSize(16);
            mHot.setTextSize(12);
        } else {
            mVp.setCurrentItem(1);
            mAttention.setTextSize(12);
            mHot.setTextSize(16);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position==0){
            mAttention.setChecked(true);
            mAttention.setTextSize(16);
            mHot.setTextSize(12);
        }else{
            mHot.setChecked(true);
            mAttention.setTextSize(12);
            mHot.setTextSize(16);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

}
