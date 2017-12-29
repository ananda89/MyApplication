package com.example.mujahid.allinall.Database.ModelClasses;

/**
 * Created by Mujahid on 12/25/2017.
 */

public class Humanities {
    String Student_RollNumber;
    int Earth;
    int History;
    int Politics;
    int English;
    int Economics;
    int Math;
    int Soical;
    int islamicEdu;

    public Humanities(String student_RollNumber, int earth, int history, int politics, int english, int economics, int math, int soical, int islamicEdu) {
        Student_RollNumber = student_RollNumber;
        Earth = earth;
        History = history;
        Politics = politics;
        English = english;
        Economics = economics;
        Math = math;
        Soical = soical;
        this.islamicEdu = islamicEdu;
    }

    public String getStudent_RollNumber() {
        return Student_RollNumber;
    }

    public int getEarth() {
        return Earth;
    }

    public int getHistory() {
        return History;
    }

    public int getPolitics() {
        return Politics;
    }

    public int getEnglish() {
        return English;
    }

    public int getEconomics() {
        return Economics;
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
