package edu.hdsb.gwss.ryanp.unit5.dataStructures.LinkedList;

/**
 * Lesson: 6.03 - a Node, in a Linked List
 */
public interface NodeInterface {

    /**
     * The node pointed to by 'next' is returned
     */
    public Node getNext();

    /**
     * The node pointed to by 'next' is changed to newNode
     */
    public void setNext( Node newNode );

    /**
     * The node pointed to by 'next' is returned.
     */
    public String getData();

}
