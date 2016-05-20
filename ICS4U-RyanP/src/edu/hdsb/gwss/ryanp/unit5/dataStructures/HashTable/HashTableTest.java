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
        Student ryan = new Student(1, "Ryan", "Protheroe");
        table.put((int) ryan.getKey(), ryan);
        System.out.println(table.toString());
        assert (table.contains(ryan));
        assert (table.containsKey(1));

        //ADDING KEY WITH SAME HASH VALUE
        Student coolerRyan = new Student(14, "CoolerRyan", "Protheroe");
        table.put((int) coolerRyan.getKey(), coolerRyan);
        System.out.println(table.toString());
        assert (table.contains(coolerRyan));
        assert (table.containsKey(14));

        //REMOVING STUDENT AT IMPORPER INDEX//COLLSIONS
        System.out.println(table.remove((int) ryan.getKey()));
        System.out.println(table.toString());
        assert (!table.isEmpty());
        assert (table.size() == 1);

        //RESIZE
        HashTable table3 = new HashTable(3);
        System.out.println(table3.toString());

        Student fill1 = new Student(14, "CoolerRyan", "Protheroe");
        table3.put((int) fill1.getKey(), fill1);
        System.out.println(table3.toString());

        Student fill2 = new Student(14, "BLOOP", "Protheroe");
        table3.put((int) fill2.getKey(), fill2);
        System.out.println(table3.toString());

        Student fill3 = new Student(14, "POW", "Protheroe");
        table3.put((int) fill3.getKey(), fill3);
        System.out.println(table3.toString());

        Student fill4 = new Student(14, "SQUAAAD", "Protheroe");
        table3.put((int) fill4.getKey(), fill4);
        System.out.println(table3.toString());

    }
}
