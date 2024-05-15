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
public class PartTimeEmployee extends Employee {
    private int workingHour;
    private float payRate;

    public PartTimeEmployee(String employeeID, String employeeName, int yearOfBirth, String address, String phone, int workingHour, float payRate) {
        super(employeeID, employeeName, yearOfBirth, address, phone);
        this.workingHour = workingHour;
        this.payRate = payRate;
    }

    @Override
    public String getInfo() {
        return "Part-Time Employee: " + employeeName + " (" + employeeID + ")";
    }

    @Override
    public float getPayment() {
        return workingHour * payRate;
    }
}
