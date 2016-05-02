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
public class LockClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MasterLock masterLock = new MasterLock("MasterLock");
        DudleyLock dudley = new DudleyLock();
        Android android = new Android(3, 8, 5, "android");
        MasterULock masterULock = new MasterULock();

        dudley.getCombonation();
        dudley.getCombonation();
        dudley.getName();
        masterLock.getCombonation();
        android.getCombonation();
        android.setCombo(2, 3, 4);
        android.getCombonation();
    }
}
