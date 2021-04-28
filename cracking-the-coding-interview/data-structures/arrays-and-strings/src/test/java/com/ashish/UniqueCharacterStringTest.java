package com.ashish;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 1.1
 * <p>
 * Implement an algorithm to determine if a string has all unique characters. What if
 * you cannot use additional data structures?
 * <p>
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

    @Test
    public void uniqueCharacterStringSetSolution() {

        String inputString = "ashish";
        boolean characterUnique = isStringUniqueCharacteredSetSolution(inputString);
        if (characterUnique) {
            System.out.println("Input string contains all unique characters");
        } else {
            System.out.println("Input string does not contain all unique characters");
        }
    }

    private boolean isStringUniqueCharacteredSetSolution(String inputString) {
        boolean containsUnique = false;
        if (inputString.length() <= 256) {
            Set<Character> characterFlag = new HashSet<>();
            for (char ch : inputString.toCharArray()) {
                if (characterFlag.add(ch)) {
                    containsUnique = true;
                } else {
                    containsUnique = false;
                }
            }
        }

        return containsUnique;
    }


}
