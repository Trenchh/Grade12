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
public class LinkedList implements LinkListInterface {

    private Node head;
    private Node tail;

    @Override
    public int size() {
        if (this.isEmpty()) {
            int size = 0;
            Node n = this.head;
            while (n.getNext() != null) {
                size++;
                n = n.getNext();
            }
            return size;
        }
        return 0;
    }

    @Override
    public void makeEmpty() {
        Node n = this.head;
        Node tmp = n;
        while (n.getNext() != null) {
            // FIX, IT WILL ERASE BEFORE GETTING NEXT tmp = n.getNext();
            tmp = n.getNext();
            n.setNext(null);
            n = tmp;

        }
    }

    @Override
    public boolean isEmpty() {
        return this.head.getData() == null;
    }

    @Override
    public void addAtFront(String str) {
        Node front = new Node(str);
        front.setNext(head);
        this.head = front;
        if (this.isEmpty()) {
            this.tail = front;
        }

    }

    @Override
    public void addAtEnd(String str) {

    }

    @Override
    public void remove(String str) {

    }

    @Override
    public String removeFromEnd() {

    }

    @Override
    public String removeFromFront() {

    }

}
