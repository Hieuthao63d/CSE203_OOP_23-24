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
 class TeachingAssistant extends Staff {
    private int numberOfSubjects;

    @Override
    public void calculateSalary() {
        salary = (numberOfSubjects * 0.3) * 18000;
    }

    @Override
    public void inputDetails(Scanner scanner) {
        System.out.print("Enter full name: ");
        fullName = scanner.nextLine();
        System.out.print("Enter date of birth: ");
        dateOfBirth = scanner.nextLine();
        System.out.print("Enter personnel ID: ");
        personnelId = scanner.nextLong();
        System.out.print("Enter number of subjects assisted: ");
        numberOfSubjects = scanner.nextInt();
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
