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
public class CDCollection {
    private List<CD> cds;

    public CDCollection() {
        this.cds = new ArrayList<>();
    }

    public void addCD(CD cd) {
        cds.add(cd);
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
}
