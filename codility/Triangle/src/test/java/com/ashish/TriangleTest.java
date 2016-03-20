package com.ashish;

import org.apache.commons.collections.Bag;
import org.apache.commons.collections.bag.HashBag;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author Ashish Sharma
 */
public class TriangleTest {

    @Test
    public void triangleTest() {
        int A[] = new int[]{10, 2, 5, 1, 8, 20};
        System.out.println(solution(A));
    }

    public int solution(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        Arrays.sort(A);
        for (int i = 2; i < A.length; i++) {

            int p = A[i - 2];
            int q = A[i - 1];
            int r = A[i];

            if (p <= 0) {
                continue;
            }

            // r < p + q , just check this
            if (r - p < q) {
                return 1;
            }

        }
        return 0;
    }
}
