package com.example.mujahid.allinall.Activity;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

import com.example.mujahid.allinall.CustomAdapters.VIewPagerAdapter;
import com.example.mujahid.allinall.Navigationmenufrag.Espresso;
import com.example.mujahid.allinall.Navigationmenufrag.expandlist;
import com.example.mujahid.allinall.Navigationmenufrag.listview;
import com.example.mujahid.allinall.R;

public class ViewPager extends AppCompatActivity {
android.support.v7.widget.Toolbar toolbar;

TabLayout tabLayout;
android.support.v4.view.ViewPager viewPager;
VIewPagerAdapter vIewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolsbar);

tabLayout = (TabLayout)findViewById(R.id.tabLayout);
viewPager = (android.support.v4.view.ViewPager)findViewById(R.id.Viewpager);
 vIewPagerAdapter = new VIewPagerAdapter(getSupportFragmentManager());

vIewPagerAdapter.addFragment(new listview(),"List View");
vIewPagerAdapter.addFragment(new expandlist(),"Expand List");
vIewPagerAdapter.addFragment(new Espresso(), "Espresso");
viewPager.setAdapter(vIewPagerAdapter);
tabLayout.setupWithViewPager(viewPager);



    }
}
