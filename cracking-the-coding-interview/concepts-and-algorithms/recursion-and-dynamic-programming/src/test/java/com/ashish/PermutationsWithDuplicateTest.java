package com.ashish;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * 8.8
 * <p>
 * <B>Permutations with Duplicates:</B>
 * <p>
 * Write a method to compute all permutations of a string whose characters are not necessarily unique.
 * The list of permutations should not have duplicates.
 * Write a method to compute all permutations of a string of unique characters.
 *
 * @author Ashish Sharma on 03/04/2019.
 * @since 03/04/2019.
 */
public class PermutationsWithDuplicateTest {

    private PermutationsWithDuplicate permutationsWithDuplicate;

    @BeforeMethod
    public void init() {
        permutationsWithDuplicate = new PermutationsWithDuplicate();
    }

    @Test
    public void testPermutationsWithDuplicate() {
        List<String> permutations = permutationsWithDuplicate.printPerms("aaabbbbccccc");
        permutations.forEach(str -> System.out.println(str));
    }
}
