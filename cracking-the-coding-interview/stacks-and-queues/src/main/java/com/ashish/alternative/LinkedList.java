package com.ashish.alternative;

import java.util.Iterator;

/**
 * @author Ashish Sharma
 *         Created on 7/2/2015.
 */
public class LinkedList<T> implements Iterable<T> {
    protected Node head;
    protected int listCount;

    public int size() {
        return listCount;
    }

    public Node getHead() {
        return head;
    }

    public LinkedList() {
        head = null;
        listCount = 0;
    }

    public void add(T element) {
        if (head == null) {
            head = new Node(element, null);
            listCount++;
        } else {

            Node tempNode = new Node(element, null);
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(tempNode);
            listCount++;
        }
    }

    public void add(Node node) {
        if (head == null) {
            head = node;
            listCount++;
        } else {

            Node tempNode = node;
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(tempNode);
            listCount++;
        }
    }

    public void add(T element, int index) {
        if (index < 0 && index > listCount) {
            return;
        }

        Node tempNode = new Node(element, null);
        Node tempCurrent = head;
        for (int i = 1; i < index - 1 && tempCurrent.getNext() != null; i++) {
            tempCurrent = tempCurrent.getNext();
        }
        tempNode.setNext(tempCurrent.getNext());
        tempCurrent.setNext(tempNode);
        listCount++;
    }

    public T get(int index) {
        if (index <= 0 && index > listCount) {
            return null;
        }

        Node tempCurrent = head;
        for (int i = 1; i < index; i++) {
            if (tempCurrent.getNext() == null) {
                return null;
            }
            tempCurrent = tempCurrent.getNext();
        }

        return (T) tempCurrent.getElement();
    }

    public boolean remove(int index) {
        if (index == 1 && listCount == 1) {
            head = null;
            listCount--;
            return true;
        } else if (index < 1 && index > listCount) {
            return false;
        }
        Node tempCurrent = head;
        for (int i = 1; i < index - 1; i++) {
            if (tempCurrent.getNext() == null) {
                return false;
            }
            tempCurrent = tempCurrent.getNext();
        }

        tempCurrent.setNext(tempCurrent.getNext().getNext());
        listCount--;
        return true;
    }

    public Iterator iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            private Node tempHeadForIteration;

            {
                tempHeadForIteration = head;
            }

            public boolean hasNext() {
                if (tempHeadForIteration != null) {
                    return true;
                } else {
                    return false;
                }
            }

            public T next() {
                T elementToReturn = (T) tempHeadForIteration.getElement();
                tempHeadForIteration = tempHeadForIteration.getNext();
                return elementToReturn;
            }

            public void remove() {
            }
        };
        return iterator;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node current = head;
        while (current != null) {
            stringBuilder.append(current.getElement());
            stringBuilder.append(",");
            current = current.getNext();
        }
        return stringBuilder.toString();
    }

    public class Node<T> {
        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        private Node next;
        private T element;

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }
    }
}
