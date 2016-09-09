package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 3.1 Describe how you could use a single array to implement three stacks
 * Created by Ashish Sharma on 9/7/2016.
 */
public class ImplementThreeStacksTest {

    int stackSize = 100;
    int[] buffer = new int[stackSize * 3];
    int[] stackPointer = {-1, -1, -1}; // pointers to track top element

    @BeforeMethod
    public void init() {
    }

    @Test
    public void implementThreeStacks() {
    }

    void push(int stackNum, int value) throws Exception {
         /* Check if we have space */
        if (stackPointer[stackNum] + 1 >= stackSize) { // Last element
            throw new Exception("0ut of space.");
        }
         /* Increment stack pointer and then update top value */
        stackPointer[stackNum]++;
        buffer[absTopOfStack(stackNum)] = value;
    }

    int pop(int stackNum) throws Exception {
        if (stackPointer[stackNum] == -1) {
            throw new Exception("Trying to pop an empty stack.");
        }
        int value = buffer[absTopOfStack(stackNum)]; // Get top
        buffer[absTopOfStack(stackNum)] = 0; // Clear index
        stackPointer[stackNum]--; // Decrement pointer
        return value;
    }

    int peek(int stackNum) {
        int index = absTopOfStack(stackNum);
        return buffer[index];
    }

    boolean isEmpty(int stackNum) {
        return stackPointer[stackNum] == -1;
    }

    /* returns index of top of stack "stackNum", in absolute terms */
    int absTopOfStack(int stackNum) {
        return stackNum * stackSize + stackPointer[stackNum];
    }
}
