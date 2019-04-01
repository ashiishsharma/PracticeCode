package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * <B>15.7</B> ,  <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * <B>FizzBuzz:</B>
 * <p>
 * In the classic problem FizzBuzz, you are told to print the numbers from 1 to n.
 * However, when the number is divisible by 3, print "Fizz''.
 * When it is divisible by 5, print "Buzz''.
 * When it is divisible by 3 and 5, print"FizzBuzz".
 * <p>
 * In this problem, you are asked to do this in a multithreaded way.
 * <p>
 * Implement a multithreaded version of FizzBuzz with four threads. One thread checks for divisibility
 * of 3 and prints"Fizz''.
 * <p>
 * Another thread is responsible for divisibility of 5 and prints"Buzz''.
 * <p>
 * A third thread is responsible for divisibility of 3 and 5 and prints "FizzBuzz''.
 * <p>
 * A fourth thread does the numbers.
 *
 * @author Ashish Sharma on 04/29/2019.
 * @since 04/29/2019.
 */
public class FizzBuzzTest {

    FizzBuzz fizzBuzz;

    @BeforeMethod
    public void init() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void testFizzBuzz() {

    }
}
