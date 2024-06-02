/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5_ass1;
import java.io.*;
import java.util.*;
import java.util.Comparator;
import java.util.stream.Collectors;
/**
 *
 * @author Phan Thao
 */
public class Manage {
    private Vector<Student> vector = new Vector<>();
    private Scanner sc = new Scanner(System.in);

    public void addUni() {
        Student university_students = new UniversityStudent();
        university_students.Input();
        vector.add(university_students);
    }

    public void addCol() {
        Student college_students = new CollegeStudent();
        college_students.Input();
        vector.add(college_students);
    }

    public void deleteById() {
        System.out.print("Enter ID to delete: ");
        String idToDelete = sc.next();
        vector.removeIf(student -> student.getId().equals(idToDelete));
    }

    public void printStudentList() {
        vector.forEach(Student::Output);
    }

    public void sortByTypeAndCode() {
        Collections.sort(vector, Comparator.comparing(Student::getType).thenComparing(Student::getId));
        System.out.println("Student list sorted.");
    }

    public void printGraduation() {
        long count = vector.stream().filter(Student::CheckGraduation).peek(Student::Output).count();
        System.out.println("Number of eligible students: " + count);
    }

    public void findByName() {
        System.out.print("Enter name to search: ");
        String findName = sc.nextLine().toLowerCase();
        List<Student> foundStudents = vector.stream()
                                            .filter(s -> s.getFullName().toLowerCase().contains(findName))
                                            .collect(Collectors.toList());
        if (foundStudents.isEmpty()) {
            System.out.println("No students found.");
        } else {
            foundStudents.forEach(Student::Output);
            saveSearchResults(foundStudents, "C:\\temp\\Result.dat");
        }
    }

    private void saveSearchResults(List<Student> students, String filename) {
        try (FileOutputStream f = new FileOutputStream(filename);
             ObjectOutputStream fo = new ObjectOutputStream(f)) {
            for (Student st : students) {
                fo.writeObject(st);
            }
        } catch (IOException e) {
            System.out.println("Error saving search results: " + e.getMessage());
        }
    }

    public void saveToFile(String fName) {
        try (FileOutputStream f = new FileOutputStream(fName);
             ObjectOutputStream fo = new ObjectOutputStream(f)) {
            for (Student st : vector) {
                fo.writeObject(st);
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public void loadFile(String fname) {
        File file = new File(fname);
        if (!file.exists()) return;
        try (FileInputStream fi = new FileInputStream(file);
             ObjectInputStream fo = new ObjectInputStream(fi)) {
            Student st;
            while (fi.available() > 0) {
                st = (Student) fo.readObject();
                vector.add(st);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }
}
