/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5_ass2;

/**
 *
 * @author Phan Thao
 */
abstract  class Staff {
    protected String fullName;
    protected String dateOfBirth;
    protected String personnelID;

    public Staff(String fullName, String dateOfBirth, String personnelID) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.personnelID = personnelID;
    }

    // Phương thức trừu tượng để tính lương
    public abstract double calculateSalary();
}
