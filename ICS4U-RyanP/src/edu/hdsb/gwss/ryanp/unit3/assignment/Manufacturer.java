/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit3.assignment;

import java.text.NumberFormat;
import java.util.ArrayList;

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
    private double sales;
    private boolean inBusiness;
    private ArrayList<Toy> products;

    public Manufacturer() {
        this.products = new ArrayList<Toy>();
        this.inBusiness = true;
        this.factoryID = ++lastIDUsed;
        this.location = NOT_SET;
        this.sales = NOT_SET;
        this.name = "Manufacturer #" + lastIDUsed;
    }

    public Manufacturer(String name) {
        this();
        this.name = name;
    }

    public Manufacturer(String name, int location) {
        this(name);
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getFactoryID() {
        return factoryID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Toy> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return getName() + " is a toy manufacturer ";
    }

    public void add(Toy toy) {
        if (toy.isValid(toy)) {
            if (products.contains(toy)) {
            } else {
                this.products.add(toy);
            }
        }
    }
}
