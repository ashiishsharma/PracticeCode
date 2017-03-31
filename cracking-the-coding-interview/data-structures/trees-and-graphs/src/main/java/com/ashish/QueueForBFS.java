package com.ashish;

/**
 * Created by shshaash on 3/28/2017.
 */
public class QueueForBFS<T> {
    private Node head;
    private Node tail;

    public int getQueueCount() {
        return queueCount;
    }

    private int queueCount;

    public QueueForBFS() {
        head = null;
        tail = null;
        queueCount = 0;
    }

    public void enqueue(T element) {
        if (head == null && tail == null) {
            tail = new Node(head, element);
            head = tail;
        } else {
            Node tempNode = new Node(tail, element);
            tail = tempNode;

        }
        queueCount++;
    }

    public T dequeue() {
        T element;
        if (head == null && tail == null) {
            return null;
        } else if (queueCount == 1) {
            element = (T) head.getElement();
            head = null;
            tail = null;
        } else {
            Node tempNode = tail;
            Node prevNode = tail;
            element = (T) head.getElement();
            for (int i = 1; i <= queueCount - 1; i++) {
                prevNode = tempNode;
                tempNode = tempNode.getNext();
            }

            head = prevNode;
            head.setNext(null);
        }
        queueCount--;
        return element;
    }

    public T peek() {
        T element;
        if (head == null && tail == null) {
            return null;
        } else {
            element = (T) head.getElement();
        }
        return element;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = null;
        if (tail != null) {
            stringBuilder = new StringBuilder(tail.getElement().toString());
            Node tempNode = tail.getNext();
            while (tempNode != null) {
                stringBuilder.append(" ");
                stringBuilder.append(tempNode.getElement().toString());
                tempNode = tempNode.getNext();
            }
        }
        return stringBuilder.toString();
    }

    private class Node<T> {
        Node next;
        T element;

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

        public Node(Node next, T element) {
            this.next = next;
            this.element = element;
        }
    }
}
