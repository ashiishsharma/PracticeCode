package com.ashish;

import org.testng.annotations.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * @author Ashish Sharma
 *         Created on 9/6/2015.
 */
public class ProducerConsumerThreadTest {

    @Test
    public void testBlockingQueue() throws InterruptedException {
        CustomBlockingQueue customBlockingQueue = new CustomBlockingQueue(5);
        CustomProducer producer = new CustomProducer(customBlockingQueue);
        CustomConsumer consumer = new CustomConsumer(customBlockingQueue);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(producer);
        executorService.execute(consumer);

        TimeUnit.SECONDS.sleep(25);

        executorService.shutdown();


    }
}
