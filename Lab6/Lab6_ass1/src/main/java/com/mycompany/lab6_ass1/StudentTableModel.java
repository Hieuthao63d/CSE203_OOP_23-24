/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6_ass1;
import javax.swing.table.AbstractTableModel;
import java.util.List;
/**
 *
 * @author Phan Thao
 */
public class StudentTableModel extends AbstractTableModel {
    private final List<Student> students;
    private final String[] columnNames = {"Student ID", "First Name", "Last Name", "Gender", "School Stage"};

    public StudentTableModel(List<Student> students) {
        this.students = students;
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);
        switch (columnIndex) {
            case 0: return student.getStudentID();
            case 1: return student.getFirstName();
            case 2: return student.getLastName();
            case 3: return student.getGender();
            case 4: return student.getSchoolStage();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
