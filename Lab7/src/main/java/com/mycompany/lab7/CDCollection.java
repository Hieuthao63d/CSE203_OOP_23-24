/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab7;
import java.util.*;
/**
 *
 * @author Phan Thao
 */
public class CDCollection {
    private List<CD> cds;

    public CDCollection() {
        cds = new ArrayList<>();
    }

    public boolean addCD(CD cd) {
        return cds.add(cd);
    }

    public boolean deleteById(String id) {
        return cds.removeIf(cd -> cd.getId().equals(id));
    }
}
