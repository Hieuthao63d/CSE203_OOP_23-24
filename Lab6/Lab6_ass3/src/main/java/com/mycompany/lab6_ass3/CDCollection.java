/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6_ass3;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author Phan Thao
 */
public class CDCollection {
    private List<CD> cds = new ArrayList<>();
    private JFrame addCDFrame;
    public CDCollection() {
        
        addCDFrame = new CDAddFrame(this);
    }

    public void addCD(CD cd) {
        cds.add(cd);
    }
    public void displayAddCDFrame(){
        addCDFrame.setVisible(true);
    }
    
    public CD searchByTitle(String title) {
        int index = Collections.binarySearch(cds, new CD("", "", "", title, 0, 0), CD.compareAboutTitle);
        if (index != -1) {
            return cds.get(index);
        } else {
            return null;
        }
    }

    public List<CD> searchByCollection(String collection) {
        List<CD> result = new ArrayList<>();
        for (CD cd : cds) {
            if (cd.getCollection().equals(collection)) {
                result.add(cd);
            }
        }
        return result;
    }

    public List<CD> searchByType(String type) {
        List<CD> result = new ArrayList<>();
        for (CD cd : cds) {
            if (cd.getType().equals(type)) {
                result.add(cd);
            }
        }
        return result;
    }

    public boolean deleteById(String id) {
        return cds.removeIf(cd -> cd.getId().equals(id));
    }

    public CD editById(String id, String collection, String type, String title, double price, int year) {
        for (CD cd : cds) {
            if (cd.getId().equals(id)) {
                cd.setCollection(collection);
                cd.setType(type);
                cd.setTitle(title);
                cd.setPrice(price);
                cd.setYear(year);
                return cd;
            }
        }
        return null;
    }

    public void displayAll() {
        for (CD cd : cds) {
            System.out.println(cd);
        }
    }

    public void sort() {
        cds.sort(Comparator.comparing(CD::getYear));
    }

    public void displayMenu() {
        System.out.println("1. Add CD");
        System.out.println("2. Search CD by CD title");
        System.out.println("3. Search CDs by collection");
        System.out.println("4. Search CDs by type");
        System.out.println("5. Delete CD by CD Id");
        System.out.println("6. Edit CD information by Id");
        System.out.println("7. Display all CDs");
        System.out.println("8. Sort the CD list ascending by year of release");
        System.out.println("9. Exit");
    }

    public void handleOption(String option, Scanner scanner) {
        switch (option) {
            case "1":
                // Add CD
                System.out.print("Enter CD id, collection, type, title, price, year: ");
                String id = scanner.next();
                String collection = scanner.next();
                String type = scanner.next();
                String title = scanner.next();
                double price = scanner.nextDouble();
                int year = scanner.nextInt();
                addCD(new CD(id, collection, type, title, price, year));
                break;
            case "2":
                // Search CD by CD title
                System.out.print("Enter CD title to search: ");
                title = scanner.next();
                CD cd = searchByTitle(title);
                if (cd != null) {
                    System.out.println("Found CD: " + cd);
                } else {
                    System.out.println("CD not found.");
                }
                break;
            case "3":
                // Search CDs by collection
                System.out.print("Enter collection to search: ");
                collection = scanner.next();
                List<CD> cds = searchByCollection(collection);
                System.out.println("Found CDs: " + cds);
                break;
            case "4":
                // Search CDs by type
                System.out.print("Enter type to search: ");
                type = scanner.next();
                cds = searchByType(type);
                System.out.println("Found CDs: " + cds);
                break;
            case "5":
                // Delete CD by CD Id
                System.out.print("Enter CD id to delete: ");
                id = scanner.next();
                boolean deleted = deleteById(id);
                if (deleted) {
                    System.out.println("Deleted CD.");
                } else {
                    System.out.println("CD not found.");
                }
                break;
            case "6":
                // Edit CD information by Id
                System.out.print("Enter CD id to edit, and new collection, type, title, price, year: ");
                id = scanner.next();
                collection = scanner.next();
                type = scanner.next();
                title = scanner.next();
                price = scanner.nextDouble();
                year = scanner.nextInt();
                cd = editById(id, collection, type, title, price, year);
                if (cd != null) {
                    System.out.println("Edited CD: " + cd);
                } else {
                    System.out.println("CD not found.");
                }
                break;
            case "7":
                // Display all CDs
                displayAll();
                break;
            case "8":
                // Sort the CD list ascending by year of release
                sort();
                System.out.println("Sorted CDs: ");
                displayAll();
                break;
            case "9":
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }
}
