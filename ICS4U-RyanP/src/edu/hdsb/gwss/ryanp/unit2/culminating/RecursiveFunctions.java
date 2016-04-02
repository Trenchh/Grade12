/*
 * Name: RecursiveFunctions.java
 * Date: March 23rd, 2016
 * Version: v0.1
 * Author: Ryan Protheroe
 * Description: 
 */
package edu.hdsb.gwss.ryanp.unit2.culminating;

/**
 *
 * @author 1protheroery
 */
public class RecursiveFunctions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("The function returns: " + FunctionOne(5, 3));
        System.out.println("The function returns: " + FunctionOne(2, 2));
        System.out.println("The function returns: " + FunctionOne(1, 4));
        System.out.println("The function returns: " + FunctionOne(-5, -2));
        System.out.println("The function returns: " + FunctionTwo(1, 1));
        System.out.println("The function returns: " + FunctionTwo(2, 1));
        System.out.println("The function returns: " + FunctionTwo(5, 5));
    }

    public static int FunctionOne(int x, int y) {
        if (x < y) {
            return -FunctionOne(y, x);
        } else if (x == y) {
            return 0;
        } else {
            return 1 + FunctionOne((x - 1), y);
        }
    }

    public static int FunctionTwo(int m, int n) {
        if (m == 0) {
            return n + 1;
        } else if (m > 0 & n == 0) {
            return FunctionTwo(m - 1, 1);
        } else {
            return FunctionTwo(m - 1, FunctionTwo(m, n - 1));
        }
    }

}
