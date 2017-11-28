package com.example.mujahid.allinall.Pojo;

/**
 * Created by Mujahid on 11/26/2017.
 */
//Data Model class
public class ProgrammingLangData {
    private String LangName;
    private String LangDes;
    private int logo;

    public   ProgrammingLangData(String name, String des, int l){
       LangName = name;
       LangDes = des;
       logo = l;
    }

    public String getLangName(){
        return  LangName;
    }

    public String getLangDes(){
        return LangDes;
    }

    public int getLogo(){
        return logo;
    }


}
