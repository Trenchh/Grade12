/*
 * Name: SimpleEncryption.java
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
        String cryption = " ";
        int amount;
        String tmp;
        int indexInArray = 0;
        int crypt = 0;
        int choice;

        //OBJECTS
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        System.out.println("Press 1 to decrypt or 2 to encrypt?");
        choice = input2.nextInt();
        System.out.println();

        System.out.println("Please enter a word or sentence: ");
        word = input.nextLine();
        length = word.length();
        word = word.toLowerCase();
        System.out.println();

        System.out.println("Enter the encryption/decryption amount: ");
        amount = input.nextInt();
        System.out.println();

        //ENCRYPTION
        if (choice == 2) {
            for (int index = 0; index < length; index++) {

                if (word.substring(index, index + 1).equals(" ")) {
                    cryption = cryption.concat(" ");
                } else {
                    tmp = word.substring(index, index + 1);
                    for (int i = 0; i <= alphabet.length - 1; i++) {
                        if (tmp.equals(alphabet[i])) {
                            crypt = i + amount;
                        }
                    }
                    while ((crypt) > 25) {
                        crypt = crypt - 26;
                    }
                    cryption = cryption.concat(alphabet[crypt]);
                }
            }
        } else {
            for (int index = 0; index < length; index++) {
                if (word.substring(index, index + 1).equals(" ")) {
                    cryption = cryption.concat(" ");
                } else {
                    tmp = word.substring(index, index + 1);

                    for (int i = 0; i <= alphabet.length - 1; i++) {
                        if (tmp.equals(alphabet[i])) {
                            crypt = i - amount;
                        }
                    }
                    while ((crypt) < 0) {
                        crypt = crypt + 26;
                    }
                    cryption = cryption.concat(alphabet[crypt]);
                }
            }
        }
        System.out.println(cryption);
    }
}
