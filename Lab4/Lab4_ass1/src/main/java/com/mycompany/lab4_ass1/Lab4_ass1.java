/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
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
public class Lab4_ass1 {

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary("D:\\word.txt"); 
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a word to look up (type 'exit' to quit): ");
            String input = scanner.nextLine().toLowerCase();
            if ("exit".equals(input)) {
                break;
            }

            Instant from = Instant.now(); // Start timing
            if (dictionary.wordExists(input)) {
                Instant to = Instant.now(); // End timing
                System.out.println("Meaning of '" + input + "': " + dictionary.getMeaning(input));
                System.out.println("Time taken to search (milliseconds): " + Duration.between(from, to).toMillis());
            } else {
                Instant to = Instant.now(); // End timing
                System.out.println("Word '" + input + "' does not exist in the dictionary.");
                System.out.println("Time taken to search (milliseconds): " + Duration.between(from, to).toMillis());
            }
        }

        scanner.close();
    }
}
