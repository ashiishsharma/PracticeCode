package com.ashish;

import org.testng.annotations.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 5.7
 * <p>
 * An array A contains all the integers from 0 through n,
 * except for one number which is missing.
 * <p>
 * In this problem, we cannot access an entire integer in A with a single operation.
 * <p>
 * The elements of A are represented in binary, and the only operation we can use
 * to access them is "fetch the jth bit of A[i]," which takes constant time.
 * <p>
 * Write code to find the missing integer.
 * <p>
 * Can you do it in O(n) time?
 * <p>
 *
 * @author Ashish Sharma on 4/4/2017.
 *         <p>
 * @since 4/4/2017.
 */
public class FindMissingNumberTest {

    //Getting wrong results
    @Test
    public void testMissingInteger() {
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 18, 19, 20};
        ArrayList<BitInteger> arrayList = new ArrayList();

        for (int i : array) {
            arrayList.add(new BitInteger(i));
        }

        System.out.println("Missing number is : " + findMissing(arrayList));
    }

    public int findMissing(ArrayList<BitInteger> array) {
 /* Start from the least significant bit, and work our way up */
        return findMissing(array, 0);
    }

    public int findMissing(ArrayList<BitInteger> input, int column) {
        if (column >= BitInteger.INTEGER_SIZE) { // We're done!
            return 0;
        }
        ArrayList<BitInteger> oneBits = new ArrayList<BitInteger>(input.size() / 2);
        ArrayList<BitInteger> zeroBits =
                new ArrayList<BitInteger>(input.size() / 2);

        for (BitInteger t : input) {
            if (t.fetch(column) == 0) {
                zeroBits.add(t);
            } else {
                oneBits.add(t);
            }
        }
        if (zeroBits.size() <= oneBits.size()) {
            int v = findMissing(zeroBits, column + 1);
            return (v << 1) | 0;
        } else {
            int v = findMissing(oneBits, column + 1);
            return (v << 1) | 1;
        }
    }
}
