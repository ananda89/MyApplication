package com.example.mujahid.allinall.Database.ModelClasses;

import java.util.HashMap;

/**
 * Created by Mujahid on 12/25/2017.
 */

class Science {

 private String Student_RollNumber;

 private int Physics;
 private int Chemistry;
 private int Bangla;
 private int English;
 private int Biology;
 private int Math;
 private int Soical;
 private int islamicEdu;


    public Science(String student_RollNumber, int physics, int chemistry, int bangla, int english, int biology, int math, int soical, int islamicEdu) {
        Student_RollNumber = student_RollNumber;
        Physics = physics;
        Chemistry = chemistry;
        Bangla = bangla;
        English = english;
        Biology = biology;
        Math = math;
        Soical = soical;
        this.islamicEdu = islamicEdu;
    }

    public String getStudent_RollNumber() {
        return Student_RollNumber;
    }

    public int getPhysics() {
        return Physics;
    }

    public int getChemistry() {
        return Chemistry;
    }

    public int getBangla() {
        return Bangla;
    }

    public int getEnglish() {
        return English;
    }

    public int getBiology() {
        return Biology;
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
