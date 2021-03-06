package com.ashish;

import org.testng.annotations.Test;

/**
 * 1.2
 * <p>
 * Implement a function void reverse(char* str) in C or C++ which reverses a null-terminated
 * string.
 * <p>
 * @author Ashish Sharma on 12/6/2015.
 */
public class ReverseStringTest {

    @Test
    public void reverseStringTest() {
        String inputString = "Ashish Sharma is great";
        inputString = getReversedString(inputString);
        System.out.println("Reversed String is : " + inputString);
    }

    private String getReversedString(String inputString) {
        int startString = 0;
        int endString = inputString.length() - 1;
        char tmp;
        char[] inputCharacterArray = inputString.toCharArray();
        while (startString < endString) {
            tmp = inputCharacterArray[startString];
            inputCharacterArray[startString] = inputCharacterArray[endString];
            inputCharacterArray[endString] = tmp;
            startString++;
            endString--;
        }
        return new String(inputCharacterArray);
    }
}
