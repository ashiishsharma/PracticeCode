package com.ashish;

import org.testng.annotations.Test;


/**
 * @author Ashish Sharma
 *         Created on 7/2/2015.
 */
public class QueueTest {

    @Test
    public void testQueue(){
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}
