package com.ashish;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.testng.annotations.Test;

/**
 * 1.4
 * Write a method to replace all spaces in a string with'%20'. You may assume that
 * the string has sufficient space at the end of the string to hold the additional
 * characters, and that you are given the "true" length of the string. (Note: if implementing
 * in Java, please use a character array so that you can perform this operation
 * in place.)
 * EXAMPLE
 * Input: "Mr John Smith
 * Output: "Mr%20Dohn%20Smith"
 * @author Ashish Sharma on 12/8/2015.
 */
public class ReplaceStringSpaceTest {

    @Test
    public void replaceStringSpaceTest() {
        String str = "Ashish Sharma ";

        System.out.println(replaceStringSpace(str));

    }

    private String replaceStringSpace(String str) {
        int spaceCount = 0;

        for (char ch : str.toCharArray()) {
            if (ch == ' ') {
                spaceCount++;
            }
        }

        char[] stringArray = str.toCharArray();
        int newLength = str.length() + 2 * spaceCount;
        char[] newStringArray = new char[newLength];

        //Here we are copying the smaller character array into the larger one
        // compensating for the increased number of characters.
        for (int i = stringArray.length - 1; i >= 0; i--) {
            if (stringArray[i] == ' ') {
                newStringArray[newLength - 1] = '0';
                newStringArray[newLength - 2] = '2';
                newStringArray[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                newStringArray[newLength - 1] = stringArray[i];
                newLength = newLength - 1;
            }

        }
        return new String(newStringArray);
    }
}
