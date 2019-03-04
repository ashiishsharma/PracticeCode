package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * 8.4
 * <p>
 * <B>Power Set:</B>
 * <p>
 * Write a method to return all subsets of a set.
 * <p>
 *
 * @author Ashish Sharma on 02/28/2019.
 * <p>
 * @since 02/28/2019.
 */
public class PowerSetTest {

    private PowerSet powerSet;

    @BeforeMethod
    public void init() {
        powerSet = new PowerSet();
    }

    @Test
    public void testPowerSet() {
        System.out.println(powerSet);
    }
}
