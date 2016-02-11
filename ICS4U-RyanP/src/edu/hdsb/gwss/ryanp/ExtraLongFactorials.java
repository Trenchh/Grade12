/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Swag God
 */
public class ExtraLongFactorials {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BigInteger userInput;
        BigInteger one = new BigInteger("1");
        BigInteger zero = new BigInteger("0");

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        userInput = input.nextBigInteger();

        for (BigInteger i = userInput; i.compareTo(BigInteger.ZERO) > 0; i = i.subtract(BigInteger.ONE)) {
            System.out.println(i);
            userInput = userInput.add(userInput.multiply(i));
        }

        System.out.println(userInput);

    }

}
