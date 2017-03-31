package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 3.6
 * <p>
 * Write a program to sort a stack in ascending order (with biggest items on top).
 * You may use at most one additional stack to hold items, but you may not copy the
 * elements into any other data structure (such as an array). The stack supports the
 * following operations: push, pop, peek, and isEmpty.
 * <p>
 *
 * @author Ashish Sharma on 1/5/2017.
 * @since 1/5/2017
 */
public class StackInAscendingOrderTest {


    private Stack<Integer> sortedStack;
    private Stack<Integer> inputStack;

    @BeforeMethod
    public void initialize() {
        sortedStack = new Stack<Integer>();
        inputStack = new Stack<Integer>();
    }

    @Test
    public void testSortingStackWithOneElement() {
        inputStack.push(1);
        sortStack();
        printSortedStack();
    }

    @Test
    public void testSortingStackWithTwoElement() {
        inputStack.push(2);
        inputStack.push(1);
        sortStack();
        printSortedStack();
    }

    @Test
    public void testSortingStack() {
        inputStack.push(2);
        inputStack.push(8);
        inputStack.push(10);
        inputStack.push(15);
        sortStack();
        printSortedStack();
    }

    private Stack sortStack() {
        while (!inputStack.isEmpty()) {
            if (sortedStack.isEmpty()) {
                sortedStack.push(inputStack.pop());
                continue;
            }
            int elementToPush = inputStack.pop();
            //insert all the elements of sortedStack in inputStack that is
            // greater then the inputStack top element
            while (!sortedStack.isEmpty() && sortedStack.peek() > elementToPush) {
                inputStack.push(sortedStack.pop());
            }
            sortedStack.push(elementToPush);
        }
        return sortedStack;
    }

    private void printSortedStack() {
        while (!sortedStack.isEmpty()) {
            System.out.print(sortedStack.pop() + ", ");
        }
    }
}
