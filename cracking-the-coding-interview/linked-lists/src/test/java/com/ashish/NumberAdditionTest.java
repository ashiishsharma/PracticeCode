package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * You have two numbers represented by a linked list,
 * where each node contains a single digit. The digits
 * are stored in reverse order, such that the 1's digit is at the
 * head of the list. Write a function that adds the two numbers and
 * returns the sum as a linked list.
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

    @Test
    public void numberAdditionTest(){
        
    }
}
