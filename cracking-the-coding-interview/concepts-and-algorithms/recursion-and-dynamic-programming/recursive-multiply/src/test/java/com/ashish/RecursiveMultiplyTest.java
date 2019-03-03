package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * 8.5
 * <p>
 * <B>Recursive Multiply:</B>
 * <p>
 * Write a recursive function to multiply two positive integers without using
 * the * operator (or / operator). You can use addition, subtraction, and bit shifting, but you should
 * minimize the number of those operations.
 * Write a method to return all subsets of a set.
 * <p>
 *
 * @author Ashish Sharma on 03/03/2019.
 * <p>
 * @since 03/03/2019.
 */
public class RecursiveMultiplyTest {

    private RecursiveMultiply recursiveMultiply;

    @BeforeMethod
    public void init() {
        recursiveMultiply = new RecursiveMultiply();
    }

    @Test
    public void testRecursiveMultiply() {
        recursiveMultiply.minProduct();

    }
}
