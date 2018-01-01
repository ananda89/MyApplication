package com.example.mujahid.allinall.Database.Activity;

import android.database.sqlite.SQLiteConstraintException;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mujahid.allinall.Activity.L;
import com.example.mujahid.allinall.Database.HelperClasses.DatabaseOperation;

import com.example.mujahid.allinall.Database.SubjectFragment.Arts_Subjects;
import com.example.mujahid.allinall.Database.SubjectFragment.Commerce_Subjects;
import com.example.mujahid.allinall.Database.SubjectFragment.Science_Subjects;
import com.example.mujahid.allinall.EventBus.Event;
import com.example.mujahid.allinall.EventBus.GlobalBus;
import com.example.mujahid.allinall.R;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import javax.security.auth.Subject;

public class Student_Data_Insert extends AppCompatActivity {
    Spinner spinner;
    Fragment fragment;
    EditText stu_name;
    EditText Father_name;
    EditText Mother_name;
    EditText Roll_number;
    EditText Birth_Date;
    String[] ScienceRecever;
    String[] CommerceRecever;
    String[] ArtRecever;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__data__insert);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(Spinner());
        stu_name = findViewById(R.id.student_name);
        Father_name = findViewById(R.id.Father_name);
        Mother_name = findViewById(R.id.Mother_name);
        Roll_number = findViewById(R.id.roll_number);
        Birth_Date = findViewById(R.id.birth_date);
    }

    private AdapterView.OnItemSelectedListener Spinner(){

        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            switch (i){
                case 0:
                    fragment = new Science_Subjects();
                    break;
                case 1:
                    fragment = new Commerce_Subjects();
                    break;
                case 2:
                    fragment = new Arts_Subjects();
                    break;
                    default:
                        fragment = new Science_Subjects();
                        break;

            }
               onFragmentTran();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
    }

    private void onFragmentTran(){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout,fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.commit();

    }

    @Override
    protected void onStart() {
        super.onStart();
        // Register this fragment to listen to event.
        GlobalBus.getBus().register(this);
    }

    void onScienceDatacall(){

        Science_Subjects data= (Science_Subjects) getSupportFragmentManager().findFragmentById(R.id.frameLayout);
        data.mainCall();
    }
    void onCommerceDatacall(){

        Commerce_Subjects data= (Commerce_Subjects) getSupportFragmentManager().findFragmentById(R.id.frameLayout);
        data.mainCall();
    }

    void onArtsDatacall(){

        Arts_Subjects data= (Arts_Subjects) getSupportFragmentManager().findFragmentById(R.id.frameLayout);
        data.mainCall();
    }

    @Override
    protected void onStop() {
        super.onStop();
        GlobalBus.getBus().unregister(this);
    }

    @Subscribe
    public void SciencegetMessage(Event.ScienceFragmentActivityMessage fragmentActivityMessage) {

        ScienceRecever =  fragmentActivityMessage.getMessage();

    }

    @Subscribe
    public void CommercegetMessage(Event.CommerceFragmentActivityMessage fragmentActivityMessage) {

        CommerceRecever =  fragmentActivityMessage.getMessage();

    }

    @Subscribe
    public void ArtsgetMessage(Event.ArtFragmentActivityMessage fragmentActivityMessage) {

        ArtRecever =  fragmentActivityMessage.getMessage();

    }

    public void onSave(View view) {
    Thread a = new Thread(new onBackgroundSave());
    a.start();
    }

    public boolean Validation(){

        boolean ok = false;

        if(stu_name.getText().length()!=0 && Father_name.getText().length()!=0 && Mother_name.getText().length()!=0 && Roll_number.getText().length()!= 0 && Birth_Date.getText().length()!=0){
            ok = true;
        }
        return ok;
    }

    public void onEdit(View view) {
        //Need to works
    }

    class onBackgroundSave implements Runnable {

        DatabaseOperation a = new DatabaseOperation();
        boolean isSucessScienceSave;
        boolean isSucessStudentSave;
        boolean isSucessCommerceSave;
        boolean isSuccessArtsSave;

        @Override
        public void run() {
            try {
                if (Validation()) {

                    isSucessStudentSave = a.insertIntoStudent(getApplicationContext(), stu_name.getText().toString(), Father_name.getText().toString(), Mother_name.getText().toString(), Roll_number.getText().toString(), spinner.getSelectedItem().toString(), Birth_Date.getText().toString());

                    if (spinner.getSelectedItem().toString().equals("Science")) {
                        onScienceDatacall();
                        isSucessScienceSave = a.insertIntoScience(getApplicationContext(), Roll_number.getText().toString(), Integer.parseInt(ScienceRecever[0]), Integer.parseInt(ScienceRecever[1]), Integer.parseInt(ScienceRecever[2]), Integer.parseInt(ScienceRecever[4]), Integer.parseInt(ScienceRecever[3]), Integer.parseInt(ScienceRecever[5]));
                        if (isSucessStudentSave && isSucessScienceSave) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "Data Saved Sucessfully!", Toast.LENGTH_LONG).show();
                                }
                            });

                        } else {

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "Data not Saved Sucessfully!", Toast.LENGTH_LONG).show();
                                }
                            });

                        }

                    } else if (spinner.getSelectedItem().toString().equals("Commerce")) {

                        onCommerceDatacall();

                        isSucessCommerceSave = a.insertIntoCommerce(getApplicationContext(), Roll_number.getText().toString(), Integer.parseInt(CommerceRecever[1]), Integer.parseInt(CommerceRecever[0]), Integer.parseInt(CommerceRecever[2]), Integer.parseInt(CommerceRecever[3]), Integer.parseInt(CommerceRecever[4]), Integer.parseInt(CommerceRecever[5]));

                        if (isSucessStudentSave && isSucessCommerceSave) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "Data Saved Sucessfully!", Toast.LENGTH_LONG).show();
                                }
                            });

                        } else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "Data not Saved Sucessfully!", Toast.LENGTH_LONG).show();
                                }
                            });

                        }

                    } else if (spinner.getSelectedItem().toString().equals("Humanities")) {

                        onArtsDatacall();
                        isSuccessArtsSave = a.insertIntoArts(getApplicationContext(), Roll_number.getText().toString(), Integer.parseInt(ArtRecever[0]), Integer.parseInt(ArtRecever[1]), Integer.parseInt(ArtRecever[2]), Integer.parseInt(ArtRecever[3]), Integer.parseInt(ArtRecever[4]), Integer.parseInt(ArtRecever[5]));
                        if (isSucessStudentSave && isSuccessArtsSave) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "Data Saved Sucessfully!", Toast.LENGTH_LONG).show();
                                }
                            });

                        } else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "Data not Saved Sucessfully!", Toast.LENGTH_LONG).show();
                                }
                            });

                        }

                    }

                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Input Data Please!", Toast.LENGTH_LONG).show();
                        }
                    });
                }

            }catch (SQLiteConstraintException e){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),"Student Roll Number used",Toast.LENGTH_LONG).show();
                    }
                });
            }
        }
    }
        }


