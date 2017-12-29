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
public class Arts_Subjects extends Fragment {


    EditText histroy;
    EditText math;
    EditText economics;
    EditText bangla;
    EditText english;
    EditText islam;
    public Arts_Subjects() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        GlobalBus.getBus().register(this);
        return inflater.inflate(R.layout.fragment_arts__subjects, container, false);
    }
    public void onActivityCreated(Bundle bundle) {

        super.onActivityCreated(bundle);

        if (getView() != null) {
            histroy = getView().findViewById(R.id.history);
            math = getView().findViewById(R.id.math);
            economics = getView().findViewById(R.id.echonomics);
            bangla = getView().findViewById(R.id.Artbangla);
            english = getView().findViewById(R.id.ArtEnglish);
            islam = getView().findViewById(R.id.ArtiIslam);
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
        sendDatToActivity(histroy.getText().toString(),economics.getText().toString(),math.getText().toString(),bangla.getText().toString(),english.getText().toString(),islam.getText().toString());
    }

    public void sendDatToActivity(String history, String echonomics, String math, String ban, String eng, String is){
        String[] array = {history,echonomics,math,ban,eng,is};

        Event.ArtFragmentActivityMessage fragmentActivityMessage  =
                new Event.ArtFragmentActivityMessage(array);


        GlobalBus.getBus().post(fragmentActivityMessage);

    }
}
