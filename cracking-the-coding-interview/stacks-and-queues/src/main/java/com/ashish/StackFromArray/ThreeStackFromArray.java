package com.ashish.StackFromArray;

import java.util.EmptyStackException;

/**
 * Current implementation is fixed size for all the three stacks,
 * In case of request for Dynamic solution , the middle Array Stack Limits can be slided forward
 * and backward.
 * Created by shshaash on 9/12/2016.
 */
public class ThreeStackFromArray<T> {

    private final int stackSize;
    private final Object[] arrT;
    private final StackArrayLimit stackOneArrayLimit;
    private final StackArrayLimit stackTwoArrayLimit;
    private final StackArrayLimit stackThirdArrayLimit;
    private int stackOneCount;
    private int stackTwoCount;
    private int stackThreeCount;

    public ThreeStackFromArray(int stackSize) {
        this.stackSize = stackSize;
        arrT = new Object[3 * stackSize];
        stackOneArrayLimit = new StackArrayLimit(0, stackSize * 1);
        stackTwoArrayLimit = new StackArrayLimit(stackSize * 1 + 1, stackSize * 2);
        stackThirdArrayLimit = new StackArrayLimit(stackSize * 2 + 1, stackSize * 3);
        stackOneCount = 0;
        stackTwoCount = 0;
        stackThreeCount = 0;
    }

    public void push(int stackNum, T t) {
        switch (stackNum) {
            case 1:
                if (stackOneCount < stackSize) {
                    arrT[stackOneCount + stackOneArrayLimit.getStart()] = t;
                    stackOneCount++;
                } else {
                    throw new StackOverflowError();
                }
                break;
            case 2:
                if (stackTwoCount < stackSize) {
                    arrT[stackTwoCount + stackTwoArrayLimit.getStart()] = t;
                    stackTwoCount++;
                } else {
                    throw new StackOverflowError();
                }
                break;
            case 3:
                if (stackThreeCount < stackSize) {
                    arrT[stackThreeCount + stackThirdArrayLimit.getStart()] = t;
                    stackThreeCount++;
                } else {
                    throw new StackOverflowError();
                }
                break;
            default:
                throw new IllegalArgumentException("Illegal stack number passed, valid values : {1,2,3}");
        }
    }

    public T pop(int stackNum) {
        T t;
        switch (stackNum) {
            case 1:
                if (stackOneCount > 0) {
                    t = (T) arrT[stackOneCount + stackOneArrayLimit.getStart() - 1];
                    arrT[stackOneCount + stackOneArrayLimit.getStart() - 1] = null;
                    stackOneCount--;
                } else {
                    throw new EmptyStackException();
                }
                break;
            case 2:
                if (stackTwoCount > 0) {
                    t = (T) arrT[stackTwoCount + stackTwoArrayLimit.getStart() - 1];
                    arrT[stackTwoCount + stackTwoArrayLimit.getStart() - 1] = null;
                    stackTwoCount--;
                } else {
                    throw new EmptyStackException();
                }
                break;
            case 3:
                if (stackThreeCount > 0) {
                    t = (T) arrT[stackThreeCount + stackThirdArrayLimit.getStart() - 1];
                    arrT[stackThreeCount + stackThirdArrayLimit.getStart() - 1] = null;
                    stackThreeCount--;
                } else {
                    throw new EmptyStackException();
                }
                break;
            default:
                throw new IllegalArgumentException("Illegal stack number passed, valid values : {1,2,3}");
        }
        return t;
    }

    public T peek(int stackNum) {
        T t;
        switch (stackNum) {
            case 1:
                if (stackOneCount > 0) {
                    t = (T) arrT[stackOneCount + stackOneArrayLimit.getStart() - 1];
                } else {
                    throw new EmptyStackException();
                }
                break;
            case 2:
                if (stackTwoCount > 0) {
                    t = (T) arrT[stackTwoCount + stackTwoArrayLimit.getStart() - 1];
                } else {
                    throw new EmptyStackException();
                }
                break;
            case 3:
                if (stackThreeCount > 0) {
                    t = (T) arrT[stackThreeCount + stackThirdArrayLimit.getStart() - 1];
                } else {
                    throw new EmptyStackException();
                }
                break;
            default:
                throw new IllegalArgumentException("Illegal stack number passed, valid values : {1,2,3}");
        }
        return t;
    }

    public class StackArrayLimit {

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        private final int start;
        private final int end;

        public StackArrayLimit(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
