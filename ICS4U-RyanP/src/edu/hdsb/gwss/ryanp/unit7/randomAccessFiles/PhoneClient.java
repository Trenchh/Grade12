/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit7.randomAccessFiles;

import java.io.RandomAccessFile;

/**
 *
 * @author 1protheroery
 */
import java.io.*;

public class PhoneClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Creating 8 Phone Records");
        PhoneRecord phone1 = new PhoneRecord("Samsung Galaxy S1", 4, 99.99, "ANDROID", "Rogers", '0', true);
        PhoneRecord phone2 = new PhoneRecord("Samsung Galaxy S2", 8, 199.99, "ANDROID", "Koodo", '1', false);
        PhoneRecord phone3 = new PhoneRecord("Samsung Galaxy S3", 16, 299.99, "ANDROID", "Wind", '2', false);
        PhoneRecord phone4 = new PhoneRecord("Samsung Galaxy S4", 32, 399.99, "ANDROID", "Bell", '3', true);
        PhoneRecord phone5 = new PhoneRecord("iPhone 1", 4, 99.99, "IOS", "Rogers", '0', true);
        PhoneRecord phone6 = new PhoneRecord("iPhone 4S", 8, 199.99, "IOS", "Koodo", '2', false);
        PhoneRecord phone7 = new PhoneRecord("iPhone 5", 16, 299.99, "IOS", "Wind", (char) 3, true);
        PhoneRecord phone8 = new PhoneRecord("iPhone 6S", 32, 399.99, "IOS", "Bell", (char) 4, false);
        System.out.println("*********************");

        PhoneStore s = new PhoneStore();
        s.add(phone1);
        s.add(phone2);
        s.add(phone3);
        s.add(phone4);
//        phone4 = s.get(4);
//        System.out.println(phone4.getPhoneID());
//        System.out.println(phone4.toString());
//        phone4.setUnlocked(true);
//        s.update(phone4);

        s.remove(phone1);
        s.remove(phone2);
        s.remove(phone3);
        s.remove(phone4);
        s.get(1);
        s.remove(phone4);
        s.get(4);

        //NOT SURE HOW YOU WANTED REMOVE. I MADE IT SO THAT IF THE ID YOU'RE LOOKING FOR IS REMOVED, IT WILL LOOK FOR THE NEXT ONE THAT ISN'T REMOVED.
        //THE OTHER WAY WOULD JUST HAVE A STATEMENT SAYING THAT THE OBJECT WAS REMOVED...
    }
}
