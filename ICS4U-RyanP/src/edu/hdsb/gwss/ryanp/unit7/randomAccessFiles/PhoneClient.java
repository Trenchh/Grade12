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
        System.out.println("Creating 4 Phone Records");
        PhoneRecord phone1 = new PhoneRecord("Samsung Galaxy S1", 4, 99.99, "ANDROID", "Rogers", (char) 0, true);
        PhoneRecord phone2 = new PhoneRecord("Samsung Galaxy S2", 8, 199.99, "ANDROID", "Koodo", (char) 1, false);
        PhoneRecord phone3 = new PhoneRecord("Samsung Galaxy S3", 16, 299.99, "ANDROID", "Wind", (char) 2, false);
        PhoneRecord phone4 = new PhoneRecord("Samsung Galaxy S4", 32, 399.99, "ANDROID", "Bell", (char) 3, true);
        PhoneRecord phone5 = new PhoneRecord("iPhone 1", 4, 99.99, "IOS", "Rogers", (char) 0, true);
        PhoneRecord phone6 = new PhoneRecord("iPhone 4S", 8, 199.99, "IOS", "Koodo", (char) 2, false);
        PhoneRecord phone7 = new PhoneRecord("iPhone 5", 16, 299.99, "IOS", "Wind", (char) 3, true);
        PhoneRecord phone8 = new PhoneRecord("iPhone 6S", 32, 399.99, "IOS", "Bell", (char) 4, false);
        System.out.println("*********************");

        System.out.println(phone2.toString());

        PhoneStore store = new PhoneStore();
        store.add(phone2);

        phone1.setUnlocked(false);
        store.update(phone2);

//
//        RandomAccessFile recordFile = new RandomAccessFile("phone_info.dat", "rw");
//
//        //phone 1
//        recordFile.seek(0);
//        recordFile.writeChars(phone1.getName());
//        recordFile.writeInt(phone1.getStorage());
//        recordFile.writeDouble(phone1.getPrice());
//        recordFile.writeChars(phone1.getOS());
//        recordFile.writeChars(phone1.getCarrier());
//        recordFile.writeInt(phone1.getRating());
//        recordFile.writeBoolean(phone1.isUnlocked());
//
//        //phone 2
//        recordFile.seek(phone1.RECORD_SIZE);
//        recordFile.writeChars(phone2.getName());
//        recordFile.writeInt(phone2.getStorage());
//        recordFile.writeDouble(phone2.getPrice());
//        recordFile.writeChars(phone2.getOS());
//        recordFile.writeChars(phone2.getCarrier());
//        recordFile.writeInt(phone2.getRating());
//        recordFile.writeBoolean(phone2.isUnlocked());
//
//        //phone 3
//        recordFile.seek(phone1.RECORD_SIZE * 2);
//        recordFile.writeChars(phone3.getName());
//        recordFile.writeInt(phone3.getStorage());
//        recordFile.writeDouble(phone3.getPrice());
//        recordFile.writeChars(phone3.getOS());
//        recordFile.writeChars(phone3.getCarrier());
//        recordFile.writeInt(phone3.getRating());
//        recordFile.writeBoolean(phone3.isUnlocked());
//
//        //phone 4
//        recordFile.seek(phone1.RECORD_SIZE * 3);
//        recordFile.writeChars(phone4.getName());
//        recordFile.writeInt(phone4.getStorage());
//        recordFile.writeDouble(phone4.getPrice());
//        recordFile.writeChars(phone4.getOS());
//        recordFile.writeChars(phone4.getCarrier());
//        recordFile.writeInt(phone4.getRating());
//        recordFile.writeBoolean(phone4.isUnlocked());
//
//        //phone 5
//        recordFile.seek(phone1.RECORD_SIZE * 4);
//        recordFile.writeChars(phone5.getName());
//        recordFile.writeInt(phone5.getStorage());
//        recordFile.writeDouble(phone5.getPrice());
//        recordFile.writeChars(phone5.getOS());
//        recordFile.writeChars(phone5.getCarrier());
//        recordFile.writeInt(phone5.getRating());
//        recordFile.writeBoolean(phone5.isUnlocked());
//
//        //phone 6
//        recordFile.seek(phone1.RECORD_SIZE * 5);
//        recordFile.writeChars(phone6.getName());
//        recordFile.writeInt(phone6.getStorage());
//        recordFile.writeDouble(phone6.getPrice());
//        recordFile.writeChars(phone6.getOS());
//        recordFile.writeChars(phone6.getCarrier());
//        recordFile.writeInt(phone6.getRating());
//        recordFile.writeBoolean(phone6.isUnlocked());
//
//        //phone 7
//        recordFile.seek(phone1.RECORD_SIZE * 6);
//        recordFile.writeChars(phone7.getName());
//        recordFile.writeInt(phone7.getStorage());
//        recordFile.writeDouble(phone7.getPrice());
//        recordFile.writeChars(phone7.getOS());
//        recordFile.writeChars(phone7.getCarrier());
//        recordFile.writeInt(phone7.getRating());
//        recordFile.writeBoolean(phone7.isUnlocked());
//
//        //phone 8
//        recordFile.seek(phone1.RECORD_SIZE * 7);
//        recordFile.writeChars(phone8.getName());
//        recordFile.writeInt(phone8.getStorage());
//        recordFile.writeDouble(phone8.getPrice());
//        recordFile.writeChars(phone8.getOS());
//        recordFile.writeChars(phone8.getCarrier());
//        recordFile.writeInt(phone8.getRating());
//        recordFile.writeBoolean(phone8.isUnlocked());
    }

}
