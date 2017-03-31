package com.ashish;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 4.4
 * <p>
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes
 * at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 * <p>
 *
 * @author Ashish Sharma on 3/28/2017.
 *         <p>
 * @since 3/28/2017
 */
public class BinaryTreeToLinkedListTest {

    @Test
    public void BFSTest() {
        binaryTree = binarySearchTreeCreationWithOutSeparateInsertionMethod();
        List<LinkedList<BinaryTreeNodeForBFS>> arrayListForNodesOnSameHeight = BFSForBinaryTree(binaryTree.getRoot());
    }

    private List<LinkedList<BinaryTreeNodeForBFS>> BFSForBinaryTree(BinaryTreeNodeForBFS root) {

        root.setNodeColor(BinaryTreeNodeForBFS.NodeColor.Gray);
        root.setDistanceFromRoot(0);

        QueueForBFS<BinaryTreeNodeForBFS> bfsQueue = new QueueForBFS<BinaryTreeNodeForBFS>();
        bfsQueue.enqueue(root);

        // Get nodes available on same height in a queue
        QueueForBFS<BinaryTreeNodeForBFS> printBFSQueue = new QueueForBFS<BinaryTreeNodeForBFS>();
        printBFSQueue.enqueue(root);

        while (bfsQueue.getQueueCount() != 0) {
            BinaryTreeNodeForBFS binaryTreeNodeForBFS = bfsQueue.dequeue();
            if (binaryTreeNodeForBFS.getLeft() != null && binaryTreeNodeForBFS.getLeft().getNodeColor() == BinaryTreeNodeForBFS.NodeColor.White) {
                binaryTreeNodeForBFS.getLeft().setNodeColor(BinaryTreeNodeForBFS.NodeColor.Gray);
                binaryTreeNodeForBFS.getLeft().setDistanceFromRoot(binaryTreeNodeForBFS.getDistanceFromRoot() + 1);
                bfsQueue.enqueue(binaryTreeNodeForBFS.getLeft());

                // Get nodes available on same height in a queue
                printBFSQueue.enqueue(binaryTreeNodeForBFS.getLeft());
            }

            if (binaryTreeNodeForBFS.getRight() != null && binaryTreeNodeForBFS.getRight().getNodeColor() == BinaryTreeNodeForBFS.NodeColor.White) {
                binaryTreeNodeForBFS.getRight().setNodeColor(BinaryTreeNodeForBFS.NodeColor.Gray);
                binaryTreeNodeForBFS.getRight().setDistanceFromRoot(binaryTreeNodeForBFS.getDistanceFromRoot() + 1);
                bfsQueue.enqueue(binaryTreeNodeForBFS.getRight());

                // Get nodes available on same height in a queue
                printBFSQueue.enqueue(binaryTreeNodeForBFS.getRight());
            }
            binaryTreeNodeForBFS.setNodeColor(BinaryTreeNodeForBFS.NodeColor.Black);
        }

        // Creating required linked list for each height level
        List<LinkedList<BinaryTreeNodeForBFS>> arrayListForNodesOnSameHeight = new ArrayList<LinkedList<BinaryTreeNodeForBFS>>();
        LinkedList<BinaryTreeNodeForBFS> nodesOnSameHeight = new LinkedList<BinaryTreeNodeForBFS>();
        arrayListForNodesOnSameHeight.add(nodesOnSameHeight);

        do {
            BinaryTreeNodeForBFS binaryTreeNodeForBFS = printBFSQueue.dequeue();
            if (binaryTreeNodeForBFS.getDistanceFromRoot() == root.getDistanceFromRoot() + 1) {
                System.out.println();
                nodesOnSameHeight = new LinkedList<BinaryTreeNodeForBFS>();
                arrayListForNodesOnSameHeight.add(nodesOnSameHeight);
                root = binaryTreeNodeForBFS;
            }
            System.out.print(binaryTreeNodeForBFS.getValue() + " ");
            nodesOnSameHeight.add(binaryTreeNodeForBFS);
        } while (printBFSQueue.getQueueCount() > 0);

        return arrayListForNodesOnSameHeight;
    }

    private int[] sortedArray;
    private BinaryTreeNodeForBFS[] binaryTreeNodeArray;
    private BinaryTreeForBFS binaryTree;

    public BinaryTreeForBFS binarySearchTreeCreationWithOutSeparateInsertionMethod() {
        binaryTreeNodeArray = getSortedBinaryTreeNodeArray();
        int start = 0;
        int end = binaryTreeNodeArray.length - 1;
        int mid = (start + end) / 2;
        binaryTree = new BinaryTreeForBFS(binaryTreeNodeArray[mid]);
        binaryTreeNodeArray[mid].setLeft(createBinarySearchTreeWithMinimalHeight(binaryTreeNodeArray[mid], start, mid - 1));
        binaryTreeNodeArray[mid].setRight(createBinarySearchTreeWithMinimalHeight(binaryTreeNodeArray[mid], mid + 1, end));
        return binaryTree;
    }

    private BinaryTreeNodeForBFS createBinarySearchTreeWithMinimalHeight(BinaryTreeNodeForBFS parentBinaryTreeNode, int start, int end) {
        BinaryTreeNodeForBFS binaryTreeNode = null;
        if (start <= end) {
            if (start == end) {
                binaryTreeNode = new BinaryTreeNodeForBFS(parentBinaryTreeNode, binaryTreeNodeArray[start].getValue());
            } else {
                int mid = (start + end) / 2;
                binaryTreeNode = new BinaryTreeNodeForBFS(parentBinaryTreeNode, binaryTreeNodeArray[mid].getValue());
                binaryTreeNode.setLeft(createBinarySearchTreeWithMinimalHeight(binaryTreeNode, start, mid - 1));
                binaryTreeNode.setRight(createBinarySearchTreeWithMinimalHeight(binaryTreeNode, mid + 1, end));
            }
        }
        return binaryTreeNode;
    }

    private BinaryTreeNodeForBFS[] getSortedBinaryTreeNodeArray() {
        //Test with both arrays
//        sortedArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        sortedArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        binaryTreeNodeArray = new BinaryTreeNodeForBFS[sortedArray.length];

        for (int i = 0; i < sortedArray.length; i++) {
            BinaryTreeNodeForBFS binaryTreeNode = new BinaryTreeNodeForBFS(null, sortedArray[i]);
            binaryTreeNodeArray[i] = binaryTreeNode;
        }

        return binaryTreeNodeArray;
    }

    @Test
    public void printQueueTest() {
        QueueForBFS queueForBFS = new QueueForBFS();
        queueForBFS.enqueue(1);
        queueForBFS.enqueue(2);
        queueForBFS.enqueue(3);
        queueForBFS.enqueue(4);
        queueForBFS.enqueue(5);
        queueForBFS.enqueue(6);

        System.out.println(queueForBFS.toString());
    }
}
