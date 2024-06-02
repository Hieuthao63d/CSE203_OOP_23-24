/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5_ass2;
import java.util.*;
/**
 *
 * @author Phan Thao
 */
 class Lecturer extends Staff{
    private int yearsOfExperience;
    private List<String> subjectsTaught;

    @Override
    public void calculateSalary() {
        salary = (subjectsTaught.size() * yearsOfExperience * 0.12) * 20000;
    }

    @Override
    public void inputDetails(Scanner scanner) {
        System.out.print("Enter full name: ");
        fullName = scanner.nextLine();
        System.out.print("Enter date of birth: ");
        dateOfBirth = scanner.nextLine();
        System.out.print("Enter personnel ID: ");
        personnelId = scanner.nextLong();
        System.out.print("Enter years of experience: ");
        yearsOfExperience = scanner.nextInt();
        System.out.print("Enter number of subjects taught: ");
        int numSubjects = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        subjectsTaught = new ArrayList<>();
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter subject " + (i + 1) + ": ");
            subjectsTaught.add(scanner.nextLine());
        }
        calculateSalary();
    }

    @Override
    public void editDetails(Scanner scanner) {
        System.out.print("Enter new full name: ");
        fullName = scanner.nextLine();
        // Additional edit options as needed
        calculateSalary();
    }
}
