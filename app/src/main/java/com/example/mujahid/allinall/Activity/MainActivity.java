package com.example.mujahid.allinall.Activity;

import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mujahid.allinall.Navigationmenufrag.AsynTask;
import com.example.mujahid.allinall.Navigationmenufrag.Broadcast;
import com.example.mujahid.allinall.Navigationmenufrag.Espresso;
import com.example.mujahid.allinall.Navigationmenufrag.Facebook;
import com.example.mujahid.allinall.Navigationmenufrag.Notification;
import com.example.mujahid.allinall.Navigationmenufrag.Thread;
import com.example.mujahid.allinall.Navigationmenufrag.complexui;
import com.example.mujahid.allinall.Navigationmenufrag.contentprovider;
import com.example.mujahid.allinall.Navigationmenufrag.expandlist;
import com.example.mujahid.allinall.Navigationmenufrag.googleMap;
import com.example.mujahid.allinall.Navigationmenufrag.listview;
import com.example.mujahid.allinall.Navigationmenufrag.recycleview;
import com.example.mujahid.allinall.Navigationmenufrag.restapi;
import com.example.mujahid.allinall.Navigationmenufrag.service;
import com.example.mujahid.allinall.Navigationmenufrag.sharedperfermence;
import com.example.mujahid.allinall.Navigationmenufrag.sqlite;
import com.example.mujahid.allinall.Navigationmenufrag.unitTest;
import com.example.mujahid.allinall.R;

public class MainActivity extends AppCompatActivity {
       private DrawerLayout drawer;
       private ActionBarDrawerToggle toggle;

    Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout)findViewById(R.id.layout);
        toggle = new ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close);
        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setUpDrawerClick(navigationView);


    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setUpDrawerClick(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
fragment = null;
              switch (item.getItemId()){
                case R.id.Thread:
                  fragment = new Thread();
                  break;
                  case R.id.AsynTask:
                      fragment = new AsynTask();
                   break;
                  case R.id.BroadCast:
                      fragment = new Broadcast();
                  break;
                  case R.id.complexUI:
                      fragment = new complexui();
                      break;
                  case R.id.content:
                      fragment = new contentprovider();
                      break;
                  case R.id.Espresso:
                      fragment = new Espresso();
                      break;
                  case R.id.ExLIst:
                      fragment = new expandlist();
                      break;
                  case R.id.Facebook:
                      fragment = new Facebook();
                      break;
                  case R.id.map:
                      fragment = new googleMap();
                      break;
                  case R.id.ListView:
                      fragment = new listview();
                      break;
                  case R.id.notify:
                      fragment = new Notification();
                      break;
                  case R.id.Recycle:
                      fragment =  new recycleview();
                  case R.id.REST:
                      fragment = new restapi();
                      break;
                  case R.id.Service:
                      fragment = new service();
                      break;
                  case R.id.Shared:
                      fragment = new sharedperfermence();
                      break;
                  case R.id.SQLite:
                      fragment = new sqlite();
                      break;
                  case R.id.UintTest:
                      fragment = new unitTest();
                      break;
                  case R.id.Viewpager:
                      // fragment = new viewpager();
                Intent intent = new Intent(MainActivity.this, ViewPager.class);
                      startActivity(intent);
                    break;


              }
              if(fragment!=null){
                  setTitle(item.getTitle());
                  FragTransction(); 
              }
                item.setChecked(true);

                drawer.closeDrawers();
               return true;
            }
        });

    }

public void FragTransction(){
    FragmentManager manager = getSupportFragmentManager();
    manager.beginTransaction().replace(R.id.frame,fragment).commit();

}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.expandlistmenu, menu);


        return true;
    }






   }

