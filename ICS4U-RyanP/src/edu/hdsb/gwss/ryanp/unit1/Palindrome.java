/*
 * Name: RoundingError.java
 * Date: February,10th 2016
 * Version: v0.1
 * Author: Ryan Protheroe
 */
package edu.hdsb.gwss.ryanp.unit1;

import java.util.Scanner;

/**
 *
 * @author 1protheroery
 */
public class Palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //VARIABLES
        String word;
        String palindrome;
        int length = 0;
        int yesOrNo = 0;

        //OBJECTS
        Scanner input = new Scanner(System.in);

        //DESCRIPTION OF PROGRAM
        System.out.println(" Palindrome ");
        System.out.println();
        System.out.println("This program will reverse the word entered and check if it is a palindrome");
        System.out.println();

        //USER INPUT
        System.out.println("Please enter a word: ");
        word = input.nextLine();
        length = word.length();
        word = word.toLowerCase();
        palindrome = word;
        System.out.println();

        //CHECKS EACH LETTER TO SEE IF IT MATCHES LETTER AT CORRESPONDING INDEX
        for (int index = 0; index < length; index++, length--) {
            if (palindrome.substring(index, index + 1).equals(palindrome.substring(length - 1, length))) {
                yesOrNo = 1;
                System.out.println("yee");

            } else {
                yesOrNo = 2;
                System.out.println("nah");
                break;
            }
        }
        if (yesOrNo == 1) {
            System.out.println(word + " is a palindrome");
        } else {
            System.out.println(word + " is not a palindrome");
        }
    }
}
