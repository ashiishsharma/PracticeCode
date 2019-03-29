package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.BitSet;

/**
 * <B>10.7</B> ,  <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * <B>Missing Int: </B>
 * <p>
 * Given an input file with four billion non-negative integers, provide an algorithm to
 * generate an integer that is not contained in the file.
 * Assume you have 1 GB of memory available for this task.
 * <p>
 * FOLLOW UP
 * What if you have only 1O MB of memory? Assume that all the values are distinct and we now have
 * no more than one billion non-negative integers.
 *
 * @author Ashish Sharma on 03/29/2019.
 * @since 03/29/2019.
 */
public class MissingIntTest {

    MissingInt missingInt;
    BitSet bitSet;

    @BeforeMethod
    public void init() {
        bitSet = new BitSet();
        missingInt = new MissingInt();
    }

    @Test
    public void testMissingInt() {
    }
}
