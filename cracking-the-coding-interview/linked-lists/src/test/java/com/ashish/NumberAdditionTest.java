package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * You have two numbers represented by a linked sumResultList,
 * where each node contains a single digit. The digits
 * are stored in reverse order, such that the 1's digit is at the
 * head of the sumResultList. Write a function that adds the two numbers and
 * returns the sum as a linked sumResultList.
 * EXAMPLE
 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295.
 * Output: 2 -> 1 -> 9.That is, 912.
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * EXAMPLE
 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is, 617 + 295.
 * Output: 9 -> 1 -> 2.That is, 912.
 * <p>
 * Created by Ashish Sharma on 1/3/2016.
 */
public class NumberAdditionTest {

    private LinkedList<Integer> sumResultList;

    @BeforeMethod
    public void setLinkedList() {
        sumResultList = new LinkedList<Integer>();
    }

    /**
     * Solution for reverse Order
     */
    @Test
    public void numberAdditionTest() {
        LinkedList firstNumber = new LinkedList();
        LinkedList secondNumber = new LinkedList();

        firstNumber.add(7);
        firstNumber.add(1);
        firstNumber.add(6);

        secondNumber.add(2);
        secondNumber.add(9);
        secondNumber.add(5);

        sumResultList = new LinkedList<Integer>();
        addReverseOrderNumberLists(firstNumber, secondNumber);

        System.out.println(sumResultList);
    }


    /**
     * Solution for reverse Order sum
     * @param firstNumber
     * @param secondNumber
     */
    private void addReverseOrderNumberLists(LinkedList firstNumber, LinkedList secondNumber) {
        LinkedList.Node firstNumberDigit = firstNumber.getHead();
        LinkedList.Node secondNumberDigit = secondNumber.getHead();

        Integer carryOver = 0;
        do {
            Integer firstDigit = 0;
            Integer secondDigit = 0;

            if (firstNumberDigit != null) {
                firstDigit = (Integer) firstNumberDigit.getElement();
            }

            if (secondNumberDigit != null) {
                secondDigit = (Integer) secondNumberDigit.getElement();
            }


            Integer sumOfDigit = carryOver + firstDigit + secondDigit;
            if (sumOfDigit > 10) {
                carryOver = sumOfDigit / 10;
                sumOfDigit = sumOfDigit % 10;
            } else {
                carryOver = 0;
            }

            sumResultList.add(sumOfDigit);

            firstNumberDigit = firstNumberDigit.getNext();
            secondNumberDigit = secondNumberDigit.getNext();


        } while (firstNumberDigit != null || secondNumberDigit != null || carryOver > 0);
    }

    /**
     * Solution for forward Order
     */
    @Test
    public void numberForwardAdditionTest() {
        LinkedList firstNumber = new LinkedList();
        LinkedList secondNumber = new LinkedList();

        firstNumber.add(6);
        firstNumber.add(1);
        firstNumber.add(7);

        secondNumber.add(5);
        secondNumber.add(9);
        secondNumber.add(2);

        sumResultList = new LinkedList<Integer>();
        addReverseOrderNumberLists(firstNumber, secondNumber);

        System.out.println(sumResultList);
    }
}
