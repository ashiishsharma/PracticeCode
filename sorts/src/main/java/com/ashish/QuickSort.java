package com.ashish;

/**
 * @author Ashish Sharma
 *         Created on 7/5/2015.
 */
public class QuickSort {
    public int[] sort(int[] arr) {
        if (arr.length > 1) {
            quickSort(arr, 0, arr.length - 1);
        }
        return arr;
    }

    private int[] quickSort(int arr[], int start, int end) {
        if (end - start + 1 > 1) {
            int pivotPoint = start;
            int pivot = arr[pivotPoint];
            do {
                for (int i = end; i > pivotPoint; i--) {
                    if (pivot > arr[i]) {
                        pivotPoint = swap(arr, pivotPoint, pivot, i);
                        break;
                    }
                }
                for (int i = start; i < pivotPoint; i++) {
                    if (pivot < arr[i]) {
                        pivotPoint = swap(arr, pivotPoint, pivot, i);
                        break;
                    }
                }
            } while (!leftIsSmall(arr, start, pivotPoint) || !rightIsLarge(arr, end, pivotPoint));
            if (start == pivotPoint) {
                quickSort(arr, start + 1, end);
                quickSort(arr, pivotPoint + 1, end - 1);
            } else {
                quickSort(arr, start, pivotPoint - 1);
                quickSort(arr, pivotPoint + 1, end);
            }
        }
        return arr;
    }

    private int swap(int[] arr, int pivotPoint, int pivot, int i) {
        int temp = arr[i];
        arr[i] = pivot;
        arr[pivotPoint] = temp;
        pivotPoint = i;
        return pivotPoint;
    }

    private boolean rightIsLarge(int[] arr, int end, int pivotPoint) {
        boolean rightIsLarge = true;
        for (int i = pivotPoint + 1; i <= end; i++) {
            if (arr[i] < arr[pivotPoint]) {
                rightIsLarge = false;
            }
        }
        return rightIsLarge;
    }

    private boolean leftIsSmall(int[] arr, int start, int pivotPoint) {
        boolean leftIsSmall = true;
        for (int i = start; i < pivotPoint; i++) {
            if (arr[i] > arr[pivotPoint]) {
                leftIsSmall = false;
            }
        }
        return leftIsSmall;
    }
}
