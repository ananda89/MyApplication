package com.example.mujahid.allinall.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mujahid.allinall.CustomAdapters.RecycleViewAdapter;
import com.example.mujahid.allinall.Pojo.ProgrammingLangData;
import com.example.mujahid.allinall.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class recycleview extends Fragment {
    private RecyclerView recyclerView;

    public recycleview() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return  inflater.inflate(R.layout.fragment_recycleview, container, false);
    }

    public void onActivityCreated(Bundle saved) {
        super.onActivityCreated(saved);

        if(getView()!=null){
            recyclerView = (RecyclerView)getView().findViewById(R.id.Recycle);
        }

        List<ProgrammingLangData> arrayList = new ArrayList<>();
        arrayList.add(new ProgrammingLangData("Java a Programming Language","Multiplatform",R.drawable.customlist_java ));
        arrayList.add(new ProgrammingLangData("Swift a Programming Language","IOS Master", R.drawable.customlist_swift));
        arrayList.add(new ProgrammingLangData("SQL a Database Language","Data Quary", R.drawable.customlist_sql));
        arrayList.add(new ProgrammingLangData("C++ a Programming Language", "Objet Oriented",R.drawable.customlist_cplus));
        arrayList.add(new ProgrammingLangData("Kotlin a Programming Language","Official of Android",R.drawable.customlist_kotlin));
        arrayList.add(new ProgrammingLangData("C# a programming Language","Microsoft Gift", R.drawable.customlist_csharp));
        arrayList.add(new ProgrammingLangData("Php a programming Language","Server Side Master", R.drawable.customlist_php));

        RecycleViewAdapter adapter = new RecycleViewAdapter(getActivity(),arrayList);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


    }



}
