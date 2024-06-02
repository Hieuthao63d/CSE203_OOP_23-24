/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab5_ass2;
import java.util.Scanner;
/**
 *
 * @author Phan Thao
 */
public class Lab5_ass2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StaffList staffList = new StaffList();

        int option = 0;
        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add new lecturer");
            System.out.println("2. Add new teaching assistant");
            System.out.println("3. Add new researcher");
            System.out.println("4. Add new specialist");
            System.out.println("5. Edit staff by ID");
            System.out.println("6. Remove staff by ID");
            System.out.println("7. Calculate total salary");
            System.out.println("8. Salary stats by staff type");
            System.out.println("9. Top 3 highest paid staff");
            System.out.println("10. Exit");
            System.out.print("Option: ");
            option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    staffList.addStaff(new Lecturer());
                    break;
                case 2:
                    staffList.addStaff(new TeachingAssistant());
                    break;
                case 3:
                    staffList.addStaff(new Researcher());
                    break;
                case 4:
                    staffList.addStaff(new Specialist());
                    break;
                case 5:
                    staffList.editStaffById();
                    break;
                case 6:
                    staffList.removeStaffById();
                    break;
                case 7:
                    staffList.calculateTotalSalary();
                    break;
                case 8:
                    staffList.salaryStatsByType();
                    break;
                case 9:
                    staffList.displayTopPaidStaff();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        } while (option != 10);

        scanner.close();
    }
}
