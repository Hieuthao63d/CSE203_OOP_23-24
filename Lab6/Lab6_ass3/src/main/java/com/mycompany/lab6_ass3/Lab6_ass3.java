/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab6_ass3;
import java.util.*;
import javax.swing.SwingUtilities;
/**
 *
 * @author Phan Thao
 */
public class Lab6_ass3 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CDCollection collection = new CDCollection();
            collection.displayAddCDFrame();
        });
    }
}
