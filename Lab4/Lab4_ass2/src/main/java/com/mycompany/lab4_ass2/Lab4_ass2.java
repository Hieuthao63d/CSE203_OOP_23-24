/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab4_ass2;
import java.util.Scanner;

/**
 *
 * @author Phan Thao
 */
public class Lab4_ass2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter bank name (TPBANK or VIETCOMBANK): ");
        String bankName = scanner.nextLine().toUpperCase();

        Bank bank;
        try {
            BankType bankType = BankType.valueOf(bankName);
            bank = BankFactory.getBank(bankType);
            System.out.println("Bank name: " + bank.getBankName());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid bank name entered.");
        }

        scanner.close();
    }
}
