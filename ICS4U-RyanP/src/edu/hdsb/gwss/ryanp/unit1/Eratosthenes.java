/*
 * Name: Eratosthenes.java
 * Date: February,18th 2016
 * Version: v0.1
 * Author: Ryan Protheroe
 */
package edu.hdsb.gwss.ryanp.unit1;

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
        boolean numbers[] = new boolean[1000];
        int index = 0;
        int number;

        System.out.println("The prime numbers from 1 - 1000 are:");

        for (int i = 0; i < 1000; i++) {
            number = i + 1;
            numbers[i] = true;

            for (int k = 2; k < number; k++) {
                if (number % k != 0) {
                    numbers[i] = false;
                }
            }
            if (numbers[i] = false) {
                System.out.print(number + ", ");
            }

        }

    }

}
