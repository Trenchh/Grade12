/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit3.assignment;

import java.util.ArrayList;

/**
 *
 * @author 1protheroery
 */
public class Manufacturer {

    private static final int = 0;
    
    private static int locationNumber = 0;

    private String name;
    private int location;
    private double sales;
    private boolean inBusiness;
    public ArrayList<String[][]> products = new ArrayList<String[][]>();

    public Manufacturer() {
        this.inBusiness = true;
        this.location = locationNumber++;
        this.sales = 0;
        this.name = "Toy Store #" + locationNumber;
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

    public void setName(String name) {
        this.name = name;
    }
    
    
}
