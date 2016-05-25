/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit7.randomAccessFiles;

import java.text.NumberFormat;

/**
 *
 * @author 1protheroery
 */
public class Phone {

    NumberFormat money = NumberFormat.getCurrencyInstance();

    //CLASS CONSTANTS
    private static final String[] CARRIERS = {"BELL", "ROGERS", "TELUS", "KOODO", "WIND", "VIRGIN"};
    private static final int NOT_SET = -1;

    //CLASS VARIABLE
    private static int lastIDUsed = 0;

    private String name;
    private int storage;
    private String carrier;
    private double price;
    private int phoneID;
    private int number;
    private String OS;

    public Phone() {
        this.setPhoneID();
        this.setName("Phone #" + this.phoneID);
        this.setStorage(NOT_SET);
        this.setCarrier(null);

    }

    public void setNumber(int number) {
        if (Integer.toString(number).length() == 10) {
            this.number = number;
        } else {
            this.number = NOT_SET;
            System.out.println("INVALID NUMBER");
        }
    }

    public int getNumber() {
        if (this.number == NOT_SET) {
            System.out.println("SET NUMBER");
        } else {
            System.out.println("THE NUMBER FOR " + this.name + " IS " + this.number);
        }
        return number;
    }

    public void setCarrier(String carrier) {
        this.carrier = null;
        for (int i = 0; i < CARRIERS.length; i++) {
            if (carrier.toUpperCase().equals(CARRIERS[i])) {
                this.carrier = carrier;
            }
        }
    }

    public String getCarrier() {
        if (this.carrier == null) {
            System.out.println("SET CARRIER");
        }
        return carrier;
    }

    public void setStorage(int amount) {
        if (amount <= 0) {
            this.storage = NOT_SET;
            System.out.println("INVALID AMOUNT");

        } else {
            this.storage = amount;
        }
    }

    public int getStorage() {
        if (storage == NOT_SET) {
            System.out.println("SET AMOUNT OF STORAGE");
        }
        return storage;
    }

    public void setName(String name) {
        if (name == null || name.length() > 20) {
            System.out.println("INVALID NAME");
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    private int setPhoneID() {
        this.phoneID = ++lastIDUsed;
        return phoneID;
    }

    public int getPhoneID() {
        return phoneID;
    }
}
