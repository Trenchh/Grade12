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
        int size = 0;
        if (!this.isEmpty()) {
            Node n = this.head;
            size = 1;
            while (n.getNext() != null) {
                n = n.getNext();
                size++;
            }
        }
        return size;
    }

    @Override
    public void makeEmpty() {
        this.tail = null;
        this.head = null;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    @Override
    public void addAtFront(String str) {
        Node front = new Node(str);
        front.setNext(this.head);
        if (isEmpty()) {
            this.tail = front;
        }
        this.head = front;
    }

    @Override
    public void addAtEnd(String str) {
        Node end = new Node(str);
        if (this.isEmpty()) {
            this.head = end;
            this.tail = end;
            System.out.println("added at end when empty");

        } else {
            this.tail.setNext(end);
            this.tail = end;
            System.out.println("added at end");

        }
    }

    @Override
    public void remove(String str) {
        if (!this.isEmpty()) {
            if (this.head.getData().equals(str)) {
                this.removeHead();
            } else if (this.tail.getData().equals(str)) {
                this.removeTail();

            } else if (!this.isEmpty()) {
                Node n = this.head;
                while (!n.getNext().getData().equals(str)) {
                    n = n.getNext();
                }
                Node tmp = n.getNext();
                n.setNext(n.getNext().getNext());
                tmp = null;
            }
        }
    }

    @Override
    public String removeTail() {
        if (!this.isEmpty()) {
            if (this.size() == 1) {
                Node tmp = this.tail;
                this.makeEmpty();
                return tmp.getData();
            } else {
                Node n = this.head;
                while(n.getNext() != this.tail) {
                    n = n.getNext();
                }
                Node tmp = this.tail;
                this.tail = n;
                tmp.setNext(null);
                return tmp.getData();
                //removeTailRecursion(this.head);
            }
        }
        return null;
    }

    @Override
    public String removeHead() {
        if (!this.isEmpty()) {
            if (this.size() == 1) {
                Node tmp = this.tail;
                this.makeEmpty();
                return tmp.getData();
            } else {
                Node n = this.head;
                Node tmp = n;
                this.head = n.getNext();
                tmp.setNext(null);
                return tmp.getData();
            }
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

//    private String removeTailRecursion(Node next) {
//        if (next.getNext() == this.tail) {
//            Node tmp = this.tail;
//            this.tail = next;
//            tmp.setNext(null);
//            return tmp.getData();
//        } else {
//            removeTailRecursion(next.getNext());
//        }
//        return null;
//    }

    @Override
    public String toString() {
        Node n = this.head;
        String print = "HEAD --> ";
        while (n != null) {
            print = print + n.getData() + " --> ";
            n = n.getNext();
        }
        print = print + "TAIL";
        return print;
    }

}
