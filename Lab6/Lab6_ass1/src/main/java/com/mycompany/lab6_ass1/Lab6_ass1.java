/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab6_ass1;
import javax.swing.*;
/**
 *
 * @author Phan Thao
 */
public class Lab6_ass1 {

    public static void main(String[] args) {
            try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Ensure the program exits when the frame closes
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create and display the main application window
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame(new StudentManager());
            mainFrame.setVisible(true);
        });
    }
}
