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
public class Commerce_Subjects extends Fragment {
    EditText accounting;
    EditText entireprenure;
    EditText business;
    EditText bangla;
    EditText english;
    EditText islam;

    public Commerce_Subjects() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        GlobalBus.getBus().register(this);
        return inflater.inflate(R.layout.fragment_commerce__subjects, container, false);
    }
    public void onActivityCreated(Bundle bundle) {

        super.onActivityCreated(bundle);
        if (getView() != null) {

            accounting = getView().findViewById(R.id.accounting);
            entireprenure = getView().findViewById(R.id.entireprenure);
            business = getView().findViewById(R.id.business);
            bangla = getView().findViewById(R.id.Combangla);
            english = getView().findViewById(R.id.ComEnglish);
            islam = getView().findViewById(R.id.ComiIslam);
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
        sendDatToActivity(business.getText().toString(),accounting.getText().toString(),entireprenure.getText().toString(),bangla.getText().toString(),english.getText().toString(),islam.getText().toString());
    }

    public void sendDatToActivity(String business, String accounting, String entireprenure, String ban, String eng, String is){
        String[] array = {business,accounting,entireprenure,ban,eng,is};

        Event.CommerceFragmentActivityMessage fragmentActivityMessage  =
                new Event.CommerceFragmentActivityMessage(array);


        GlobalBus.getBus().post(fragmentActivityMessage);

    }
}
