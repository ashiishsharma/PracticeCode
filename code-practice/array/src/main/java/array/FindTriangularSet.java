package array;

import java.util.*;

/**
 * Created by batraa on 4/19/2015.
 * <p>
 * <p>
 * Given an array with lengths, you have to select 3 lengths (a, b and c) for a triangle such that it satisfies condition a+b>c,b+c>a, a+c>b.
 * Find the number of possible triangles can be created from the given array.
 * ex: 3 5 6 9 10
 * (3,9,10), (3 5 6), (5 6 10), (5 9 10), (5 6 9), (6 9 10)
 * so number of possible triangles is 6
 */
public class FindTriangularSet {

    public static void main(String args[]) {

        int arr[] = {3, 5, 6, 9, 10};
        System.out.print(findNumberOfTriangles(arr));
    }

    private static int findNumberOfTriangles(int arr[]) {

        int count = -1;

        Set<List<Integer>> set = new HashSet<List<Integer>>();

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                for (int k = j + 1; k < arr.length; k++) {

                    if ((arr[i] + arr[j] > arr[k]) && (arr[j] + arr[k] > arr[i]) && (arr[i] + arr[k] > arr[j])) {

                        List<Integer> lst = new ArrayList<Integer>();
                        lst.add(arr[i]);
                        lst.add(arr[j]);
                        lst.add(arr[k]);
                        set.add(lst);
                    }
                }
            }
        }

        return set.size();
    }

    private static int findNumberOfTriangles2(int A[]) {
        int count = 0;

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
                count++;
            }

        }
        return count;
    }

}
