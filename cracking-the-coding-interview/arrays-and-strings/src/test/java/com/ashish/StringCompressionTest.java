package com.ashish;

import org.testng.annotations.Test;

/**
 * Implement a method to perform basic string compression using the counts of
 * repeated characters. For example, the string aabcccccaaa would become
 * a2blc5a3. If the "compressed" string would not become smaller than the original
 * string, your method should return the original string.
 *
 * @author Ashish Sharma
 */
public class StringCompressionTest {

    @Test
    public void stringCompression() {
        String stringToCompress = "aabcccccaaa";

        String compressedString = compressString(stringToCompress);

        System.out.println(compressedString);
    }

    private String compressString(String stringToCompress) {
        StringBuilder stringBuilder = new StringBuilder();

        char lastChar = stringToCompress.charAt(0);
        int lastCharCount = 0;
        for (char ch : stringToCompress.toCharArray()) {
            if (lastChar == ch) {
                lastCharCount++;
            } else {
                stringBuilder.append(lastChar);
                stringBuilder.append(lastCharCount);
                lastChar = ch;
                lastCharCount = 1;
            }
        }
        stringBuilder.append(lastChar);
        stringBuilder.append(lastCharCount);
        return stringBuilder.toString();
    }
}
