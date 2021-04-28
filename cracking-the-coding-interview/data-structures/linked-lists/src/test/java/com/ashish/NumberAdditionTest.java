package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 2.5
 * <p>
 * You have two numbers represented by a linked list,
 * where each node contains a single digit. The digits
 * are stored in reverse order, such that the 1's digit is at the
 * head of the list. Write a function that adds the two numbers and
 * returns the sum as a linked list.
 * EXAMPLE
 * <p>Input: (7-&gt; 1 -&gt; 6) + (5 -&gt; 9 -&gt; 2).That is, 617 + 295.
 * <p>Output: 2 -&gt; 1 -&gt; 9.That is, 912.
 * <p>FOLLOW UP
 * <p>Suppose the digits are stored in forward order. Repeat the above problem.
 * <p>EXAMPLE
 * <p>Input: (6 -&gt; 1 -&gt; 7) + (2 -&gt; 9 -&gt; 5).That is, 617 + 295.
 * <p>Output: 9 -&gt; 1 -&gt; 2.That is, 912.
 * <p>
 * @author Ashish Sharma on 1/3/2016.
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
        firstNumber.add(4);
        firstNumber.add(7);

        secondNumber.add(2);
        secondNumber.add(9);
        secondNumber.add(5);
        secondNumber.add(8);

        sumResultList = new LinkedList<Integer>();
        addReverseOrderNumberLists(firstNumber, secondNumber);

        System.out.println(sumResultList);
    }


    /**
     * Solution for reverse Order sum
     *
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
            if (sumOfDigit >= 10) {
                carryOver = sumOfDigit / 10;
                sumOfDigit = sumOfDigit % 10;
            } else {
                carryOver = 0;
            }

            sumResultList.add(sumOfDigit);

            if (firstNumberDigit != null) {
                firstNumberDigit = firstNumberDigit.getNext();
            }

            if (secondNumberDigit != null) {
                secondNumberDigit = secondNumberDigit.getNext();
            }


        } while (firstNumberDigit != null || secondNumberDigit != null || carryOver > 0);
    }

    /**
     * Solution for forward Order
     *
     * Read the List and put the elements in a stack,pop the stack elements to create a reverse order list ,
     * Use the solution described above.
     * Again read the list returned as solution ( reverse order list ) using a stack ,
     * pop out the elements to create a forward order list
     */
    @Test
    public void numberForwardAdditionTest() {
        LinkedList firstNumber = new LinkedList();
        LinkedList secondNumber = new LinkedList();

        firstNumber.add(6);
        firstNumber.add(1);
        firstNumber.add(7);

        secondNumber.add(2);
        secondNumber.add(9);
        secondNumber.add(5);

    }

    @Test
    /**
     * Alternative solution
     */
    public void numberAdditionTestBetterSolution(){
        /* Convert each linked list to regular integer by following algorithm :
         6 -> 1 -> 7 in linked list = 6 * 100 + 1 * 10 + 7 = 617
         2 -> 9 -> 5 in linked list = 2 * 100 + 9 * 10 + 5 = 295
         Add the integers by regular 617 + 295 = 912
         Now divide the resulting integer by 10 repeatedly , the remainder gives out the digits, : https://stackoverflow.com/questions/5196186/split-int-value-into-separate-digits
         take the digits and create the linked list with that.
         Alternatively, Convert the sum integer to a string , take out the character array out of the string for individual digits
         and then create the linked list.
        */
    }


}
