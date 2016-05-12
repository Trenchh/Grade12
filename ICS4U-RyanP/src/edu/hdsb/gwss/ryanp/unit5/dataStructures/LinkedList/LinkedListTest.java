/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit5.dataStructures.LinkedList;

/**
 *
 * @author 1protheroery
 */
public class LinkedListTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        //BASE CASE
        assert (list.head() == null);
        assert (list.tail() == null);
        assert (list.size() == 0);
        assert (list.isEmpty() == true);
        assert (list.removeHead() == null);
        assert (list.removeTail() == null);

        //ADD ONE
        list.addAtEnd("Hello");
        assert (list.tail() == "Hello");
        assert (list.head() == "Hello");
        assert (list.size() == 1);
        assert (list.isEmpty() == false);

        //REMOVE ONE
        assert (list.removeTail() == "Hello");
        assert (list.size() == 0);
        assert (list.isEmpty() == true);

        list.addAtEnd("Hello");
        assert (list.removeHead() == "Hello");
        assert (list.size() == 0);
        assert (list.isEmpty() == true);

        //ADD AT FRONT
        list.addAtFront("Hello");
        list.addAtFront("Bye");
        list.addAtFront("SHALOM");
        assert (list.head() == "SHALOM");
        assert (list.tail() == "Hello");
        assert (list.size() == 3);
        assert (list.isEmpty() == false);

        //ADD AT END
        list.addAtEnd("bowbowbow");
        list.addAtEnd("squaaad");
        list.addAtEnd("flocka");
        assert (list.head() == "SHALOM");
        assert (list.tail() == "flocka");
        assert (list.size() == 6);
        assert (list.isEmpty() == false);

    }

}
