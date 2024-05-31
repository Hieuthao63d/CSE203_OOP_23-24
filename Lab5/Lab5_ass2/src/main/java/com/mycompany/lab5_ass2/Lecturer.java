/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5_ass2;
import java.util.*;
/**
 *
 * @author Phan Thao
 */
 class Lecturer extends Staff{
    private String academicRank;
    private String academicDegree;
    private int yearsOfTeaching;
    private List<String> subjectsTaught;

    public Lecturer(String fullName, String dateOfBirth, String personnelID, String academicRank, String academicDegree, int yearsOfTeaching, List<String> subjectsTaught) {
        super(fullName, dateOfBirth, personnelID);
        this.academicRank = academicRank;
        this.academicDegree = academicDegree;
        this.yearsOfTeaching = yearsOfTeaching;
        this.subjectsTaught = subjectsTaught;
    }

    @Override
    public double calculateSalary() {
        return (subjectsTaught.size() * yearsOfTeaching * 0.12) * 20000;
    }
}
