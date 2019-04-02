package com.ashish;

import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ashish Sharma
 *         Created on 8/30/2015.
 *         Based on Thinking In Java by Bruce Eckel 4th Edition
 *         Chapter : Concurrency
 */
public class ThreadTest {
    private static final int threadCount = 5;
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount);
    private static CountDownLatch countDownLatch = new CountDownLatch(threadCount);


    @Test
    public void testThread() {
        Thread thread = new Thread(new CountDown());
        thread.start();
    }

    @Test
    public void testExecutorCountDownLatchDemo() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i++) {
            executorService.execute(new CountDownDemo());
        }
        countDownLatch.await();
        System.out.println("Finishing Latch hit");
        executorService.shutdown();

    }

    class CountDownDemo implements Runnable {
        private int countDown = 10;

        public void run() {
            do {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    countDown--;
                    System.out.println("Thread id:" + Thread.currentThread().getId());
                    System.out.println(countDown);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (countDown > 0);
            System.out.println("Lift Off");
            System.out.println("Decreasing Count Down ...");
            countDownLatch.countDown();
            System.out.println("Decreased Count Down ...");
        }
    }

    @Test
    public void testExecutorCyclicBarrierDemo() throws InterruptedException, BrokenBarrierException {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount - 1);
        for (int i = 0; i < threadCount; i++) {
            executorService.execute(new CountDown());
        }
        cyclicBarrier.await();
        System.out.println("Finishing Barrier in main");
        executorService.shutdown();
    }

    class CountDown implements Runnable {
        private int countDown = 10;

        public void run() {
            do {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    countDown--;
                    System.out.println("Thread id:" + Thread.currentThread().getId());
                    System.out.println(countDown);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (countDown > 0);
            System.out.println("Lift Off");
            try {
                System.out.println("Hitting barrier");
                cyclicBarrier.await();
                System.out.println("Finishing barrier");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testExecutorWithCallable() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<Integer>> results = new ArrayList();
        for (int i = 0; i < 5; i++) {
            results.add(executorService.submit(new CallableDemo()));
        }

        for (Future future : results) {

            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return;
            } finally {
                executorService.shutdown();
            }
        }
        executorService.shutdown();
    }

    class CallableDemo implements Callable<Integer> {

        public Integer call() throws Exception {
            Random random = new Random();
            System.out.println("Thread id:" + Thread.currentThread().getId());
            return random.nextInt();
        }
    }

    @Test
    public void threadJoinTest() throws InterruptedException {
        Thread thread = new Thread(new ThreadJoinDemo());
        thread.start();
        thread.join();
    }

    class ThreadJoinDemo implements Runnable {

        @Override
        public void run() {
            int i = 100;
            do {
                System.out.println(i);
                i--;
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
            } while (i > 0);
        }
    }

    @Test
    public void threadExceptionHandlerDemo() {
//        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService executorService = Executors.newFixedThreadPool(1, new MyThreadFactory());
        executorService.execute(new ThreadDemoException());
    }

    class ThreadDemoException implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getId());
            throw new RuntimeException();
        }
    }

    class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("Caught " + e);
        }
    }

    class MyThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            System.out.println("Creating new thread");
            System.out.println(Thread.currentThread().getId());
            Thread thread = new Thread(r);
            thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            System.out.println("eh=" + thread.getUncaughtExceptionHandler());
            return thread;
        }
    }

    @Test
    public void demoThreadLocks() {
        int i = 0;
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            do {
                System.out.println("show your lock");
                i++;
            } while (i < 100);
        } finally {
            lock.unlock();
        }
    }

    @Test
    public void alternatingThreadDemoTest() {

        AlternatingThreadDemo alternatingThreadDemo = new AlternatingThreadDemo();
        new Thread() {
            public void run() {
                alternatingThreadDemo.myName();
            }
        }.start();
        alternatingThreadDemo.displayName();

    }

    class AlternatingThreadDemo {
        final private Object syncObj = new Object();

        public synchronized void myName() {
            for (int i = 0; i < 10; i++) {
                System.out.println("My Name is ");
                Thread.yield();
            }
        }

        public void displayName() {
            synchronized (syncObj) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Ashish Sharma");
                    Thread.yield();
                }
            }
        }
    }

    @Test
    public void demoThreadLocal() throws InterruptedException {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                threadLocalDemo.increment();
                System.out.println("Thread id " + Thread.currentThread().getId() + ", ThreadLocal value : " + threadLocalDemo.getThreadLocalInteger());
            }
        };
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
            thread.join();
        }
    }


    class ThreadLocalDemo {
        private ThreadLocal<Integer> threadLocalInteger = new ThreadLocal() {
            protected Integer initialValue() {
                Random random = new Random();
                return random.nextInt();
            }
        };

        public Integer getThreadLocalInteger() {
            return threadLocalInteger.get();
        }


        public void increment() {
            threadLocalInteger.set(threadLocalInteger.get() + 1);
        }
    }

    @Test
    public void demoInterruptTasks() throws InterruptedException {
        demoRun(new SleepBlocked());
        demoRun(new IOBlocked(System.in));
        demoRun(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Aborting with System.exit(0)");
        System.exit(0); // ... since last 2 interrupts failed
    }

    private void demoRun(Runnable r) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting " + r.getClass().getName());
        f.cancel(true); // Interrupts if running
        System.out.println("Interrupt sent to " + r.getClass().getName());
    }

    class SleepBlocked implements Runnable {
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
            System.out.println("Exiting SleepBlocked.run()");
        }
    }

    class IOBlocked implements Runnable {
        private InputStream in;

        public IOBlocked(InputStream is) {
            in = is;
        }

        public void run() {
            try {
                System.out.println("Waiting for read():");
                in.read();
            } catch (IOException e) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Interrupted from blocked I/O");
                } else {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Exiting IOBlocked.run()");
        }
    }

    class SynchronizedBlocked implements Runnable {
        public synchronized void f() {
            while (true) // Never releases lock
                Thread.yield();
        }

        public SynchronizedBlocked() {
            new Thread() {
                public void run() {
                    f(); // Lock acquired by this thread
                }
            }.start();
        }

        public void run() {
            System.out.println("Trying to call f()");
            f();
            System.out.println("Exiting SynchronizedBlocked.run()");
        }
    }

    @Test
    public void demoInterruptWithResourceClosed() throws IOException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8080);
        InputStream socketInput =
                new Socket("localhost", 8080).getInputStream();
        exec.execute(new IOBlocked(socketInput));
        exec.execute(new IOBlocked(System.in));
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Shutting down all threads");
        exec.shutdownNow();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Closing " + socketInput.getClass().getName());
        socketInput.close(); // Releases blocked thread
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Closing " + System.in.getClass().getName());
        System.in.close(); // Releases blocked thread
    }

    @Test
    public void demoNIOBlocked() throws IOException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8080);
        InetSocketAddress isa =
                new InetSocketAddress("localhost", 8080);
        SocketChannel sc1 = SocketChannel.open(isa);
        SocketChannel sc2 = SocketChannel.open(isa);
        Future<?> f = exec.submit(new NIOBlocked(sc1));
        exec.execute(new NIOBlocked(sc2));
        exec.shutdown();
        TimeUnit.SECONDS.sleep(1);
        // Produce an interrupt via cancel:
        f.cancel(true);
        TimeUnit.SECONDS.sleep(1);
        // Release the block by closing the channel:
        sc2.close();
    }

    class NIOBlocked implements Runnable {
        private final SocketChannel sc;

        public NIOBlocked(SocketChannel sc) {
            this.sc = sc;
        }

        public void run() {
            try {
                System.out.println("Waiting for read() in " + this);
                sc.read(ByteBuffer.allocate(1));
            } catch (ClosedByInterruptException e) {
                System.out.println("ClosedByInterruptException");
            } catch (AsynchronousCloseException e) {
                System.out.println("AsynchronousCloseException");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Exiting NIOBlocked.run() " + this);
        }
    }

    @Test
    public void demoInterrupting() throws InterruptedException {
        Thread t = new Thread(new Blocked2());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Issuing t.interrupt()");
        t.interrupt();
    }

    class BlockedMutex {
        private Lock lock = new ReentrantLock();

        public BlockedMutex() {
            // Acquire it right away, to demonstrate interruption
            // of a task blocked on a ReentrantLock:
            lock.lock();
        }

        public void f() {
            try {// This will never be available to a second task
                lock.lockInterruptibly(); // Special call
                System.out.println("lock acquired in f()");
            } catch (InterruptedException e) {
                System.out.println("Interrupted from lock acquisition in f()");
            }
        }
    }

    class Blocked2 implements Runnable {
        BlockedMutex blocked = new BlockedMutex();

        public void run() {
            System.out.println("Waiting for f() in BlockedMutex");
            blocked.f();
            System.out.println("Broken out of blocked call");
        }
    }

    @Test
    public void demoFinally() {
        try {
            System.out.println("I am in");
            System.exit(0);
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Exception caught");
        } finally {
            System.out.println("Finally");
        }
    }

    @Test
    public void interruptingIdiomDemo() throws InterruptedException {
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(300);
        t.interrupt();
    }

    class NeedsCleanup {
        private final int id;

        public NeedsCleanup(int ident) {
            id = ident;
            System.out.println("NeedsCleanup " + id);
        }

        public void cleanup() {
            System.out.println("Cleaning up " + id);
        }
    }

    class Blocked3 implements Runnable {
        private volatile double d = 0.0;

        public void run() {
            try {
                while (!Thread.interrupted()) {
                    // point1
                    NeedsCleanup n1 = new NeedsCleanup(1);
                    // Start try-finally immediately after definition
                    // of n1, to guarantee proper cleanup of n1:
                    try {
                        System.out.println("Sleeping");
                        TimeUnit.SECONDS.sleep(1);
                        // point2
                        NeedsCleanup n2 = new NeedsCleanup(2);
                        // Guarantee proper cleanup of n2:
                        try {
                            System.out.println("Calculating");
                            // A time-consuming, non-blocking operation:
                            for (int i = 1; i < 2500000; i++)
                                d = d + (Math.PI + Math.E) / d;
                            System.out.println("Finished time-consuming operation");
                        } finally {
                            n2.cleanup();
                        }
                    } finally {
                        n1.cleanup();
                    }
                }
                System.out.println("Exiting via while() test");
            } catch (InterruptedException e) {
                System.out.println("Exiting via InterruptedException");
            }
        }
    }

    @Test
    public void taskCooperationDemo() throws InterruptedException {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ApplyShine(car));
        exec.execute(new ApplyWax(car));
        TimeUnit.SECONDS.sleep(15); // Run for a while...
        exec.shutdownNow(); // Interrupt all tasks
    }

    class Car {
        private boolean waxOn = false;

        public synchronized void waxed() {
            waxOn = true; // Ready to buff
            notifyAll();
        }

        public synchronized void shinned() {
            waxOn = false; // Ready for another coat of wax
            notifyAll();
        }

        public synchronized void waitForWaxing()
                throws InterruptedException {
            while (waxOn == false)
                wait();
        }

        public synchronized void waitForShinning()
                throws InterruptedException {
            while (waxOn == true)
                wait();
        }
    }

    class ApplyWax implements Runnable {
        private Car car;

        public ApplyWax(Car c) {
            car = c;
        }

        public void run() {
            try {
                while (!Thread.interrupted()) {
                    System.out.println("Wax On! ");
                    TimeUnit.MILLISECONDS.sleep(200);
                    car.waxed();
                    car.waitForShinning();
                }
            } catch (InterruptedException e) {
                System.out.println("Exiting via interrupt");
            }
            System.out.println("Ending Wax On task");
        }
    }

    class ApplyShine implements Runnable {
        private Car car;

        public ApplyShine(Car c) {
            car = c;
        }

        public void run() {
            try {
                while (!Thread.interrupted()) {
                    car.waitForWaxing();
                    System.out.println("Wax Off! ");
                    TimeUnit.MILLISECONDS.sleep(200);
                    car.shinned();
                }
            } catch (InterruptedException e) {
                System.out.println("Exiting via interrupt");
            }
            System.out.println("Ending Wax Off task");
        }
    }

    @Test
    public void blockingQueueDemo() throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Producer(blockingQueue));
        executorService.execute(new Consumer(blockingQueue));

        TimeUnit.SECONDS.sleep(20);
        executorService.shutdownNow();
    }

    private class Producer implements Runnable {
        private BlockingQueue blockingQueue;

        public Producer(BlockingQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            int i = 0;
            try {
                while (!Thread.interrupted()) {
                    TimeUnit.MILLISECONDS.sleep(200);
                    System.out.println("Produced : " + i);
                    blockingQueue.put(i);
                    i++;
                }
            } catch (InterruptedException e) {
                System.out.println("Producer Interrupted");
            }
        }
    }

    private class Consumer implements Runnable {

        private BlockingQueue blockingQueue;

        public Consumer(BlockingQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    TimeUnit.MILLISECONDS.sleep(800);
                    System.out.println("Consumed : " + blockingQueue.take());
                }
            } catch (InterruptedException e) {
                System.out.println("Consumer Interrupted");
            }
        }
    }
}