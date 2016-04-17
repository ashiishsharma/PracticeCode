package com.ashish;

/**
 * @author Ashish Sharma
 *         Created on 7/5/2015.
 */
public class InsertionSort {
    public int[] sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
        return arr;
    }
}
