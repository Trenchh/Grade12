package edu.hdsb.gwss.ryanp.unit5.dataStructures.LinkedList;

/**
 * Lesson: 6.03 - Linked List
 */
public interface LinkListInterface {

    public int size();
    
    public void makeEmpty();
    
    public boolean isEmpty();
    
    /**
     * Adds a node to the front of the linked list .
     *
     * @param str
     */
    public void addAtFront( String str );
    
    /**
     * Adds a node to the end of the linked list.
     *
     * @param str
     */
    public void addAtEnd( String str );
    
    /**
     * Deletes a node in the linked list.
     *
     * @param str
     */
    public void remove( String str );
    public String removeFromEnd();
    public String removeFromFront();
    
    /**
     * Creates a string that lists the nodes of the linked list.
     *
     * @return string
     */
    @Override
    public String toString( );

}
