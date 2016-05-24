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
    private static final String BELL = "BELL";
    private static final String ROGERS = "ROGERS";
    private static final String TELUS = "TELUS";
    private static final String KOODO = "KOODO";
    private static final String WIND = "WIND";

    //CLASS VARIABLE
    private static int lastIDUsed = 0;

    private String name;
    private int storage;
    private String carrier;
    private double price;
    private int number;
    private String OS;

}
