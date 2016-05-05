/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit5.dataStructures;

/**
 *
 * @author Swag God
 */
public class Stack implements StackInterface {

    public static final int DEFAULT_SIZE = 25;
    private static final int EMPTY = -1;
    private int[] stack;
    private int top;

    public Stack() {
        this(DEFAULT_SIZE);
    }

    public Stack(int capacity) {
        this.stack = new int[capacity];
        this.top = EMPTY;
    }

    @Override
    public int top() {
        if (this.isEmpty() == false) {
            return this.stack[top];
        } else {
            return EMPTY;
        }
    }

    @Override
    public int pop() {
        if (this.isEmpty() == false) {
            this.top--;
            return this.stack[top + 1];
        } else {
            return EMPTY;
        }
    }

    @Override
    public void push(int value) {
        if (this.isFull() == false) {
            this.top++;
            this.stack[top] = value;
        }
    }

    @Override
    public int size() {
        return this.top + 1;
    }

    @Override
    public int capacity() {
        return this.stack.length;
    }

    @Override
    public boolean isEmpty() {
        return this.top == EMPTY;
    }

    @Override
    public boolean isFull() {
        return this.size() == this.capacity();
    }

    @Override
    public void makeEmpty() {
        this.top = EMPTY;
    }

    @Override
    public String toString() {
        String s = "BOTTOM --> ";
        for( int i = 0; i <= this.top; i++ ) {
            s = s + this.stack[i] + "-->";
        }
        s = s + "TOP";
        return s;
    }
    
    
    
}
