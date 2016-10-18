package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;

import com.ashish.LinkedList;

import java.util.Set;

/**
 * 2.1
 * <p>
 * Write code to remove duplicates from an unsorted linked list.
 * <p>FOLLOW UP
 * <p>How would you solve this problem if a temporary buffer is not allowed?
 * <p>Answer : If temporary buffer is not allowed then we can iterate with two pointers: current which iterates
 * through the linked list, and runner which checks all subsequent nodes for duplicates , 0(1) space, but 0(N2) time
 * <p>
 * @author Ashish Sharma on 12/28/2015.
 */
public class RemoveDuplicatesTest {

    private LinkedList<Integer> duplicateList;
    private Set<Integer> duplicateFinder;

    @BeforeMethod
    public void setLinkedList() {
        duplicateList = new LinkedList<Integer>();

        duplicateList.add(1);
        duplicateList.add(5);
        duplicateList.add(8);
        duplicateList.add(3);
        duplicateList.add(1);
        duplicateList.add(5);
        duplicateList.add(8);
        duplicateList.add(3);

        duplicateFinder = new HashSet<Integer>();
    }

    @Test
    public void removeDuplicateTest() {

        // Set don't allow duplicates, so we are using that property to remove duplicates in the linked list
        System.out.println(duplicateList);

        for (Integer i : duplicateList) {
            if (!duplicateFinder.contains(i)) {
                duplicateFinder.add(i);
            }
        }

        duplicateList = new LinkedList<Integer>();
        for (Integer i : duplicateFinder) {
            duplicateList.add(i);
        }

        System.out.println(duplicateList);
    }
}
