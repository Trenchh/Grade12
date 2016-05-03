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
public interface LockInterface {

    ArrayList<Integer> getCombonation();

    void setCombo(int num1, int num2, int num3);

    void setCombo(int num1, int num2, int num3, int num4);

    int getSerialNumber();

    void lock();

    void unlock(int num1, int num2, int num3);

    void unlock(int num1, int num2, int num3, int num4);
}
