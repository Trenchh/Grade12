/*
 * Name: PascalsTriangle.java
 * Date: March 23rd, 2016
 * Version: v0.1
 * Author: Ryan Protheroe
 * Description: Displays pascals triangle
 */
package edu.hdsb.gwss.ryanp.unit2.culminating;

/**
 *
 * @author 1protheroery
 */
public class PascalsTriangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        row(7);
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
                System.out.print(term(k, col) + " ");
            }
            

            System.out.println();
        }

    }
}
