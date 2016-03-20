package codility.array;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author Ashish Sharma
 */
public class ArrayElementTest {

    @Test
    public void findArrayElement() {
        int A[] = {2, 3, 1, 5};


        int missingElement = solution(A);
        System.out.println(missingElement);
    }

    private int solution(int A[]){
        Arrays.sort(A);
        int missingElement = -1;
        for (int i = 0; i < A.length; i++) {
            if (i+1 < A.length && A[i] + 1 != A[i + 1]) {
                missingElement = A[i] + 1;
            }
        }
        return missingElement;
    }
}
