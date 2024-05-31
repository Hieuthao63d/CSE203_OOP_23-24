/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5_ass1;

/**
 *
 * @author Phan Thao
 */
public class UniversityStudent extends Student  {
    private String thesisName; 
    private double thesisScore; 
    
     public UniversityStudent(String studentNumber, String fullName, int totalCredits, double averageScore, String thesisName, double thesisScore){
        super(studentNumber, fullName , totalCredits, averageScore);
        this.thesisName = thesisName;
        this.thesisScore = thesisScore; 
    }
    @Override
    public boolean isEligibleForGraduation() {
        return totalCredits >= 150 && averageScore >= 5 && thesisScore >= 5;
    }

    @Override
    public String getType() {
        return "University";
    }

    @Override
    public String toString() {
        return "UniversityStudent{" +
                "studentNumber='" + studentNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                ", totalCredits=" + totalCredits +
                ", averageScore=" + averageScore +
                ", thesisName='" + thesisName + '\'' +
                ", thesisScore=" + thesisScore +
                '}';
    }

}
