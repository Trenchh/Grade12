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
public class Android extends Lock {

    public Android() {
        super(3, 9);
    }

    public Android(String name) {
        this();
        this.setName(name);
    }

    public Android(int num1, int num2, int num3, String name) {
        this(name);
        this.maxNumber = 9;
        this.setCombo(num1, num2, num3);
    }
}
