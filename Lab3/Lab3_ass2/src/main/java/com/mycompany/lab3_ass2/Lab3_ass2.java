/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
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
public class Lab3_ass2 {

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Full-time Employee");
            System.out.println("2. Add Part-time Employee");
            System.out.println("3. Show all Full-time Employees");
            System.out.println("4. Show all Part-time Employees");
            System.out.println("5. Show all Employees");
            System.out.println("6. Search Employee by Id");
            System.out.println("7. Delete Employee by Id");
            System.out.println("8. Edit Employee information by Id");
            System.out.println("9. Search Employee by payment");
            System.out.println("10. Sort Employees");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.println("Enter ID, Name, Year of Birth, Address, Phone, Salary:");
                    manager.addEmployee(new FullTimeEmployee(scanner.next(), scanner.next(), scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextFloat()));
                    break;
                case 2:
                    System.out.println("Enter ID, Name, Year of Birth, Address, Phone, Working Hours, Pay Rate:");
                    manager.addEmployee(new PartTimeEmployee(scanner.next(), scanner.next(), scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextFloat()));
                    break;
                case 3:
                    manager.showAllFullTimeEmployees();
                    break;
                case 4:
                    manager.showAllPartTimeEmployees();
                    break;
                case 5:
    manager.displayAllEmployees();
    break;
                case 6:
                    System.out.print("Enter Employee ID:");
                    Employee e = manager.findEmployeeById(scanner.next());
                    if (e != null) {
                        System.out.println(e.getInfo());
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 7:
                    System.out.print("Enter Employee ID to delete:");
                    manager.deleteEmployeeById(scanner.next());
                    break;
                case 8:
                    System.out.print("Enter Employee ID to edit:");
                    manager.editEmployeeById(scanner.next());
                    break;
                case 9:
                    System.out.print("Enter payment range (from to): ");
                    float from = scanner.nextFloat();
                    float to = scanner.nextFloat();
                    manager.searchEmployeesByPayment(from, to);
                    break;
                case 10:
    manager.sortEmployeesByAgeAndPayment();
    manager.displayAllEmployees();
    break;
                case 11:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
