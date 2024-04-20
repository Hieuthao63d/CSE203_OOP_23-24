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
        
        //Q3
        //Q3 hs = new Q3(10);
        //List<Integer> sequence = hs.calculateSquence();
        //System.out.println(sequence);
        
        //Q4
        /*int[]array = {1,2,3,4,5,6,7,8,9,10};
        Q4 evenSum = new Q4(array);
        int sum = evenSum.calculateSum();
        System.out.println(sum);*/
        
        //Q5
        /*ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(3);
        array.add(1);
        array.add(3);
        array.add(2);
        array.add(4);

        Q5 operations = new Q5(array);

        System.out.println("Original array: " + operations.array);

        boolean removed = operations.removeFirstSpeElement(1);
        System.out.println("Removed 1: " + removed + ", array: " + operations.array);

        operations.insertAtSpePosition(5, 2);
        System.out.println("Inserted 5 at position 2: " + operations.array);

        List<Integer> duplicates = operations.findDuplicate();
        System.out.println("Duplicates: " + duplicates);

        operations.removeDuplicate();
        System.out.println("Array after removing duplicates: " + operations.array);*/
        
        //Q6
        Q6 operations = new Q6("thao");

        System.out.println(operations.getLength());

        System.out.println(operations.countWord());

        System.out.println( operations.concatenate(" 2131200020"));

        System.out.println(operations.isPalindrome());
    }
   }

