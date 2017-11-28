package com.example.mujahid.allinall.Navigationmenufrag;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.mujahid.allinall.CustomAdapters.CustomListAdapter;
import com.example.mujahid.allinall.Pojo.ProgrammingLangData;
import com.example.mujahid.allinall.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class listview extends Fragment {


    public listview() {
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listview, container, false);
    }

    public void onActivityCreated(Bundle savedInstance){

super.onActivityCreated(savedInstance);

        ArrayList<ProgrammingLangData> arrayList = new ArrayList<>();
        arrayList.add(new ProgrammingLangData("Java a Programming Language","Multiplatform",R.drawable.customlist_java ));
        arrayList.add(new ProgrammingLangData("Swift a Programming Language","IOS Master", R.drawable.customlist_swift));
        arrayList.add(new ProgrammingLangData("SQL a Database Language","Data Quary", R.drawable.customlist_sql));
        arrayList.add(new ProgrammingLangData("C++ a Programming Language", "Objet Oriented",R.drawable.customlist_cplus));
        arrayList.add(new ProgrammingLangData("Kotlin a Programming Language","Official of Android",R.drawable.customlist_kotlin));
        arrayList.add(new ProgrammingLangData("C# a programming Language","Microsoft Gift", R.drawable.customlist_csharp));
        arrayList.add(new ProgrammingLangData("Php a programming Language","Server Side Master", R.drawable.customlist_php));
        CustomListAdapter arrayAdapter = new CustomListAdapter(getActivity(),R.layout.custom_listview1,arrayList);
        View view = getView();
        if(view!=null){
          ListView  listView = view.findViewById(R.id.list);
listView.setAdapter(arrayAdapter);
        }

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.listfragmentmenu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


}
