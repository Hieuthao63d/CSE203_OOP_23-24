/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab1;

import java.util.*;

/**
 *
 * @author Phan Thao
 */
public class Lab1 {

    public static void main(String[] args) {
        //Q1
        //System.out.println(new Q1(123456).SumFirstLastDigit());
        
        //Q2
        //Q2 q2Object = new Q2(1, 2, 3);
        //System.out.println(q2Object.findMinimum());
        
         // Hiển thị kết quả các phép tính
        Q3 hs = new Q3(10);
        List<Integer> sequence = hs.calculateSquence();
        System.out.println(sequence);
   }
}
