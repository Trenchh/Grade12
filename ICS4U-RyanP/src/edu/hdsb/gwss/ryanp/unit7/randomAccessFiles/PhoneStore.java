/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit7.randomAccessFiles;

/**
 *
 * @author 1protheroery
 */
import java.io.*;

public class PhoneStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Creating 4 Phone Records");
        PhoneRecord phone1 = new PhoneRecord("Samsung Galaxy S1", 4, 99.99, "ANDROID", "Rogers", (char) 0, false);
        PhoneRecord phone2 = new PhoneRecord("Samsung Galaxy S2", 8, 199.99, "ANDROID", "Koodo", (char) 1, false);
        PhoneRecord phone3 = new PhoneRecord("Samsung Galaxy S3", 16, 299.99, "ANDROID", "Wind", (char) 2, false);
        PhoneRecord phone4 = new PhoneRecord("Samsung Galaxy S4", 32, 399.99, "ANDROID", "Bell", (char) 3, false);
        System.out.println("*********************");

        RandomAccessFile recordFile = new RandomAccessFile("phone_info.dat", "rw");

        //phone 1
        recordFile.seek(0);
        recordFile.writeChars(phone1.getName());
        recordFile.writeInt(phone1.getStorage());
        recordFile.writeDouble(phone1.getPrice());
        recordFile.writeChars(phone1.getOS());
        recordFile.writeChars(phone1.getCarrier());
        recordFile.writeInt(phone1.getRating());

        //phone 2
        recordFile.seek(phone1.RECORD_SIZE);
        recordFile.writeChars(phone2.getName());
        recordFile.writeInt(phone2.getStorage());
        recordFile.writeDouble(phone2.getPrice());
        recordFile.writeChars(phone2.getOS());
        recordFile.writeChars(phone2.getCarrier());
        recordFile.writeInt(phone2.getRating());

        //phone 3
        recordFile.seek(phone1.RECORD_SIZE * 2);
        recordFile.writeChars(phone3.getName());
        recordFile.writeInt(phone3.getStorage());
        recordFile.writeDouble(phone3.getPrice());
        recordFile.writeChars(phone3.getOS());
        recordFile.writeChars(phone3.getCarrier());
        recordFile.writeInt(phone3.getRating());

        //phone 4
        recordFile.seek(phone1.RECORD_SIZE * 3);
        recordFile.writeChars(phone4.getName());
        recordFile.writeInt(phone4.getStorage());
        recordFile.writeDouble(phone4.getPrice());
        recordFile.writeChars(phone4.getOS());
        recordFile.writeChars(phone4.getCarrier());
        recordFile.writeInt(phone4.getRating());

    }
}
