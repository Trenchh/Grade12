package edu.hdsb.gwss.ryanp.unit5.dataStructures.LinkedList;

import edu.hdsb.gwss.ryanp.pt2.CSStudent;

/**
 * Lesson: 6.03 - a Node
 */
public class Node implements NodeInterface {
    
    private String data;
    private Node next;

    public Node(String newData) {
        this.data = newData;
        this.next = null;
    }

    public Node(CSStudent student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Node getNext() {
        return this.next;
    }

    @Override
    public void setNext(Node nextNode) {
        this.next = nextNode;
    }

    @Override
    public String getData() {
        return this.data;
    }

}
