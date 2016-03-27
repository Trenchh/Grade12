/*
 * Name: PascalsTriangle.java
 * Date: March 23rd, 2016
 * Version: v0.1
 * Author: Ryan Protheroe
 * Description: Displays pascals triangle up decided row
 */
package edu.hdsb.gwss.ryanp.unit2.culminating;

import java.util.Scanner;

/**
 *
 * @author 1protheroery
 */
public class PascalsTriangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter how many rows you would like to display?");
        int display = input.nextInt();

        row(display);
    }

    public static int term(int row, int col) {
        if (row < 2 || col == 0 || col == row) {
            return 1;
        } else {
            return term(row - 1, col) + term(row - 1, col - 1);
        }
    }

    public static void row(int row) {
        for (int k = 0; k < row; k++) {
            for (int col = 0; col < (k + 1); col++) {
                System.out.println(term(k, col) + " ");
            }
            System.out.println();
        }

    }
}
