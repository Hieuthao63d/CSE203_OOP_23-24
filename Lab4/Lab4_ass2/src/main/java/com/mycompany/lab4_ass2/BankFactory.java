/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4_ass2;

/**
 *
 * @author Phan Thao
 */
public class BankFactory {
    public static Bank getBank (BankType bankType){
        switch (bankType) {
            case TPBANK:
                return new TPBank();
            case VIETCOMBANK:
                return new VietcomBank();
            default:
                throw new IllegalArgumentException("This bank type is unsupported");
        }
        
    }
    
}
