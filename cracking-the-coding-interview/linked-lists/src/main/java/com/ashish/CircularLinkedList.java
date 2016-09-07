package com.ashish;

/**
 * Created by developer on 27-08-2016.
 */
public class CircularLinkedList<T> extends LinkedList<T> {

    /**
     * The list is made circular by connecting the end of linked list with the provided index of the
     * linked list node
     *
     * @param index of the Node at which Tail should link
     */
    public boolean makeCircular(int index) {
        Node tailNode = getTailNode();
        Node targetCircleNode = getTargetCircleNode(index);
        if (tailNode != null && targetCircleNode != null) {
            tailNode.setNext(targetCircleNode);
            return true;
        } else {
            return false;
        }
    }

    private Node getTargetCircleNode(int index) {
        if (index < 0 && index > listCount) {
            return null;
        }
        Node tempCurrent = head;
        for (int i = 1; i <= index - 1 && tempCurrent.getNext() != null; i++) {
            tempCurrent = tempCurrent.getNext();
        }
        return tempCurrent;
    }

    private Node getTailNode() {
        if (head == null) {
            return null;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            return current;
        }
    }

    @Override
    public String toString() {
        return "CircularLinkedList";
    }
}
