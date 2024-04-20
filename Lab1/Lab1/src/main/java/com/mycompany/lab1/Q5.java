/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1;
import java.util.*;

/**
 *
 * @author Phan Thao
 */
public class Q5 {

    public Q5(ArrayList<Integer> array) {
        this.array = array;
    }

    public Q5() {
    }
    public ArrayList<Integer>array;
    
    public boolean removeFirstSpeElement(int element){
        if(array.contains(element)){
            array.remove(Integer.valueOf(element));
            return true;
        }
        return false;
    }
    public void insertAtSpePosition(int element, int position){
        if (position < array.size()){
            array.add(position,element);
            array.remove(array.size()-1);
            
        }
    }
    public List<Integer> findDuplicate(){
        Set<Integer>uniqueElement = new HashSet<>();
        List<Integer> duplicate = new ArrayList<>();
        for (int num:array){
            if(!uniqueElement.add(num)){
                if(!duplicate.contains(num)){
                    duplicate.add(num);
                }
            }
        }
        return duplicate;
    }
    public void removeDuplicate(){
        Set<Integer> uniqueElement = new HashSet<>(array);
        array.clear();
        array.addAll(uniqueElement);
    }
}
