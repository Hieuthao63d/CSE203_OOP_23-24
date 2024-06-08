/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab3_ass1;
import java.util.*;
import javax.swing.SwingUtilities;
/**
 *
 * @author Phan Thao
 */
public class Lab3_ass1 {

    public static void main(String[] args) {
        CDCollection cdCollection = new CDCollection();
        Scanner scanner = new Scanner(System.in);
        String option = "";

        while (!option.equals("9")) {
            cdCollection.displayMenu();
            System.out.print("Enter your option: ");
            option = scanner.nextLine();
            cdCollection.handleOption(option, scanner);
        }

        System.out.println("Exiting...");
        scanner.close();
    }
}
