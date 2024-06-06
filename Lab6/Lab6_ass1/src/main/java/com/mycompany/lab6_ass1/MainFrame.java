/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6_ass1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Phan Thao
 */
public class MainFrame extends JFrame {
    private StudentManager studentManager;
    private JTable studentTable;
    private JScrollPane scrollPane;

    public MainFrame(StudentManager studentManager) {
        this.studentManager = studentManager;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Student Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton btnNewStudent = new JButton("New Student");
        btnNewStudent.addActionListener(e -> {
            NewStudentDialog dialog = new NewStudentDialog(this, studentManager);
            dialog.setVisible(true);
        });

        JButton btnCheckTotal = new JButton("Check Total Student");
        btnCheckTotal.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                "Total Students: " + studentManager.getListStudent().size(),
                "Total Students", JOptionPane.INFORMATION_MESSAGE);
        });

        JButton btnRefresh = new JButton("Refresh Table");
        btnRefresh.addActionListener(e -> refreshTable());

        buttonPanel.add(btnNewStudent);
        buttonPanel.add(btnCheckTotal);
        buttonPanel.add(btnRefresh);

        add(buttonPanel, BorderLayout.NORTH);

        studentTable = new JTable(studentManager.getStudentTableModel());
        scrollPane = new JScrollPane(studentTable);
        add(scrollPane, BorderLayout.CENTER);

        studentTable.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    deleteSelectedStudent();
                }
            }
        });
    }

    private void refreshTable() {
        studentTable.setModel(studentManager.getStudentTableModel());
    }

    private void deleteSelectedStudent() {
        int row = studentTable.getSelectedRow();
        if (row >= 0 && JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this student?", "Confirm Deletion", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            studentManager.removeStudent(row);
            refreshTable();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame(new StudentManager()).setVisible(true);
        });
    }
}