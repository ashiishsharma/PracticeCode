package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 3.2
 * How would you design a stack which, in addition to push and pop, also has a
 * function min which returns the minimum element? Push, pop and min should all
 * operate in 0(1) time.
 * <p>
 * Created by Ashish Sharma on 13-09-2016.
 */
public class MinimumStackElementTest {

    @BeforeMethod
    public void init() {

    }

    @Test
    public void stackWithMinimum() {

        StackWithMinimum stackWithMinimum = new StackWithMinimum();
        stackWithMinimum.push(3);
        System.out.println(stackWithMinimum.min());
        stackWithMinimum.push(56);
        stackWithMinimum.push(34);
        System.out.println(stackWithMinimum.min());
        stackWithMinimum.push(1);
        System.out.println(stackWithMinimum.min());
        System.out.println(stackWithMinimum.pop());
        System.out.println(stackWithMinimum.pop());
        System.out.println(stackWithMinimum.min());
    }
}
