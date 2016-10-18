package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 2.4
 * Write code to partition a linked list around a value x,
 * such that all nodes less than x come before all nodes
 * greater than or equal to x.
 * <p>
 * Created by Ashish Sharma on 1/1/2016.
 */
public class PartitionLinkedListTest {

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
    public void partitionLinkedListTest() {
        LinkedList<Integer> partitionedList = partitionList(list, 7);
        System.out.println(partitionedList);
    }

    private LinkedList<Integer> partitionList(LinkedList<Integer> list, int i) {
        LinkedList<Integer> beforeList = new LinkedList<Integer>();
        LinkedList<Integer> afterList = new LinkedList<Integer>();
        afterList.add(i);

        for (Integer j : list) {
            if (j < i) {
                beforeList.add(j);
            } else if (j > i) {
                afterList.add(j);
            }
        }

        beforeList.add(afterList.getHead());
        return beforeList;
    }
}
