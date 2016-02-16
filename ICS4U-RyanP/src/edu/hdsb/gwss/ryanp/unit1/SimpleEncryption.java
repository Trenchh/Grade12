/*
 * Name: RoundingError.java
 * Date: February,16th 2016
 * Version: v0.1
 * Author: Ryan Protheroe
 */
package edu.hdsb.gwss.ryanp.unit1;

import java.util.Scanner;

/**
 *
 * @author 1protheroery
 */
public class SimpleEncryption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //VARIABLES
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
            "x", "y", "z"};
        String word;
        int length;
        String encryption = " ";
        int amount;
        String tmp;
        int indexInArray = 0;

        //OBJECTS
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a word or sentence to be encrypted: ");
        word = input.nextLine();
        length = word.length();
        word = word.toLowerCase();
        System.out.println("Enter the decryption amount: ");
        amount = input.nextInt();

        for (int index = 0; index < length; index++) {

            tmp = word.substring(index, index + 1);

            for (int i = 0; i <= alphabet.length - 1; i++) {
                if (tmp.equals(alphabet[i])) {
                    indexInArray = i;
                } else {
                }
            }
            encryption = encryption.concat(alphabet[(indexInArray + amount)]);
        }
        System.out.println(encryption);
    }

}
