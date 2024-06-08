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
    private JTextField txtID, txtTitle, txtPrice, txtYear;
    private JComboBox<String> cbCollection;
    private JRadioButton rbVCD, rbCD;
    private ButtonGroup typeGroup;
    private JButton btnAdd, btnClear, btnShowAll;

    public CDAddFrame(CDCollection collection) {
        setTitle("PhanThao_CD Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        initializeComponents();
        layoutComponents();
        setVisible(true);
    }

    private void initializeComponents() {
        txtID = new JTextField(10);
        txtTitle = new JTextField(10);
        txtPrice = new JTextField(10);
        txtYear = new JTextField(10);

        String[] collections = {"movie", "music", "game"};
        cbCollection = new JComboBox<>(collections);

        rbVCD = new JRadioButton("VCD", true);
        rbCD = new JRadioButton("CD");
        typeGroup = new ButtonGroup();
        typeGroup.add(rbVCD);
        typeGroup.add(rbCD);

        btnAdd = new JButton("Add");
        btnClear = new JButton("Clear");
        btnShowAll = new JButton("Show All");
    }

    private void layoutComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("CD ID:"), gbc);
        gbc.gridy++;
        add(new JLabel("CD Title:"), gbc);
        gbc.gridy++;
        add(new JLabel("CD Collection:"), gbc);
        gbc.gridy++;
        add(new JLabel("CD Type:"), gbc);
        gbc.gridy++;
        add(new JLabel("CD Price:"), gbc);
        gbc.gridy++;
        add(new JLabel("CD Year of Release:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(txtID, gbc);
        gbc.gridy++;
        add(txtTitle, gbc);
        gbc.gridy++;
        add(cbCollection, gbc);
        gbc.gridy++;
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        radioPanel.add(rbVCD);
        radioPanel.add(rbCD);
        add(radioPanel, gbc);
        gbc.gridy++;
        add(txtPrice, gbc);
        gbc.gridy++;
        add(txtYear, gbc);

        // Button layout in the same row
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy++;
        add(btnAdd, gbc);
        gbc.gridx++;
        add(btnClear, gbc);
        gbc.gridx++;
        add(btnShowAll, gbc);
    }

    public static void main(String[] args) {
        new CDAddFrame(new CDCollection());
    }
}
