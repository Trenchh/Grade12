/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit7.randomAccessFiles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
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
            // WHERE ARE WE MOVING?
            if (p.getPhoneID() == -1) {
                raf.seek(raf.length());
                p.setPhoneID((int) (raf.length() / PhoneRecord.RECORD_SIZE) + 1);
            } else {
                raf.seek((p.getPhoneID() - 1) * PhoneRecord.RECORD_SIZE);
            }
            raf.writeBoolean(p.isDeleted());
            raf.writeChars(p.getName());
            raf.writeInt(p.getStorage());
            raf.writeDouble(p.getPrice());
            raf.writeChars(p.getOS());
            raf.writeChars(p.getCarrier());
            raf.writeInt(p.getRating());
            raf.writeBoolean(p.isUnlocked());

        } catch (IOException ex) {
            Logger.getLogger(PhoneStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    private PhoneRecord read(PhoneRecord p) {

        return p;
    }

    public PhoneRecord add(PhoneRecord p) {
        return write(p);
    }

    public PhoneRecord update(PhoneRecord p) {
        return write(p);
    }

    public void remove(PhoneRecord p) {
        try {
            raf.seek((int) p.getPhoneID() * PhoneRecord.RECORD_SIZE);
            p.setDeleted(true);
            raf.writeBoolean(p.isDeleted());
        } catch (IOException ex) {
            Logger.getLogger(PhoneStore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
