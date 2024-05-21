/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4_ass3;

/**
 *
 * @author Phan Thao
 */
public class CollegeStudent extends Student{
    private double graduationExamScore;
    
    public CollegeStudent(String studentNumber, String fullName, int totalCredits, double averageScore, double graduationExamScore){
        super(studentNumber, fullName, totalCredits, averageScore);
        this.graduationExamScore = graduationExamScore;
    }
    @Override
    public boolean isEligibleForGraduation(){
        return totalCredits >= 100 && averageScore >= 5 && graduationExamScore >= 5;
        }
    @Override
        public String getType(){
            return "College";
        }
    @Override
        public String toString(){
          return  "CollegeStudent{" +
                "studentNumber='" + studentNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                ", totalCredits=" + totalCredits +
                ", averageScore=" + averageScore +
                ", graduationExamScore=" + graduationExamScore +
                '}';
 
        }
}
