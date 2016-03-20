package codility.permcheck;

import org.testng.annotations.Test;

/**
 * @author Ashish Sharma
 */
public class PermutationCheckTest {

    @Test
    public void checkPermutation() {
        int[] permutationArray = new int[]{4, 1, 3};

        System.out.println(solution(permutationArray));
    }

    public int solution(int A[]) {
        int arraySum = 0;
        int summation = 0;
        int highestElement = 0;
        for (int i = 0; i < A.length; i++) {
            arraySum += A[i];
            if (A[i] > highestElement) {
                highestElement = A[i];
            }
        }
        //Summation on first n numbers formula
        summation = (highestElement * (highestElement + 1)) / 2;

        if (summation == arraySum) {
            return 1;
        } else {
            return 0;
        }
    }
}
