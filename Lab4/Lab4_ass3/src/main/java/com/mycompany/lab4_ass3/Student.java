/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4_ass3;

/**
 *
 * @author Phan Thao
 */
public class Student {
    protected String studentNumber;
    protected String fullName;
    protected int totalCredits;
    protected double averageScore;

    public Student(String studentNumber, String fullName, int totalCredits, double averageScore) {
        this.studentNumber = studentNumber;
        this.fullName = fullName;
        this.totalCredits = totalCredits;
        this.averageScore = averageScore;
    }
    
    public boolean isEligibleForGraduation(){
        return false;
    }
    public String getStudentNumber(){
        return studentNumber;
    }

    public String getFullName() {
        return fullName;
    }
    public String getType(){
        return "Student";
    }
}
