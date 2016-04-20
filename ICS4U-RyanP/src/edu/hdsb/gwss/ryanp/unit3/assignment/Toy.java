/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit3.assignment;

import java.text.NumberFormat;
import java.util.Objects;

/**
 *
 * @author 1protheroery
 */
public class Toy {

    NumberFormat money = NumberFormat.getCurrencyInstance();

    //CLASS CONSTANTS
    private static final String[] AGE = {"BABY", "TODDLER", "KID", "TEEN"};
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
    private int toyID;
    private double price;
    private boolean sold;
    private Manufacturer manufacturer;

    public Toy() {
        this.setToyID(toyID);
        this.setName("Toy #" + this.toyID);
        this.sold = false;
        this.setPrice(NOT_SET);
        this.setAgeRange(ageRange);
        this.setModelNumber(modelNumber);
        System.out.println("OBJECT CREATED");
    }

    public Toy(String name) {
        this();
        this.setName(name);
    }

    public Toy(String name, int ageRange, int toyID, double price) {
        this(name);
        this.toyID = toyID;
        this.setPrice(price);
        this.setAgeRange(ageRange);
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

    private int setToyID(int ToyID) {
        this.toyID = ++lastIDUsed;
        return toyID;
    }

    public int getToyID() {
        return toyID;
    }

    private void setModelNumber(String modelNumber) {
        for (int i = 0; i < 9; i++) {
            int r = (int) (Math.random() * 9);
            modelNumber = modelNumber.concat(Integer.toString(r));
        }
        //System.out.println(modelNumber);
        this.modelNumber = modelNumber;
    }

    public double getPrice() {
        if (price <= 0 && price != -1) {
            System.out.println("Price not set");
            return NOT_SET;
        } else {
            return price;
        }
    }

    public void setPrice(double price) {
        if (price == NOT_SET) {
            System.out.println("Price not set");
            this.price = NOT_SET;
        } else if (price <= 0) {
            System.out.println("Invalid price");
        } else {
            this.price = price;
        }
    }

    public int getAgeRange() {
        return ageRange;
    }

    public String getAgeRangeName() {
        if (this.ageRange > 0 && this.ageRange < 5) {
            return AGE[ageRange - 1];
        } else {
            return "/NOT SET/";
        }
    }

    public void setAgeRange(int ageRange) {
        if (ageRange > 0 && ageRange <= 4) {
            this.ageRange = ageRange;
        } else {
            this.ageRange = NOT_SET;
        }
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold, Manufacturer m) {
        this.sold = sold;
    }

    @Override
    public String toString() {
        return "The " + name + " is appropriate for " + getAgeRangeName() + ", it is manufactured by " + manufacturer.getName() + " under the model number " + getModelNumber() + " and has a price of " + money.format(getPrice());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    public boolean equals(Toy toy) {
        if (toy.isValid()) {
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
            if (this.toyID != other.toyID) {
                return false;
            }
            if (!Objects.equals(this.manufacturer, other.manufacturer)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean isValid() {
        if (this.name == null || this.name.length() == 0) {
            System.out.println("Set Name");
            return false;
        }
        if (this.manufacturer == null) {
            System.out.println("Set Manufacturer");
            return false;
        }
        if (this.price <= 0 && this.price != -1) {
            System.out.println("Set Price");
            return false;
        }
        if (this.toyID <= 0) {
            return false;
        }
        if (!this.modelNumber.substring(0, 2).toLowerCase().equals("ae") && this.modelNumber.length() != 11) {
            return false;
        }
        return true;
    }
}
