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
public class MenuManager {
    private static List<Staff> staffList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Staff");
            System.out.println("2. Save and Calculate Salaries");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStaff();
                    break;
                case 2:
                    saveAllData();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addStaff() {
        // Giống như ví dụ trước, thêm nhân viên
        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter date of birth (dd/MM/yyyy): ");
        String dob = scanner.nextLine();
        System.out.print("Enter personnel ID: ");
        String pid = scanner.nextLine();
        // Lặp lại cho các loại nhân viên khác...
    }

    private static void saveAllData() {
        saveStaff(); // Lưu thông tin nhân viên
        saveTotalSalary(); // Lưu tổng lương
        saveTotalSalaryByType(); // Lưu tổng lương theo loại nhân viên
        saveHighestPaidStaff(); // Lưu 3 nhân viên có lương cao nhất
    }

    private static void saveStaff() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("EiuStaff.eiu"))) {
            for (Staff staff : staffList) {
                writer.write(staff.toString());
                writer.newLine();
            }
            System.out.println("Staff information saved to EiuStaff.eiu");
        } catch (IOException e) {
            System.out.println("Error saving staff information: " + e.getMessage());
        }
    }

    private static void saveTotalSalary() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("TotalSalary.eiu"))) {
            double totalSalary = staffList.stream()
                .mapToDouble(Staff::calculateSalary)
                .sum();
            writer.write("Total salary of all staff: " + totalSalary);
            System.out.println("Total salary saved to TotalSalary.eiu");
        } catch (IOException e) {
            System.out.println("Error saving total salary: " + e.getMessage());
        }
    }

    private static void saveTotalSalaryByType() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("TotalSalarybyType.eiu"))) {
            Map<String, Double> salaryByType = new HashMap<>();
            staffList.forEach(staff -> {
                String type = staff.getClass().getSimpleName();
                salaryByType.merge(type, staff.calculateSalary(), Double::sum);
            });
            salaryByType.forEach((type, total) -> {
                try {
                    writer.write(type + " total salary: " + total);
                    writer.newLine();
                } catch (IOException e) {
                    System.out.println("Error writing salary by type: " + e.getMessage());
                }
            });
            System.out.println("Total salary by type saved to TotalSalarybyType.eiu");
        } catch (IOException e) {
            System.out.println("Error saving salary by type: " + e.getMessage());
        }
    }

    private static void saveHighestPaidStaff() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("HighestPaidStaff.eiu"))) {
            List<Staff> sortedBySalary = new ArrayList<>(staffList);
            sortedBySalary.sort(Comparator.comparingDouble(Staff::calculateSalary).reversed());
            for (int i = 0; i < Math.min(3, sortedBySalary.size()); i++) {
                Staff staff = sortedBySalary.get(i);
                writer.write(staff.toString() + " - Salary: " + staff.calculateSalary());
                writer.newLine();
            }
            System.out.println("Top 3 highest paid staff saved to HighestPaidStaff.eiu");
        } catch (IOException e) {
            System.out.println("Error saving highest paid staff: " + e.getMessage());
        }
    }
}
