/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5_ass2;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
/**
 *
 * @author Phan Thao
 */
public class MenuManager {
    private ArrayList<Staff> staffList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add staff");
            System.out.println("2. Save and Exit");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    addStaff();
                    break;
                case "2":
                    saveStaffList();
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private void addStaff() {
        System.out.println("Enter staff type (Lecturer/Assistant/Researcher/Specialist):");
        String staffType = scanner.nextLine();
        System.out.println("Enter full name:");
        String fullName = scanner.nextLine();
        System.out.println("Enter date of birth:");
        String dob = scanner.nextLine();
        System.out.println("Enter personnel ID:");
        String personnelID = scanner.nextLine();

        switch (staffType.toLowerCase()) {
            case "lecturer":
                addLecturer(fullName, dob, personnelID);
                break;
            case "assistant":
                addAssistant(fullName, dob, personnelID);
                break;
            case "researcher":
                addResearcher(fullName, dob, personnelID);
                break;
            case "specialist":
                addSpecialist(fullName, dob, personnelID);
                break;
            default:
                System.out.println("Invalid staff type.");
                break;
        }
    }

    private void addLecturer(String fullName, String dob, String personnelID) {
        System.out.println("Enter academic rank:");
        String rank = scanner.nextLine();
        System.out.println("Enter academic degree:");
        String degree = scanner.nextLine();
        System.out.println("Enter years of teaching:");
        int yearsTeaching = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter subjects taught (comma-separated):");
        List<String> subjects = List.of(scanner.nextLine().split(","));
        staffList.add(new Lecturer(fullName, dob, personnelID, rank, degree, yearsTeaching, subjects));
    }

    private void addAssistant(String fullName, String dob, String personnelID) {
        System.out.println("Enter number of subjects assisted:");
        int numSubjects = Integer.parseInt(scanner.nextLine());
        staffList.add(new TeachingAssistant(fullName, dob, personnelID, numSubjects));
    }

    private void addResearcher(String fullName, String dob, String personnelID) {
        System.out.println("Enter years of research:");
        int yearsResearch = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter project codes (comma-separated):");
        List<String> projects = List.of(scanner.nextLine().split(","));
        staffList.add(new Researcher(fullName, dob, personnelID, projects, yearsResearch));
    }

    private void addSpecialist(String fullName, String dob, String personnelID) {
        System.out.println("Enter years of work experience:");
        int yearsWork = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter project codes (comma-separated):");
        List<String> eduProjects = List.of(scanner.nextLine().split(","));
        staffList.add(new Specialist(fullName, dob, personnelID, eduProjects, yearsWork));
    }

    private void saveStaffList() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("EiuStaff.eiu"))) {
            oos.writeObject(staffList);
            System.out.println("Data has been saved.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
