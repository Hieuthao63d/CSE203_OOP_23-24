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
 class Specialist extends Staff {
    private int yearsOfExperience;
    private List<String> projectCodes;

    @Override
    public void calculateSalary() {
        long countTProjects = projectCodes.stream().filter(p -> p.startsWith("T")).count();
        salary = (yearsOfExperience * 4 + countTProjects) * 18000;
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
        System.out.print("Enter number of projects: ");
        int numProjects = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        projectCodes = new ArrayList<>();
        for (int i = 0; i < numProjects; i++) {
            System.out.print("Enter project code " + (i + 1) + ": ");
            projectCodes.add(scanner.nextLine());
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
