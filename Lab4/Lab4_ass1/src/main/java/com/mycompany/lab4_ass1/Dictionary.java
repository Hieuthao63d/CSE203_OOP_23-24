/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4_ass1;
import java.util.Scanner;
import java.util.HashMap;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.Duration;
/**
 *
 * @author Phan Thao
 */
public class Dictionary {
    private TreeMap<String, String> map; 

    
    public Dictionary(String filePath) {
        map = new TreeMap<>(); 
        // map = new HashMap<>(); 
        Instant from = Instant.now();
        try {
            loadWords(filePath);
        } catch (IOException e) {
            System.out.println("Error loading dictionary: " + e.getMessage());
        }
        Instant to = Instant.now();
        System.out.println("Milliseconds to load dictionary: " + Duration.between(from, to).toMillis());
    }

    private void loadWords(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",", 2);
            if (parts.length == 2) {
                map.put(parts[0], parts[1]);
            }
        }
        reader.close();
    }

    public boolean wordExists(String word) {
        return map.containsKey(word);
    }

    public String getMeaning(String word) {
        return map.get(word);
    }
}
