package com.example.mujahid.allinall.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mujahid.allinall.Activity.MainActivity;
import com.example.mujahid.allinall.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboradUI extends Fragment {
Fragment fragment;
CardView banking;
CardView finance;
CardView light;
CardView net;
    public DashboradUI() {
setHasOptionsMenu(true);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_dashborad_ui, container, false);
    }
    public void onActivityCreated(Bundle saved) {

        super.onActivityCreated(saved);
        if(getView()!=null){

            banking = getView().findViewById(R.id.banking);
            finance = getView().findViewById(R.id.finance);
            light = getView().findViewById(R.id.light);
            net = getView().findViewById(R.id.networking);
            finance.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "Finance Clicked!", Toast.LENGTH_SHORT).show();
                }
            });
        banking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Banking Cliked!", Toast.LENGTH_SHORT).show();
            }
        });

        light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Light Cliked!", Toast.LENGTH_SHORT).show();
            }
        });

        net.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Networking Cliked!", Toast.LENGTH_SHORT).show();
            }
        });
        }

    }


}
