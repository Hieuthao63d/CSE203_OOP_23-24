/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3_ass2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/**
 *
 * @author Phan Thao
 */
public class FullTimeEmployee extends Employee {
    private float salary;

    public FullTimeEmployee(String employeeID, String employeeName, int yearOfBirth, String address, String phone, float salary) {
        super(employeeID, employeeName, yearOfBirth, address, phone);
        this.salary = salary;
    }

    @Override
    public String getInfo() {
        return "Full-Time Employee: " + employeeName + " (" + employeeID + ")";
    }

    @Override
    public float getPayment() {
        return salary;
    }
    
}
