/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit3.locks;

import java.util.ArrayList;

/**
 *
 * @author Swag God
 */
public abstract class Lock {

    protected String name;
    private static int lastIDUsed = 0;
    private int serialNumber;
    private boolean lockValid;
    private boolean open;
    protected boolean canSet;
    protected ArrayList<Integer> combonation = new ArrayList<Integer>();
    private int counter = 0;
    private int attempts;

    public Lock() {
        this.lockValid = true;
        this.open = false;
        this.serialNumber = ++lastIDUsed;
        this.name = "LOCK #" + this.serialNumber;
        System.out.println(this.name + " created");
    }

    public Lock(int numberCount, int maxNumber) {
        this();
        for (int i = 0; i < numberCount; i++) {
            this.combonation.add((int) (Math.random() * maxNumber));
        }
        System.out.println("Combonation set");
    }

    public ArrayList<Integer> getCombonation() {
        if (this.counter == 0) {
            this.counter++;
            System.out.println(this.combonation);
            return this.combonation;
        }
        System.out.println("Combonation can't be retrieved again");
        return null;
    }

    public String getName() {
        System.out.println("The name of this lock is " + this.name);
        return this.name;
    }

    public void setCombo(int num1, int num2, int num3, int maxNumber) {
        if (this.canSet == true) {
            if (num1 < maxNumber && num1 >= 0 && num2 < maxNumber && num2 >= 0 && num3 < maxNumber && num3 >= 0) {
                this.combonation.add(num1);
                this.combonation.add(num2);
                this.combonation.add(num3);
            }
        } else {
            System.out.println("You can not change the combonation on this lock");

        }
    }

//    public void open(int num1, int num2, int num3) {
//        
//        
//    }
}
