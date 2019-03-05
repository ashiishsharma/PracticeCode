package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * 8.11
 * <p>
 * <B>Coins:</B>
 * <p>
 * Given an infinite number of quarters (25 cents), dimes (1 O cents), nickels (5 cents), and
 * pennies (1 cent), write code to calculate the number of ways of representing n cents.
 *
 * @author Ashish Sharma on 03/05/2019.
 * @since 03/05/2019.
 */
public class CoinsTest {

    private Coins coins;

    @BeforeMethod
    public void init() {
        coins = new Coins();
    }

    @Test
    public void testCoins() {
        System.out.println(coins.makeChange(50));
    }

    @Test
    public void testCoinsDynamicProgramming(){
        System.out.println(coins.makeChangeDynamicProgramming(50));
    }
}
