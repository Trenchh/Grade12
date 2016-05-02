/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit3.locks;

/**
 *
 * @author Swag God
 */
public class MasterULock extends Lock {

    // int numberCount = 4;
    private int maxNumber = 9;

    public MasterULock() {
        super(4, 9);
    }

    public MasterULock(String name) {
        this();
        this.setName(name);
    }

    public MasterULock(int num1, int num2, int num3, int num4, String name) {
        this(name);
        this.maxNumber = 9;
        this.setCombo(num1, num2, num3, num4, this.maxNumber);
    }

    public void setCombo(int num1, int num2, int num3, int num4, int maxNumber) {
        if (num1 <= maxNumber && num1 >= 0 && num2 <= maxNumber && num2 >= 0 && num3 <= maxNumber && num3 >= 0 && num4 <= maxNumber && num4 >= 0) {
            this.combonation.add(num1);
            this.combonation.add(num2);
            this.combonation.add(num3);
        }
    }

}
