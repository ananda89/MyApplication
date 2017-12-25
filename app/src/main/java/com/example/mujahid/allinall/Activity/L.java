package com.example.mujahid.allinall.Activity;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Mujahid on 12/21/2017.
 */

public class L {
    public static void m(String message){
        Log.d("Mim",message);
    }

    public static void s(Context context, String message){
        Toast.makeText(context,message, Toast.LENGTH_LONG).show();
    }

}
