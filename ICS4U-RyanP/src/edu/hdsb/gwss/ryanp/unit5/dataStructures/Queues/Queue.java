/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit5.dataStructures.Queues;

import java.util.Arrays;

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
            return this.queue[this.front];
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
        if (this.front == EMPTY && this.back == EMPTY) {
            this.front = 0;
            this.back = 0;
            this.queue[this.back] = value;
        } else if (!this.isFull()) {
            this.back = (this.back + 1) % this.capacity();
            this.queue[this.back] = value;
        }
    }

    @Override
    public int dequeue() {
        int value = EMPTY;
        if (!this.isEmpty()) {
            value = this.queue[this.front];
            if (this.back == this.front ) {              
                this.makeEmpty();
            } else {
                this.front = (this.front + 1) % this.capacity();
            }
        }
        return value;
    }

    @Override
    public int size() {
        if (!this.isEmpty()) {
            if (this.back == this.front ) {
                return 1;
            } else if (this.back > this.front) {
                return this.back + 1 - this.front;
            } else {
                int sum = this.back + this.front;
                return this.capacity() + 1 - sum;
            }
        }
        return 0;

    }

    @Override
    public int capacity() {
        return this.queue.length;
    }

    @Override
    public boolean isEmpty() {
        if(this.front == EMPTY && this.back == EMPTY){
            return true;
        }
        return false;

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

    @Override
    public String toString() {
        System.out.println(this.front);
        System.out.println(this.back);
        return Arrays.toString(this.queue);
//        String s = "BOTTOM --> ";
//        if (!this.isEmpty()) {
//            if (this.front == 0 && this.back == 0) {
//                return "BOTTOM -->" + this.queue[this.back] + "--> TOP";
//            } else {
//                for (int i = this.front; i % this.capacity() != this.back; i++) {
//                    s = s + this.queue[i % this.capacity()] + "-->";
//                }
//                s = s + "TOP";
//                return s;
//            }
//        }
//        return "BOTTOM --> TOP";

    }
}
