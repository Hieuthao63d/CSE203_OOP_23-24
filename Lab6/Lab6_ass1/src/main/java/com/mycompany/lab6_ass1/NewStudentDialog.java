/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6_ass1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Phan Thao
 */
public class NewStudentDialog extends JDialog{
    private JTextField studentId, lastName, midName, firstName, yearOfBirth;
    private JRadioButton male, female;
    private JComboBox<String> schoolStage;
    private JButton btnSave, btnClear, btnCancel;
    private StudentManager studentManager;

    public NewStudentDialog(Frame parent, StudentManager studentManager) {
        super(parent, "New Student", true);
        this.studentManager = studentManager;
        setSize(300, 400);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(6, 1));

        addStudentIDPanel();
        addNamePanel();
        addYearOfBirthAndGenderPanel();
        addSchoolStagePanel();
        addControlPanel();
    }

    private void addStudentIDPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Student ID:"));
        studentId = new JTextField(20);
        panel.add(studentId);
        this.add(panel);
    }

    private void addNamePanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Last-Mid-First name:"));
        lastName = new JTextField(10);
        midName = new JTextField(10);
        firstName = new JTextField(10);
        panel.add(lastName);
        panel.add(midName);
        panel.add(firstName);
        this.add(panel);
    }

    private void addYearOfBirthAndGenderPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Year of Birth and Gender:"));
        yearOfBirth = new JTextField(10);
        panel.add(yearOfBirth);
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        panel.add(male);
        panel.add(female);
        this.add(panel);
    }

    private void addSchoolStagePanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("School Stage:"));
        String[] data = {"Elementary School", "Middle School", "High School"};
        schoolStage = new JComboBox<>(data);
        panel.add(schoolStage);
        this.add(panel);
    }

    private void addControlPanel() {
        JPanel panel = new JPanel();
        btnSave = new JButton("Save");
        btnSave.addActionListener(this::saveStudent);
        btnClear = new JButton("Clear");
        btnClear.addActionListener(e -> clearForm());
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(e -> setVisible(false));
        panel.add(btnSave);
        panel.add(btnClear);
        panel.add(btnCancel);
        this.add(panel);
    }

    private void saveStudent(ActionEvent e) {
        String id = studentId.getText();
        String last = lastName.getText();
        String mid = midName.getText();
        String first = firstName.getText();
        int yOb = Integer.parseInt(yearOfBirth.getText());
        String gender = male.isSelected() ? "Male" : "Female";
        String school = (String) schoolStage.getSelectedItem();

        Student newStudent = new Student(id, last, mid, first, yOb, gender, school);
        if (studentManager.addStudent(newStudent)) {
            JOptionPane.showMessageDialog(this, "Student added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Error: Student ID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        studentId.setText("");
        lastName.setText("");
        midName.setText("");
        firstName.setText("");
        yearOfBirth.setText("");
        schoolStage.setSelectedIndex(0);
        male.setSelected(true);
    }
}

