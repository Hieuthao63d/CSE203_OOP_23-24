/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lab2;

import java.util.*;

/**
 *
 * @author Phan Thao
 */
public class Lab2 {

    public static void main(String[] args) {
        //Q1
        Scanner scanner = new Scanner(System.in);
        /*
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
         */
        //Q2
        ArrayList<BankAccount> accounts = new ArrayList<>();

        System.out.print("Enter the number of accounts: ");
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            System.out.print("Enter account number, name, and initial balance for account " + (i + 1) + ": ");
            int accNum = scanner.nextInt();
            String name = scanner.next();
            double balance = scanner.nextDouble();
            accounts.add(new BankAccount(accNum, name, balance));
        }

        System.out.println("Account list:");
        for (BankAccount account : accounts) {
            account.print();
        }

        // Deposit money into an account
        System.out.print("Enter account number to deposit money into: ");
        int accNum = scanner.nextInt();
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        for (BankAccount account : accounts) {
            if (account.getAccNum() == accNum) {
                account.deposit(amount);
                System.out.println("After deposit, account details are: ");
                account.print();
                break;
            }
        }

        // Withdraw money from an account
        System.out.print("Enter account number to withdraw money from: ");
        accNum = scanner.nextInt();
        System.out.print("Enter amount to withdraw: ");
        amount = scanner.nextDouble();
        for (BankAccount account : accounts) {
            if (account.getAccNum() == accNum) {
                boolean success = account.withdraw(amount);
                if (success) {
                    System.out.println("After withdrawal, account details are: ");
                    account.print();
                } else {
                    System.out.println("Insufficient balance to withdraw.");
                }
                break;
            }
        }

        // Transfer money from one account to another
        System.out.print("Enter source account number for money transfer: ");
        int sourceAccNum = scanner.nextInt();
        System.out.print("Enter target account number for money transfer: ");
        int targetAccNum = scanner.nextInt();
        System.out.print("Enter amount to transfer: ");
        amount = scanner.nextDouble();
        BankAccount sourceAccount = null, targetAccount = null;
        for (BankAccount account : accounts) {
            if (account.getAccNum() == sourceAccNum) {
                sourceAccount = account;
            } else if (account.getAccNum() == targetAccNum) {
                targetAccount = account;
            }
        }
        if (sourceAccount != null && targetAccount != null) {
            boolean success = sourceAccount.transferMoney(targetAccount, amount);
            if (success) {
                System.out.println("After transfer, source account details are: ");
                sourceAccount.print();
                System.out.println("After transfer, target account details are: ");
                targetAccount.print();
            } else {
                System.out.println("Insufficient balance to transfer.");
            }
        } else {
            System.out.println("Either source or target account number is incorrect.");
        }
        scanner.close();
    }

}
