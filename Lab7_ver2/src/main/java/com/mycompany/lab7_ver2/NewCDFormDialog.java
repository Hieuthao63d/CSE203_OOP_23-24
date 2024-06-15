/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab7_ver2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Phan Thao
 */
public class NewCDFormDialog extends JDialog{
    private JTextField titleField, typeField, priceField;
    private JButton saveButton, cancelButton;
    private CD cd;
    private boolean saved;

    public NewCDFormDialog(Frame parent) {
        super(parent, "New CD", true);
        setupForm();
        pack();
        setLocationRelativeTo(parent);
    }

    private void setupForm() {
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Title:"));
        titleField = new JTextField(20);
        add(titleField);

        add(new JLabel("Type:"));
        typeField = new JTextField(20);
        add(typeField);

        add(new JLabel("Price:"));
        priceField = new JTextField(20);
        add(priceField);

        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        add(saveButton);
        add(cancelButton);

        saveButton.addActionListener(e -> saveCD());
        cancelButton.addActionListener(e -> setVisible(false));
    }

    private void saveCD() {
        String title = titleField.getText();
        String type = typeField.getText();
        double price = Double.parseDouble(priceField.getText());

        cd = new CD(title, type, price);
        saved = true;
        setVisible(false);
    }

    public CD getCD() {
        return cd;
    }

    public boolean isSaved() {
        return saved;
    }
}
