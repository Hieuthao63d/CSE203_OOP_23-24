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
 class Specialist extends Staff {
    private List<String> projectCodes;
    private int yearsOfWork;

    public Specialist(String fullName, String dateOfBirth, String personnelID, List<String> projectCodes, int yearsOfWork) {
        super(fullName, dateOfBirth, personnelID);
        this.projectCodes = projectCodes;
        this.yearsOfWork = yearsOfWork;
    }

    @Override
    public double calculateSalary() {
        long count = projectCodes.stream().filter(code -> code.startsWith("T")).count();
        return (yearsOfWork * 4 + count) * 18000;
    }
}
