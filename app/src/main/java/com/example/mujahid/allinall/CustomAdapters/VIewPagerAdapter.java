package com.example.mujahid.allinall.CustomAdapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Mujahid on 11/28/2017.
 */

public class VIewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    private ArrayList<String> tabTitles = new ArrayList<>();

    public void addFragment(Fragment fragment, String titles){
        fragmentArrayList.add(fragment);
        tabTitles.add(titles);
    }

    public VIewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    public CharSequence getPageTitle(int position){
        return  tabTitles.get(position);
    }

}
