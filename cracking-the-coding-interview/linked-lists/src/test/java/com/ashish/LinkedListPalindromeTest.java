package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 2.7
 * Implement a function to check if a linked list is a palindrome
 * <p>
 * Created by developer on 05-09-2016.
 */
public class LinkedListPalindromeTest {

    @BeforeMethod
    public void init() {

    }

    @Test
    public void checkPalindromeTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(1);

        LinkedList.Node oneStepPointer = linkedList.getHead();
        LinkedList.Node twoStepPointer = linkedList.getHead();

        do {
            oneStepPointer = oneStepPointer.getNext();
            twoStepPointer = twoStepPointer.getNext().getNext();

            if (twoStepPointer == null) {
                System.out.println("Reached end of linked list");
                break;
            }
        }
        while (twoStepPointer != null
                && twoStepPointer.getNext() != null
                && twoStepPointer.getNext().getNext() != null);


    }
}
