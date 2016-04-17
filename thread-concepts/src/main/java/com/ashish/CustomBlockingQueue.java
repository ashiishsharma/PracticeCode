package com.ashish;

/**
 * @author Ashish Sharma
 *         Created on 9/6/2015.
 */
public class CustomBlockingQueue<T> {
    private final int size;
    private final SizeLimitedQueue<T> customQueue;

    public CustomBlockingQueue(int queueArraySize) {
        size = queueArraySize;
        // Any general queue too can be used here
        customQueue = new SizeLimitedQueue(size);
    }

    public synchronized void enqueue(T value) throws InterruptedException {
        while (customQueue.queueCount == size) {
            System.out.println("Waiting to add");
            wait();
        }
        addValue(value);
    }

    private synchronized void addValue(T value) {
        customQueue.enqueue(value);
        notifyAll();
    }

    public synchronized T dequeue() throws InterruptedException {
        while (customQueue.queueCount == 0) {
            System.out.println("Waiting to remove");
            wait();
        }
        return removeValue();
    }

    private synchronized T removeValue() {
        T value = customQueue.dequeue();
        notifyAll();
        return value;
    }
}
