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
public class EmployeeManager {
    private ArrayList<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public void showAllFullTimeEmployees() {
        for (Employee e : employees) {
            if (e instanceof FullTimeEmployee) {
                System.out.println(e.getInfo());
            }
        }
    }

    public void showAllPartTimeEmployees() {
        for (Employee e : employees) {
            if (e instanceof PartTimeEmployee) {
                System.out.println(e.getInfo());
            }
        }
    }

    public void deleteEmployeeById(String id) {
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            employees.remove(employee);
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void editEmployeeById(String id) {
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter new name:");
            employee.employeeName = scanner.nextLine();
            System.out.println("Enter new address:");
            employee.address = scanner.nextLine();
            System.out.println("Enter new phone:");
            employee.phone = scanner.nextLine();
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void searchEmployeesByPayment(float from, float to) {
        for (Employee e : employees) {
            float payment = e.getPayment();
            if (payment >= from && payment <= to) {
                System.out.println(e.getInfo());
            }
        }
    }

    public void sortEmployeesByAgeAndPayment() {
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                int ageCompare = Integer.compare(e1.yearOfBirth, e2.yearOfBirth);
                if (ageCompare != 0) {
                    return ageCompare;
                }
                return Float.compare(e1.getPayment(), e2.getPayment());
            }
        });
        System.out.println("Employees sorted by age and payment.");
    }
    public void displayAllEmployees() {
        for (Employee e : employees) {
            System.out.println(e.getInfo() + " - Payment: " + e.getPayment());
        }
    }

    public Employee findEmployeeById(String id) {
        for (Employee e : employees) {
            if (e.employeeID.equals(id)) {
                return e;
            }
        }
        return null;
    }
}
