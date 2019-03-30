package com.ashish;

import org.testng.annotations.BeforeMethod;

/**
 * <B>13.7</B> ,  <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * <B>Lambda Expressions:</B>
 * <p>
 * There is a class Country that has methods getContinent() and
 * getPopulation(). Write a function int getPopulation(List<Country> countries,
 * String continent) that computes the total population of a given continent, given a list of all
 * countries and the name of a continent.
 * <p>
 *
 * @author Ashish Sharma on 04/29/2019.
 * @since 04/29/2019.
 */
public class LambdaExpressionsTest {

    LambdaExpressions lambdaExpressions;

    @BeforeMethod
    public void init(){
lambdaExpressions = new LambdaExpressions();
    }

    @BeforeMethod
    public void testLambdaExpressions(){

    }
}
