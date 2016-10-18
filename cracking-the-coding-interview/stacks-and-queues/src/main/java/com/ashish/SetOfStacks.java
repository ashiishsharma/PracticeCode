package com.ashish;

import java.util.EmptyStackException;

/**
 * Used a stack of stacks for implementing the solution
 * @author Ashish Sharma on 10/5/2016.
 */
public class SetOfStacks<T> {
    private static final int defaultStackSize = 10;
    private int sizeOfStack;
    private StackOfStacks<StackOfStacks<T>> stackOfStacksVariable;
    private StackOfStacks<T> currentStack;

    /**
     * Number of stacks in 'stack of stacks'
     */
    private int numberOfStacks;

    public SetOfStacks(int sizeOfStack) {
        this.sizeOfStack = sizeOfStack;
        initialize();
    }

    public SetOfStacks() {
        this.sizeOfStack = defaultStackSize;
        initialize();
    }

    private void initialize() {
        stackOfStacksVariable = new StackOfStacks<StackOfStacks<T>>();
        currentStack = new StackOfStacks<T>();
        numberOfStacks = 1;
    }

    public void push(T t) {
        if (currentStack != null && currentStack.stackLength() < sizeOfStack) {
            currentStack.push(t);
        } else {
            stackOfStacksVariable.push(currentStack);
            currentStack = new StackOfStacks<T>();
            currentStack.push(t);
        }
    }

    public T pop() {
        T t = null;
        if (currentStack != null && currentStack.stackLength() > 0) {
            t = currentStack.pop();
        } else if (stackOfStacksVariable.stackLength() > 0) {
            currentStack = stackOfStacksVariable.pop();
            if (currentStack.stackLength() > 0) {
                t = currentStack.pop();
            }
        } else {
            throw new EmptyStackException();
        }
        return t;
    }

    public T pop(int i) {
        T t = null;
        if (i == 0) {
            t = pop();
        } else if (i > 0 && i < getNumberOfStacks()) {
            t = stackOfStacksVariable.getStackArr().get(i - 1).pop();
        } else {
            throw new RuntimeException("stack index out of bounds");
        }
        return t;
    }

    /**
     * Rebalance the stacks after some stack in the middle gets popped
     *
     * @param i
     */
    private void balanceTheStacks(int i) {
        // To Do
    }

    public int getNumberOfStacks() {
        return numberOfStacks + stackOfStacksVariable.stackLength();
    }
}
