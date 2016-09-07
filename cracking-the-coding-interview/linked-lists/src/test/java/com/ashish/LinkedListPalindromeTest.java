package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Stack;

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
        /**
         * Use Floyd's algorithm to reach the middle of the linked list.
         * Add element in stack from one step pointer till you reach middle
         * Iterate from middle to end matching the elements from stack to validate
         * the palindrome.
         */
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
//        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(1);

        LinkedList.Node oneStepPointer = linkedList.getHead();
        LinkedList.Node twoStepPointer = linkedList.getHead();

        Stack palindromeStack = new Stack();
        palindromeStack.add(oneStepPointer.getElement());

        do {
            oneStepPointer = oneStepPointer.getNext();
            palindromeStack.add(oneStepPointer.getElement());
            twoStepPointer = twoStepPointer.getNext().getNext();

            if (twoStepPointer == null) {
                System.out.println("Reached end of linked list");
                break;
            }
        }
        while (twoStepPointer != null
                && twoStepPointer.getNext() != null);

        if (twoStepPointer != null) {
            oneStepPointer = oneStepPointer.getNext();
            palindromeStack.pop();
        }else {
            palindromeStack.pop();
        }

        boolean isPalindrome = false;
        while (oneStepPointer != null) {
            if (oneStepPointer.getElement() != palindromeStack.pop()) {
                isPalindrome = false;
                break;
            }
            oneStepPointer = oneStepPointer.getNext();
            isPalindrome = true;
        }

        if (isPalindrome) {
            System.out.println("Linked list is a palindrome");
        } else {
            System.out.println("Linked list is not a palindrome");
        }
    }
}
