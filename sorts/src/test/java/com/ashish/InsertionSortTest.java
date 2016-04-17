package com.ashish;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author Ashish Sharma
 *         Created on 7/5/2015.
 */
public class InsertionSortTest {

    @Test
    public void insertionSort() {
        int[] arr = new int[]{34, 2, 7, 8, 1, 43, 76, 89, 56};

        InsertionSort insertionSort = new InsertionSort();
        arr = insertionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
