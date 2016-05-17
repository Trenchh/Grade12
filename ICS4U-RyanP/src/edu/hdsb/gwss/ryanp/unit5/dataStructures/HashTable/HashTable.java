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
        //IS IT THE RIGHT STUDENT?
        //IS IT THE ONE BELOW OR ABOVE? 
        //ITLL STOP WHEN IT HITS A NULL
        if (!this.isEmpty()) {
            int index = this.hash(key);
            while (this.hashTable[index] != null) {
                if (this.hashTable[index].getKey() == key) {
                    return this.hashTable[index];
                }
            }
            return null;
        }
        return null;

    }

    @Override
    public Student remove(int key) {
        //LEAVE TO THE END
        //IF YOU REMOVE, IT WILL MAKE IT NULL, THEN OTHER FUNCTIONS WILL SCREW UP    
        //YOU HAVE TO MOVE EVERYTHING ELSE DOWN/UP THAT WAS SUPPOSED TO GO IN THAT SPOT
        //REHASH

        return null;
    }

    @Override
    public void put(int key, Student student) {
        if (this.loadFactor() < 0.75) {
            int index = this.hash(key);
            while (this.hashTable[index] != null) {
                index = (index + 1) % this.capacity();
            }
            this.hashTable[index] = student;
        } else {
            this.resize();
            this.put(key, student);
        }

    }

    @Override
    public boolean contains(Student student) {
        if (!this.isEmpty()) {
            for (int i = this.hash((int) student.getKey()); this.hashTable[i] != null; i++) {
                if (this.hashTable[i] == student) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean containsKey(int key) {
        if (!this.isEmpty()) {
            for (int i = this.hash(key); this.hashTable[i] != null; i++) {
                if (this.hashTable[i].getKey() == key) {
                    return true;
                }
            }
            return false;
        }
        return false;
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
