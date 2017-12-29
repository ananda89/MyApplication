package com.example.mujahid.allinall.Database.ModelClasses;

/**
 * Created by Mujahid on 12/25/2017.
 */

public class Student {

    private String Student_name;
    private String Father_name;
    private String Mother_name;
    private String Birth_date;
    private String subject;
    private String Roll_Number;

    public Student(String student_name, String father_name, String mother_name, String birth_date, String Subject, String roll_Number) {
        Student_name = student_name;
        Father_name = father_name;
        Mother_name = mother_name;
        Birth_date = birth_date;
        this.subject = Subject;
        Roll_Number = roll_Number;
    }

    public String getStudent_name() {
        return Student_name;
    }

    public String getFather_name() {
        return Father_name;
    }

    public String getMother_name() {
        return Mother_name;
    }

    public String getBirth_date() {
        return Birth_date;
    }

    public String getSubject() {
        return subject;
    }

    public String getRoll_Number() {
        return Roll_Number;
    }
}
