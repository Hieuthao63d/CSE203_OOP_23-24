/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab7_ver2;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Phan Thao
 */
public class CDStore extends JFrame{
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton addButton, deleteButton, refreshButton;
    private List<CD> cdList;

    public CDStore() {
        super("CD Store");
        cdList = new ArrayList<>();
        setupUI();
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void setupUI() {
        setLayout(new BorderLayout());

        // Table setup
        String[] columnNames = {"Title", "Type", "Price"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Buttons setup
        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Add CD");
        deleteButton = new JButton("Delete CD");
        refreshButton = new JButton("Refresh");
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Button actions
        addButton.addActionListener(e -> {
            NewCDFormDialog dialog = new NewCDFormDialog(this);
            dialog.setVisible(true);
            if (dialog.isSaved()) {
                CD newCD = dialog.getCD();
                cdList.add(newCD);
                addCDToTable(newCD);
            }
        });

        deleteButton.addActionListener(e -> deleteSelectedCD());
        refreshButton.addActionListener(e -> refreshTable());
    }

    private void addCDToTable(CD cd) {
        Object[] rowData = {cd.getTitle(), cd.getType(), cd.getPrice()};
        tableModel.addRow(rowData);
    }

    private void deleteSelectedCD() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            tableModel.removeRow(selectedRow);
            cdList.remove(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a CD to delete.");
        }
    }

    private void refreshTable() {
        tableModel.setRowCount(0); // Clear the table
        for (CD cd : cdList) {
            addCDToTable(cd);
        }
    }
}
