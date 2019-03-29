package com.ashish;

import java.util.Arrays;

public class PeaksAndValleys {

    void sortValleyPeak(int[] array) {
        Arrays.sort(array);
        for (int i = 1; i < array.length; i += 2) {
            swap(array, i - 1, i);
        }
    }


    void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
