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
    private static final String[] CONTINENTS = {"NORTH AMERICA", "SOUTH AMERICA", "EUROPE", "ASIA", "ANTARCTICA", "AFRICA", "AUSTRALIA"};
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
        if (this.location > 0 && this.location < 8) {
            return CONTINENTS[location - 1];
        } else {
            return "/NOT SET/";
        }
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
                System.out.println(toy.getName() + " Added");

            }
        }
    }

    public void remove(Toy toy) {
        if (toy.isValid()) {
            if (products.contains(toy)) {
                this.products.remove(toy);
                System.out.println(toy.getName() + " Removed");
            }
        }
    }

    public Toy get(String name) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name.toUpperCase())) {
                return products.get(i);
            }
        }
        return null;
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
