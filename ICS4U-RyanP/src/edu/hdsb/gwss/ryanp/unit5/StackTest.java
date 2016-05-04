/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit5;

/**
 *
 * @author 1protheroery
 */
public class StackTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack stack = new Stack();

        // EMPTY
        assert (stack.top() == -1);
        assert (stack.pop() == -1);
        assert (stack.size() == 0);
        assert (stack.capacity() == Stack.DEFAULT_SIZE);
        assert (stack.isEmpty() == true);
        assert (stack.isFull() == false);

        // ADD ONE VALUE
        stack.push(1);
        assert (stack.top() == 1);
        assert (stack.size() == 1);
        assert (stack.capacity() == Stack.DEFAULT_SIZE);
        assert (stack.isEmpty() == false);
        assert (stack.isFull() == false);

        // POP ONE VALUE
        stack.pop();
        assert (stack.top() == -1);
        assert (stack.size() == 0);
        assert (stack.capacity() == Stack.DEFAULT_SIZE);
        assert (stack.isEmpty() == true);
        assert (stack.isFull() == false);

        // FILL STACK
        for (int i = 0; i < stack.capacity(); i++) {
            stack.push(i);
        }
        assert (stack.top() == 24);
        assert (stack.size() == 25);
        assert (stack.capacity() == Stack.DEFAULT_SIZE);
        assert (stack.isEmpty() == false);
        assert (stack.isFull() == true);

        // PUSH WHEN FULL
        stack.push(25);
        assert (stack.top() == 24);
        assert (stack.size() == 25);
        assert (stack.capacity() == Stack.DEFAULT_SIZE);
        assert (stack.isEmpty() == false);
        assert (stack.isFull() == true);

        // MAKE EMPTY
        stack.makeEmpty();
        assert (stack.top() == -1);
        assert (stack.size() == 0);
        assert (stack.capacity() == Stack.DEFAULT_SIZE);
        assert (stack.isEmpty() == true);
        assert (stack.isFull() == false);

        // POP WHEN EMPTY
        stack.pop();
        assert (stack.top() == -1);
        assert (stack.size() == 0);
        assert (stack.capacity() == Stack.DEFAULT_SIZE);
        assert (stack.isEmpty() == true);
        assert (stack.isFull() == false);

        Stack stack2 = new Stack(15);

        // SETS CAPACITY TO 25
        assert (stack2.top() == -1);
        assert (stack2.size() == 0);
        assert (stack2.capacity() == 15);
        assert (stack2.isEmpty() == true);
        assert (stack2.isFull() == false);
    }
}
