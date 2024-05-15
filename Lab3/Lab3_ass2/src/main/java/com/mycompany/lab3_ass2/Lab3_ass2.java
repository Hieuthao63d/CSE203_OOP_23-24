/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab3_ass2;
import java.util.*; 
/**
 *
 * @author Phan Thao
 */
public class Lab3_ass2 {

    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);
        String option = "";

        while (!option.equals("11")) {
            System.out.println("1. Add Full-time Employee");
            System.out.println("2. Add Part-time Employee");
            System.out.println("3. Show all Full-time Employee");
            System.out.println("4. Show all Part-time Employee");
            System.out.println("5. Show all Employee");
            System.out.println("6. Search Employee by Id");
            System.out.println("7. Delete Employee by Id");
            System.out.println("8. Edit Employee information by Id");
            System.out.println("9. Search Employee by payment");
            System.out.println("10. Sort Full-time Employee and Part-Time employee in ascending order by age, payment");
            System.out.println("11. Exit");
            System.out.print("Enter your option: ");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    // Add Full-time Employee
                    break;
                case "2":
                    // Add Part-time Employee
                    break;
                case "3":
                    // Show all Full-time Employee
                    break;
                case "4":
                    // Show all Part-time Employee
                    break;
                case "5":
                    // Show all Employee
                    break;
                case "6":
                    // Search Employee by Id
                    break;
                case "7":
                    // Delete Employee by Id
                    break;
                case "8":
                    // Edit Employee information by Id
                    break;
                case "9":
                    // Search Employee by payment
                    break;
                case "10":
                    // Sort Full-time Employee and Part-Time employee in ascending order by age, payment
                    break;
                case "11":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();    }
}
