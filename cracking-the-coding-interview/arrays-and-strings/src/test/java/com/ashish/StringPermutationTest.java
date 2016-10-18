package com.ashish;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * 1.3
 * Given two strings, write a method to decide if one is a permutation of the other
 *
 * @author Ashsih Sharma on 12/8/2015.
 */
public class StringPermutationTest {

    @Test
    public void stringPermutationTest() {
        String str1 = "god";
        String str2 = "dog";
        System.out.println(areStringsPermutation(str1, str2));
    }

    private boolean areStringsPermutation(String str1, String str2) {
        boolean areStringPermutation = false;
        if (str1.length() == str2.length()) {
            char[] strCharArray1 = str1.toCharArray();
            Arrays.sort(strCharArray1);

            char[] strCharArray2 = str2.toCharArray();
            Arrays.sort(strCharArray2);

            str1 = new String(strCharArray1);
            str2 = new String(strCharArray2);

            if (str1.equals(str2)) {
                areStringPermutation = true;
            }
        }

        return areStringPermutation;
    }
}
