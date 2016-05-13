package edu.hdsb.gwss.ryanp.unit5.dataStructures.HashTable;

/**
 * Lesson: 6.04 - (Closed) Hash Table
 */
public interface HashTableInterface {

    public int size();
    
    public int capacity();
    
    public double loadFactor();
    
    public void makeEmpty();
    
    public boolean isEmpty();
    
    public void resize();
    
    public Student get( int key );
    
    public Student remove( int key );
    
    public void put( int key, Student value);
    
    public boolean contains( int key );
    
    public boolean containsKey( int key );
    
    public int hash( int key );

}
