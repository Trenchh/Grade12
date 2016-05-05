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
public class QueueTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue queue = new Queue();

        // EMPTY
        assert (queue.back() == 0);
        assert (queue.front() == 0);
        assert (queue.size() == 0);
        assert (queue.capacity() == Queue.DEFAULT_SIZE);
        assert (queue.isEmpty() == true);
        assert (queue.isFull() == false);

        // ENQUEUE
        queue.enqueue(1);
        assert (queue.back() == 1);
        assert (queue.front() == 0);
        assert (queue.size() == 1);
        assert (queue.capacity() == Queue.DEFAULT_SIZE);
        assert (queue.isEmpty() == false);
        assert (queue.isFull() == false);

        // DEQUEUE
        queue.dequeue();
        assert (queue.back() == 0);
        assert (queue.front() == 0);
        assert (queue.size() == 0);
        assert (queue.capacity() == Queue.DEFAULT_SIZE);
        assert (queue.isEmpty() == true);
        assert (queue.isFull() == false);

        // FILL QUEUE
        queue.makeEmpty();
        for (int i = 1; i <= queue.capacity(); i++) {
            queue.enqueue(i);
            System.out.println(queue.toString());
        }
        assert (queue.back() == 24);
        assert (queue.front() == 0);
        assert (queue.size() == 24);
        assert (queue.capacity() == Queue.DEFAULT_SIZE);
        assert (queue.isEmpty() == false);
        assert (queue.isFull() == true);

        // DEQUEUE THEN ENQUEUE
        queue.dequeue();
        queue.enqueue(99);
        System.out.println(queue.toString());
        assert (queue.back() == 99);
        assert (queue.front() == 1);
        assert (queue.size() == 0);
        assert (queue.capacity() == Queue.DEFAULT_SIZE);
        assert (queue.isEmpty() == false);
        assert (queue.isFull() == true);
        
        // ENQUEUE WHEN FULL
        queue.enqueue(25);
        assert (queue.back() == 24);
        assert (queue.front() == 0);
        assert (queue.size() == 24);
        assert (queue.capacity() == Queue.DEFAULT_SIZE);
        assert (queue.isEmpty() == false);
        assert (queue.isFull() == true);

        // MAKE EMPTY
        queue.makeEmpty();
        assert (queue.back() == 0);
        assert (queue.front() == 0);
        assert (queue.size() == 0);
        assert (queue.capacity() == Queue.DEFAULT_SIZE);
        assert (queue.isEmpty() == true);
        assert (queue.isFull() == false);

        // DEQUEUE WHEN EMPTY
        queue.dequeue();
        assert (queue.back() == 0);
        assert (queue.front() == 0);
        assert (queue.size() == 0);
        assert (queue.capacity() == Queue.DEFAULT_SIZE);
        assert (queue.isEmpty() == true);
        assert (queue.isFull() == false);
    }

}
