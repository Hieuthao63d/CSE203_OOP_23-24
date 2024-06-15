/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.observer_pattern;

/**
 *
 * @author Phan Thao
 */
public class Observer_Pattern {

    public static void main(String[] args) {
        Stock appleStock = new ConcreteStock("APP", 100);
        Stock dellStock = new ConcreteStock("DELL", 100);

        // Register basic investors
        Investor tomInvestor = new SimpleInvestor("Tom");
        Investor bobInvestor = new SimpleInvestor("Bob");
        appleStock.addObserver(tomInvestor);
        appleStock.addObserver(bobInvestor);
        dellStock.addObserver(tomInvestor);

        // Simulate a significant price change
        appleStock.notifyInvestors(100);
        appleStock.notifyInvestors(40.0);
        appleStock.notifyInvestors(10.0);
        appleStock.notifyInvestors(5.0);
        dellStock.notifyInvestors(300.0);
        dellStock.notifyInvestors(200.0);
    }
}
