/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5_ass1;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Phan Thao
 */
public class MenuManager {
    private Vector<Student> students= new Vector<>();
    private final Scanner scanner;
    private final String filePath = "D:\\student.dat";

    public MenuManager() {
       // this.students = new Vector<>();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {  // Thay đổi từ private sang public
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Add college students from file.");
            System.out.println("2. Add university students from file.");
            System.out.println("3. Remove a student from the list.");
            System.out.println("4. Print student list.");
            System.out.println("5. Print the list of students eligible for graduation.");
            System.out.println("6. Sort the student list.");
            System.out.println("7. Find student by full name and save to Result.dat.");
            System.out.println("8. Exit");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            handleMenuChoice(choice);
        }
    }

    private void handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                addStudentsFromFile("D:\\College.dat");
                break;
            case 2:
                addStudentsFromFile1("D:\\University.dat");
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
        }
    }

    private void addStudentsFromFile(String file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 5) {
                String studentNumber = data[0];
                String fullName = data[1];
                int totalCredits = Integer.parseInt(data[2]);
                double averageScore = Double.parseDouble(data[3]);
                double graduationExamScore = Double.parseDouble(data[4]);
                CollegeStudent student = new CollegeStudent(studentNumber, fullName, totalCredits, averageScore, graduationExamScore);
                students.add(student);
            }
        }
        System.out.println("Students added successfully from " + file);
    } catch (IOException e) {
        System.out.println("Error when reading from file: " + e.getMessage());
    }
    }
     private void addStudentsFromFile1(String file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 6) {
                String studentNumber = data[0];
                String fullName = data[1];
                int totalCredits = Integer.parseInt(data[2]);
                double averageScore = Double.parseDouble(data[3]);
                String thesisName = data[4];
                 double thesisScore = Double.parseDouble(data[5]);
                UniversityStudent student = new UniversityStudent(studentNumber, fullName, totalCredits, averageScore, thesisName,thesisScore);
                students.add(student);
            }
        }
        System.out.println("Students added successfully from " + file);
    } catch (IOException e) {
        System.out.println("Error when reading from file: " + e.getMessage());
    }
    }

    private void removeStudent() {
        System.out.print("Enter student number to remove: ");
        String studentNumber = scanner.nextLine();
        boolean removed = students.removeIf(student -> student.getStudentNumber().equals(studentNumber));
        if (removed) {
            saveStudents();
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("No student found with the given number.");
        }
    }

    private void printStudentList() {
        students.forEach(System.out::println);
    }

    private void printEligibleGraduates() {
        List<Student> eligibleStudents = students.stream()
                .filter(Student::isEligibleForGraduation)
                .collect(Collectors.toList());
        System.out.println("Eligible Students:");
        eligibleStudents.forEach(System.out::println);
        System.out.println("Total number of eligible students: " + eligibleStudents.size());
    }

    private void sortStudents() {
        students.sort(Comparator.comparing(Student::getType).thenComparing(Student::getStudentNumber));
        saveStudents();
        System.out.println("Students sorted successfully.");
        printStudentList();
    }

    private void findStudentByName() {
        System.out.print("Enter full name to search: ");
    String fullName = scanner.nextLine();
    List<Student> results = students.stream()
            .filter(s -> s.getFullName().toLowerCase().contains(fullName.toLowerCase()))
            .collect(Collectors.toList());
    saveResults(results);
    }

    private void saveResults(List<Student> results) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Result.dat"))) {
        for (Student stu : results) {
            writer.write(stu.toString());
            writer.newLine();  // Ensure each student is written on a new line
        }
        System.out.println("Results saved to Result.dat");
    } catch (IOException e) {
        System.out.println("Error writing to Result.dat: " + e.getMessage());
    }
    }

    private void saveStudents() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\student.dat"))) {
        for (Student stu : students) {
            writer.write(stu.toString());
            writer.newLine();
        }
        System.out.println("All students saved to student.dat");
    } catch (IOException e) {
        System.out.println("Error writing to student.dat: " + e.getMessage());
    }
}
}