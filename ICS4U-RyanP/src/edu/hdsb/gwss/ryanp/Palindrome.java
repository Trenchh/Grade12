/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp;

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

        //OBJECTS
        Scanner input = new Scanner(System.in);

        //DESCRIPTION OF PROGRAM
        System.out.println(" Palindrome ");
        System.out.println();
        System.out.println("This program will reverse the word entered and check if it is a palindrome");
        System.out.println();

        //USER INPUT
        System.out.println("Please enter a word: ");
        word = input.next();
        length = word.length();
        System.out.println();

        word = word.toLowerCase();
        for (int index = 0; index <= length; index++) {
            //palindrome.
            
        }

    }
}
