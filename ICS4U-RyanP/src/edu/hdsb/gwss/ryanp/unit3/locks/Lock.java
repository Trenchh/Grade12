/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit3.locks;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Swag God
 */
public class Lock implements LockInterface {

    private static int lastIDUsed = 0;
    private int serialNumber;
    private boolean locked;
    protected int maxNumber;
    protected ArrayList<Integer> combination = new ArrayList<Integer>();
    //private ArrayList<Integer> aCopy = new ArrayList<Integer>();
    private boolean canGet;
    private int attempts;
//    protected boolean canSet;
    private boolean bricked;

    public Lock() {
        this.locked = true;
        this.serialNumber = ++lastIDUsed;
        this.canGet = true;
        this.bricked = false;
    }

    public Lock(int numberCount, int maxNumber) {
        this();
        this.maxNumber = maxNumber;
        for (int i = 0; i < numberCount; i++) {
            this.combination.add((int) (Math.random() * maxNumber));
        }
        System.out.println("Combination set: " + this.combination);
    }

    public ArrayList<Integer> getCombonation() {
        if (this.bricked == false) {
            if (this.canGet == true) {
                this.canGet = false;
                //this.aCopy = Arrays.copyOf(this.combination, this.combination.size());
                System.out.println(this.combination);
                //return this.aCopy;
                return this.combination;
            }
            System.out.println("Combination can't be retrieved again");
            return null;
        } else {
            System.out.println("LOCK IS BRICKED");

        }
        return null;
    }

    public void setCombo(int num1, int num2, int num3) {
        if (this.bricked == false) {
            //this.canSet = true;
            if (this instanceof Android) {
                if (num1 <= this.maxNumber && num1 >= 0 && num2 <= this.maxNumber && num2 >= 0 && num3 <= this.maxNumber && num3 >= 0) {
                    this.clearCombo();
                    this.combination.add(num1);
                    this.combination.add(num2);
                    this.combination.add(num3);
                    System.out.println("combination set");
                } else {
                    // this.canSet = false;
                    System.out.println("INVALID INPUT");
                }
            } else {
                if (this instanceof MasterULock) {
                    System.out.println("Use the 4 number setter");

                } else {
                    System.out.println("You can not change the combination on this lock");
                }

            }
        } else {
            System.out.println("LOCK IS BRICKED");

        }
    }

    //so much duplicate code, tried reducing it for masterlock but it got too inefficient
    //I'm sure theres a really easy way to do so.
    
    public void setCombo(int num1, int num2, int num3, int num4) {
        if (this.bricked == false) {
            // this.canSet = true;
            if (this instanceof MasterULock) {
                if (num1 <= this.maxNumber && num1 >= 0 && num2 <= this.maxNumber && num2 >= 0 && num3 <= this.maxNumber && num3 >= 0 && num4 <= this.maxNumber && num4 >= 0) {
                    this.clearCombo();
                    this.combination.add(num1);
                    this.combination.add(num2);
                    this.combination.add(num3);
                    this.combination.add(num4);
                    System.out.println("combination set");
                } else {
                    //  this.canSet = false;
                    System.out.println("INVALID INPUT");
                }
            } else {
                if (this instanceof Android) {
                    System.out.println("Use the 3 number setter");

                } else {
                    System.out.println("You can not change the combination on this lock");
                }
            }
        } else {
            System.out.println("LOCK IS BRICKED");
        }
    }

    public int getSerialNumber() {
        System.out.println("The serial number of this lock is :" + this.serialNumber);
        return this.serialNumber;
    }

    private void clearCombo() {
        System.out.println("combination cleared");
        this.combination.removeAll(this.combination);
    }

    public void lock() {
        if (this.bricked == false) {
            if (this.locked == false) {
                this.attempts = 0;
                this.locked = true;
                System.out.println("The lock is now locked");
            } else {
                System.out.println("The lock is already locked");
            }
        } else {
            System.out.println("LOCK IS BRICKED");

        }
    }

    public void unlock(int num1, int num2, int num3) {
        if (this.bricked == false) {
            if (this.locked == true) {
                if (this instanceof Android || this instanceof MasterLock || this instanceof DudleyLock) {
                    this.attempts++;
                    if (this.attempts <= 3) {
                        if (this.combination.get(0).equals(num1) && this.combination.get(1).equals(num2) && this.combination.get(2).equals(num3)) {
                            System.out.println("The lock is now unlocked");
                            this.locked = false;
                            this.attempts = 0;
                        } else {
                            System.out.println("WRONG COMBINATION");
                        }
                    } else {
                        this.bricked = true;
                        System.out.println("TOO MANY ATTEMPTS, LOCK IS BRICKED");
                    }
                } else {
                    System.out.println("Use the 4 number setter");

                }

            } else {
                System.out.println("ALREADY UNLOCKED");

            }
        } else {
            System.out.println("LOCK IS BRICKED");

        }
    }

    public void unlock(int num1, int num2, int num3, int num4) {
        if (this.bricked == false) {
            if (this.locked == true) {
                if (this instanceof MasterULock) {
                    this.attempts++;
                    if (this.attempts <= 3) {
                        if (this.combination.get(0).equals(num1) && this.combination.get(1).equals(num2) && this.combination.get(2).equals(num3) && this.combination.get(3).equals(num4)) {
                            System.out.println("The lock is now unlocked");
                            this.locked = false;
                            this.attempts = 0;
                        } else {
                            System.out.println("WRONG COMBINATION");
                        }
                    } else {
                        this.bricked = true;
                        System.out.println("TOO MANY ATTEMPTS, LOCK IS BRICKED");
                    }
                } else {
                    System.out.println("Use the 3 number setter");

                }

            } else {
                System.out.println("ALREADY UNLOCKED");

            }
        } else {
            System.out.println("LOCK IS BRICKED");
        }
    }
}
