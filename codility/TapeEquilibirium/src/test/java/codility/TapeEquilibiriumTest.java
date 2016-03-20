package codility;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * @author Ashish Sharma
 */
public class TapeEquilibiriumTest {

    @Test
    public void getMinimumDifference() {

        int[] arr = new int[]{3, 1, 2, 4, 3};


        System.out.println(solution(arr));
    }


    public int solution(int A[]) {
        if (A.length != 0 && A.length > 1) {
            int minimumDifference = Integer.MAX_VALUE;
            int currentDifference = Integer.MAX_VALUE;

            int totalSum = Arrays.stream(A, 0, A.length).sum();
            int currentSum = 0;

            for (int i = 0; i < A.length - 1; i++) {
                currentSum += A[i];
                currentDifference = Math.abs(currentSum - (totalSum - currentSum));
                if (currentDifference < minimumDifference) {
                    minimumDifference = currentDifference;
                }
            }

            return minimumDifference;
        } else if (A.length == 1) {
            return A[0];
        } else {
            return -1;
        }

    }
}
