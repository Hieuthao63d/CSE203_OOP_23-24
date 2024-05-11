/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab3_ass1;
import java.util.*;
/**
 *
 * @author Phan Thao
 */
public class Lab3_ass1 {

    public static void main(String[] args) {
        CDCollection cdCollection = new CDCollection();
        Scanner scanner = new Scanner(System.in);
        String option = "";

        while (!option.equals("9")) {
            System.out.println("1. Add CD");
            System.out.println("2. Search CD by CD title");
            System.out.println("3. Search CDs by collection");
            System.out.println("4. Search CDs by type");
            System.out.println("5. Delete CD by CD Id");
            System.out.println("6. Edit CD information by Id");
            System.out.println("7. Display all CDs");
            System.out.println("8. Sort the CD list ascending by year of release");
            System.out.println("9. Exit");
            System.out.print("Enter your option: ");
            option = scanner.nextLine();

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
                    cdCollection.addCD(new CD(id, collection, type, title, price, year));
                    break;
                case "2":
                    // Search CD by CD title
                    System.out.print("Enter CD title to search: ");
                    title = scanner.next();
                    CD cd = cdCollection.searchByTitle(title);
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
                    List<CD> cds = cdCollection.searchByCollection(collection);
                    System.out.println("Found CDs: " + cds);
                    break;
                case "4":
                    // Search CDs by type
                    System.out.print("Enter type to search: ");
                    type = scanner.next();
                    cds = cdCollection.searchByType(type);
                    System.out.println("Found CDs: " + cds);
                    break;
                case "5":
                    // Delete CD by CD Id
                    System.out.print("Enter CD id to delete: ");
                    id = scanner.next();
                    boolean deleted = cdCollection.deleteById(id);
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
                    cd = cdCollection.editById(id, collection, type, title, price, year);
                    if (cd != null) {
                        System.out.println("Edited CD: " + cd);
                    } else {
                        System.out.println("CD not found.");
                    }
                    break;
                case "7":
                    // Display all CDs
                    cdCollection.displayAll();
                    break;
                case "8":
                    // Sort the CD list ascending by year of release
                    cdCollection.sort();
                    System.out.println("Sorted CDs: ");
                    cdCollection.displayAll();
                    break;
                case "9":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
