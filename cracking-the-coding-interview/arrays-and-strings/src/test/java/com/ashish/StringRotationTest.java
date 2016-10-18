package com.ashish;

import org.apache.commons.lang.StringUtils;
import org.testng.annotations.Test;

/**
 * 1.8
 * Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, si and s2, write code to check If s2 is a rotation
 * of s1 using only one call to isSubstring (e.g., "waterbottLe"
 * is a rotation of "erbottLewat").
 * <p>
 * Created by Ashish Sharma on 12/27/2015.
 */
public class StringRotationTest {

    @Test
    public void stringRotationTest() {
        String original = "waterbottle";
        String rotation = "erbottlewat";

        boolean isRotation = checkRotation(original, rotation);
        System.out.println(isRotation);
    }

    private boolean checkRotation(String original, String rotation) {
        boolean isRotation = false;
        if (StringUtils.isNotEmpty(original) && StringUtils.isNotEmpty(rotation)
                && original.length() == rotation.length()) {

            original = original.concat(original);
            isRotation = original.contains(rotation);
        }
        return isRotation;
    }
}
