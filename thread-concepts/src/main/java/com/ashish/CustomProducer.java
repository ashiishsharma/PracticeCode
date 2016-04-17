package com.ashish;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Ashish Sharma
 *         Created on 9/6/2015.
 */
public class CustomProducer implements Runnable {

    private CustomBlockingQueue customBlockingQueue;

    public CustomProducer(CustomBlockingQueue customBlockingQueue) {
        this.customBlockingQueue = customBlockingQueue;
    }

    @Override
    public void run() {
        int producedValue = 0;

        try {
            while (!Thread.interrupted()) {
                // You can modify the values of 'sleep' time to simulate rate of production
                TimeUnit.MILLISECONDS.sleep(1000);
                int produced = producedValue++;
                customBlockingQueue.enqueue(produced);
                System.out.println("Produced value:" + produced);
            }
        } catch (InterruptedException e) {
            System.out.println("Producer Interrupted");
        }
    }
}
