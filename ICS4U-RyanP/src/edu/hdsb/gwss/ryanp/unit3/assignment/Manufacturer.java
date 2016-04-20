/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit3.assignment;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author 1protheroery
 */
public class Manufacturer {

    NumberFormat money = NumberFormat.getCurrencyInstance();

    //CLASS CONSTANTS
    private static final int NORTH_AMERICA = 1;
    private static final int SOUTH_AMERICA = 2;
    private static final int EUROPE = 3;
    private static final int ASIA = 4;
    private static final int ANTARCTICA = 5;
    private static final int AFRICA = 6;
    private static final int AUSTRALIA = 7;
    private static final int NOT_SET = -1;

    private static int lastIDUsed = 0;

    private String name;
    private int factoryID;
    private int location;
    private boolean inBusiness;
    private ArrayList<Toy> products;

    public Manufacturer() {
        this.products = new ArrayList<Toy>();
        this.inBusiness = true;
        this.setFactoryID(factoryID);
        this.setLocation(NOT_SET);
        this.setName("Manufacturer #" + lastIDUsed);
    }

    public Manufacturer(String name) {
        this();
        this.name = name;
    }

    public Manufacturer(String name, int location, int factoryID) {
        this(name);
        this.location = location;
        this.factoryID = factoryID;
    }

    public void setName(String name) {
        if (name == null || name.length() > 25) {
            System.out.println("Invalid name");
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        if (location > 0 && location < 8) {
            this.location = location;
        } else {
            this.location = NOT_SET;
        }
    }

    public String locationName() {
        if (this.location == 1) {
            return "NORTH AMERICA";
        } else if (this.location == 2) {
            return "SOUTH AMERICA";
        } else if (this.location == 3) {
            return "EUROPE";
        } else if (this.location == 4) {
            return "ASIA";
        } else if (this.location == 5) {
            return "ANTARCTICA";
        } else if (this.location == 6) {
            return "AFRICA";
        } else if (this.location == 7) {
            return "AUSTRALIA";
        }
        return "/NOT SET/";
    }

    public boolean isInBusiness() {
        return inBusiness;
    }

    public void setInBusiness(boolean inBusiness) {
        this.inBusiness = inBusiness;
    }

    private int setFactoryID(int factoryID) {
        this.factoryID = ++lastIDUsed;
        return factoryID;
    }

    public int getFactoryID() {
        return factoryID;
    }

    public ArrayList<Toy> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return getName() + " is a toy manufacturer located in " + locationName();
    }

    public void add(Toy toy) {
        if (toy.isValid()) {
            if (!products.contains(toy)) {
                this.products.add(toy);
                System.out.println("Toy Added");

            }
        }
    }

    public void remove(Toy toy) {
        if (toy.isValid()) {
            if (products.contains(toy)) {
                this.products.remove(toy);
                System.out.println("Toy Removed");

            }
        }
    }

    public String get(Toy toy) {
        if (toy.isValid()) {
            if (products.contains(toy)) {
                return toy.toString();
            }
        }
        return "NOT FOUND";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    public boolean equals(Manufacturer man) {
        if (man == null) {
            return false;
        }
        if (getClass() != man.getClass()) {
            return false;
        }
        final Manufacturer other = (Manufacturer) man;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.factoryID != other.factoryID) {
            return false;
        }
        if (this.location != other.location) {
            return false;
        }
        if (!Objects.equals(this.products, other.products)) {
            return false;
        }
        return true;
    }

    public boolean isValid() {
        if (this.name == null || this.name.length() == 0) {
            System.out.println("Set Name");
            return false;
        }
        if (this.location <= 0 && this.location != -1) {
            System.out.println("Set Location");
            return false;
        }
        if (this.factoryID <= 0) {
            return false;
        }
        return true;
    }
}
