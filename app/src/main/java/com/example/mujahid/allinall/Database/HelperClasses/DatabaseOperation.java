package com.example.mujahid.allinall.Database.HelperClasses;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.mujahid.allinall.Activity.L;
import com.example.mujahid.allinall.Database.Activity.Student_Data_Insert;

/**
 * Created by Mujahid on 12/28/2017.
 */

public class DatabaseOperation {

    public boolean insertIntoStudent(Context context, String name, String Father_name, String Mother_name, String Roll_number, String Subject, String Birth_date) {
        boolean sucessful = true;
        try {

            SQLiteOpenHelper openHelper = new ResultSystemDatabaseHelper(context);
            SQLiteDatabase database = openHelper.getWritableDatabase();

            String sql = "INSERT INTO Student \n" +

                    "(Student_name, Father_Name, Mother_Name, Roll_Number, Subject, Birth_Date)\n" +

                    "VALUES\n" +

                    "('" + name + "', '" + Father_name + "', '" + Mother_name + "', '" + Roll_number + "', '" + Subject + "', '"+ Birth_date +"');";
            database.execSQL(sql);

        }catch (SQLiteConstraintException b){
            throw new SQLiteConstraintException();
        }

        catch (SQLiteException e) {

            Log.d("Mim", e.getMessage());
            sucessful = false;

        }

        return sucessful;

    }

    public boolean insertIntoScience(Context context, String roll_number, int physics, int chemistry, int biology, int english, int bangla, int islam) {
        boolean sucessful = true;
        try {
            SQLiteOpenHelper openHelper = new ResultSystemDatabaseHelper(context);
            SQLiteDatabase database = openHelper.getWritableDatabase();
            String sql = "INSERT INTO Science \n" +
                    "(Roll_Number, Physics, Chemistry, Bangla, English, Biology, IslamicEDu)\n" +
                    "VALUES\n" +
                    "(" + roll_number + " , " + physics + ", " + chemistry + ", " + bangla + ", " + english + ", " + biology + ", " + islam + ");";
            database.execSQL(sql);
        }
        catch (SQLiteConstraintException b){
            throw new SQLiteConstraintException();
        }
        catch (SQLiteException e) {
            Log.d("Mim", e.getMessage());
            sucessful = false;
        }

        return sucessful;
    }


    public boolean insertIntoCommerce(Context context, String roll_number, int accounting, int business, int entirepurenure, int english, int bangla, int islam) {

        boolean sucessful = true;
        try {
            SQLiteOpenHelper openHelper = new ResultSystemDatabaseHelper(context);
            SQLiteDatabase database = openHelper.getWritableDatabase();
            String sql = "INSERT INTO Commerce \n" +
                    "(Roll_Number, Accounting, Business_Study, Entireprenueship, English, Bangla, IslamicEDu)\n" +
                    "VALUES\n" +
                    "(" + roll_number + " , " + accounting + ", " + business + ", " + entirepurenure + ", " + english + ", " + bangla + ", " + islam + ");";
            database.execSQL(sql);

        } catch (SQLiteConstraintException e) {
            throw new SQLiteConstraintException();
        }catch (Exception e){

            Log.d("Mim", e.getMessage());
            sucessful = false;
        }

        return sucessful;
    }


    public boolean insertIntoArts(Context context, String roll_number, int history, int economics, int math, int english, int bangla, int islam) {

        boolean sucessful = true;
        try {
            SQLiteOpenHelper openHelper = new ResultSystemDatabaseHelper(context);
            SQLiteDatabase database = openHelper.getWritableDatabase();
            String sql = "INSERT INTO Humanities \n" +
                    "(Roll_Number, History, Economics, Math, English, Bangla, IslamicEDu)\n" +
                    "VALUES\n" +
                    "(" + roll_number + " , " + history + ", " + economics + ", " + math + ", " + english + ", " + bangla + ", " + islam + ");";
            database.execSQL(sql);

        }
        catch (SQLiteConstraintException b){
            throw new SQLiteConstraintException();
        }

        catch (SQLiteException e) {
            Log.d("Mim", e.getMessage());
            sucessful = false;
        }

        return sucessful;
    }


    public Cursor getMark(Context contex, String roll){
        Cursor a = null;
        try {
            SQLiteOpenHelper openHelper = new ResultSystemDatabaseHelper(contex);
            SQLiteDatabase database = openHelper.getWritableDatabase();
            String sql = "SELECT Physics, Chemistry, Bangla, English, Biology, IslamicEDu  FROM Science WHERE Roll_Number = " + roll + " ;";
            a = database.rawQuery(sql, null);
        }
        catch (SQLiteException e){
            Log.d("Mim",e.getMessage());
        }
        return a;
    }
}
