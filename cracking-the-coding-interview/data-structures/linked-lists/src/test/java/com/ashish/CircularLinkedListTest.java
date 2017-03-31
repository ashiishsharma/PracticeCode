package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Ashish Sharma on 27-08-2016.
 */
public class CircularLinkedListTest {

    @BeforeMethod
    public void init() {

    }

    @Test
    public void testCircular() {
        CircularLinkedList circularLinkedList = getCircularLinkedList();
        System.out.println("test");
    }

    private CircularLinkedList getCircularLinkedList() {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.add(1);
        circularLinkedList.add(2);
        circularLinkedList.add(3);
        circularLinkedList.add(4);
        circularLinkedList.add(5);
        circularLinkedList.add(6);
        circularLinkedList.add(7);
        circularLinkedList.add(8);
        circularLinkedList.add(9);
        circularLinkedList.add(10);
        circularLinkedList.makeCircular(4);
        return circularLinkedList;
    }

    @Test
    public void testIsLinkedListCircular() {
        CircularLinkedList circularLinkedList = getCircularLinkedList();

        // Detect Circular linked list, Floyd's algorithm

        LinkedList.Node oneStepPointer = circularLinkedList.getHead();
        LinkedList.Node twoStepPointer = circularLinkedList.getHead();

        do {
            oneStepPointer = oneStepPointer.getNext();
            twoStepPointer = twoStepPointer.getNext().getNext();

            if (oneStepPointer != null && twoStepPointer != null && oneStepPointer.getElement() == twoStepPointer.getElement()) {
                System.out.println("Linked list is circular");
                break;
            }
        } while (oneStepPointer != null || twoStepPointer != null);
    }


}

