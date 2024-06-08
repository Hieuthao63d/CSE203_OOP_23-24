/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3_ass1;

import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author Phan Thao
 */
public class MainApplication {
    private static CDCollection cdCollection = new CDCollection();
    private static JFrame mainFrame;
    
    public static void setupMainFrame() {
        mainFrame = new JFrame("CD Store Management");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 300);
        mainFrame.setLayout(new FlowLayout());

        JButton btnAddCD = new JButton("Add New CD");
        btnAddCD.addActionListener(e -> displayAddCDFrame());
        mainFrame.add(btnAddCD);

        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    public static void displayAddCDFrame() {
        JFrame addCDFrame = new CDAddFrame(cdCollection);
        addCDFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> setupMainFrame());
    }
}
