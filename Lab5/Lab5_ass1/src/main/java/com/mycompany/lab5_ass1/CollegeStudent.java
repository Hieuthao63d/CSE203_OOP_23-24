/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5_ass1;
import java.io.*;
import java.util.*;
/**
 *
 * @author Phan Thao
 */
public class CollegeStudent extends Student{
    private double graduationExamScore;

    public CollegeStudent() {}

    public CollegeStudent(String id, String fullName, int credit, double averageScore, double graduationExamScore) {
        super(id, fullName, credit, averageScore);
        this.graduationExamScore = graduationExamScore;
    }

    @Override
    public void Input() {
        super.Input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter graduation exam score: ");
        graduationExamScore = sc.nextDouble();
        sc.nextLine(); // Consume newline left-over
    }

    @Override
    public void Output() {
        super.Output();
        System.out.println("Graduation exam score: " + graduationExamScore);
    }

    @Override
    public boolean CheckGraduation() {
        return super.CheckGraduation() && graduationExamScore >= 5;
    }
}
