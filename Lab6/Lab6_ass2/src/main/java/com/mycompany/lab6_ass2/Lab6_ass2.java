/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab6_ass2;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Phan Thao
 */
public class Lab6_ass2 extends JFrame {
    public Lab6_ass2(){
        setTitle("Resort Price Calculator");
        setSize(350,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
       CalculatorPanel panel = new CalculatorPanel();
       add(panel);
       
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            Lab6_ass2 frame = new Lab6_ass2();
            frame.setVisible(true);
        });
    }
}
