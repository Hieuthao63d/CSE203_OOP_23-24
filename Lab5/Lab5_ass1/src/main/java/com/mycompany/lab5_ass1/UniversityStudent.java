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
public class UniversityStudent extends Student  {
    private String thesisName;
    private double thesisScore;

    public UniversityStudent() {}

    public UniversityStudent(String id, String fullName, int credit, double averageScore, String thesisName, double thesisScore) {
        super(id, fullName, credit, averageScore);
        this.thesisName = thesisName;
        this.thesisScore = thesisScore;
    }

    @Override
    public void Input() {
        super.Input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter thesis name: ");
        thesisName = sc.nextLine();
        System.out.print("Enter thesis score: ");
        thesisScore = sc.nextDouble();
        sc.nextLine(); // Consume newline left-over
    }

    @Override
    public void Output() {
        super.Output();
        System.out.println("Thesis name: " + thesisName);
        System.out.println("Thesis score: " + thesisScore);
    }

    @Override
    public boolean CheckGraduation() {
        return super.CheckGraduation() && thesisScore >= 5;
    }

}
