/*
 * Name: Eratosthenes.java
 * Date: February,20th 2016
 * Version: v0.1
 * Author: Ryan Protheroe
 */
package edu.hdsb.gwss.ryanp.unit1;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Swag God
 */
public class Resistors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String colours[] = {"black", "brown", "red", "orange", "yellow", "green",
            "blue", "violet", "grey", "white"};

        String code;
        String amount = "";
        int ohms;

        //OBJECTS
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the colour code(xxx-xxx-xxx):");
        code = input.nextLine();
        code = code.toLowerCase();

        StringTokenizer st = new StringTokenizer(code, "-");
        while (st.hasMoreTokens()) {
            String colour = st.nextToken();

            switch (colour) {
                case "black":
                    amount = amount.concat("0");
                    break;
                case "brown":
                    amount = amount.concat("1");
                    break;
                case "red":
                    amount = amount.concat("2");
                    break;
                case "orange":
                    amount = amount.concat("3");
                    break;
                case "yellow":
                    amount = amount.concat("4");
                    break;
                case "green":
                    amount = amount.concat("5");
                    break;
                case "blue":
                    amount = amount.concat("6");
                    break;
                case "violet":
                    amount = amount.concat("7");
                    break;
                case "grey":
                    amount = amount.concat("8");
                    break;
                case "white":
                    amount = amount.concat("9");
                    break;

            }

        }
        ohms = Integer.parseInt(amount.substring(0, 2)) * (int) Math.pow(10, Double.parseDouble(amount.substring(2, 3)));
        System.out.println(ohms);

    }

}
