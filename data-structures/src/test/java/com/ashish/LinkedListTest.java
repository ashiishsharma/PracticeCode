package com.ashish;

import org.testng.annotations.Test;

/**
 * @author Ashish Sharma
 *         Created on 7/2/2015.
 */
public class LinkedListTest {

    @Test
    public void testLinkedList() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        System.out.println(linkedList.size());

        linkedList.remove(3);

        System.out.println(linkedList.size());

        linkedList.add(3, 3);

        System.out.println(linkedList.size());
//        java.util.LinkedList
        System.out.println(linkedList.get(4));

        linkedList.add(8,0);
    }
}
