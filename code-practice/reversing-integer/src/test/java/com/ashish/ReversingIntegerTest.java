package com.ashish;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ashish Sharma
 *         on 10/25/2015.
 */
public class ReversingIntegerTest {

    @Test
    public void reverseIntegerTest() {
        Queue<Integer> reversedQueue = new LinkedList<Integer>();
        reversedQueue = reverseNumber(2134, reversedQueue);
        System.out.println(regenerateReversedNumber(reversedQueue, reversedQueue.size() - 1, 0));
    }

    private Queue reverseNumber(int number, Queue<Integer> reversedQueue) {
        int quotient = number / 10;
        int remainder = number % 10;
        reversedQueue.add(remainder);
        if (quotient > 10) {
            reverseNumber(quotient, reversedQueue);
        } else {
            reversedQueue.add(quotient);
        }

        return reversedQueue;
    }

    private int regenerateReversedNumber(Queue<Integer> reversedQueue, int power, int sum) {
        if (power > 0) {
            sum = sum + reversedQueue.remove() * ((Double) Math.pow(10, power)).intValue();
            sum = regenerateReversedNumber(reversedQueue, power - 1, sum);
        } else {
            sum = sum + reversedQueue.remove();
        }
        return sum;
    }
}
