package com.ashish;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author Ashish Sharma
 *         Created on 7/9/2015.
 */
public class MergeSortTest {

    @Test
    public void testMergeSort() {
        MergeSort mergeSort = new MergeSort();
        int[] arr = new int[]{34, 7, 5, 3, 22, 55, 1, 76, 65, 25, 456, 120, 55, 44, 42};
        System.out.println(Arrays.toString(mergeSort.sort(arr)));
    }
}
