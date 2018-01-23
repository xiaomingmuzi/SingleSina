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

import com.lixm.singlesina.R;
import com.lixm.singlesina.customview.SlidingTabLayout;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Lixm
 * @date 2017/14/7
 * @detail
 */

public class MainFragment extends BaseFragment  {

    @BindView(R.id.main_vp)
    ViewPager mVp;
    @BindView(R.id.id_main_indicator)
    SlidingTabLayout mSlidingTabLayout;
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
        fragments = new ArrayList<>();
        fragments.add(new AttentionFragment());
        fragments.add(new HotFragment());
        myAdapter = new MyAdapter(getChildFragmentManager());
        mVp.setAdapter(myAdapter);
        String[] titles = new String[]{"关注", "热门"};
        mVp.setOffscreenPageLimit(titles.length - 1);
        ArrayList<String> titleArray = new ArrayList<>();
        Collections.addAll(titleArray, titles);
        mSlidingTabLayout.setViewPager(mVp, titleArray.toArray(new String[titles.length]));
        return view;
    }

//    @Override
//    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
////        0页到1页：positionOffset：0 – 1 变化
////        1页到0页： positionOffset：1 – 0 变化
////        Value from [0, 1) indicating the offset from the page at position.
////        LogUtil.w("positionOffset：" + positionOffset + "  oldPositionOffset：" + oldPositionOffset);
//        if (oldPositionOffset != 0 && positionOffset != 0) {
//            if (oldPositionOffset != positionOffset){
//                mLineView.slidDistance(positionOffset > oldPositionOffset ? 1 : 0, positionOffset);
//            }
//        }
//        oldPositionOffset = positionOffset;
//
//
//
//    }
//
//    @Override
//    public void onPageSelected(int position) {
//    }
//
//    @Override
//    public void onPageScrollStateChanged(int state) {
//
//    }

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
