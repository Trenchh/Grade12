/*
 * Name: FiveTerms.java
 * Date: March 21st, 2016
 * Version: v0.1
 * Author: Ryan Protheroe
 * Description: Determines nth term for the sequence
 */
package edu.hdsb.gwss.ryanp.unit2.culminating;

import java.text.DecimalFormat;

/**
 *
 * @author 1PROTHEROERY
 */
public class FiveTerms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        for (int i = 1; i <= 5; i++) {
            if (i < 1) {
                System.out.println("Invalid Input");
            } else {
                System.out.println("Term " + i + ": " + SequenceOne(i));
            }
        }

        System.out.println();

        for (int i = 1; i <= 5; i++) {
            if (i < 1) {
                System.out.println("Invalid Input");
            } else {
                System.out.println("Term " + i + ": " + decimalFormat.format(SequenceTwo(i)));
            }
        }

    }

    public static int SequenceOne(int t) {
        if (t == 1) {
            return 1;
        } else if (t == 2) {
            return 3;
        } else {
            return SequenceOne((t - 1)) + SequenceOne((t - 2));
        }
    }

    public static double SequenceTwo(int t) {
        if (t == 1) {
            return 2;
        } else {
            return Math.sqrt((3 * SequenceTwo(t - 1)) + 4);
        }
    }
}
