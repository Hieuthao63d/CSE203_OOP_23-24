/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5_ass2;
import java.util.Scanner;

/**
 *
 * @author Phan Thao
 */
abstract  class Staff {
    protected String fullName;
    protected String dateOfBirth;
    protected long personnelId;
    protected double salary;

    public abstract void calculateSalary();
    public abstract void inputDetails(Scanner scanner);
    public abstract void editDetails(Scanner scanner);
    
    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, DOB: %s, Salary: %.2f", personnelId, fullName, dateOfBirth, salary);
    }
}
