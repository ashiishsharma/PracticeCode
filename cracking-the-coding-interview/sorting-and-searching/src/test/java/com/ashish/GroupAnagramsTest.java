package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * <B>10.2</B> ,  <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * <B>Group Anagrams:</B>
 * <p>
 * Write a method to sort an array of strings so that all tne anagrams are next to
 * each other.
 *
 * @author Ashish Sharma on 03/28/2019.
 * @since 03/28/2019.
 */
public class GroupAnagramsTest {

    GroupAnagrams groupAnagrams;

    @BeforeMethod
    public void init() {
        groupAnagrams = new GroupAnagrams();
    }

    @Test
    public void testAnagrams() {

    }
}
