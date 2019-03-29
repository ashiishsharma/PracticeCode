package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * <B>10.4</B> ,  <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * <B>Sorted Search, No Size:</B>
 * <p>
 * You are given an array-like data structure Listy which lacks a size
 * method. It does, however, have an elementAt ( i) method that returns the element at index i in
 * 0( 1) time. If i is beyond the bounds of the data structure, it returns -1. (For this reason, the data
 * structure only supports positive integers.) Given a Listy which contains sorted, positive integers,
 * find the index at which an element x occurs. If x occurs multiple times, you may return any index.
 *
 * @author Ashish Sharma on 03/29/2019.
 * @since 03/29/2019.
 */
public class SortedSearch_NoSizeTest {

    SortedSearch_NoSize sortedSearch_noSize;

    @BeforeMethod
    public void init(){
        sortedSearch_noSize = new SortedSearch_NoSize();
    }

    @Test
    public void testSortedSearch_NoSize(){

    }
}
