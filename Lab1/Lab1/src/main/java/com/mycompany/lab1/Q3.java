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
public class Q3 {

    public Q3() {
    }

    public Q3(int n) {
        this.n = n;
    }
    private int n;
    public List<Integer> calculateSquence(){
        List<Integer>sequence = new ArrayList<>();
        while (n!=1){
            sequence.add(n);
            if (n%2==0){
                n=n/2;
                
            }else{
                n= n*3+1;
            }
        }
        sequence.add(n);
        return sequence;
        
    }
    
    
}
