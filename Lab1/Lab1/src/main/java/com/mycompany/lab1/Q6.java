/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1;

/**
 *
 * @author Phan Thao
 */
public class Q6 {

    public Q6() {
    }

    public Q6(String str) {
        this.str = str;
    }
    private String str;
    
    public int getLength(){
        return str.length();
    }
    public int countWord(){
        String[] word = str.split("\\s+");
        return word.length;
       
    }
    public String concatenate(String otherStr){
        return str + otherStr;
    }
    public boolean isPalindrome(){
        int i=0, j = str.length()-1;
        while (i<j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
                
            }
            i++;
            j++;
            
        }
        return true;
    }
}
