package com.example.mujahid.allinall.Fragment;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import com.example.mujahid.allinall.Constants.Constant;
import com.example.mujahid.allinall.CustomAdapters.BCRecycleVIewAdapter;
import com.example.mujahid.allinall.Database.BroadcastDatabase.BroadcastHelper;
import com.example.mujahid.allinall.Pojo.IncommingCalls;
import com.example.mujahid.allinall.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Broadcast extends Fragment {

    BroadcastReceiver phoneReceiver;
    BroadcastReceiver Airplane;
    BroadcastReceiver DataCon;
    //UI
    Switch Air;
    Switch Data;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    //Data Container
    ArrayList<IncommingCalls> list = new ArrayList<>();
    BCRecycleVIewAdapter adapter;

    public Broadcast() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_broadcast, container, false);
    }

    public void onActivityCreated(Bundle load) {

        super.onActivityCreated(load);

        adapter = new BCRecycleVIewAdapter(list);
        ReadFromDB();
        if(getView()!=null) {
            Air = getView().findViewById(R.id.AirPlane);
            Data = getView().findViewById(R.id.DataCon);
            recyclerView = getView().findViewById(R.id.recycles);
            layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(layoutManager);
        }
        phoneReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
                if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
                    String number = intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                    BroadcastHelper helper = new BroadcastHelper(context);
                    helper.addInfo(helper.getWritableDatabase(),number);
                    helper.close();
                    ReadFromDB();
                }

            }
        };

        Airplane = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if(isAirplaneModeOn(context)){
                    Air.setChecked(true);
                }else {
                    Air.setChecked(false);
                }
            }
        };

        DataCon = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
            if(isDataConnected(context)){
                Data.setChecked(true);
            }else{
                Data.setChecked(false);
            }
            }
        };
    }

    public boolean isAirplaneModeOn(Context context){
        return Settings.Global.getInt(context.getContentResolver(),Settings.Global.AIRPLANE_MODE_ON,0) != 0;
    }

    private boolean isDataConnected(Context context){
        boolean isConnected = false;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo info = cm.getActiveNetworkInfo();

            isConnected = info != null && info.isConnectedOrConnecting();
        }
        return isConnected;
    }
    public void onDestroy() {
        super.onDestroy();


    }

    public void onResume() {
        super.onResume();
        getActivity().registerReceiver(Airplane, new IntentFilter(Constant.AIRPLANE));
        getActivity().registerReceiver(DataCon, new IntentFilter(Constant.NET));
        getActivity().registerReceiver(phoneReceiver, new IntentFilter(Constant.PHONE_STATE));
    }

    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(Airplane);
        getActivity().unregisterReceiver(phoneReceiver);
        getActivity().unregisterReceiver(DataCon);
    }

    private void ReadFromDB(){
        list.clear();
        BroadcastHelper helper = new BroadcastHelper(getActivity());
        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor cursor = helper.readNumber(database);

        if(cursor.getCount() > 0 ){

            while (cursor.moveToNext()){
                IncommingCalls call = new IncommingCalls(cursor.getInt(cursor.getColumnIndex("Id")),cursor.getString(cursor.getColumnIndex("Incomming_Calls")));
                list.add(call);
            }
            helper.close();
            cursor.close();
            adapter.notifyDataSetChanged();
            // recyclerView.setVisibility(View.VISIBLE);
            //view.setVisibility(View.GONE);
        }
    }





}
