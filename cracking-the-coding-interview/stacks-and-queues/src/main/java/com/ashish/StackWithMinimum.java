package com.ashish;

import java.util.Comparator;
import java.util.EmptyStackException;

/**
 * Created by Ashish Sharma on 13-09-2016.
 */
public class StackWithMinimum<T extends Comparable> extends Stack<T> {

    Stack<T> minimumElementStack;

    public StackWithMinimum() {
        minimumElementStack = new Stack<T>();
    }

    public void push(T t) {
        if (min() != null && t.compareTo(min()) <= 0) {
            minimumElementStack.push(t);
        } else if (min() == null) {
            minimumElementStack.push(t);
        }
        super.push(t);
    }

    public T pop() {
        T t = super.pop();
        if (min() != null && t.compareTo(min()) == 0) {
            minimumElementStack.pop();
        }
        return t;
    }

    public T min() {
        T t = null;
        try {
            t = minimumElementStack.peek();
        } catch (EmptyStackException e) {
            System.out.println("Minimum element stack empty");
        }
        return t;
    }
}
