package com.ashish;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author Ashish Sharma
 *         Created on 7/5/2015.
 */
public class BubbleSortTest {

    @Test
    public void testBubbleSort() {

        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = new int[]{34, 2, 7, 8, 1, 43, 76, 89, 56};
        System.out.println(Arrays.toString(bubbleSort.sort(arr)));
    }
}
