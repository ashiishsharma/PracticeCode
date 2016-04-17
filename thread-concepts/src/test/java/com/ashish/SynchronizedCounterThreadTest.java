package com.ashish;

import org.testng.annotations.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Ashish Sharma
 *         on 10/23/2015.
 */
public class SynchronizedCounterThreadTest {

    CountDownLatch countDownLatch;

    @Test
    public void synchronizedCounterThreadTest() throws InterruptedException {
        int numberOfThreads = 2;
        countDownLatch = new CountDownLatch(numberOfThreads);
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        PrintCount print = new PrintCount();
        executorService.execute(new PrintOdd(print, countDownLatch));
        executorService.execute(new PrintEven(print, countDownLatch));
        countDownLatch.await();
        executorService.shutdown();

    }

    public class PrintCount {

        public int getCounter() {
            return counter;
        }

        private int counter;
        private boolean isOddPrinted;
        private boolean isEvenPrinted;

        public PrintCount() {
            counter = 0;
            isOddPrinted = true;
            isEvenPrinted = false;
        }

        public synchronized void printOdd() throws InterruptedException {
            while (!isEvenPrinted) {
                wait();
            }
            System.out.println(counter);
            counter++;
            isOddPrinted = true;
            isEvenPrinted = false;
            notifyAll();
        }

        public synchronized void printEven() throws InterruptedException {
            while (!isOddPrinted) {
                wait();
            }
            System.out.println(counter);
            counter = counter + 2;
            isOddPrinted = false;
            isEvenPrinted = true;
            notifyAll();
        }
    }

    public class PrintOdd implements Runnable {

        private PrintCount print;
        private CountDownLatch countDownLatch;

        public PrintOdd(PrintCount print, CountDownLatch countDownLatch) {
            this.print = print;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            do {
                try {
                    if (!Thread.interrupted()) {
                        if (print.getCounter() >= 500) {
                            break;
                        }
                        print.printOdd();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
            countDownLatch.countDown();
        }
    }

    public class PrintEven implements Runnable {

        private PrintCount print;
        private CountDownLatch countDownLatch;

        public PrintEven(PrintCount print, CountDownLatch countDownLatch) {
            this.print = print;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            do {
                try {
                    if (!Thread.interrupted()) {
                        if (print.getCounter() >= 500) {
                            break;
                        }
                        print.printEven();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
            countDownLatch.countDown();
        }
    }
}
