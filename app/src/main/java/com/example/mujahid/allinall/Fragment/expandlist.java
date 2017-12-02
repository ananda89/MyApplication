package com.example.mujahid.allinall.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.mujahid.allinall.CustomAdapters.CustomExpandListAdapter;
import com.example.mujahid.allinall.Pojo.GameData;
import com.example.mujahid.allinall.R;

import java.util.ArrayList;
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
       if(getView()!=null) {
           expandableListView = (ExpandableListView) getView().findViewById(R.id.expandList);
       }
       String[] actiongame = {"Call of Duty","BattleField","Prototype"};
       String[] sportgame = {"Cricket 2007", "Don Bardman 2014", "FIFA 2015"};
       String[] swordgame = {"Prince of Parsia", "Dark Soul", "Skyrim"};
       List<GameData> newList = new ArrayList<>();
       newList.add(new GameData("Action Game", actiongame));
       newList.add(new GameData("SportGame", sportgame));
       newList.add(new GameData("Sword Game",swordgame));
       CustomExpandListAdapter adapter = new CustomExpandListAdapter(getActivity(),newList);
       expandableListView.setAdapter(adapter);



   }



}
