/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5_ass1;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Phan Thao
 */
 abstract  class Student implements Serializable{
    private String id;
    private String fullName;
    private int credit;
    private double averageScore;
    private transient Scanner sc = new Scanner(System.in);

    public Student() {}

    public Student(String id, String fullName, int credit, double averageScore) {
        this.id = id;
        this.fullName = fullName;
        this.credit = credit;
        this.averageScore = averageScore;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getCredit() {
        return credit;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void Input() {
        System.out.print("Enter student ID: ");
        id = sc.nextLine();
        System.out.print("Enter student full name: ");
        fullName = sc.nextLine();
        System.out.print("Enter student credit: ");
        credit = sc.nextInt();
        System.out.print("Enter student average score: ");
        averageScore = sc.nextDouble();
        sc.nextLine();  // Consume newline left-over
    }

    public void Output() {
        System.out.println("Student ID: " + id);
        System.out.println("Student name: " + fullName);
        System.out.println("Number of credits: " + credit);
        System.out.println("Average score: " + averageScore);
    }
    public String getType() {
        if (this instanceof UniversityStudent) {
            return "UniversityStudent";
        } else if (this instanceof CollegeStudent) {
            return "CollegeStudent";
        }
        return "Student";
    }

    public boolean CheckGraduation() {
        return credit >= 100 && averageScore >= 5;
    }

    // Comparator for sorting
    public static Comparator<Student> compareClass = new Comparator<Student>() {
        @Override
        public int compare(Student a, Student b) {
            if (!a.getClass().equals(b.getClass())) {
                return a.getClass().getName().compareTo(b.getClass().getName());
            }
            return a.getId().compareTo(b.getId());
        }
    };
}
