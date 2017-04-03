package com.ashish;

/**
 * 5.5
 * <p>
 * Write a function to determine the number of bits required to
 * convert integer A to integer B.
 * <p>
 * EXAMPLE :
 * Input : 31,14
 * Output : 2
 *
 * @author Ashish Sharma on 4/3/2017.
 *         <p>
 * @since 4/3/2017
 */
public class ConvertIntegerTest {

    int bitSwapRequired(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c = c >> 1) {
            count += c & 1;
        }
        return count;
    }

    public static int bitSwapRequired2(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c = c & (c - 1)) {
            count++;
        }
        return count;
    }
}
