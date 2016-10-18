package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ashish.LinkedList.*;

/**
 * 2.2
 * Implement an algorithm to find the kth to last element of a singly linked list.
 * <p>
 * Created by Ashish Sharma on 12/29/2015.
 */
public class KthElementLocationTest {

    private LinkedList<Integer> list;

    @BeforeMethod
    public void setLinkedList() {
        list = new LinkedList<Integer>();
        list.add(1);
        list.add(5);
        list.add(8);
        list.add(3);
        list.add(7);
        list.add(9);
        list.add(2);
        list.add(4);
        list.add(6);
    }

    /**
     * Recursively iterate till last element and then count backwards in the linked list.
     */
    @Test
    public void elementLocationTestRecursive() {
        ReverseCount reverseCount = new ReverseCount();
        int elementNumber = 3;
        System.out.println(nthToLastReturnRecursive(list.getHead(), elementNumber, reverseCount).getElement());
    }

    public class ReverseCount {
        public int value = 0;
    }

    public Node nthToLastReturnRecursive(Node head, int elementNumber, ReverseCount i) {
        if (head == null) {
            return null;
        }
        Node node = nthToLastReturnRecursive(head.getNext(), elementNumber, i);
        i.value = i.value + 1;
        if (i.value == elementNumber) { // We've found the kth element
            return head;
        }
        return node;
    }


    /**
     * Set two pointer's spaced apart with the 'elementNumber' required and then iterate the pointers till the end.
     */
    @Test
    public void elementLocationTestIterative() {
        int elementNumber = 3;
        System.out.println(nthToLastReturnIterative(list.getHead(), elementNumber).getElement());
    }

    public Node nthToLastReturnIterative(Node head, int elementNumber) {
        Node first, second, nodeToReturn = null;

        if (head != null) {

            first = head;
            for (int i = 0; i < elementNumber - 1; i++) {
                if (first == null) {
                    return nodeToReturn;
                }
                first = first.getNext();
            }
            second = head;

            while (first.getNext() != null) {
                first = first.getNext();
                second = second.getNext();
            }

            nodeToReturn = second;

        }
        return nodeToReturn;
    }

}
