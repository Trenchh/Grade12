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
    private String ModelNumber;
    private int storeID;
    private double price;
    private boolean sold;
    private Manufacturer manufacturer;

    public Toy() {
        this.storeID = ++lastIDUsed;
        this.setName("Toy #" + this.storeID );
        this.sold = false;
        this.setPrice(-1);
    }

    public Toy(String name) {
        this();
        this.setName(name);
    }

    public Toy(String name, double price) {
        this(name);
        this.setPrice(price);
    }

    public Toy(String name, int storeID, double price) {
        this(name, price);
        this.storeID = storeID;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() > 25) {
            System.out.println("Invalid name");
        } else {
            this.name = name;

        }
    }

    public String getModelNumber() {
        return ModelNumber;
    }

    public void setModelNumber(String ModelNumber) {
        //RANDOMIZER
        this.ModelNumber = ModelNumber;
    }

    public double getPrice() {
        if (price < 0) {
            System.out.println("Price not set");
            return -1;
        } else {
            return price;
        }
    }

    public void setPrice(double price) {
        if (price == -1) {
            System.out.println("Price not set");
        }
        if (price < 0) {
            System.out.println("Invalid price");
        } else {
            this.price = price;
        }
    }

}
