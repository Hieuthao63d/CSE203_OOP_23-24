/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3_ass1;

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
    
    @Override
    public String toString(){
        return "CD{" +
                "id='" + id + '\'' +
                ", collection='" + collection + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", year=" + year +
                '}';
    }
            
}
