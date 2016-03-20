package com.ashish;

import org.testng.annotations.Test;

/**
 * @author Ashish Sharma
 */
public class CountDivTest {

    @Test
    public void countDiv() {
        int A = 6;
        int B = 11;
        int K = 2;

        System.out.println(solution(A,B,K));
    }

    public int solution(int A, int B, int K) {
        int counter = 0;
        for (int i = A; i <= B; i++) {
            if (i % K == 0) {
                counter++;
            }
        }
        return counter;
    }
}