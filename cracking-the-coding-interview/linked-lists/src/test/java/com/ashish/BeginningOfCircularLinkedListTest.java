package com.ashish;

import org.testng.annotations.Test;

/**
 * Created by developer on 10-07-2016.
 *
 * 2.6
 * Given a circular linked list, implement an algorithm which returns the node at the
 beginning of the loop
 */
public class BeginningOfCircularLinkedListTest {

    @Test
    public void testGetLoopingPoint() {
        CircularLinkedList circularLinkedList = getCircularLinkedList();

        //region Detect Circular linked list, Floyd's algorithm

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

        //endregion

        //region Getting the looping point
        // Run both the pointers at same speed now
        oneStepPointer = circularLinkedList.getHead();
        do {
            if (oneStepPointer.getElement() == twoStepPointer.getElement()) {
                System.out.println("Looping point: " + oneStepPointer.getElement());
                break;
            }
            // Running the pointers at same speed now
            oneStepPointer = oneStepPointer.getNext();
            twoStepPointer = twoStepPointer.getNext();
        } while (true);
        //endregion
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
}
