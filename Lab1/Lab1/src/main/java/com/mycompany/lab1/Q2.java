/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1;

/**
 *
 * @author Phan Thao
 */
public class Q2 {
    private double num1, num2, num3;

    public Q2(double num1, double num2, double num3) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }

    public Q2() {
    }

    public double findMinimum() {
        double minNum = num1;

        if (num2 < minNum) {
            minNum = num2;
        }

        if (num3 < minNum) {
            minNum = num3;
        }

        return minNum;
    }
}
