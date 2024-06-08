/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6_ass1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.util.*;
import java.util.ArrayList;
import java.io.*;


/**
 *
 * @author Phan Thao
 */
public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    public boolean addStudent(Student stu) {
        for (Student s : students) {
            if (s.getStudentID().equals(stu.getStudentID())) {
                return false; // Student ID already exists
            }
        }
        students.add(stu);
        saveStudentToFile("D://Student.Dat");
        return true;
    }

    public Student findStudentById(String studentID) {
        for (Student s : students) {
            if (s.getStudentID().equals(studentID)) {
                return s;
            }
        }
        return null; // No student found
    }

    public ArrayList<Student> getListStudent() {
        return students;
    }

    public StudentTableModel getStudentTableModel() {
        return new StudentTableModel(students);
    }
    public void removeStudent(int index) {
        if (index >= 0 && index < students.size()) {
            students.remove(index);
        }
        
    }
    public void saveStudentToFile ( String filename){
        File file = new File (filename);
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdir();
        }
        try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))){
            out.writeObject(students);
        }catch (IOException e){
            System.err.println("Error saving students: "+e.getMessage());
        }
    }
    public void loadStudentFromeFile (String filename){
        File file = new File(filename);
        if(file.exists()){
           try(ObjectInputStream in = new ObjectInputStream ( new FileInputStream(filename))){
            students = (ArrayList<Student>)in.readObject();
            
        }catch (ClassNotFoundException | IOException e){
            System.err.println("Error loading students: "+e.getMessage());
        } 
        }
        
    }
}
