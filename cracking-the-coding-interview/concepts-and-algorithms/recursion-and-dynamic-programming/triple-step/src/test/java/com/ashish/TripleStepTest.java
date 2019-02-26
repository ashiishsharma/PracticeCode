package com.ashish;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * 8.1
 * <p>
 * <B>Triple Step:</B>
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
 * steps at a time. Implement a method to count how many possible ways the child can run up the
 * stairs.
 * <p>
 *
 * @author Ashish Sharma on 02/22/2019.
 * <p>
 * @since 02/22/2019.
 */
public class TripleStepTest {
    private TripleStep tripleStep;

    @BeforeMethod
    public void init() {
        tripleStep = new TripleStep();
    }

    @Test
    public void testSimpleImplementation() {
        System.out.println("Triple Step solution : " + tripleStep.simpleCountWays(20));
    }

    @Test
    public void testMemoizationImplementation() {
        System.out.println("Triple step solution : " + tripleStep.memoizationCountWays(20));
    }
}
