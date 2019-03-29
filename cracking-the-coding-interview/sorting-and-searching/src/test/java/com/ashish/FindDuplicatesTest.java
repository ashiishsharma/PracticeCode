package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * <B>10.8</B> ,  <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * <B>Find Duplicates:</B>
 * <p>
 * You have an array with all the numbers from 1 to N, where N is at most 32,000.
 * The array may have duplicate entries and you do not know what N is.
 * With only 4 kilobytes of memory available, how would you print all duplicate elements in the array?
 *
 * @author Ashish Sharma on 03/29/2019.
 * @since 03/29/2019.
 */
public class FindDuplicatesTest {

    FindDuplicates findDuplicates;

    @BeforeMethod
    public void init() {
        findDuplicates = new FindDuplicates();
    }

    @Test
    public void testFindDuplicate() {

    }
}
