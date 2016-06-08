/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ryanp.unit5.dataStructures.Queues;

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
        assert (queue.back() == -1);
        assert (queue.front() == -1);
        assert (queue.size() == 0);
        assert (queue.capacity() == Queue.DEFAULT_SIZE);
        assert (queue.isEmpty() == true);
        assert (queue.isFull() == false);

        // ENQUEUE
        queue.enqueue(1);
        assert (queue.back() == 1);
        assert (queue.front() == 1);
        assert (queue.size() == 1);
        assert (queue.capacity() == Queue.DEFAULT_SIZE);
        assert (queue.isEmpty() == false);
        assert (queue.isFull() == false);

        // DEQUEUE
        queue.dequeue();
        assert (queue.back() == -1);
        assert (queue.front() == -1);
        assert (queue.size() == 0);
        assert (queue.capacity() == Queue.DEFAULT_SIZE);
        assert (queue.isEmpty() == true);
        assert (queue.isFull() == false);

        // FILL QUEUE
        for (int i = 0; i < queue.capacity(); i++) {
            queue.enqueue(i);
        }
        assert (queue.back() == 24);
        assert (queue.front() == 0);
        assert (queue.size() == 25);
        assert (queue.capacity() == Queue.DEFAULT_SIZE);
        assert (queue.isEmpty() == false);
        assert (queue.isFull() == true);
            System.out.println(queue.toString());

        // ENQUEUE WHEN FULL
        queue.enqueue(25);
        assert (queue.back() == 24);
        assert (queue.front() == 0);
        assert (queue.size() == 25);
        assert (queue.capacity() == Queue.DEFAULT_SIZE);
        assert (queue.isEmpty() == false);
        assert (queue.isFull() == true);
            System.out.println(queue.toString());

        // DEQUEUE THEN ENQUEUE
        queue.dequeue();
        queue.enqueue(99);
        assert (queue.back() == 99);
        assert (queue.front() == 1);
        assert (queue.size() == 25);
        assert (queue.capacity() == Queue.DEFAULT_SIZE);
        assert (queue.isEmpty() == false);
        assert (queue.isFull() == true);
            System.out.println(queue.toString());

        // MAKE EMPTY
        queue.makeEmpty();
        assert (queue.back() == -1);
        assert (queue.front() == -1);
        assert (queue.size() == 0);
        assert (queue.capacity() == Queue.DEFAULT_SIZE);
        assert (queue.isEmpty() == true);
        assert (queue.isFull() == false);
            System.out.println(queue.toString());

        // DEQUEUE WHEN EMPTY
        queue.dequeue();
        assert (queue.back() == -1);
        assert (queue.front() == -1);
        assert (queue.size() == 0);
        assert (queue.capacity() == Queue.DEFAULT_SIZE);
        assert (queue.isEmpty() == true);
        assert (queue.isFull() == false);

        Queue queue2 = new Queue(15);

        // SETS CAPACITY TO 15
        assert (queue2.back() == -1);
        assert (queue2.front() == -1);
        assert (queue2.size() == 0);
        assert (queue2.capacity() == 15);
        assert (queue2.isEmpty() == true);
        assert (queue2.isFull() == false);

    }
}
