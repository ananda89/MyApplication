package com.example.mujahid.allinall.Activity;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.mujahid.allinall.R;

public class collapseToolbar extends AppCompatActivity {

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapse_toolbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.coltool);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}