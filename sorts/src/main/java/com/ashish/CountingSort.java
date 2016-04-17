package com.ashish;

/**
 * @author Ashish Sharma
 *         Created on 8/9/2015.
 */
public class CountingSort {

    int[] arrayToSort;
    int[] arrayElementCount;
    int[] sortedArray;

    /**
     * @param arrayToSort
     * @param maxElement  as per Coremen, this value is ranging from 0 to maxElement
     */
    public CountingSort(int[] arrayToSort, int maxElement) {
        this.arrayToSort = arrayToSort;
        arrayElementCount = new int[maxElement + 1];
        sortedArray = new int[arrayToSort.length];
    }


    public void calculateElementCount() {
        for (int i = 0; i < arrayToSort.length; i++) {
            arrayElementCount[arrayToSort[i]] = arrayElementCount[arrayToSort[i]] + 1;
        }
    }

    public void calculateElementOrderCount() {
        for (int i = 1; i < arrayElementCount.length; i++) {
            arrayElementCount[i] = arrayElementCount[i] + arrayElementCount[i - 1];
        }
    }

    public int[] countingSort() {
        calculateElementCount();
        calculateElementOrderCount();
        for (int i = arrayToSort.length - 1; i >= 0; i--) {
            sortedArray[arrayElementCount[arrayToSort[i]] - 1] = arrayToSort[i];
            arrayElementCount[arrayToSort[i]] = arrayElementCount[arrayToSort[i]] - 1;
        }
        return sortedArray;
    }
}
