/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5_ass2;
import java.util.*;
import java.io.*;
/**
 *
 * @author Phan Thao
 */
public class StaffList {
    private List<Staff> staffList;

    public StaffList() {
        staffList = new ArrayList<>();
    }

    public void addStaff(Staff staff) {
        Scanner scanner = new Scanner(System.in);
        staff.inputDetails(scanner);
        staffList.add(staff);
        System.out.println("Staff added successfully.");
    }

    public void editStaffById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter personnel ID to edit: ");
        long id = scanner.nextLong();
        Staff staff = findStaffById(id);
        if (staff != null) {
            staff.editDetails(scanner);
            System.out.println("Staff edited successfully.");
        } else {
            System.out.println("Staff not found.");
        }
    }

    private Staff findStaffById(long id) {
        return staffList.stream()
                .filter(s -> s.personnelId == id)
                .findFirst()
                .orElse(null);
    }

    public void removeStaffById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter personnel ID to remove: ");
        long id = scanner.nextLong();
        Staff staff = findStaffById(id);
        if (staff != null) {
            staffList.remove(staff);
            System.out.println("Staff removed successfully.");
        } else {
            System.out.println("Staff not found.");
        }
    }

    public void calculateTotalSalary() {
        double totalSalary = staffList.stream()
                .mapToDouble(s -> s.salary)
                .sum();
        System.out.println("Total salary of all staff is: " + totalSalary);
    }

    public void salaryStatsByType() {
        Map<String, Double> salaryByType = new HashMap<>();
        staffList.forEach(s -> salaryByType.merge(s.getClass().getSimpleName(), s.salary, Double::sum));
        salaryByType.forEach((type, sum) -> System.out.println("Total salary for " + type + " is: " + sum));
    }

    public void displayTopPaidStaff() {
        staffList.stream()
                .sorted(Comparator.comparingDouble(s -> -s.salary))
                .limit(3)
                .forEach(s -> System.out.println(s.toString() + " with salary: " + s.salary));
    }
}
