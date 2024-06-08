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
        SwingUtilities.invokeLater(() -> {
            CDCollection collection = new CDCollection();
            collection.displayAddCDFrame();
        });
    }
}
