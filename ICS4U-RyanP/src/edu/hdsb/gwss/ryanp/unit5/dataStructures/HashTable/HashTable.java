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
    public static final int DEFAULT_SIZE = 50;

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
        return this.size() / (double) this.capacity();
    }

    @Override
    public void makeEmpty() {
        for (int i = 0; i < this.capacity(); i++) {

            this.hashTable[i] = null;

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

        Student[] newTable = this.hashTable;
        System.out.println("SIZE " + this.size());
        this.hashTable = new Student[nextPrime(this.size() * 4)];
        System.out.println("SIZE " + this.size());

        for (Student newTable1 : newTable) {
            if (newTable1 != null) {
                this.put((int) newTable1.getKey(), newTable1);
            }
            System.out.println(" HASHTABLE " + Arrays.toString(hashTable));
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
                index = index + 1;
                index = index % this.capacity();
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
        if (this.containsKey(key)) {
            int index = this.hash(key);
            boolean found = false;
            Student removed = null;
            while (this.hashTable[index] != null && found == false) {
                if (this.hashTable[index].getKey() == key) {
                    removed = this.hashTable[index];
                    this.hashTable[index] = null;
                    found = true;
                }
                index++;
            }
            this.rehash();
            return removed;
        }
        return null;
    }

    @Override
    public void put(int key, Student student) {
        int index = this.hash(key);
        if (this.hashTable[index] == null) {
            this.hashTable[index] = student;
        } else {
            while (this.hashTable[index] != null) {
                index = index + 1;
                index = index % this.capacity();
            }
            this.hashTable[index] = student;
        }
        if (this.loadFactor() >= .75) {
            this.resize();
        }

//        System.out.println("A");
//        if (this.size() + 1 / this.capacity() < 0.75) {
//            System.out.println("A");
//            int index = this.hash(key);
//            while (this.hashTable[index] != null) {
//                System.out.println("A");
//                index = index + 1 % this.capacity();
//            }
//            this.hashTable[index] = student;
//            System.out.println("A");
//        }
//        } else {
//            this.resize();
//            this.put(key, student);
//        }
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
        int index = this.hash(key);

        while (this.hashTable[index] != null) {
            if (this.hashTable[index].getKey() == key) {
                return true;
            } else {
                index = index + 1;
                index = index % this.capacity();
            }
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

    private static int nextPrime(int x) {
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

    private void rehash() {
        for (int i = 0; i < this.capacity(); i++) {
            if (this.hashTable[i] != null) {
                Student tmp = this.hashTable[i];
                this.hashTable[i] = null;
                this.hashTable[this.hash((int) tmp.getKey())] = tmp;
            }
        }
    }

}
