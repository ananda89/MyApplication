package com.example.mujahid.allinall.Database.HelperClasses;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mujahid on 12/28/2017.
 */

public class ResultSystemDatabaseHelper extends SQLiteOpenHelper {

        private static final String DataBase_name = "ResultSystem";
        private static final int DataBase_version = 1;

    ResultSystemDatabaseHelper(Context context) {
        super(context, DataBase_name, null, DataBase_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String Student_Table = "CREATE TABLE Student (\n" +
                "Student_name TEXT,\n" +
                "Father_name TEXT,\n" +
                "Mother_name TEXT,\n" +
                "Subject TEXT,\n" +
                "Roll_Number TEXT NOT NULL PRIMARY KEY,\n" +
                "Birth_Date TEXT\n" +
                ");";

        String Science_Table = "CREATE TABLE Science (\n" +
                "\n" +
                "Roll_Number TEXT NOT NULL PRIMARY KEY,\n" +
                "Physics INTEGER,\n" +
                "Chemistry INTEGER,\n" +
                "Bangla INTEGER,\n" +
                "English INTEGER,\n" +
                "Biology INTEGER,\n" +
                "IslamicEDu INTEGER\n" +
                ");";
        String Commerce_Table = "CREATE TABLE Commerce (\n" +
                "\n" +
                "Roll_Number TEXT NOT NULL PRIMARY KEY,\n" +
                "Business_Study INTEGER,\n" +
                "Entireprenueship INTEGER,\n" +
                "Accounting INTEGER,\n" +
                "English INTEGER,\n" +
                "Bangla INTEGER,\n" +
                "IslamicEDu INTEGER\n" +
                ");";

        String ArtsTable = "CREATE TABLE Humanities (\n" +
                "Roll_Number TEXT NOT NULL PRIMARY KEY,\n" +
                "History INTEGER,\n" +
                "Economics INTEGER,\n" +
                "English INTEGER,\n" +
                "Math INTEGER, \n" +
                "Bangla INTEGER,\n" +
                "IslamicEDu INTEGER\n" +
                ");";

        sqLiteDatabase.execSQL(Student_Table);
        sqLiteDatabase.execSQL(Science_Table);
        sqLiteDatabase.execSQL(Commerce_Table);
        sqLiteDatabase.execSQL(ArtsTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int old, int newData) {
        String sql = "DROP TABLE IF EXISTS Humanities OR Commerce OR Science OR Student";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
}
