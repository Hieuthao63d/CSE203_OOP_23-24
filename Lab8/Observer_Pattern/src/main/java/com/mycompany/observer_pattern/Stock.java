/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.observer_pattern;
import java.io.*;
import java.util.*;

/**
 *
 * @author Phan Thao
 */
public interface Stock {
    public void addObserver(Investor investor);
    public void removeObserver(Investor investor);
    public void nitifyInvestors(double priceChange);
}
