import org.testng.annotations.Test;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Ashish Sharma
 */
public class MissingIntegerTest {

    @Test
    public void findMissingElement() {
        int A[] = {1, 3, 6, 4, 1, 2};

        System.out.println(solution(A));
    }

    public int solution(int[] A) {
        int len = A.length;
        int[] buffer = new int[len];
        int min = Integer.MAX_VALUE;

        // Find min within the array for the positive integers
        for (int i = 0; i < len; i++) {
            if (min > A[i] && A[i] > 0) {
                min = A[i];
            }
        }

        // No positive integer? Return 1
        if (min == Integer.MAX_VALUE) {
            return 1;
        }

        // Fill additional buffer with positive integers restricting to valus from 1 to A.length
        for (int i = 0; i < len; i++) {
            if (A[i] > len) continue;
            if (A[i] < 1) continue;
            buffer[A[i] - 1] = A[i];
        }

        // Return result
        if (buffer[0] != 1) return 1;
        for (int i = 0; i < len; i++) {
            if (buffer[i] == 0) return i + 1;
        }
        return len + 1;
    }
}
