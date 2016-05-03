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
        // TEST #1: DudleyLock
        // PRE-CONDTION:
        //      - none
        // POST-CONDTION:
        //      - its locked
        //      - has serialnumber 1
        //      - has preset combo
        System.out.println("----------------------------------------------------");
        System.out.println("Test #1 - DudleyLock");
        //combo prints when instantiated
        DudleyLock dudley = new DudleyLock();
        //should say that it is already locked
        dudley.lock();
        dudley.getSerialNumber();

        // TEST #2: MasterLock
        // PRE-CONDTION:
        //      - none
        // POST-CONDTION:
        //      - its locked
        //      - has serialnumber 2
        //      - has preset combo
        System.out.println("----------------------------------------------------");
        System.out.println("Test #2 - MasterLock");
        //combo prints when instantiated
        MasterLock masterLock = new MasterLock();
        //should print that it is already locked
        masterLock.lock();
        masterLock.getSerialNumber();

        // TEST #3: Retrieving/setting combination
        // PRE-CONDTION:
        //      - none
        // POST-CONDTION:
        //      - retrieve combination once
        //      - wil not retrieve a 2nd time
        System.out.println("----------------------------------------------------");
        System.out.println("Test #3 - Retrieving/setting combination");
        dudley.getCombonation();
        //should print "can not retrieve again"
        dudley.getCombonation();
        //should print that you cant change combos on the locks
        dudley.setCombo(3, 4, 5);
        masterLock.setCombo(3, 4, 5);
        //combination shouldnt change from when instantiated
        masterLock.getCombonation();

        // TEST #4: unlock
        // PRE-CONDTION:
        //      - none
        // POST-CONDTION:
        //      - can't unlock because the combo is random everytime(its possible i get the numbers right
        //      - lock will brick after 3 attempts
        //      - nothing else will work
        System.out.println("----------------------------------------------------");
        System.out.println("Test #4 - Unlock");
        dudley.unlock(1, 2, 3);
        dudley.unlock(5, 19, 21);
        dudley.unlock(4, 6, 1);
        dudley.unlock(6, 6, 6);
        dudley.getCombonation();
        dudley.lock();

        // TEST #5: MasterULock
        // PRE-CONDTION:
        //      - none
        // POST-CONDTION:
        //      - should have random combo
        //      - will set combo
        //      - shouldnt set when using set(int,int,int);
        //      - shouldnt unlock when using unlock(int,int,int);
        System.out.println("----------------------------------------------------");
        System.out.println("Test #5 - MasterULock");
        MasterULock masterULock = new MasterULock();
        masterULock.setCombo(1, 2, 3);
        masterULock.getCombonation();
        MasterULock m = new MasterULock();
        m.setCombo(1, 2, 3, 4);
        m.setCombo(3, 5, 6);
        m.getCombonation();
        m.unlock(1, 2, 3);
        m.unlock(1, 2, 3, 4);
        m.unlock(1, 2, 3, 4);
        m.lock();

        // TEST #6: Android
        // PRE-CONDTION:
        //      - none
        // POST-CONDTION:
        //      - should have random combo
        //      - will set combo
        //      - shouldnt set when using set(int,int,int,int);
        //      - shouldnt unlock when using unlock(int,int,int,int);
        System.out.println("----------------------------------------------------");
        System.out.println("Test #5 - Android");
        Android android = new Android();
        android.setCombo(1, 2, 3);
        android.getCombonation();
        Android a = new Android();
        a.setCombo(3, 5, 6);
        a.setCombo(1, 2, 3, 4);
        a.getCombonation();
        a.unlock(1, 2, 3, 4);
        a.unlock(3, 5, 6);
        a.unlock(3, 5, 6);
        a.lock();
    }
}
