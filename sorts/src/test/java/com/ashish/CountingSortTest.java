package com.ashish;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author Ashish Sharma
 *         Created on 8/9/2015.
 */
public class CountingSortTest {

    @Test
    public void initializeSortArray() {
        int[] arrayToSort = new int[]{2, 5, 3, 0, 2, 3, 0, 3};

        CountingSort countingSort = new CountingSort(arrayToSort, 5);
        countingSort.calculateElementCount();
    }

    @Test
    public void calculateElementOrder() {
        int[] arrayToSort = new int[]{2, 5, 3, 0, 2, 3, 0, 3};

        CountingSort countingSort = new CountingSort(arrayToSort, 5);
        countingSort.calculateElementCount();
        countingSort.calculateElementOrderCount();
    }

    @Test
    public void countingSort() {
        int[] arrayToSort = new int[]{2, 5, 3, 0, 2, 3, 0, 3};

        CountingSort countingSort = new CountingSort(arrayToSort, 5);
        System.out.println(Arrays.toString(countingSort.countingSort()));
    }
}
