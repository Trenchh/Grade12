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
        if (this.isEmpty() == false) {
            return this.queue[front];
        }
        return EMPTY;
    }

    @Override
    public int back() {
        if (this.isEmpty() == false) {
            return this.queue[back];
        }
        return EMPTY;

    }

    @Override
    public void enqueue(int value) {
        if (this.isFull() == false) {
            this.back++;
            this.queue[back] = value;
        }
    }

    @Override
    public int dequeue() {
        if (this.isEmpty() == false) {
            this.front++;
            return this.queue[front - 1];
        } else {
            return EMPTY;

        }
    }

    @Override
    public int size() {
        return this.back - this.front;
    }

    @Override
    public int capacity() {

    }

    @Override
    public boolean isEmpty() {

    }

    @Override
    public boolean isFull() {

    }

    @Override
    public void makeEmpty() {
        this.front = EMPTY;
        this.back = EMPTY;
    }

}
