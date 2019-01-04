package com.ashish;

public class CircularArray<T> {
    private T circularArray[];
    private int size;
    private int headIndexLocation;

    public CircularArray(int size) {
        this.size = size;
        this.circularArray = (T[]) new Object[size];
        this.headIndexLocation = 0;
    }

    public void set(int index, T object) {
        if (index < size) {
            circularArray[index] = object;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public T get(int index) {
        if (index < size) {
            return circularArray[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void rotateRight(int shiftRight) {
            headIndexLocation = shiftRight%size;
    }
}
