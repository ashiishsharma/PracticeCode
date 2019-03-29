package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * <B>10.5</B> ,  <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * <B>Sparse Search:</B>
 * <p>
 * Given a sorted array of strings that is interspersed with empty strings, write a
 * method to find the location of a given string.
 * <p>
 * EXAMPLE
 * Input: ball, {"at", "", "", "", "", , , "ball","car", "" , "" , "dad", ""}
 * Output: 4
 *
 * @author Ashish Sharma on 03/29/2019.
 * @since 03/29/2019.
 */
public class SparseSearchTest {

    SparseSearch sparseSearch;

    @BeforeMethod
    public void init() {
        sparseSearch = new SparseSearch();
    }

    @Test
    public void testSparseTest() {

    }
}
