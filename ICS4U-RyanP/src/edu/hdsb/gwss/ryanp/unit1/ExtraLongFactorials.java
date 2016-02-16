/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit1;

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

        for (BigInteger i = userInput.subtract(BigInteger.ONE); i.compareTo(BigInteger.ZERO) > 0; i = i.subtract(BigInteger.ONE)) {
            userInput = userInput.multiply(i);
        }

        System.out.println(userInput);

    }

}
