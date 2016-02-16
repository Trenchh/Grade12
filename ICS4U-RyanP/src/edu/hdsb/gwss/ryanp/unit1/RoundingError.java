/*
 * Name: RoundingError.java
 * Date: February,10th 2016
 * Version: v0.1
 * Author: Ryan Protheroe
 * Description:
 */
package edu.hdsb.gwss.ryanp.unit1;

import java.util.Scanner;

/**
 *
 * @author Swag God
 */
public class RoundingError {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        double userInput = input.nextDouble();

        System.out.println("The square of the square: " + (Math.sqrt(userInput * userInput)));
        System.out.println("The round off error: " + (((Math.sqrt(userInput * userInput))) - userInput));
    }

}
