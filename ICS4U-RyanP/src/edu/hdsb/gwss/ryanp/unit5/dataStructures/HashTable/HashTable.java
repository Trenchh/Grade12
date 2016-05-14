/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit5.dataStructures.HashTable;

import java.util.Arrays;

/**
 *
 * @author 1protheroery
 */
public class HashTable implements HashTableInterface {

    //SIZES HAV TO BE PRIME NUMBER
    //WHEN USER SETS CAPACITY, IT HAS TO BE THE NEXT PRIME NUMBER
    private Student[] hashTable;
    public static final int DEFAULT_SIZE = 13;

    public HashTable() {
        this(DEFAULT_SIZE);
    }

    public HashTable(int size) {
        this.hashTable = new Student[nextPrime(size)];
    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < this.capacity(); i++) {
            if (this.hashTable[i] != null) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public int capacity() {
        return this.hashTable.length;
    }

    @Override
    public double loadFactor() {
        return this.size() / this.capacity();
    }

    @Override
    public void makeEmpty() {
        for (int i = 0; i < this.capacity(); i++) {
            if (this.hashTable[i] != null) {
                this.hashTable[i] = null;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public void resize() {
        //IF LOAD FACTOR IS GREATER THAN 0.75/75%
        //DROP IT DOWN TO 25%
        //4/5 IS FILED, RESIZE WILL MAKE IT 4/16
        //DENOMINATOR HAS TO BE A PRIME NUMBER... SO ITS 4/17
        //NOT A DIRECT COPY, HAVE TO REHASH
        if (this.loadFactor() >= .75) {

        }
    }

    @Override
    public Student get(int key) {

        //FIND @ HASHVALUE
        //IS IT THE RIGH STUDENT?
        //IS IT THE ONE BELOW OR ABOVE? 
        //ITLL STOP WHEN IT HITS A NULL
        return null;
    }

    @Override
    public Student remove(int key) {
        //LEAVE TO THE END
        //IF YOU REMOVE, IT WILL MAKE IT NULL, THEN OTHER FUNCTIONS WILL SCREW UP    
        //YOU HAVE TO MOVE EVERYTHING ELSE DOWN/UP THAT WAS SUPPOSED TO GO IN THAT SPOT
        return null;

    }

    @Override
    public void put(int key, Student value) {
        this.hashTable[this.hash(key)] = value;
    }

    @Override
    public boolean contains(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsKey(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hash(int key) {
        return key % this.capacity();
    }

    public String toString() {
        return Arrays.toString(this.hashTable);
    }

    public static int nextPrime(int x) {
        boolean primeFound = false;
        x = x - 1;
        while (!primeFound) {
            x++;
            primeFound = true;
            for (int i = 2; i < x; i++) {
                if (x % i == 0) {
                    i = x;
                    primeFound = false;
                }
            }
        }
        return x;
    }
}
