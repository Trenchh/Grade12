/*
 * Name: EasterComes.java
 * Date: February,10th 2016
 * Version: v0.1
 * Author: Ryan Protheroe
 * Description: Tells you when easter is for every year
 */
package edu.hdsb.gwss.ryanp.unit1;

import java.util.Scanner;

/**
 *
 * @author 1protheroery
 */
public class EasterComes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the year: ");
        int year = input.nextInt();
        
        String monthName = "";
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int j = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * j) / 451;
        int p = (h + j - 7 * m + 114) % 31;
        int month = (h + j - 7 * m + 114) / 31;
        int day = p + 1;

        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;

        }

        System.out.println("Easter is on: " + monthName + ", " + day);

    }

}