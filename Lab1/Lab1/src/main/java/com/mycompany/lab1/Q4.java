/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1;

/**
 *
 * @author Phan Thao
 */
public class Q4 {

    public Q4(int[] array) {
        this.array = array;
    }

    public Q4() {
    }
    private int[]array;
    public int calculateSum(){
        int sum=0;
        for(int num:array){
            if (num %2==0){
                sum+=num;
            }
        }
        return sum;
    }
    
}
