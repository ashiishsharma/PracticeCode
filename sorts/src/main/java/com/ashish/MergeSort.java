package com.ashish;

/**
 * @author Ashish Sharma
 *         Created on 7/9/2015.
 */
public class MergeSort {
    private int[] array;
    private int[] tempArray;

    private int arrayLength;

    public int[] sort(int[] values) {
        this.array = values;
        arrayLength = values.length;
        this.tempArray = new int[arrayLength];
        mergesort(0, arrayLength - 1);
        return array;
    }

    private void mergesort(int start, int end) {
        // check if start is smaller then end, if not then the array is sorted
        if (start < end) {
            // Get the index of the element which is in the middle
            int middle = start + (end - start) / 2;
            // Sort the left side of the array
            mergesort(start, middle);
            // Sort the right side of the array
            mergesort(middle + 1, end);
            // Combine them both
            merge(start, middle, end);
        }
    }

    private void merge(int start, int middle, int end) {

        // Copy both parts into the tempArray array
        for (int i = start; i <= end; i++) {
            tempArray[i] = array[i];
        }

        int tempArrayIndex = start;
        int middleIndex = middle + 1;
        int arrayIndex = start;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (tempArrayIndex <= middle && middleIndex <= end) {
            if (tempArray[tempArrayIndex] <= tempArray[middleIndex]) {
                array[arrayIndex] = tempArray[tempArrayIndex];
                tempArrayIndex++;
            } else {
                array[arrayIndex] = tempArray[middleIndex];
                middleIndex++;
            }
            arrayIndex++;
        }
        // Copy the rest of the left side of the array into the target array
        while (tempArrayIndex <= middle) {
            array[arrayIndex] = tempArray[tempArrayIndex];
            arrayIndex++;
            tempArrayIndex++;
        }

    }
}
