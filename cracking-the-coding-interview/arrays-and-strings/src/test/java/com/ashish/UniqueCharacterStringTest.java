package com.ashish;

import org.testng.annotations.Test;

/**
 * Implement an algorithm to determine if a string has all unique characters. What if
 * you cannot use additional data structures?
 *
 * @author Ashish Sharma on 12/2/2015.
 */
public class UniqueCharacterStringTest {

    @Test
    public void uniqueCharacterString() {

        String inputString = "ashi";
        boolean characterUnique = isStringUniqueCharactered(inputString);
        if (characterUnique) {
            System.out.println("Input string contains all unique characters");
        } else {
            System.out.println("Input string does not contain all unique characters");
        }
    }

    private boolean isStringUniqueCharactered(String inputString) {
        boolean containsUnique = false;
        if (inputString.length() <= 256) {
            boolean[] characterFlag = new boolean[256];
            for (char ch : inputString.toCharArray()) {
                int charValue = ch;
                if (!characterFlag[charValue]) {
                    characterFlag[charValue] = true;
                    containsUnique = true;
                } else {
                    containsUnique = false;
                }
            }
        }

        return containsUnique;
    }
}