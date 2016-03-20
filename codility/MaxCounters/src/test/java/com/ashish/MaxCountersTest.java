package com.ashish;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author Ashish Sharma
 */
public class MaxCountersTest {

    @Test
    public void maxCounter() {
        int A[] = {3, 4, 4, 6, 1, 4, 4};
        int counterCount = 5;
        solution(counterCount, A);
    }

    public int[] solution(int N, int[] A) {
        int counters[] = new int[N];
        int currentMaxValue = 0;
        for (int i : A) {
            if (i <= N) {
                counters[i - 1]++;
                if (currentMaxValue < counters[i - 1]) {
                    currentMaxValue = counters[i - 1];
                }
            } else if (i > N) {
                for (int j = 0; j < counters.length; j++) {
                    counters[j] = currentMaxValue;
                }
//                Arrays.fill(counters,currentMaxValue);
            }
        }
        return counters;
    }
}
