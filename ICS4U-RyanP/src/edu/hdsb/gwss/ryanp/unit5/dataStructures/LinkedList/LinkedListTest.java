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
        assert(list.head() == null);
        assert(list.tail() == null);
        assert(list.size() == 0);
        assert(list.isEmpty() == true);
        
        
    }
    
}
