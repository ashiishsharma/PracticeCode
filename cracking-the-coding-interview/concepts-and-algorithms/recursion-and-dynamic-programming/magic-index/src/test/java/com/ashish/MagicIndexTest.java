package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * 8.3
 * <p>
 * <B>Magic Index:</B>
 * <p>
 * A magic index in an array A[ 1 ... n-1] is defined to be an index such that A[i] = i.
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
 * FOLLOW UP
 * What if the values are not distinct?
 * <p>
 *
 * @author Ashish Sharma on 02/26/2019.
 * <p>
 * @since 02/26/2019.
 */
public class MagicIndexTest {

    private MagicIndex magicIndex;

    @BeforeMethod
    public void init() {
        magicIndex = new MagicIndex();
    }

    /**
     * For case when array values are distinct
     */
    @Test
    public void testMagicIndex() {
        int testArray[] = new int[]{-2, -1, 3, 4, 8, 5, 11, 23, 24, 56, 58, 67};
        System.out.println("Magic index at: " + magicIndex.magicIndexSimple(testArray));

    }

    /**
     * For case when array values are distinct
     */
    @Test
    public void testMagicIndexBinarySearch() {
        int testArray[] = new int[]{-2, -1, 3, 4, 8, 5, 11, 23, 24, 56, 58, 67};
        System.out.println("Magic index at: " + magicIndex.magicIndexBinarySearch(testArray));
    }

    /**
     * For case when array values are duplicates
     */
    @Test
    public void testMagicIndexBinarySearchForDuplicateArrayValues() {
        int testArray[] = new int[]{-2, -1, 3, 4, 4, 4, 4, 4, 4, 4, 8, 5, 11, 23, 24, 56, 58, 67};
        System.out.println("Magic index at: " + magicIndex.magicIndexBinarySearchDuplicateArrayElements(testArray));
    }
}
