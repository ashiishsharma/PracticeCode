package com.ashish;

import org.testng.annotations.Test;

/**
 * 5.6
 * <p>
 * Write a program to swap odd and even bits in an integer with as few instructions as
 * possible (e.g., bit 0 and bit! are swapped, bit 2 and bit 3 are swapped, and so on).
 * <p>
 *
 * @author Ashish Sharma on 4/4/2017.
 *         <p>
 * @since 4/4/2017.
 */
public class BitSwapTest {

    @Test
    public void testSwapBits() {
        int i = 34;
        System.out.println("Integer to have bits swapped : " + i);
        System.out.println("Integer after bits swapped : " + swapOddEvenBits(i));
    }

    //Only for 32 bit int
    public int swapOddEvenBits(int x) {
        return (((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1));
    }
}
