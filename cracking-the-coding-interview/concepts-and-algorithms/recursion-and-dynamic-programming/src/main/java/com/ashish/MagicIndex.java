package com.ashish;

public class MagicIndex {

    public int magicIndexSimple(int[] array) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == index) {
                return index;
            }
        }
        return -1;
    }

    public int magicIndexBinarySearch(int[] array) {
        return magicIndexBinarySearch(array, 0, array.length - 1);
    }

    private int magicIndexBinarySearch(int[] array, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid) {
            return magicIndexBinarySearch(array, start, mid - 1);
        } else {
            return magicIndexBinarySearch(array, mid + 1, end);
        }
    }

    int magicIndexBinarySearchDuplicateArrayElements(int[] array) {
        return magicIndexBinarySearchDuplicateArrayElements(array, 0, array.length - 1);
    }

    int magicIndexBinarySearchDuplicateArrayElements(int[] array, int start, int end) {
        if (end < start) return -1;

        int midindex = (start + end) / 2;
        int midValue = array[midindex];
        if (midValue == midindex) {
            return midindex;
        }

        /* Search left */
        int leftindex = Math.min(midindex - 1, midValue);
        int left = magicIndexBinarySearchDuplicateArrayElements(array, start, leftindex);
        if (left >= 0) {
            return left;
        }

        /* Search right */
        int rightIndex = Math.max(midindex + 1, midValue);
        int right = magicIndexBinarySearchDuplicateArrayElements(array, rightIndex, end);

        return right;
    }
}
