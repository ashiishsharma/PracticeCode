package com.ashish;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 7.9
 *
 * <p>From Cracking the coding interview 6th edition</p>
 *
 * <p><B>Circular Array</B>: Implement a CircularArray class that supports an array-like data structure which
 * can be efficiently rotated.</p>
 * <p>If possible, the class should use a generic type (also called a template), and
 * should support iteration via the standard for (Obj o : circularArray) notation.</p>
 *
 * <p> The solution contains the thought process of classes that need to be
 * there, rest of the full code is skipped </p>
 *
 * <p>Refer book itself for more detailed solution, since it has no fixed solution</p>
 *
 * @author Ashish Sharma on 1/4/2019.
 * <p>
 * @since 1/4/2019.
 */
public class CircularArrayTest {
    private CircularArray<Integer> circularArray;

    @BeforeMethod
    public void initialize() {
        circularArray = new CircularArray<Integer>(10);
        circularArray.set(0, 0);
        circularArray.set(1, 1);
        circularArray.set(2, 2);
        circularArray.set(3, 3);
        circularArray.set(4, 4);
        circularArray.set(5, 5);
        circularArray.set(6, 6);
        circularArray.set(7, 7);
        circularArray.set(8, 8);
        circularArray.set(9, 9);

    }

    @Test
    public void testArrayOperation() {
        circularArray.set(2, 4);
        Assert.assertEquals(4, (Object) circularArray.get(2));
        circularArray.rotateRight(5);
    }

    @Test
    public void testArrayIteration() {
        circularArray.rotateRight(5);
        for (Object i : circularArray) {
            System.out.println("Array objects : " + i);
        }
    }

    @Test
    public void testModulo() {
        System.out.println(-4 % 8);
    }
}
