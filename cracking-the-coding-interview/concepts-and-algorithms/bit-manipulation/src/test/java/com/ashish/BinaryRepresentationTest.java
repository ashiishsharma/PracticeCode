package com.ashish;

import org.testng.annotations.Test;

/**
 * 5.2
 * <p>
 * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double,
 * print the binary representation.
 * <p>
 * If the number cannot be represented accurately in binary with at most 32 characters, print "ERROR."
 * <p>
 *
 * @author Ashish Sharma on 4/3/2017.
 *         <p>
 * @since 4/3/2017
 */
public class BinaryRepresentationTest {

    @Test
    public void testBinaryRepresentation() {
        System.out.println("Binary representation for " + 0.2 + " is: " + printBinary(0.2));
    }

    public static String printBinary(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }

        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while (num > 0) {
        /* Setting a limit on length: 32 characters */
            if (binary.length() >= 32) {
                return "ERROR";
            }

            double r = num * 2;
            if (r >= 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();
    }

    public static String printBinary2(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }

        StringBuilder binary = new StringBuilder();
        double frac = 0.5;
        binary.append(".");
        while (num > 0) {
         /* Setting a limit on length: 32 characters */
            if (binary.length() > 32) {
                return "ERROR";
            }
            if (num >= frac) {
                binary.append(1);
                num -= frac;
            } else {
                binary.append(0);
            }
            frac /= 2;
        }
        return binary.toString();
    }
}
