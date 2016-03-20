package com.ashish;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author Ashish Sharma
 */
public class MaxProductOfThreeTest {


    @Test
    public void maxProductOfThreeTest() {
        int[] A = {-3, 1, 2, -2, 5, 6};
        System.out.println(solution(A));
    }

    public int solution1(int[] A) {
        int N = A.length;
        // the worst-case time complexity is O(N*log(N))
        Arrays.sort(A);
        // the max product of three elements is the product of the last three
        // elements in the sorted array or the product of the first two elements
        // and the last element if the first two elements are negatives.
        return Math.max(A[0] * A[1] * A[N-1], A[N-3] * A[N-2] * A[N-1]);
    }

    public int solution(int[] A) {

        int[] maxes = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        // Invariant: maxes[0] <= maxes[1] <= maxes[2]

        int[] mins = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        // Invariant: mins[0] <= mins[1]

        // O(n)
        for (int a : A) {
            updateMaxes(a, maxes);
            updateMins(a, mins);
        }

        System.out.println(Arrays.toString(maxes));
        System.out.println(Arrays.toString(mins));

        int obvious = maxes[0] * maxes[1] * maxes[2];
        int twoBigNegs = mins[0] * mins[1] * maxes[2];
        return Math.max(obvious, twoBigNegs);
    }

    private static void updateMaxes(int a, int[] maxes) {
        if (a >= maxes[2]) {
            // Found new max, shift down
            maxes[0] = maxes[1];
            maxes[1] = maxes[2];
            maxes[2] = a;
        } else if (a >= maxes[1]) {
            maxes[0] = maxes[1];
            maxes[1] = a;
        } else if (a > maxes[0]) {
            maxes[0] = a;
        }
    }

    private static void updateMins(int a, int[] mins) {
        if (a <= mins[0]) {
            // Found new min, shift down
            mins[1] = mins[0];
            mins[0] = a;
        } else if (a < mins[1]) {
            mins[1] = a;
        }
    }
}
