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

        //System.out.println(phone2.getRating());
        //System.out.println(phone2.toString());
        PhoneStore store = new PhoneStore();
        // phone2.setDeleted(true);
        store.add(phone1);
        // phone1.setUnlocked(false);
        // store.update(phone1);
        store.add(phone2);
        store.get(1);
        store.get(2);
        phone1.setUnlocked(false);
        store.update(phone1);
        store.get(1);
    }
}
