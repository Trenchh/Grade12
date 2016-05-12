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

    public LinkedList() {
        tail = null;
        head = null;
    }

    @Override
    public int size() {
        if (!this.isEmpty()) {
            if (this.head == this.tail) {
                return 1;
            }
            int size = 1;
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
            tmp = n.getNext();
            n.setNext(null);
            n = tmp;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.head == null || this.tail == null;
    }

    @Override
    public void addAtFront(String str) {
        Node front = new Node(str);
        front.setNext(this.head);
        this.head = front;
        if (this.isEmpty()) {
            this.tail = front;
        }
    }

    @Override
    public void addAtEnd(String str) {
        Node end = new Node(str);
        if (!this.isEmpty()) {
            this.tail.setNext(end);
            this.tail = end;
        } else {
            this.head = end;
            this.tail = end;
        }
    }

    @Override
    public void remove(String str) {
        if (!this.isEmpty()) {
            Node n = this.head;
            while (n.getNext() != null) {
                if (n.getNext().getData() == str) {
                    n.getNext().setNext(null);
                    n.setNext(n.getNext().getNext());
                } else {
                    n = n.getNext();
                }
            }
        }
    }

    @Override
    public String removeTail() {
        if (!this.isEmpty()) {
            if (this.size() == 1) {
                Node tmp = this.tail;
                tmp.setNext(null);
                this.tail = null;
                this.head = null;
                return tmp.getData();
            } else {
                removeTailRecursion(this.head);
            }
        }
        return null;
    }

    @Override
    public String removeHead() {
        if (!this.isEmpty()) {
            Node n = this.head;
            Node tmp = n;
            this.head = n.getNext();
            tmp.setNext(null);
            return tmp.getData();
        }
        return null;
    }

    @Override
    public String head() {
        if (!this.isEmpty()) {
            return this.head.getData();
        }
        return null;
    }

    @Override
    public String tail() {
        if (!this.isEmpty()) {
            return this.tail.getData();
        }
        return null;
    }

    private String removeTailRecursion(Node next) {
        if (next.getNext() == this.tail) {
            Node tmp = this.tail;
            this.tail = next;
            tmp.setNext(null);
            return tmp.getData();
        } else {
            removeTailRecursion(next.getNext());
        }
        return null;
    }
}
