/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3_ass1;
import java.util.*;
/**
 *
 * @author Phan Thao
 */
public class CD {
    private String id;
    private String collection;
    private String type;
    private String title;
    private double price;
    private int year;

    public CD(String id, String collection, String type, String title, double price, int year) {
        this.id = id;
        this.collection = collection;
        this.type = type;
        this.title = title;
        this.price = price;
        this.year = year;
    }

    // getters and setters for all fields except id

    public String getId() {
        return id;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "CD{" +
                "id='" + id + '\'' +
                ", collection='" + collection + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", year=" + year +
                '}';
    }

    static Comparator<CD> compareAboutTitle = new Comparator<CD>() {
        @Override
        public int compare(CD o1, CD o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    };
            
}
