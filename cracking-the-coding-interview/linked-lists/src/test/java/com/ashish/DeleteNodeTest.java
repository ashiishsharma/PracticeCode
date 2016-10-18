package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 2.3
 * Implement an algorithm to delete a node in the middle of a singly
 * linked list, given only access to that node.
 * <p>
 * Created by Ashish Sharma on 12/30/2015.
 */
public class DeleteNodeTest {

    private LinkedList<Integer> list;

    @BeforeMethod
    public void init() {
        list = new LinkedList<Integer>();
        list.add(1);
        list.add(5);
        list.add(8);
        list.add(3);
        list.add(7);
        list.add(9);
        list.add(2);
        list.add(4);
        list.add(6);
    }

    public LinkedList.Node getMiddleNode() {
        LinkedList.Node node = list.getHead();
        for (int i = 0; i < 3; i++) {
            node = node.getNext();
        }
        return node;
    }

    @Test
    public void deleteMiddleNodeTest() {
        System.out.println(list);
        deleteMiddleNode(getMiddleNode());
        System.out.println(list);
    }

    /**
     * copy the data from the next node over to
     * the current node, and then delete the next node.
     *
     * @param middleNode
     * @return
     */
    private boolean deleteMiddleNode(LinkedList.Node middleNode) {
        if (middleNode == null
                || middleNode.getNext() == null) {
            return false;
        }

        LinkedList.Node nextNode = middleNode.getNext();

        middleNode.setElement(nextNode.getElement());
        middleNode.setNext(nextNode.getNext());
        return true;
    }
}
