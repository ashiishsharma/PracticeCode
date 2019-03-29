package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * <B>10.11</B> ,  <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * <B>Peaks and Valleys:</B>
 * <p>
 * In an array of integers, a "peak" is an element which is greater than or equal
 * to the adjacent integers and a "valley" is an element which is less than or equal to the adjacent
 * integers. For example, in the array {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and {5, 2} are valleys. Given an
 * array of integers, sort the array into an alternating sequence of peaks and valleys.
 * EXAMPLE
 * Input: {5, 3, 1, 2, 3}
 * Output: {5, 1, 3, 2, 3}
 *
 * @author Ashish Sharma on 03/29/2019.
 * @since 03/29/2019.
 */
public class PeaksAndValleysTest {

    PeaksAndValleys peaksAndValleys;

    @BeforeMethod
    public void init(){
        peaksAndValleys = new PeaksAndValleys();
    }

    @Test
    public void testPeaksAndValleys(){

    }
}
