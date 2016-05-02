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
public class DudleyLock extends Lock {
    //int numberCount = 3;
    private int maxNumber = 59;

    public DudleyLock() {
        super(3, 59);
    }

    public DudleyLock(String name) {
        this();
        this.name = name;
    }

    public DudleyLock(int num1, int num2, int num3, String name) {
        this(name);
        this.setCombo(num1, num2, num3, maxNumber);
    }
}
