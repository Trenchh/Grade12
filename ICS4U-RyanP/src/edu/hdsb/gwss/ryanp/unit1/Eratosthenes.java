/*
 * Name: Eratosthenes.java
 * Date: February,18th 2016
 * Version: v0.1
 * Author: Ryan Protheroe
 */
package edu.hdsb.gwss.ryanp.unit1;

//import java.util.ArrayList;
/**
 *
 * @author 1protheroery
 */
public class Eratosthenes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //VARIABLES
        boolean numbers[] = new boolean[1000];

        //ArrayList<Integer> numbers = new ArrayList<Integer>();
        //int number = 0;
        boolean result = true;
        int count = 0;

        System.out.println("The prime numbers from 1 - 1000 are:");

        for (int i = 2; i < numbers.length - 1; i++) {
            numbers[i] = true;
        }

        for (int j = 2; j < 1000; j++) {

            if (numbers[j] == true) {
                for (int k = 2; k <= 1000; k++) {
                    int multiple = j * k;

                    if (multiple < 999) {
                        numbers[multiple] = false;
                    } else {
                        break;
                    }
                }
            }
        }
        for (int p = 0; p < numbers.length - 1; p++) {
            if (numbers[p] == true) {
                if (count < 10) {
                    System.out.print(p + ", ");
                    count++;
                } else {
                    System.out.println(p);
                    count = 0;
                }

            }
        }
    }
}

//        for (int i = 0; i < 1000; i++) {
//            number = i + 1;
//
//            for (int k = 2; k < number; k++) {
//                if (number % k == 0) {
//                    result = false;
//                    break;
//                }
//            }
//            if (result == true) {
//                numbers.add(number);
//            }
//        }
//        for (int i = 0; i < numbers.size(); i++) {
//            System.out.print(numbers.toArray()[i] + ", ");
//        }
//    }
//}
