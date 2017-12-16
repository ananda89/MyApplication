package com.example.mujahid.allinall.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.mujahid.allinall.Activity.LoginScreen;
import com.example.mujahid.allinall.Activity.ModernProfileUI;
import com.example.mujahid.allinall.R;
import com.example.mujahid.allinall.Activity.collapseToolbar;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class complexui extends Fragment {
Fragment fragment;
    public ArrayList<String> flag = new ArrayList<>();
    public complexui() {
        setHasOptionsMenu(true);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_complexui, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.compleuimenu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.Dash:
                fragment = new DashboradUI();
                FragTransction();
                return true;
            case R.id.Flex:

                Intent intent = new Intent(getActivity(), collapseToolbar.class);
                startActivity(intent);
                return true;

            case R.id.Login:
                Intent intent2 = new Intent(getActivity(), LoginScreen.class);
                startActivity(intent2);
                return true;

            case R.id.profile:
                Intent intent3 = new Intent(getActivity(), ModernProfileUI.class);
                startActivity(intent3);
                return  true;
                default:
                fragment = new DashboradUI();
                FragTransction();
                return super.onOptionsItemSelected(item);
        }
    }

    public void FragTransction(){
        FragmentManager manager = getChildFragmentManager();
        manager.beginTransaction().replace(R.id.fragmentTran,fragment).commit();
    }

}
