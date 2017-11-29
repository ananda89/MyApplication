package com.example.mujahid.allinall.Navigationmenufrag;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.example.mujahid.allinall.Activity.MainActivity;
import com.example.mujahid.allinall.CustomAdapters.VIewPagerAdapter;
import com.example.mujahid.allinall.R;

import junit.framework.Assert;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPager extends Fragment {

    TabLayout tabLayout;
    android.support.v4.view.ViewPager viewPager;
    VIewPagerAdapter vIewPagerAdapter;
    public ViewPager() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_pager, container, false);
    }

    public void onActivityCreated(Bundle saved) {

        super.onActivityCreated(saved);

        /*
        if(getView()!=null){
            android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) getView().findViewById(R.id.tool);
            ((MainActivity)getActivity()).getSupportActionBar().hide();
            ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        }
*/



if(getView()!= null){
    tabLayout = (TabLayout)getView().findViewById(R.id.tabLayout);
    viewPager = (android.support.v4.view.ViewPager)getView().findViewById(R.id.Viewpager);
    vIewPagerAdapter = new VIewPagerAdapter(getChildFragmentManager());
}


        vIewPagerAdapter.addFragment(new listview(),"List View");
        vIewPagerAdapter.addFragment(new expandlist(),"Expand List");
        vIewPagerAdapter.addFragment(new Espresso(), "Espresso");
        viewPager.setAdapter(vIewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

}
