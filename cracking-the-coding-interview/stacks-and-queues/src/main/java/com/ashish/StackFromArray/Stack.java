package com.ashish.StackFromArray;

import java.util.EmptyStackException;

/**
 * Created by Ashish Sharma on 9/8/2016.
 */
public class Stack<T> {

    private final int stackSize;
    private final Object[] arrT;
    private int stackCount;

    public Stack(int stackSize) {
        this.stackSize = stackSize;
        arrT = new Object[stackSize];
        stackCount = 0;
    }

    public void push(T t) {
        if (stackCount < stackSize) {
            arrT[stackCount] = t;
            stackCount++;
        } else {
            throw new StackOverflowError();
        }
    }

    public T pop() {
        if (stackCount > 0) {
            T t = (T) arrT[stackCount - 1];
            arrT[stackCount - 1] = null;
            stackCount--;
            return t;
        } else {
            throw new EmptyStackException();
        }
    }

    public T peek() {
        if (stackCount > 0) {
            T t = (T) arrT[stackCount - 1];
            return t;
        } else {
            throw new EmptyStackException();
        }
    }
}
