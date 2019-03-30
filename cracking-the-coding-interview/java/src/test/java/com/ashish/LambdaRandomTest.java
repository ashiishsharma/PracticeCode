package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * <B>13.8</B> ,  <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * <B>Lambda Random:</B>
 * <p>
 * Using Lambda expressions, write a function List <Integer>
 * getRandomSub set ( List< Integer> list) that returns a random subset of arbitrary size. All
 * subsets (including the empty set) should be equally likely to be chosen.
 * <p>
 *
 * @author Ashish Sharma on 04/29/2019.
 * @since 04/29/2019.
 */
public class LambdaRandomTest {

    LambdaRandom lambdaRandom;

    @BeforeMethod
    public void init(){
        lambdaRandom = new LambdaRandom();
    }

    @Test
    public void testLambdaRandom(){

    }
}
