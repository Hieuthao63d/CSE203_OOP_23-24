/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4_ass3;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
/**
 *
 * @author Phan Thao
 */
public class MenuManager {
    private final Vector<Student> students;
    private final Scanner scanner;

    public MenuManager() {
        this.students = new Vector<>();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Add a new college student.");
            System.out.println("2. Add a new university student.");
            System.out.println("3. Remove a student from the list.");
            System.out.println("4. Print student list.");
            System.out.println("5. Print the list of students eligible for graduation.");
            System.out.println("6. Sort the student list.");
            System.out.println("7. Find student by full name.");
            System.out.println("8. Exit");
            System.out.print("Select an option: ");
            int choice = Integer.parseInt(scanner.nextLine());
            handleMenuChoice(choice);
        }
    }

    private void handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                addCollegeStudent();
                break;
            case 2:
                addUniversityStudent();
                break;
            case 3:
                removeStudent();
                break;
            case 4:
                printStudentList();
                break;
            case 5:
                printEligibleGraduates();
                break;
            case 6:
                sortStudents();
                break;
            case 7:
                findStudentByName();
                break;
            case 8:
                System.exit(0);
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void addCollegeStudent() {
        System.out.print("Enter student number: ");
        String studentNumber = scanner.nextLine();
        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter total credits: ");
        int totalCredits = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter average score: ");
        double averageScore = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter graduation exam score: ");
        double graduationExamScore = Double.parseDouble(scanner.nextLine());

        CollegeStudent student = new CollegeStudent(studentNumber, fullName, totalCredits, averageScore, graduationExamScore);
        students.add(student);
        System.out.println("College student added successfully.");
    }

    private void addUniversityStudent() {
        System.out.print("Enter student number: ");
        String studentNumber = scanner.nextLine();
        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter total credits: ");
        int totalCredits = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter average score: ");
        double averageScore = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter thesis name: ");
        String thesisName = scanner.nextLine();
        System.out.print("Enter thesis score: ");
        double thesisScore = Double.parseDouble(scanner.nextLine());

        UniversityStudent student = new UniversityStudent(studentNumber, fullName, totalCredits, averageScore, thesisName, thesisScore);
        students.add(student);
        System.out.println("University student added successfully.");
    }

    private void removeStudent() {
        System.out.print("Enter student number to remove: ");
        String studentNumber = scanner.nextLine();
        students.removeIf(student -> student.getStudentNumber().equals(studentNumber));
        System.out.println("Student removed successfully.");
    }

    private void printStudentList() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void printEligibleGraduates() {
        List<Student> eligibleStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.isEligibleForGraduation()) {
                eligibleStudents.add(student);
            }
        }
        System.out.println("Eligible Students:");
        for (Student student : eligibleStudents) {
            System.out.println(student);
        }
        System.out.println("Total number of eligible students: " + eligibleStudents.size());
    }

    private void sortStudents() {
        students.sort((s1, s2) -> {
            int typeComparison = s1.getType().compareTo(s2.getType());
            if (typeComparison != 0) {
                return typeComparison;
            }
            return s1.getStudentNumber().compareTo(s2.getStudentNumber());
        });
        System.out.println("Students sorted successfully.");
    }

    private void findStudentByName() {
        System.out.print("Enter full name to search: ");
        String fullName = scanner.nextLine();
        for (Student student : students) {
            if (student.getFullName().toLowerCase().contains(fullName.toLowerCase())) {
                System.out.println(student);
            }
        }
    }

}
