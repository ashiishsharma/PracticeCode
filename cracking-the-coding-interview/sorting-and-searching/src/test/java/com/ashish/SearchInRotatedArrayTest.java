package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * <B>10.3</B> ,  <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * <B>Search in Rotated Array:</B>
 * <p>
 * Given a sorted array of n integers that has been rotated an unknown
 * number of times, write code to find an element in the array. You may assume that the array was
 * originally sorted in increasing order.
 * <p>
 * EXAMPLE
 * Input:find 5 in{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
 * Output: 8 (the index of 5 in the array)
 *
 * @author Ashish Sharma on 03/28/2019.
 * @since 03/28/2019.
 */
public class SearchInRotatedArrayTest {

    SearchInRotatedArray searchInRotatedArray;

    @BeforeMethod
    public void init() {
        searchInRotatedArray = new SearchInRotatedArray();
    }

    @Test
    public void testSearchInRotatedArray() {

    }
}
