package com.ashish;

/**
 * @author Ashish Sharma
 *         Created on 7/2/2015.
 */
public class SizeLimitedQueue<T> {
    private final int size;
    Node head;
    Node tail;

    public int getQueueCount() {
        return queueCount;
    }

    int queueCount;

    public SizeLimitedQueue(int size) {
        head = null;
        tail = null;
        queueCount = 0;
        this.size = size;
    }

    public void enqueue(T element) {
        if (queueCount < size) {
            if (head == null && tail == null) {
                tail = new Node(head, element);
                head = tail;
            } else {
                Node tempNode = new Node(tail, element);
                tail = tempNode;

            }
            queueCount++;
        } else {
            System.out.println("queue full");
        }
    }

    public T dequeue() {
        T element = null;
        if (queueCount != 0) {
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

                head = new Node(null, prevNode.getElement());
                if (prevNode != null) {
                    prevNode.setNext(head);
                }
            }
            queueCount--;
        } else {
            System.out.println("queue empty");
        }
        return element;
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
