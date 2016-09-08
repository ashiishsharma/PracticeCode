package com.ashish.StackFromArray;

import com.ashish.StackFromArray.Stack;
import org.testng.annotations.Test;

import java.util.EmptyStackException;

/**
 * @author Ashish Sharma
 *         Created on 7/1/2015.
 */
public class StackTest {

    @Test(expectedExceptions = EmptyStackException.class)
    public void stackTest() {
        Stack<Integer> stack = new Stack<Integer>(10);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
