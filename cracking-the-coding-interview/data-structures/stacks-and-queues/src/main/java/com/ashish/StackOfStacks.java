package com.ashish;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * @author Ashish Sharma on 11-10-2016.
 */
public class StackOfStacks<T> {

    private List<T> stackArr;
    private int elementCount;

    public StackOfStacks() {
        stackArr = new ArrayList<T>();
        elementCount = 0;
    }

    public List<T> getStackArr() {
        return stackArr;
    }

    public void push(T obj) {
        stackArr.add(obj);
        elementCount++;
    }

    public T pop() {
        T element = null;
        if (elementCount > 0) {
            element = stackArr.remove(elementCount - 1);
            elementCount--;
        } else {
            throw new EmptyStackException();
        }
        return element;
    }

    public T peek() {
        T element = null;
        if (elementCount > 0) {
            element = stackArr.get(elementCount - 1);
        } else {
            throw new EmptyStackException();
        }
        return element;
    }

    public int stackLength() {
        return elementCount;
    }
}
