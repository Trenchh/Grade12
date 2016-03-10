/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp;

import java.util.StringTokenizer;

/**
 *
 * @author 1protheroery
 */
public class TestReview {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double dub = 1.5;
        int integer = 6;

        String stringName = "Niagara Falls";
        System.out.println(stringName.substring(8, stringName.length()));

        System.out.println();

        String str = "First, Second, Third, 1, 2, 3";
        StringTokenizer x = new StringTokenizer(str, " ,");
        while (x.hasMoreTokens()) {
            System.out.println(x.nextToken());
        }
        System.out.println();

        System.out.println((int) dub);

        System.out.println();

        String str1 = "Centimetres = ";
        double dist = 100 * 2.54;
        str1 += dist;
        System.out.println(str1);

        System.out.println();

        int test1[] = {21, 23, 22, 20, 23, 18, 19, 15, 24};
        int test2[] = {32, 31, 30, 34, 20, 13, 29, 26, 33};
        int test3[] = {13, 10, 13, 10, 13, 14, 15, 11, 10};
        int results[][] = {test1, test2, test3};
        int total = 0;
        for (int row = 0; row < results.length; row++) {
            total += results[row][3];
        }
        System.out.println(total);

        System.out.println();

        System.out.println(Math.ceil(-8.1923));

        System.out.println();

        System.out.println(Math.floor(8.1923));

        System.out.println();

        System.out.println("ICS4U".equals("ics4u"));

        System.out.println();

        double y = (Math.pow(integer - 4, 2) * 2) + 0.5;
        System.out.println(y);

        System.out.println();

        String school = "Garth Webb Secondary School";
        System.out.println(school.substring(school.indexOf(" ") + 1));

        System.out.println();

        int test4[] = {21, 23, 22, 20, 23, 18, 19, 15, 24};
        int test5[] = {32, 31, 30, 34, 20, 13, 29, 26, 33};
        int test6[] = {13, 10, 13, 10, 13, 14, 15, 11, 10};
        int results1[][] = {test4, test5, test6};
        int total1 = 0;
        for (int row = 0; row < results.length; row++) {
            for (int col = 1; col < 3; col++) {
                total += results[row][col];
            }
        }
        System.out.println(total);

    }

}
