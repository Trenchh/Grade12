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

    public PhoneStore() throws FileNotFoundException {
        this.open();
    }

    private void open() throws FileNotFoundException {
        this.raf = new RandomAccessFile("phone.dat", "rw");
    }

    private void close() throws IOException {
        this.raf.close();
    }

    private PhoneRecord write(PhoneRecord p) throws IOException {
        if (p.getPhoneID() == -1) {
            raf.seek(raf.length());
            p.setPhoneID(((int) (raf.length() / PhoneRecord.RECORD_SIZE) + 1));
        } else {
            raf.seek((p.getPhoneID() - 1) * PhoneRecord.RECORD_SIZE);
        }
        raf.writeBoolean(p.isDeleted());
        raf.writeChars(p.getName());
        raf.writeInt(p.getStorage());
        raf.writeDouble(p.getPrice());
        raf.writeChars(p.getOS());
        raf.writeChars(p.getCarrier());
        raf.writeChar(p.getRating());
        raf.writeBoolean(p.isUnlocked());
        return p;
    }

    public PhoneRecord read(long recordNumber) throws IOException {

        if (this.isEmpty() == false) {
            PhoneRecord tmp = new PhoneRecord();
            tmp.setPhoneID((int) recordNumber);

            long position = PhoneRecord.RECORD_SIZE * (recordNumber - 1);
            raf.seek(position);

            while (raf.readBoolean() == true) {
                recordNumber++;
                position = PhoneRecord.RECORD_SIZE * (recordNumber - 1);
                raf.seek(position);
            }
            
            char phoneName[] = new char[PhoneRecord.LENGTH_NAME];
            for (int i = 0; i < PhoneRecord.LENGTH_NAME; i++) {
                phoneName[i] = raf.readChar();
            }
            tmp.setName(new String(phoneName));
            tmp.setStorage(raf.readInt());
            tmp.setPrice(raf.readDouble());
            char OSName[] = new char[PhoneRecord.LENGTH_OS];
            for (int i = 0; i < PhoneRecord.LENGTH_OS; i++) {
                OSName[i] = raf.readChar();
            }
            tmp.setOS(new String(OSName));
            char carrierName[] = new char[PhoneRecord.LENGTH_CARRIER];
            for (int i = 0; i < PhoneRecord.LENGTH_CARRIER; i++) {
                carrierName[i] = raf.readChar();
            }
            tmp.setCarrier(new String(carrierName));
            tmp.setRating(raf.readChar());
            tmp.setUnlocked(raf.readBoolean());
            System.out.println(tmp.toString());
            return tmp;
        }
        System.out.println("THE FILE IS EMPTY");
        return null;
    }

    public PhoneRecord add(PhoneRecord p) throws IOException {
        System.out.println("ADDED: " + p.getName());
        return write(p);
    }

    public PhoneRecord get(long recordNumber) throws IOException {
        return read(recordNumber);
    }

    public PhoneRecord update(PhoneRecord p) throws IOException {
        return write(p);
    }

    public PhoneRecord remove(PhoneRecord p) throws IOException {
        System.out.println("REMOVED: " + p.getName());
        p.setDeleted(true);
        return this.write(p);
    }

    private boolean isEmpty() throws IOException {
        long numRecords = raf.length() / PhoneRecord.RECORD_SIZE;
        long recordNumber = numRecords;
        long position = PhoneRecord.RECORD_SIZE * (recordNumber - 1);
        raf.seek(position);
        while (raf.readBoolean() == true && recordNumber > 0) {
            recordNumber--;
            if (recordNumber > 0) {
                position = PhoneRecord.RECORD_SIZE * (recordNumber - 1);
                raf.seek(position);
            }
        }
        if (recordNumber == 0) {
            return true;
        } else {
            return false;
        }

    }

}
