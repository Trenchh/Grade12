/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit5.dataStructures;

/**
 *
 * @author 1protheroery
 */
public class Queue implements QueueInterface {

    public static final int DEFAULT_SIZE = 25;
    private static final int EMPTY = -1;
    private int[] queue;
    private int front;
    private int back;

    public Queue() {
        this(DEFAULT_SIZE);
    }

    public Queue(int capacity) {
        this.queue = new int[capacity];
        this.front = EMPTY;
        this.back = EMPTY;
    }

    @Override
    public int front() {
        if (!this.isEmpty()) {
            return this.queue[this.front + 1];
        }
        return EMPTY;
    }

    @Override
    public int back() {
        if (!this.isEmpty()) {
            return this.queue[this.back];
        }
        return EMPTY;

    }

    @Override
    public void enqueue(int value) {
        if (!this.isFull()) {
            this.back = (this.back + 1) % this.capacity();
            this.queue[this.back] = value;
        }
    }

    @Override
    public int dequeue() {
        int value = EMPTY;
        if ( !this.isEmpty() ) {
            value = this.queue[this.front];
            this.front = ( this.front++ ) % this.capacity();
            return value;
        }
        return value;
    }

    @Override
    public int size() {
        
        
        //REDO
        return EMPTY;
    }

    @Override
    public int capacity() {
        return this.queue.length;
    }

    @Override
    public boolean isEmpty() {
        return this.back == this.front;
    }

    @Override
    public boolean isFull() {
        return this.size() + 1 == this.capacity();

    }

    @Override
    public void makeEmpty() {
        this.front = EMPTY;
        this.back = EMPTY;
    }

    @Override
    public String toString() {
        String s = "BOTTOM --> ";
        for (int i = 0; i <= this.back; i++) {
            s = s + this.queue[i] + "-->";
        }
        s = s + "TOP";
        return s;
    }
}
