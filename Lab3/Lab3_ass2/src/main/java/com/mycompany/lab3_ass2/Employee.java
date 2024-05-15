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
abstract class Employee {
    protected String employeeID;
    protected String employeeName;
    protected int yearOfBirth;
    protected String address;
    protected String phone;

    public Employee(String employeeID, String employeeName, int yearOfBirth, String address, String phone) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
        this.phone = phone;
    }

    public abstract String getInfo();
    public abstract float getPayment();

    public String getEmployeeID() {
        return employeeID;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
