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
 class Researcher extends Staff {
    private List<String> projectCodes;
    private int yearsOfResearch;

    public Researcher(String fullName, String dateOfBirth, String personnelID, List<String> projectCodes, int yearsOfResearch) {
        super(fullName, dateOfBirth, personnelID);
        this.projectCodes = projectCodes;
        this.yearsOfResearch = yearsOfResearch;
    }

    @Override
    public double calculateSalary() {
        long count = projectCodes.stream().filter(code -> code.startsWith("D")).count();
        return (yearsOfResearch * 2 + count) * 20000;
    }
}
