package com.ashish;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Ashish Sharma
 *         Created on 9/6/2015.
 */
public class CustomConsumer implements Runnable {
    private CustomBlockingQueue customBlockingQueue;

    public CustomConsumer(CustomBlockingQueue customBlockingQueue) {
        this.customBlockingQueue = customBlockingQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // You can modify the values of 'sleep' time to simulate rate of consumption
                TimeUnit.MILLISECONDS.sleep(100);
                int consumed = (int) customBlockingQueue.dequeue();
                System.out.println("Consumed value:" + consumed);
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer Interrupted");
        }
    }
}
