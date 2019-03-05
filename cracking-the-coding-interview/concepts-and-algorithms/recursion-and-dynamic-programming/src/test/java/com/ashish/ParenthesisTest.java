package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

/**
 * <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * 8.9
 * <p>
 * <B>Parens:</B>
 * <p>
 * Implement an algorithm to print all valid (i.e., properly opened and closed) combinations
 * of n pairs of parentheses.
 * EXAMPLE
 * Input: 3
 * Output: (( () ) ) , ( () () ) , ( () ) () , () ( () ) , () () ()
 *
 * @author Ashish Sharma on 03/05/2019.
 * @since 03/05/2019.
 */
public class ParenthesisTest {

    private Parenthesis parenthesis;

    @BeforeMethod
    public void init() {
        parenthesis = new Parenthesis();
    }

    @Test
    public void testParenthesis() {
        Set parenthesisSet = parenthesis.generateParens(4);
        parenthesisSet.forEach(str -> System.out.println(str));
    }

    @Test
    public void testParenthesisEfficient() {
        List parenthesisList = parenthesis.generateParensEfficient(4);
        parenthesisList.forEach(str -> System.out.println(str));
    }
}
