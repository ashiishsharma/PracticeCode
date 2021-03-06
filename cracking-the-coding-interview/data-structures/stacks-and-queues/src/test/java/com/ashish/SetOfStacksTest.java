package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.EmptyStackException;

/**
 * 3.3
 * <p>
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous
 * stack exceeds some threshold.
 * Implement a data structure SetOfStacks that mimics this. SetOf-Stacks should
 * be composed of several stacks and should create a new stack once
 * the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.
 * pop () should behave identically to a single stack (that is, pop () should return the
 * same values as it would if there were just a single stack).
 * <p>FOLLOW UP
 * <p>Implement a function popAt(int index) which performs a pop operation on a
 * specific sub-stack.
 * <p>
 * @author Ashish Sharma on 18-09-2016.
 */
public class SetOfStacksTest {

    @BeforeMethod
    public void init() {

    }

    @Test(expectedExceptions = EmptyStackException.class)
    public void testSetOfStacks() {
        SetOfStacks setOfStacks = new SetOfStacks(2);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);

        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
    }

    @Test
    public void popAtParticularStack(){

        SetOfStacks setOfStacks = new SetOfStacks(2);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);
        setOfStacks.push(6);
        setOfStacks.push(7);
        setOfStacks.push(8);
        setOfStacks.push(9);
        setOfStacks.push(10);

        System.out.println(setOfStacks.pop(3));

    }
}
