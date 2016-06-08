/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit7.randomAccessFiles;

import java.io.Serializable;
import java.text.NumberFormat;

/**
 *
 * @author 1protheroery
 */
public class PhoneRecord {

    NumberFormat money = NumberFormat.getCurrencyInstance();

    //CLASS CONSTANTS
    public static final int RECORD_SIZE = 95;
    protected static final int LENGTH_CARRIER = 10;
    protected static final int LENGTH_OS = 10;
    protected static final int LENGTH_NAME = 20;
//  private static final String[] CARRIERS = {"BELL", "ROGERS", "TELUS", "KOODO", "WIND", "VIRGIN"};
    //private static final String[] RATING = {"5 STARS", "4 STARS", "3 STARS", "2 STARS", "1 STAR", "0 STARS"};
    private static final int NOT_SET = -1;

    private char rating;
    private String name;
    private int storage;
    private String carrier;
    private double price;
    private int phoneID;
    //private int number;
    private String OS;
    private boolean unlocked;
    private boolean deleted;

    public PhoneRecord() {
        this.deleted = false;
        this.setPhoneID(NOT_SET);
        this.setName("Phone #" + this.phoneID);
        this.setStorage(NOT_SET);
        this.setCarrier(null);
        this.unlocked = false;
        //this.setNumber(NOT_SET);
        this.setOS(null);
        this.setRating((char) 0);
    }

    public PhoneRecord(String name, int storage, double price) {
        this();
        this.setName(name);
        this.setStorage(storage);
        this.setPrice(price);
    }

    public PhoneRecord(String name, int storage, double price, String os, String carrier, char rating, boolean unlocked) {
        this(name, storage, price);
        this.setOS(os);
        //this.setNumber(number);
        this.setCarrier(carrier);
        this.setRating(rating);
        this.setUnlocked(unlocked);
    }

    public boolean isDeleted() {
        return this.deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public char getRating() {
        if (this.rating == ' ') {
            System.out.println("SET RATING");
        } else {
            return this.rating;
        }
        return ' ';
    }

    public void setRating(char rating) {
        if (rating <= '5' && rating >= '0') {
            this.rating = rating;
        } else {
            this.rating = ' ';
        }
    }

    public double getPrice() {
        if (this.price == NOT_SET) {
            System.out.println("SET PRICE");
        }
        return this.price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            this.price = NOT_SET;
        } else {
            this.price = price;
        }
    }

    public String getOS() {
        return this.OS;
    }

    public void setOS(String OS) {
        StringBuilder temp = new StringBuilder();
        if (OS != null) {
            temp.append(OS.trim());
        } else {
            temp.append("TBD");
        }
        temp.setLength(LENGTH_OS);
        this.OS = temp.toString();
    }
//    public void setNumber(int number) {
//        if (Integer.toString(number).length() == 10) {
//            this.number = number;
//        } else {
//            this.number = NOT_SET;
//        }
//    }
//
//    public int getNumber() {
//        if (this.number == NOT_SET) {
//        } else {
//            System.out.println("THE NUMBER FOR " + this.name + " IS " + this.number);
//        }
//        return number;
//    }

    public void setCarrier(String carrier) {
        StringBuilder temp = new StringBuilder();

        if (carrier != null) {
            temp.append(carrier.trim());
        } else {
            temp.append("TBD");
        }
        temp.setLength(LENGTH_CARRIER);
        this.carrier = temp.toString();
    }

    public String getCarrier() {
        if (this.carrier == null) {
        }
        return this.carrier;
    }

    public void setStorage(int amount) {
        if (amount <= 0) {
            this.storage = NOT_SET;
        } else {
            this.storage = amount;
        }
    }

    public int getStorage() {
        if (this.storage == NOT_SET) {
            System.out.println("SET AMOUNT OF STORAGE");
        }
        return this.storage;
    }

    public void setName(String name) {
        StringBuilder temp = new StringBuilder();
        if (name != null) {
            temp.append(name.trim());
        } else {
            temp.append("TBD");
        }
        temp.setLength(LENGTH_NAME);
        this.name = temp.toString();
    }

    public String getName() {
        return this.name;
    }

    protected void setPhoneID(int phoneID) {
        this.phoneID = phoneID;
    }

    public int getPhoneID() {
        return this.phoneID;
    }

    public boolean isUnlocked() {
        return this.unlocked;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    @Override
    public String toString() {
        return this.getName() + "{" + "rating=" + this.getRating() + ", storage=" + this.getStorage() + ", carrier=" + this.getCarrier() + ", price=" + money.format(getPrice()) + ", phoneID=" + this.getPhoneID() + ", OS=" + this.getOS() + ", unlocked=" + this.isUnlocked() + '}';
    }

}
