/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;

import java.util.Scanner;

/**
 *
 * @author Phan Thao
 */
public class Q1_Complex {

    
    private double re;
    private double im;
    
    public Q1_Complex() {
    }

    public Q1_Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }
    public void input(Scanner scanner){
        System.out.print("Enter real part: ");
        this.re = scanner.nextDouble();
        System.out.print("Enter imaginary part: ");
        this.im = scanner.nextDouble();
    }
    public void print(){
        System.out.println(this.re+" + "+this.im+ "i");
    }
    public Q1_Complex plus(Q1_Complex other) {
        return new Q1_Complex(this.re + other.re, this.im + other.im);
    }

    public Q1_Complex minus(Q1_Complex other) {
        return new Q1_Complex(this.re - other.re, this.im - other.im);
    }

    public Q1_Complex multiply(Q1_Complex other) {
        double re = this.re * other.re - this.im * other.im;
        double im = this.re * other.im + this.im * other.re;
        return new Q1_Complex(re, im);
        
    }
    public Q1_Complex devide ( Q1_Complex other){
        if (other.re == 0 && other.im == 0) {
        throw new IllegalArgumentException("Cannot divide by zero");
    }
    double real = (this.re * other.re + this.im * other.im) / (other.re * other.re + other.im * other.im);
    double imaginary = (this.im * other.re - this.re * other.im) / (other.re * other.re + other.im * other.im);
    return new Q1_Complex(real, imaginary);
    }
}
