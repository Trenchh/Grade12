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

    public MasterULock() {
        super(4, 9);
    }
    
    
//    public void setCombo(int num1, int num2, int num3, int num4) {
//        if (this instanceof MasterULock) {
//            if (num4 <= this.maxNumber && num4 >= 0) {
//                super.setCombo(num1, num2, num3);
//                if (this.canSet == true) {
//                    this.combination.remove(3);
//                    this.combination.add(num4);
//                }
//            } else {
//                System.out.println("INVALID 4TH NUMBER");
//            }
//        }
//    }
}
