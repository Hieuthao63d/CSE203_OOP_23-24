/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;
import java.util.*;
/**
 *
 * @author Phan Thao
 */
public class Employee {
    private String code;
    private String name;
    private int yearsOfService;
    private double salaryCoefficient;
    private static double basicSalary = 1800000;

    public Employee(String code, String name, int yearsOfService, double salaryCoefficient) {
        this.code = code;
        this.name = name;
        this.yearsOfService = yearsOfService;
        this.salaryCoefficient = salaryCoefficient;
    }

    public double calculateSalary() {
        return salaryCoefficient * basicSalary;
    }

    @Override
    public String toString() {
        return "Employee Code: " + code + ", Name: " + name + ", Salary: " + calculateSalary();
    }

    public static void inputEmployees(ArrayList<Employee> employees, Scanner scanner) {
        System.out.print("Enter the number of employees: ");
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            System.out.print("Enter employee code, name, years of service, and salary coefficient for employee " + (i + 1) + ": ");
            String code = scanner.next();
            String name = scanner.next();
            int yearsOfService = scanner.nextInt();
            double salaryCoefficient = scanner.nextDouble();
            employees.add(new Employee(code, name, yearsOfService, salaryCoefficient));
        }
    }

    public static void printEmployees(ArrayList<Employee> employees) {
        System.out.println("Employee list:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
}
    public static Employee getHighestSalaryEmployee(ArrayList<Employee> employees) {
        return Collections.max(employees, Comparator.comparing(Employee::calculateSalary));
    }

    public static void sortEmployeesByDecreasingSalary(ArrayList<Employee> employees) {
        employees.sort(Comparator.comparing(Employee::calculateSalary).reversed());
    }
}
