package com.ashish;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * 8.7
 * <p>
 * <B>Permutations without Dups:</B>
 * <p>
 * Write a method to compute all permutations of a string of unique characters.
 *
 * @author Ashish Sharma on 03/04/2019.
 * @since 03/04/2019.
 */
public class PermutationsWithoutDuplicateTest {

    private PermutationsWithoutDuplicate permutationsWithoutDuplicate;

    @BeforeMethod
    public void init() {
        permutationsWithoutDuplicate = new PermutationsWithoutDuplicate();
    }

    @Test
    public void testPermutations() {
        List stringPermutations = permutationsWithoutDuplicate.getPerms("abcde");
        stringPermutations.forEach(str -> System.out.println(str));
    }
}
