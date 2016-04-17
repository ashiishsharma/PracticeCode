package com.ashish;

import org.testng.annotations.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Ashish Sharma
 *         on 10/23/2015.
 */
public class SynchronizedPrintingThreadTest {

    @Test
    public void synchronizedPrinting() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Print print = new Print();
        executorService.execute(new PrintStatment(print));
        executorService.execute(new PrintName(print));
        TimeUnit.MILLISECONDS.sleep(100);
        executorService.shutdown();
    }

    public class Print {

        private boolean isNamePrinted;
        private boolean isStatmentPrinted;

        public Print() {
            isNamePrinted = true;
            isStatmentPrinted = false;
        }

        public synchronized void printStatment() throws InterruptedException {
            while (!isNamePrinted) {
                wait();
            }
            System.out.println("My name is");
            isStatmentPrinted = true;
            isNamePrinted = false;
            notifyAll();
        }

        public synchronized void printName() throws InterruptedException {
            while (!isStatmentPrinted) {
                wait();
            }
            System.out.println("Ashish Sharma");
            isNamePrinted = true;
            isStatmentPrinted = false;
            notifyAll();
        }
    }

    public class PrintStatment implements Runnable {

        private Print print;

        public PrintStatment(Print print) {
            this.print = print;
        }

        @Override
        public void run() {
            do {
                try {
                    if (!Thread.interrupted()) {
                        print.printStatment();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
        }
    }

    public class PrintName implements Runnable {

        private Print print;

        public PrintName(Print print) {
            this.print = print;
        }

        @Override
        public void run() {
            do {
                try {
                    if (!Thread.interrupted()) {
                        print.printName();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
        }
    }


}
