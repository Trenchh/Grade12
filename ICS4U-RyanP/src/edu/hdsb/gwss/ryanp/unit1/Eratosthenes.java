/*
 * Name: Eratosthenes.java
 * Date: February,18th 2016
 * Version: v0.1
 * Author: Ryan Protheroe
 */
package edu.hdsb.gwss.ryanp.unit1;

import java.util.ArrayList;

/**
 *
 * @author 1protheroery
 */
public class Eratosthenes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //VARIABLES
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        int number;
        boolean result = true;
        int count = 0;

        System.out.println("The prime numbers from 1 - 1000 are:");
        
        for (int i = 0; i < 1000; i++) {
        
            number = i + 1;
            
        
        }
        
        
        

//        for (int i = 0; i < 1000; i++) {
//            number = i + 1;
//
//            for (int k = 2; k < number; k++) {
//                if (number % k == 0) {
//                    result = false;
//                    break;
//                }
//            }
//            if (result = true) {
//                numbers.add(number);
//            }
//        }
//        for (int i = 0; i < 1000; i++) {
//            System.out.print(numbers.toArray()[i] + ", ");
//        }
    }

}
