package edu.hdsb.gwss.ryanp.pt2;

import edu.hdsb.gwss.ryanp.unit5.dataStructures.LinkedList.Node;

/**
 * Linked List of Students
 *
 * @version v2016.S2
 */
public class LinkedListPT {

    private NodePT head;
    private NodePT tail;

    /**
     * Constructor: Empty Linked List
     */
    public LinkedListPT() {
        this.head = null;
        this.tail = null;
    }

    /**
     * @return returns the size (# of students) in the linked list.
     */
    public int size() {
        int size = 0;
        if (!this.isEmpty()) {
            NodePT n = this.head;
            size = 1;
            while (n.getNext() != null) {
                n = n.getNext();
                size++;
            }
        }
        return size;
    }

    /**
     * This method makes the linked list empty.
     */
    public void makeEmpty() {
        this.tail = null;
        this.head = null;
    }

    /**
     * This method returns true if the linked list is empty
     *
     * @return returns true if there are no student objects in the linked list
     */
    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    /**
     * This method adds a student object to the end of the linked list.
     *
     * @param student
     */
    public void addAtEnd(CSStudent student) {
        NodePT end = new NodePT(student);
        if (this.isEmpty()) {
            this.head = end;
            this.tail = end;

        } else {
            this.tail.setNext(end);
            this.tail = end;

        }
    }

    /**
     * This method will get a student object from the linked list, given the
     * student number
     *
     * @param key student number (key)
     * @return returns the student object for the given key, or null if it
     * doesn't exist.
     */
    public CSStudent get(int key) {
        NodePT n = this.head;
        if (this.head.getData().getKey() == key) {
            return this.head.getData();
        } else if (this.tail.getData().getKey() == key) {
            return this.tail.getData();
        } else {
            while (n.getData().getKey() != key) {
                n = n.getNext();
                if (n.getData().getKey() == key) {
                    CSStudent tmp = n.getData();
                }
                if (n == this.tail && this.tail.getData().getKey() != key) {
                    System.out.println("DOES NOT CONTAIN STUDENT");
                    return null;
                }
            }
        }
        return null;

    }

    /**
     * This method will remove a student object from the linked list, given the
     * student number.
     *
     * @param key student number (key)
     * @return returns the removed student object, or null if the key is not
     * found
     */
    public CSStudent remove(int key) {
        if (!this.isEmpty()) {
            if (this.head.getData().getKey() == key) {
                this.removeHead();
            } else if (this.tail.getData().getKey() == key) {
                this.removeTail();

            } else if (!this.isEmpty()) {
                NodePT n = this.head;
                while (n.getNext().getData().getKey() != key) {
                    n = n.getNext();
                }
                NodePT tmp = n.getNext();
                n.setNext(n.getNext().getNext());
                tmp = null;
            }
        }
        return null;
    }

    /**
     * DONE FOR YOU
     */
    @Override
    public String toString() {
        return "HEAD: " + toString(this.head);
    }

    /**
     * DONE FOR YOU
     */
    private String toString(NodePT n) {
        String s = "";
        if (n != null) {
            s = n.getData() + " --> " + this.toString(n.getNext());
        }
        return s;
    }

    public CSStudent removeTail() {
        NodePT n = this.head;
        NodePT tmp;
        if (!this.isEmpty()) {
            if (this.head == this.tail) {
                this.makeEmpty();
                return n.getData();
            } else {
                while (n.getNext() != this.tail) {
                    n = n.getNext();
                }
                tmp = n.getNext();
                n.setNext(null);
                this.tail = n;
                return tmp.getData();
            }
        } else {
            return null;
        }
    }

    public CSStudent removeHead() {
        NodePT n = this.head;
        NodePT tmp;
        if (!this.isEmpty()) {
            if (this.size() == 1) {
                tmp = this.tail;
                this.makeEmpty();
                return tmp.getData();
            } else {
                tmp = n;
                this.head = n.getNext();
                tmp.setNext(null);
                return tmp.getData();
            }
        }
        return null;
    }

}
