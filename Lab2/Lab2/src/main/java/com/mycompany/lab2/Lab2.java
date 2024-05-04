/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab2;
import java.util.Scanner;

/**
 *
 * @author Phan Thao
 */
public class Lab2 {

    public static void main(String[] args) {
        //Q1
        Scanner scanner = new Scanner(System.in);

        Q1_Complex c1 = new Q1_Complex();
        System.out.println("Enter first complex number:");
        c1.input(scanner);

        Q1_Complex c2 = new Q1_Complex();
        System.out.println("Enter second complex number:");
        c2.input(scanner);

        Q1_Complex sum = c1.plus(c2);
        System.out.print("Sum: ");
        sum.print();

        Q1_Complex difference = c1.minus(c2);
        System.out.print("Difference: ");
        difference.print();

        Q1_Complex product = c1.multiply(c2);
        System.out.print("Product: ");
        product.print();
        
        
    }
}
