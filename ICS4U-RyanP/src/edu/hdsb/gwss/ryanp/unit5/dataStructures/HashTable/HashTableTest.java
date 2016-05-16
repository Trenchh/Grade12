/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit5.dataStructures.HashTable;

/**
 *
 * @author Swag God
 */
public class HashTableTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashTable table = new HashTable();

        // EMPTY TABLE
        assert (table.size() == 0);
        assert (table.isEmpty());
        System.out.println(table.capacity());
        assert (table.capacity() == 13);

        // SIZE IS ALWAYS A PRIME NUMBER
        HashTable table2 = new HashTable(34);
        assert (table2.capacity() == 37);

        //ADDING TO TABLE
        Student ryan = new Student(7, "Ryan", "Protheroe");
        table.put((int) ryan.getStudentID(), ryan);
        System.out.println(table.toString());
    }
}
