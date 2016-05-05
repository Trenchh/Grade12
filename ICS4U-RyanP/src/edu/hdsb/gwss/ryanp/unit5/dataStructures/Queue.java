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
    private static final int EMPTY = 0;
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
        if (this.isEmpty() == false) {
            return this.queue[this.front];
        }
        return EMPTY;
    }

    @Override
    public int back() {
        if (this.isEmpty() == false) {
            return this.queue[this.back];
        }
        return EMPTY;

    }

    @Override
    public void enqueue(int value) {
        if (this.isFull() == false) {
            this.back = (this.back + 1) % this.capacity();
            this.queue[this.back] = value;
        }
    }

    @Override
    public int dequeue() {
        if (this.isEmpty() == false) {
            this.front++;
            return this.queue[this.front];
        } else {
            return EMPTY;

        }
    }

    @Override
    public int size() {
        if (this.back == this.front) {
            return 0;
        }
        return this.back - this.front;
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
        return this.size() == this.capacity();

    }

    @Override
    public void makeEmpty() {
        this.front = EMPTY;
        this.back = EMPTY;
    }

}
