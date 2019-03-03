package com.ashish;

public class RecursiveMultiply {

    public int minProduct(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;
        return minProductHelper(smaller, bigger);
    }

    private int minProductHelper(int smaller, int bigger) {
        if (smaller == 0) { // 0 x bigger = 0
            return 0;
        } else if (smaller == 1) { // 1 x bigger bigger
            return bigger;
        }
        /* Compute half. If uneven, compute other half. If even, double it. */
        int s = smaller >> 1; // Divide by 2
        int side1 = minProduct(s, bigger);
        int side2 = side1;
        if (smaller % 2 == 1) {
            side2 = minProductHelper(smaller - s, bigger);
        }
        return side1 + side2;
    }
}
