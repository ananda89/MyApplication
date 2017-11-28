package com.example.mujahid.allinall.Navigationmenufrag;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.mujahid.allinall.CustomAdapters.CustomExpandListAdapter;
import com.example.mujahid.allinall.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class expandlist extends Fragment {
    ExpandableListView expandableListView;

    public expandlist() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_expandlist, container, false);
    }
   public void onActivityCreated(Bundle savedInstance) {
       super.onActivityCreated(savedInstance);
       if(getView()!=null){
           expandableListView = (ExpandableListView)getView().findViewById(R.id.expandList);
       }
       List<String> heading = new ArrayList<>();
       List<String> h1 = new ArrayList<>();
       List<String> h2 = new ArrayList<>();
       List<String> h3 = new ArrayList<>();
       HashMap<String, List<String>> childLIst = new HashMap<>();
       String[] header = getResources().getStringArray(R.array.header);
       String[] h1Item = getResources().getStringArray(R.array.action_item);
       String[] h2Item = getResources().getStringArray(R.array.Advanture_item);
       String[] h3Item = getResources().getStringArray(R.array.sword_item);
      for(String title: header){
          heading.add(title);
      }
    for(String title: h1Item){
          h1.add(title);
    }
    for(String titile:h2Item){
        h2.add(titile);
    }

    for(String title: h3Item){
        h3.add(title);
    }

       childLIst.put(heading.get(0),h1);
       childLIst.put(heading.get(1),h2);
       childLIst.put(heading.get(2),h3);

       CustomExpandListAdapter adapter = new CustomExpandListAdapter(getActivity(),heading,childLIst);
       expandableListView.setAdapter(adapter);




   }



}
