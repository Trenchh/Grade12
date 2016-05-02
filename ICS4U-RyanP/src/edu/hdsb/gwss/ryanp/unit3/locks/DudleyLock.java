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
        this.canSet = false;
    }

    public DudleyLock(String name) {
        this();
        this.setName(name);
    }
}
