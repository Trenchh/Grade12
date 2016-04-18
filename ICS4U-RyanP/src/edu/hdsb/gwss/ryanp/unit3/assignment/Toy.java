/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit3.assignment;

/**
 *
 * @author 1protheroery
 */
public class Toy {

    //CLASS CONSTANT
   // private static final String MANUFACTURER = Manufacturer.getName();

    //CLASS VARIABLE
    private static int lastIDUsed = 0;

    private String name;
    private int storeID;
    private double price;
    private boolean sold;

    public Toy() {
        this.name = "Toy #" + lastIDUsed++;
        this.sold = false;
        this.storeID = lastIDUsed;
        this.price = 19.99;
    }

    public Toy(String name) {
        this();
        this.name = name;
    }

    public Toy(String name, double price) {
        this(name);
        this.price = price;
    }

    public Toy(String name, int storeID, double price) {
        this(name, price);
        this.storeID = storeID;
    }

}
