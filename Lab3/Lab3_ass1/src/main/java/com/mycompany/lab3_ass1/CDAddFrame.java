/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3_ass1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Phan Thao
 */
public class CDAddFrame extends JFrame  {
    private JTextField txtID,txtTitle,txtCollection,txtType,txtPrice,txtYear;
    private JButton btnAdd, btnClear;
    
    public CDAddFrame ( CDCollection collection){
        setTitle("Add New CD");
        setSize(300,300);
        setLayout(new GridLayout(7,2,5,5));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        txtID = new JTextField();
        txtTitle = new JTextField();
        txtCollection = new JTextField();
        txtType = new JTextField();
        txtPrice = new JTextField();
        txtYear = new JTextField();
        
        btnAdd = new JButton("Add");
        btnClear = new JButton("Clear");
        
        add(new JLabel("CD ID:"));
        add(txtID);
        add(new JLabel("CD Title:"));
        add(txtTitle);
        add(new JLabel("CD Collection:"));
        add(txtCollection);
        add(new JLabel("CD Type:"));
        add(txtType);
        add(new JLabel("CD Price:"));
        add(txtPrice);
        add(new JLabel("Year of Release:"));
        add(txtYear);
        add(btnAdd);
        add(btnClear);
        
        btnAdd.addActionListener(e -> {
            try{
                String id = txtID.getText();
                String title = txtTitle.getText();
                String collectionName = txtCollection.getText();
                String type = txtType.getText();
                double price = Double.parseDouble(txtPrice.getText());
                int year = Integer.parseInt(txtYear.getText());
                
                if(title.isEmpty()){
                    JOptionPane.showMessageDialog(this, "CD title cannot be empty.","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                CD newCD = new CD(id,collectionName,type,title,price,year);
                collection.addCD(newCD);
                JOptionPane.showMessageDialog(this, "CD added successfully.");
                clearFields();
                
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Price and Year must be valid number.","Error",JOptionPane.ERROR_MESSAGE);
                
            }
            
        });
        
        btnClear.addActionListener(e -> clearFields());
    }
        private void clearFields(){
            txtID.setText("");
            txtTitle.setText("");
            txtCollection.setText("");
            txtType.setText("");
            txtPrice.setText("");
            txtYear.setText("");
        
    }
}
