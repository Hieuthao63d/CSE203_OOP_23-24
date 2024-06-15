/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab7;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Phan Thao
 */
public class CDStoreApp extends JFrame {

    private JTable table;
    private JTextField txtSearch;
    private JButton btnNewCD, btnSearch, btnDelete, btnBackup, btnRestore, btnRefresh;
    private CDCollection cdCollection;
    private CD lastDeletedCD; // To store last deleted CD for restore functionality
    private static final int expectedColumnCount = 6;

    public CDStoreApp() {
        setTitle("CD Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());
        cdCollection = new CDCollection();

        initializeComponents();
        layoutComponents();
        setVisible(true);
    }

    private void initializeComponents() {
        table = new JTable(new DefaultTableModel(new Object[]{"ID","Title", "Collection", "Type", "Price"}, 0));
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        btnNewCD = new JButton("New CD");
        btnBackup = new JButton("Backup");
        btnRestore = new JButton("Restore");
        btnRefresh = new JButton("Refresh");
        btnDelete = new JButton("Delete");
        btnSearch = new JButton("Search");

        txtSearch = new JTextField(10);

        btnNewCD.addActionListener(e -> displayNewCDFrame());
        btnRefresh.addActionListener(e -> refreshCDList());
        btnDelete.addActionListener(e -> deleteCD());
        btnRestore.addActionListener(e -> restoreCD());

        btnSearch.addActionListener(e -> searchCD());
    }

    private void layoutComponents() {
        JPanel topPanel = new JPanel();
        topPanel.add(btnNewCD);
        topPanel.add(btnBackup);
        topPanel.add(btnRestore);
        topPanel.add(btnRefresh);
        topPanel.add(btnDelete);
        add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JLabel("Search:"));
        bottomPanel.add(txtSearch);
        bottomPanel.add(btnSearch);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void displayNewCDFrame() {
        CDAddFrame cdAddFrame = new CDAddFrame(cdCollection);
        cdAddFrame.setVisible(true);
    }

    private void refreshCDList() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clears the table

        try (BufferedReader reader = new BufferedReader(new FileReader("D://CD.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == expectedColumnCount) { // Make sure the data array has the correct length
                    model.addRow(data);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error reading from file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteCD() {
        String title = txtSearch.getText();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0).toString().equalsIgnoreCase(title)) {
                // Save the deleted CD data for restore functionality
                lastDeletedCD = new CD("some-id", model.getValueAt(i, 0).toString(), model.getValueAt(i, 1).toString(), model.getValueAt(i, 2).toString(), Double.parseDouble(model.getValueAt(i, 3).toString()));

                model.removeRow(i);
                break;
            }
        }
    }

    private void restoreCD() {
        if (lastDeletedCD != null) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.addRow(new Object[]{lastDeletedCD.getTitle(), lastDeletedCD.getCollection(), lastDeletedCD.getType(), lastDeletedCD.getPrice()});
            lastDeletedCD = null; // Reset after restoring
        }
    }

    private void searchCD() {
        String searchText = txtSearch.getText().toLowerCase();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(searchText));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CDStoreApp());
    }
}
