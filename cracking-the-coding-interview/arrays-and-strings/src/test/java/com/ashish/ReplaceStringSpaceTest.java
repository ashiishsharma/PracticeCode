package com.ashish;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.testng.annotations.Test;

/**
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
