package com.ashish.StackFromLinkedList;

import java.util.EmptyStackException;

/**
 * @author Ashish Sharma on 9/7/2016.
 */
public class Stack<T> {

    private final LinkedList<T> linkedList;

    public Stack() {
        linkedList = new LinkedList();
    }

    public void push(T t) {
        linkedList.add(t);
    }

    public T pop() {
        T t = null;
        LinkedList.Node currentNode;
        if (linkedList.size() > 0) {
            currentNode = linkedList.getHead();
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            t = (T) currentNode.getElement();
            linkedList.remove(linkedList.size());
        } else {
            throw new EmptyStackException();
        }
        return t;
    }

    public T peek() {
        T t = null;
        LinkedList.Node currentNode;
        if (linkedList.size() > 0) {
            currentNode = linkedList.getHead();
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            t = (T) currentNode.getElement();
        } else {
            throw new EmptyStackException();
        }
        return t;
    }

    public int size() {
        return linkedList.size();
    }
}
