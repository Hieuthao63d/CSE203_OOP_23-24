/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab5_ass1;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
/**
 *
 * @author Phan Thao
 */
public class Lab5_ass1 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Manage manager = new Manage();
        String filename = "C:\\temp\\Student.dat"; // Adjusted the path for demonstration
        manager.loadFile(filename);
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new college student.");
            System.out.println("2. Add a new university student.");
            System.out.println("3. Remove a student from the list with the student code.");
            System.out.println("4. Print student list.");
            System.out.println("5. Print the list of students eligible for graduation.");
            System.out.println("6. Sort the student list by type and code.");
            System.out.println("7. Find student list by student's full name (Contains).");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    manager.addCol();
                    manager.saveToFile(filename);
                    break;
                case 2:
                    manager.addUni();
                    manager.saveToFile(filename);
                    break;
                case 3:
                    manager.deleteById();
                    manager.saveToFile(filename);
                    break;
                case 4:
                    manager.printStudentList();
                    break;
                case 5:
                    manager.printGraduation();
                    break;
                case 6:
                    manager.sortByTypeAndCode();
                    manager.saveToFile(filename);
                    break;
                case 7:
                    manager.findByName();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }
        }
    }
}

