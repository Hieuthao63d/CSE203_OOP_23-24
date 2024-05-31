/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5_ass2;

/**
 *
 * @author Phan Thao
 */
 class TeachingAssistant extends Staff {
    private int numberOfSubjectsAssisted;

    public TeachingAssistant(String fullName, String dateOfBirth, String personnelID, int numberOfSubjectsAssisted) {
        super(fullName, dateOfBirth, personnelID);
        this.numberOfSubjectsAssisted = numberOfSubjectsAssisted;
    }

    @Override
    public double calculateSalary() {
        return (numberOfSubjectsAssisted * 0.3) * 18000;
    }
}
