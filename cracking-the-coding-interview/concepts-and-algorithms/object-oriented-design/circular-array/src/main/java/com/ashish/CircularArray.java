package com.ashish;

import java.util.Iterator;

public class CircularArray<T> implements Iterable<T> {
    private T circularArray[];
    private int size;
    private int headIndexLocation;

    public CircularArray(int size) {
        this.size = size;
        this.circularArray = (T[]) new Object[size];
        this.headIndexLocation = 0;
    }

    public void set(int index, T object) {
        circularArray[rotatedIndex(index)] = object;
    }

    public T get(int index) {
        if (index < size && index >= 0) {
            return circularArray[rotatedIndex(index)];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private int rotatedIndex(int index) {
        if (index < 0) {
            index = index + size;
        }
        int indexLocation = (headIndexLocation + index) % size;
        return indexLocation;
    }

    public void rotateRight(int shiftRight) {
        headIndexLocation = rotatedIndex(shiftRight);
    }

    public Iterator<T> iterator() {
        return new CircularArrayIterator<T>(this);
    }

    private class CircularArrayIterator<TI> implements Iterator<TI> {
        /* current reflects the offset from the rotated head, not from the actual
         * start of the raw array. */
        private int current = -1;

        private TI[] items;

        public CircularArrayIterator(CircularArray<TI> array) {
            items = array.circularArray;
        }

        @Override
        public boolean hasNext() {
            return current < circularArray.length - 1;
        }

        @Override
        public TI next() {
            current++;
            TI item = (TI) items[rotatedIndex(current)];
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported ...");
        }
    }
}