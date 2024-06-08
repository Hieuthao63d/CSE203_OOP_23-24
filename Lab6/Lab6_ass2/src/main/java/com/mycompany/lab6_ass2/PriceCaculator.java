/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6_ass2;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

/**
 *
 * @author Phan Thao
 */
public class PriceCaculator extends JPanel {
    private static final int BASE_PRICE = 200;
    private String guestName;
    private boolean breakfast;
    private boolean golf;
    private boolean pool;
    private int dayType;

    public PriceCaculator(String guestName, boolean breakfast, boolean golf, boolean pool, int dayType) {
        this.guestName = guestName;
        this.breakfast = breakfast;
        this.golf = golf;
        this.pool = pool;
        this.dayType = dayType;
    }

    public String calculate() {
        if (guestName.isEmpty()) {
            return "Guest name must not be empty.";
        }

        int total = BASE_PRICE;
        if (breakfast) total += 20;
        if (golf) total += 50;
        if (pool) total += 15;

        switch (dayType) {
            case 0: // Weekday
                total *= 0.9;
                break;
            case 1: // Weekend
                total *= 1.3;
                break;
        }

        return "Hello " + guestName + " Your payment is: $" + String.format("%.2f", (double) total);
    }
}
