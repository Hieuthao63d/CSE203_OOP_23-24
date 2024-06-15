/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab7_ver2;
import javax.swing.SwingUtilities;
import javax.swing.JFrame; 
/**
 *
 * @author Phan Thao
 */
public class Lab7_ver2 {

    public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> {
            new CDStore().setVisible(true);
        });
    
    }
}
