package com.ashish;

import com.ashish.StackFromArray.ThreeStackFromArray;
import org.testng.annotations.Test;

import java.util.EmptyStackException;

/**
 * 3.1
 * <p>
 * Describe how you could use a single array to implement three stacks
 * <p>
 * @author Ashish Sharma on 9/7/2016.
 */
public class ThreeStackFromArrayTest {

    @Test/*(expectedExceptions = EmptyStackException.class)*/
    public void stackTest() {
        ThreeStackFromArray<Integer> stack = new ThreeStackFromArray<Integer>(10);

        System.out.println("Stack 1");
        stack.push(1, 1);
        stack.push(1, 2);
        stack.push(1, 3);

        System.out.println(stack.peek(1));
        System.out.println(stack.pop(1));
        System.out.println(stack.pop(1));
        System.out.println(stack.peek(1));
        System.out.println(stack.pop(1));
//        System.out.println(stack.pop(1));

        System.out.println("Stack 2");
        stack.push(2, 1);
        stack.push(2, 2);
        stack.push(2, 3);

        System.out.println(stack.peek(2));
        System.out.println(stack.pop(2));
        System.out.println(stack.pop(2));
        System.out.println(stack.peek(2));
        System.out.println(stack.pop(2));
//        System.out.println(stack.pop(2));

        System.out.println("Stack 3");
        stack.push(3, 1);
        stack.push(3, 2);
        stack.push(3, 3);

        System.out.println(stack.peek(3));
        System.out.println(stack.pop(3));
        System.out.println(stack.pop(3));
        System.out.println(stack.peek(3));
        System.out.println(stack.pop(3));
//        System.out.println(stack.pop(3));
    }

}
