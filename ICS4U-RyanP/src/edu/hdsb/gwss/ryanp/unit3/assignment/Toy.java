/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit3.assignment;

import java.util.Objects;

/**
 *
 * @author 1protheroery
 */
public class Toy {

    //CLASS CONSTANTS
    private static final int BABY = 1;
    private static final int TODDLER = 2;
    private static final int KID = 3;
    private static final int TEEN = 4;
    private static final int NOT_SET = -1;

    //CLASS VARIABLE
    private static int lastIDUsed = 0;

    private String name;
    private int ageRange;
    private String modelNumber = "AE";
    private int storeID;
    private double price;
    private boolean sold;
    private Manufacturer manufacturer;

    public Toy() {
        this.storeID = ++lastIDUsed;
        this.setName("Toy #" + this.storeID);
        this.sold = false;
        this.setPrice(NOT_SET);
        this.ageRange = KID;
        this.setModelNumber(modelNumber);
        System.out.println("OBJECT CREATED");
    }

    public Toy(String name) {
        this();
        this.setName(name);
    }
//
//    public Toy(String name, double price) {
//        this(name);
//        this.setPrice(price);
//    }
//
//    public Toy(String name, int storeID, double price) {
//        this(name, price);
//        this.storeID = storeID;
//    }

    public Toy(String name, int ageRange, int storeID, double price) {
        // this(name, storeID, price);
        this(name);
        this.storeID = storeID;
        this.price = price;
        this.ageRange = ageRange;
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
        return modelNumber;
    }

    private void setModelNumber(String modelNumber) {
        for (int i = 0; i < 9; i++) {
            int r = (int) (Math.random() * 9);
            modelNumber = modelNumber.concat(Integer.toString(r));
        }
        System.out.println(modelNumber);
        this.modelNumber = modelNumber;
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
        } else if (price <= 0) {
            System.out.println("Invalid price");
        } else {
            this.price = price;
        }
    }

    public String getAgeRange() {
        if (this.ageRange == 1) {
            return "BABY";
        } else if (this.ageRange == 1) {
            return "TODDLER";
        } else if (this.ageRange == 1) {
            return "KID";
        } else if (this.ageRange == 1) {
            return "TEEN";
        }
        return "INVALID";
    }

    public void setAgeRange(int ageRange) {
        this.ageRange = ageRange;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    @Override
    public String toString() {
        return "The " + name + " is appropriate for " + getAgeRange() + ", it is manufactured by " + manufacturer + " under the model number of " + modelNumber + "and has a price of " + price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    public boolean equals(Toy toy) {
        if (toy == null) {
            return false;
        }
        if (getClass() != toy.getClass()) {
            return false;
        }
        final Toy other = (Toy) toy;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.modelNumber, other.modelNumber)) {
            return false;
        }
        if (this.storeID != other.storeID) {
            return false;
        }
        if (this.sold != other.sold) {
            return false;
        }
        if (!Objects.equals(this.manufacturer, other.manufacturer)) {
            return false;
        }
        return true;
    }

    public boolean isValid(Toy toy) {
        if (this.name != null) {
            return true;
        }
        if (this.manufacturer != null) {
            return true;
        }
        if (this.price != 0) {
            return true;
        }
        if (this.storeID <= storeID && this.storeID >= 0) {
            return true;
        }
        if (this.modelNumber.substring(0, 2).toLowerCase().equals("ae") && this.modelNumber.length() == 11) {
            return true;
        }
        if (ageRange <= 4 && ageRange > 0) {
            return true;
        }
        return false;
    }

}
