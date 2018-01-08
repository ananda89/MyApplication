package com.example.mujahid.allinall.Database.BroadcastDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mujahid.allinall.Constants.Constant;

/**
 * Created by Mujahid on 1/5/2018.
 */

public class BroadcastHelper extends SQLiteOpenHelper {

  public BroadcastHelper(Context context){
            super(context,Constant.BROAD_CAST_DB_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + Constant.BROAD_CAST_TABLE_NAME +
                "\n (" +
                "Id integer primary key autoincrement,\n" +
                "Incomming_Calls TEXT\n" +

                ");";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String update = "DROP TABLE IF EXISTS " + Constant.BROAD_CAST_TABLE_NAME + ";";
        sqLiteDatabase.execSQL(update);
        onCreate(sqLiteDatabase);
    }

    public void addInfo(SQLiteDatabase database, String number){
        ContentValues contentValues = new ContentValues();
        contentValues.put("Incomming_Calls",number);
        database.insert(Constant.BROAD_CAST_TABLE_NAME,null,contentValues);
    }


    public Cursor readNumber(SQLiteDatabase database){
        String[] projection = {"id","Incomming_Calls"};
        return (database.query(Constant.BROAD_CAST_TABLE_NAME,projection,null,null,null,null,null));
    }

}
