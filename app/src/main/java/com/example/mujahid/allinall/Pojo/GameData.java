package com.example.mujahid.allinall.Pojo;

/**
 * Created by Mujahid on 11/28/2017.
 */

public class GameData {
 private String headerName;
 private String[] childItems;

     public GameData(String n, String[] c){
         headerName = n;
         childItems = c;

     }

     public String getHeaderName(){
         return headerName;
     }
     public int getChildItemSize(){
         return childItems.length;
     }
     public String getChildItem(int position){
         return childItems[position];
     }


}
