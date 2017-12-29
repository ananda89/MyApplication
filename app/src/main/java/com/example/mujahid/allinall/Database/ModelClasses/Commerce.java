package com.example.mujahid.allinall.Database.ModelClasses;

/**
 * Created by Mujahid on 12/25/2017.
 */

public class Commerce {
private String Student_RollNumber;
    private int Business_study;
    private int Entireprenueship;
    private int Accounting;
    private int English;
    private int Busines_Running;
    private int Math;
    private int Soical;
    private int islamicEdu;

    public Commerce(String student_RollNumber, int business_study, int entireprenueship, int accounting, int english, int busines_Running, int math, int soical, int islamicEdu) {
        Student_RollNumber = student_RollNumber;
        Business_study = business_study;
        Entireprenueship = entireprenueship;
        Accounting = accounting;
        English = english;
        Busines_Running = busines_Running;
        Math = math;
        Soical = soical;
        this.islamicEdu = islamicEdu;
    }

    public String getStudent_RollNumber() {
        return Student_RollNumber;
    }

    public int getBusiness_study() {
        return Business_study;
    }

    public int getEntireprenueship() {
        return Entireprenueship;
    }

    public int getAccounting() {
        return Accounting;
    }

    public int getEnglish() {
        return English;
    }

    public int getBusines_Running() {
        return Busines_Running;
    }

    public int getMath() {
        return Math;
    }

    public int getSoical() {
        return Soical;
    }

    public int getIslamicEdu() {
        return islamicEdu;
    }
}
