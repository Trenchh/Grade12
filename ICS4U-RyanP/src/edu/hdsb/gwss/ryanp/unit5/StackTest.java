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
        //assert (stack.pop() == -1);
        assert (stack.size() == 1);
        assert (stack.capacity() == Stack.DEFAULT_SIZE);
        assert (stack.isEmpty() == false);
        assert (stack.isFull() == false);

//        System.out.println( stack.toString() );
//        stack.push(25);
//        System.out.println( stack.toString() );
//        System.out.println(stack.top());
//        stack.push(5);
//        System.out.println( stack.toString() );
//        stack.push(13);
//        System.out.println( stack.toString() );
//        System.out.println(stack.pop());
//        System.out.println( stack.toString() );
//        System.out.println(stack.top());
//        System.out.println( stack.toString() );
    }
}
