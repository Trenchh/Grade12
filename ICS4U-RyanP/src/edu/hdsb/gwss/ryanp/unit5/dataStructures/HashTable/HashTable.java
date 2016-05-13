/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit5.dataStructures.HashTable;

/**
 *
 * @author 1protheroery
 */
public class HashTable implements HashTableInterface {

    //SIZES HAV TO BE PRIME NUMBER
    //WHEN USER SETS CAPACITY, IT HAS TO BE THE NEXT PRIME NUMBER
    private Student[] hashTable;
    public static final int DEFAULT_SIZE = 25;

    public HashTable() {

    }

    public HashTable(int size) {

    }

    @Override
    public int size() {

        //LOOP THROUGH ARRAY; COUNT NON NULL ITEMS
        //TODO: DELETED ITEMS????
    }

    @Override
    public int capacity() {
        return this.hashTable.length;
    }

    @Override
    public double loadFactor() {
        //HOW FULL IS THE TABLE
        return this.size() / this.capacity();
    }

    @Override
    public void makeEmpty() {
        //LOOP THROUGH, MAKE THEM NULL

    }

    @Override
    public boolean isEmpty() {
        //ONCE YOU FIND ONE THAT ISNT NULL, IT ISNT EMPTY

    }

    @Override
    public void resize() {
        //IF LOAD FACTOR IS GREATER THAN 0.75/75%
        //DROP IT DOWN TO 25%
        //4/5 IS FILED, RESIZE WILL MAKE IT 4/16
        //DENOMINATOR HAS TO BE A PRIME NUMBER... SO ITS 4/17
        //NOT A DIRECT COPY, HAVE TO REHASH
        if (this.loadFactor() >= .075) {

        }
    }

    @Override
    public Student get(int key) {

        //FIND @ HASHVALUE
        //IS IT THE RIGH STUDENT?
        //IS IT THE ONE BELOW OR ABOVE? 
        //ITLL STOP WHEN IT HITS A NULL
    }

    @Override
    public Student remove(int key) {
        //LEAVE TO THE END
        //IF YOU REMOVE, IT WILL MAKE IT NULL, THEN OTHER FUNCTIONS WILL SCREW UP    
        //YOU HAVE TO MOVE EVERYTHING ELSE DOWN/UP THAT WAS SUPPOSED TO GO IN THAT SPOT

    }

    @Override
    public void put(int key, Student value) {

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static int nextPrime(int x) {
        boolean primeFound = false;
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
