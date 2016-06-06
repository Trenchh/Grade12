/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit7.randomAccessFiles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1protheroery
 */
public class PhoneStore {

    private RandomAccessFile raf;

    public PhoneStore() {
        this.open();
    }

    private void open() {
        try {
            this.raf = new RandomAccessFile("phone.dat", "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PhoneStore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void close() throws IOException {
        this.raf.close();
    }

    private PhoneRecord write(PhoneRecord p) {
        try {
            if (p.getPhoneID() == -1) {
                raf.seek(raf.length());
                p.setPhoneID((int) (raf.length() / PhoneRecord.RECORD_SIZE) + 1);
            } else {
                raf.seek((p.getPhoneID() - 1) * PhoneRecord.RECORD_SIZE);
            }
            raf.writeBoolean(p.isDeleted());
            raf.writeChars("|");
            raf.writeChars(p.getName());
            raf.writeChars("|");
            raf.writeBytes(Integer.toString(p.getStorage()));
            raf.writeChars("|");
            raf.writeBytes(Double.toString(p.getPrice()));
            raf.writeChars("|");
            raf.writeChars(p.getOS());
            raf.writeChars("|");
            raf.writeChars(p.getCarrier());
            raf.writeChars("|");
            raf.writeBytes(Integer.toString(p.getRating()));
            raf.writeChars("|");
            raf.writeBoolean(p.isUnlocked());
            raf.writeChars("||");

        } catch (IOException ex) {
            Logger.getLogger(PhoneStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    public PhoneRecord read(long recordNumber) throws IOException {
        PhoneRecord tmp = new PhoneRecord();

        long numRecords = raf.length() / PhoneRecord.RECORD_SIZE;

        while (recordNumber != 0) {
            long position = PhoneRecord.RECORD_SIZE * (recordNumber - 1);
            raf.seek(position);

            while (raf.readBoolean() == true) {
                recordNumber++;
                position = PhoneRecord.RECORD_SIZE * (recordNumber - 1);
                raf.seek(position);
            }
            position = position + 4;
            raf.seek(position);
            System.out.println(raf.readLine().substring(0, PhoneRecord.LENGTH_NAME));

            tmp.setName(raf.readLine().substring(0, PhoneRecord.LENGTH_NAME));
            position = position + tmp.LENGTH_NAME;
            raf.seek(position);
            tmp.setStorage(raf.readInt());

            return tmp;
        }
        return null;
    }

    public PhoneRecord add(PhoneRecord p) {
        return write(p);
    }

    public PhoneRecord get() throws IOException {
        Scanner input = new Scanner(System.in);
        long numRecords = raf.length() / PhoneRecord.RECORD_SIZE;
        System.out.println("\nThere are " + numRecords + " records currently in the file.");

        System.out.println("Which record do you want [1 - " + numRecords + "] or 0 to exit?");
        long recordNumber = input.nextLong();
        return read(recordNumber);
    }

    public PhoneRecord update(PhoneRecord p) {
        return write(p);
    }

    public void remove(PhoneRecord p) {
        try {
            raf.seek((int) p.getPhoneID() * PhoneRecord.RECORD_SIZE);
            p.setDeleted(true);
            this.write(p);
        } catch (IOException ex) {
            Logger.getLogger(PhoneStore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
