package com.ashish;

import java.util.Arrays;

public class TripleStep {

    public int simpleCountWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return simpleCountWays(n - 1) + simpleCountWays(n - 2) + simpleCountWays(n - 3);
        }
    }

    public int memoizationCountWays(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }

    private int countWays(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = countWays(n - 1, memo)
                    + countWays(n - 2, memo) + countWays(n - 3, memo);
            return memo[n];
        }
    }
}
