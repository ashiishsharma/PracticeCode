package com.ashish;

import org.testng.annotations.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ashish Sharma
 *         Created on 8/27/2015.
 */
public class GeneralQueriesTest {

    @Test
    public void checkExecutor() throws InterruptedException {

        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(runnable);
    }

    @Test
    public void checkQueue(){
        BlockingQueue blockingQueue = new LinkedBlockingQueue();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        DelayQueue delayQueue = new DelayQueue();
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(10);
        Exchanger exchanger = new Exchanger();
        Lock lock = new ReentrantLock();
        lock.tryLock();
        lock.unlock();
    }
}
