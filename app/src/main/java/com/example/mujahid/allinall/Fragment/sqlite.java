package com.example.mujahid.allinall.Fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.mujahid.allinall.Activity.L;
import com.example.mujahid.allinall.Database.Activity.Student_Data_Insert;
import com.example.mujahid.allinall.Database.HelperClasses.DatabaseOperation;
import com.example.mujahid.allinall.Database.HelperClasses.ResultEngine;
import com.example.mujahid.allinall.Database.ModelClasses.Student;
import com.example.mujahid.allinall.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class sqlite extends Fragment {

    private TextView student_name;
    private TextView father_name;
    private TextView mother_name;
    private TextView group;
    private TextView birth_date;
    private TextView roll_number;
    private TextView result;
    private EditText search;
    private Button load;
    Student student;
    TableLayout tableLayout;

    public sqlite() {
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
        return inflater.inflate(R.layout.fragment_sqlite, container, false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getView() != null) {
            student_name = getView().findViewById(R.id.stu_name);
            father_name = getView().findViewById(R.id.father_name);
            mother_name = getView().findViewById(R.id.mother_name);
            group = getView().findViewById(R.id.group);
            birth_date = getView().findViewById(R.id.birth_date);
            roll_number = getView().findViewById(R.id.roll_number);
            result = getView().findViewById(R.id.result);
            search = getView().findViewById(R.id.search);
            load = getView().findViewById(R.id.load);
            tableLayout =getView().findViewById(R.id.tableLayout);
        }
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(populateStudentInfo()){
                    fillTableData();
                }else {
                    L.s(getActivity(), "No Data Found");
                }

            }
        });
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.sqlitemenu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.Insert:
                Intent intent = new Intent(getActivity(), Student_Data_Insert.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("DefaultLocale")
    private boolean populateStudentInfo() {
        boolean sucess = true;
        DatabaseOperation operation = new DatabaseOperation();
        ResultEngine engine = new ResultEngine();
        Cursor cursor;
        cursor = operation.getStudentInfo(getActivity(), search.getText().toString());
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            student = new Student(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
            student_name.setText("Student Name: " + student.getStudent_name());
            father_name.setText("Father Name: " + student.getFather_name());
            mother_name.setText("Mother Name: " + student.getMother_name());
            group.setText("Group: " + student.getSubject());
            birth_date.setText("Birth Date: " + student.getBirth_date());
            roll_number.setText("Roll Number: "+ search.getText().toString());
            result.setText(String.format("Result: %.2f (%s)", engine.getPoint(getActivity(), search.getText().toString(), student.getSubject()),engine.getGPAFromPoint(engine.getPoint(getActivity(),search.getText().toString(),student.getSubject()))));
        } else {
            sucess = false;
        }

        return sucess;
    }

    private void fillTableData() {
        ResultEngine a = new ResultEngine();
        DatabaseOperation b = new DatabaseOperation();
        TableRow row;
        Cursor cursor = null;
        TextView subject, mark, grade;
        int dip = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float) 1, getResources().getDisplayMetrics());
        switch (student.getSubject()) {
            case "Science":
                cursor = b.getScienceMark(getActivity(), search.getText().toString());
                break;
            case "Commerce":
                cursor = b.getCommerceMark(getActivity(), search.getText().toString());
                break;
            case "Humanities":
                cursor = b.getArtsMark(getActivity(), search.getText().toString());
                break;
        }

        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            for (int current = 0; current < cursor.getColumnCount(); current++) {
                row = new TableRow(getActivity());
                subject = new TextView(getActivity());
                mark = new TextView(getActivity());
                grade = new TextView(getActivity());

                // t1.setText(CountryList.abbreviations[current]);
                //t2.setText(CountryList.countries[current]);
                subject.setText(cursor.getColumnName(current));
                mark.setText(String.format("%d", cursor.getInt(current)));
                grade.setText(a.getGPAFromMark(cursor.getInt(current)));
                subject.setTextSize(15);
                mark.setTextSize(15);
                grade.setTextSize(15);
                subject.setWidth(150 * dip);
                mark.setWidth(100 * dip);
                grade.setWidth(50 * dip);

                subject.setPadding(15 * dip, 0, 0, 0);
                row.addView(subject);
                row.addView(mark);
                row.addView(grade);
                row.setPadding(10*dip, 5 * dip, 0, 0);
                tableLayout.addView(row, new TableLayout.LayoutParams(
                        TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));
            }
        }


    }

}

