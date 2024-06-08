/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.observer_pattern;

/**
 *
 * @author Phan Thao
 */
public class SimpleInvestor implements Investor{
    private String Name;
    private Strategy current Strategy;

    public SimpleInvestor(String Name ) {
        this.Name = Name;
        this.currentStrategy  = Strategy.MonitorOnly;
        
        
    }
    public Strategy addapStrategy(){
        return currentStrategy;
    }
    public void update (String stockSymbol, double priceChange){
        System.out.println(getName() +" was notified by the price change in "+stockSymbol + ": $"+priceChange);
        if(priceChange <50){
            System.out.println(" add change their strategy to "+Strategy.HedgingStrategies);
        }else{
            if(priceChange > 200){
                System.out.println("add change their strategy to "+strategy.Quick);
            }
        }
    }
}
