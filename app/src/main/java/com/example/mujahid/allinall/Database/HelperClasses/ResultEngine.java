package com.example.mujahid.allinall.Database.HelperClasses;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

/**
 * Created by Mujahid on 12/25/2017.
 */

public class ResultEngine {

    private double sub1, sub2, sub3, sub4, sub5, sub6;

    public String getGPAFromMark(int mark){

        String counter = "";
        if(mark>=80){
            counter = "A+";
        }else if(mark<80 && mark >=70){
            counter = "A";
        }else if(mark < 70 && mark >=60){
            counter = "A-";
        }else if(mark < 60 && mark>=50){
            counter = "B";
        }else if(mark < 50 && mark >=40){
            counter = "C";
        }else if(mark< 40 && mark >=33){
            counter = "D";
        }else if(mark < 33 && mark >= 0){
            counter = "F";
        }

        return counter;
    }

    public String getGPAFromPoint(double point){
        String counter = "";
        if(point>=5.00){
            counter = "A+";
        }else if(point<5.00 && point >=4.00){
            counter = "A";
        }else if(point < 4.00 && point >=3.50){
            counter = "A-";
        }else if(point < 3.50 && point>=3.00){
            counter = "B";
        }else if(point < 3.00 && point >=2.50){
            counter = "C";
        }else if(point< 2.50 && point >=2.00){
            counter = "D";
        }

        return counter;
    }

    public double getPoint(Context c, String Roll){
        Cursor cursor;
        DatabaseOperation a = new DatabaseOperation();
        cursor = a.getMark(c,Roll);
        if(cursor!=null){
            cursor.moveToFirst();

            cursor.getInt(0);
            cursor.getInt(1);
            cursor.getInt(2);
            cursor.getInt(3);
            cursor.getInt(4);
            cursor.getInt(5);

            if(cursor.getInt(0) >= 80) {
                sub1  = 5;
            }
            else if((cursor.getInt(0) < 80)&&(cursor.getInt(0) >= 70)){
                sub1  = 4;
            }else if((cursor.getInt(0) < 70)&&(cursor.getInt(0) >= 60)){
                sub1 = 3.5;
            }else if((cursor.getInt(0) < 60)&&(cursor.getInt(0) >= 50)){
                sub1  = 3;
            }else if((cursor.getInt(0) < 50)&&(cursor.getInt(0) >= 40)){
                sub1 = 2;
            }else if((cursor.getInt(0) < 40)&&(cursor.getInt(0) >= 33)){
                sub1  = 1;
            }else{
                sub1 = 0.0;
            }

            if(cursor.getInt(1) >= 80) {
                sub2  = 5;
            }
            else if((cursor.getInt(1) < 80)&&(cursor.getInt(1) >= 70)){
                sub2  = 4;
            }else if((cursor.getInt(1) < 70)&&(cursor.getInt(1) >= 60)){
                sub2 = 3.5;
            }else if((cursor.getInt(1) < 60)&&(cursor.getInt(1) >= 50)){
                sub2  = 3;
            }else if((cursor.getInt(1) < 50)&&(cursor.getInt(1) >= 40)){
                sub2 = 2;
            }else if((cursor.getInt(1) < 40)&&(cursor.getInt(1) >= 33)){
                sub2  = 1;
            }else{
                sub2 = 0.0;
            }

            if(cursor.getInt(2) >= 80) {
                sub3  = 5;
            }
            else if((cursor.getInt(2) < 80)&&(cursor.getInt(2) >= 70)){
                sub3  = 4;
            }else if((cursor.getInt(2) < 70)&&(cursor.getInt(2) >= 60)){
                sub3 = 3.5;
            }else if((cursor.getInt(2) < 60)&&(cursor.getInt(2) >= 50)){
                sub3  = 3;
            }else if((cursor.getInt(2) < 50)&&(cursor.getInt(2) >= 40)){
                sub3 = 2;
            }else if((cursor.getInt(2) < 40)&&(cursor.getInt(2) >= 33)){
                sub3  = 1;
            }else{
                sub3 = 0.0;
            }

            if(cursor.getInt(3) >= 80) {
                sub4  = 5;
            }
            else if((cursor.getInt(3) < 80)&&(cursor.getInt(3) >= 70)){
                sub4  = 4;
            }else if((cursor.getInt(3) < 70)&&(cursor.getInt(3) >= 60)){
                sub4 = 3.5;
            }else if((cursor.getInt(3) < 60)&&(cursor.getInt(3) >= 50)){
                sub4  = 3;
            }else if((cursor.getInt(3) < 50)&&(cursor.getInt(3) >= 40)){
                sub4 = 2;
            }else if((cursor.getInt(3) < 40)&&(cursor.getInt(3) >= 33)){
                sub4  = 1;
            }else{
                sub4 = 0.0;
            }


            if(cursor.getInt(4) >= 80) {
                sub5  = 5;
            }
            else if((cursor.getInt(4) < 80)&&(cursor.getInt(4) >= 70)){
                sub5  = 4;
            }else if((cursor.getInt(4) < 70)&&(cursor.getInt(4) >= 60)){
                sub5 = 3.5;
            }else if((cursor.getInt(4) < 60)&&(cursor.getInt(4) >= 50)){
                sub5  = 3;
            }else if((cursor.getInt(4) < 50)&&(cursor.getInt(4) >= 40)){
                sub5 = 2;
            }else if((cursor.getInt(4) < 40)&&(cursor.getInt(4) >= 33)){
                sub5  = 1;
            }else{
                sub5 = 0.0;
            }

            if(cursor.getInt(5) >= 80) {
                sub6  = 5;
            }
            else if((cursor.getInt(5) < 80)&&(cursor.getInt(5) >= 70)){
                sub6  = 4;
            }else if((cursor.getInt(5) < 70)&&(cursor.getInt(5) >= 60)){
                sub6 = 3.5;
            }else if((cursor.getInt(5) < 60)&&(cursor.getInt(5) >= 50)){
                sub6  = 3;
            }else if((cursor.getInt(5) < 50)&&(cursor.getInt(5) >= 40)){
                sub6 = 2;
            }else if((cursor.getInt(5) < 40)&&(cursor.getInt(5) >= 33)){
                sub6  = 1;
            }else{
                sub6 = 0.0;
            }

        }else
        {
            Toast.makeText(c,"No Data Found",Toast.LENGTH_LONG).show();
        }


        return  (sub1+sub2+sub3+sub4+sub5+sub6)/6;
    }

}
