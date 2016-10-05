package com.ashish;

import java.util.EmptyStackException;

/**
 * Used a stack of stacks for implementing the solution
 * Created by shshaash on 10/5/2016.
 */
public class SetOfStacks<T> {
    private static final int defaultStackSize = 10;
    private int sizeOfStack;
    private Stack<Stack<T>> stackOfStacks;
    private Stack<T> currentStack;

    public SetOfStacks(int sizeOfStack) {
        this.sizeOfStack = sizeOfStack;
        initialize();
    }

    public SetOfStacks() {
        this.sizeOfStack = defaultStackSize;
        initialize();
    }

    private void initialize() {
        stackOfStacks = new Stack<Stack<T>>();
        currentStack = new Stack<T>();
    }

    public void push(T t) {
        if (currentStack != null && currentStack.stackLength() < sizeOfStack) {
            currentStack.push(t);
        } else {
            stackOfStacks.push(currentStack);
            currentStack = new Stack<T>();
            currentStack.push(t);
        }
    }

    public T pop() {
        T t = null;
        if (currentStack != null && currentStack.stackLength() > 0) {
            t = currentStack.pop();
        } else if (stackOfStacks.stackLength() > 0) {
            currentStack = stackOfStacks.pop();
            if (currentStack.stackLength() > 0) {
                t = currentStack.pop();
            }
        } else {
            throw new EmptyStackException();
        }
        return t;
    }
}
