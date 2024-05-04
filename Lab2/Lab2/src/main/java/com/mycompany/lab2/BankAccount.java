/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;

/**
 *
 * @author Phan Thao
 */
public class BankAccount {
    private int mAccNum;
    private String mName;
    private double mBalance;

    public BankAccount() {
    }

    public BankAccount(int mAccNum, String mName, double mBalance) {
        this.mAccNum = mAccNum;
        this.mName = mName;
        this.mBalance = mBalance;
    }

    public int getAccNum() {
        return mAccNum;
    }

    public double getBalance() {
        return mBalance;
    }

    public String getName() {
        return mName;
    }

    public void deposit(double amount) {
        mBalance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > mBalance) {
            return false;
        }
        mBalance -= amount;
        return true;
    }

    public boolean transferMoney(BankAccount other, double amount) {
        if (amount > mBalance) {
            return false;
        }
        mBalance -= amount;
        other.mBalance += amount;
        return true;
    }

    public void print() {
        System.out.println("Account Number: " + mAccNum + ", Name: " + mName + ", Balance: " + mBalance);
    }

    @Override
    public String toString() {
        return "Account Number: " + mAccNum + ", Name: " + mName + ", Balance: " + mBalance;
}
}
