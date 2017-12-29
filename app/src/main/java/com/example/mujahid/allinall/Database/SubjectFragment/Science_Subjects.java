package com.example.mujahid.allinall.Database.SubjectFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mujahid.allinall.EventBus.Event;
import com.example.mujahid.allinall.EventBus.GlobalBus;
import com.example.mujahid.allinall.R;

import org.greenrobot.eventbus.Subscribe;

/**
 * A simple {@link Fragment} subclass.
 */
public class Science_Subjects extends Fragment {

    EditText physics;
    EditText chemistry;
    EditText biology;
    EditText bangla;
    EditText english;
    EditText islam;

    public Science_Subjects() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        GlobalBus.getBus().register(this);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_science__subjects, container, false);
    }

    public void onActivityCreated(Bundle bundle) {

        super.onActivityCreated(bundle);
        if (getView() != null) {

            physics = getView().findViewById(R.id.physics);
            chemistry = getView().findViewById(R.id.chmistry);
            biology = getView().findViewById(R.id.biology);
            bangla = getView().findViewById(R.id.Scibangla);
            english = getView().findViewById(R.id.SciEnglish);
            islam = getView().findViewById(R.id.SciIslam);
        } else {
            Toast.makeText(getActivity(), "Problem is on intilization!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Unregister the registered event.
        GlobalBus.getBus().unregister(this);
    }

    @Subscribe
    public void getMessage(Event.ActivityFragmentMessage activityFragmentMessage) {

        Toast.makeText(getActivity(),activityFragmentMessage.getMessage(),Toast.LENGTH_LONG).show();
    }

    public void mainCall(){
        sendDatToActivity(physics.getText().toString(),chemistry.getText().toString(),biology.getText().toString(),bangla.getText().toString(),english.getText().toString(),islam.getText().toString());
    }

    public void sendDatToActivity(String physic, String che, String bio, String ban, String eng, String is){
        String[] array = {physic,che,bio,ban,eng,is};

        Event.ScienceFragmentActivityMessage fragmentActivityMessage  =
                new Event.ScienceFragmentActivityMessage(array);


        GlobalBus.getBus().post(fragmentActivityMessage);

    }



}
