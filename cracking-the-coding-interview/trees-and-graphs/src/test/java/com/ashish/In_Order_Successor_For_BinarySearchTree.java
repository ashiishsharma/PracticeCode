package com.ashish;

import org.testng.annotations.Test;

/**
 * 4.6
 * <p>
 * Write an algorithm to find the 'next'node (i.e., in-order successor) of a given node in
 * a binary search tree.
 * You may assume that each node has a link to its parent
 * <p>
 * Solution :
 * Pseudocode:
 * Node inorderSucc(Node n) {
 * if (n has a right subtree) {
 * return leftmost child of right subtree
 * } else {
 * while (n is a right child of n.parent) {
 * n = n.parent; // Go up
 * }
 * return n.parent; // Parent has not been traversed
 * }
 * }
 * <p>
 *
 * @author Ashish Sharma on 3/30/2017.
 *         <p>
 * @since 3/30/2017.
 */
public class In_Order_Successor_For_BinarySearchTree {


    @Test
    public void testBinaryTreeSuccessor() {

        BinaryTree binaryTree = binarySearchTreeCreationWithOutSeparateInsertionMethod();
        BinaryTreeNode binaryTreeNode = binaryTree.getRoot().getRight().getLeft().getRight();

        BinaryTreeNode binaryTreeSuccessorNode = binaryTreeSuccessor(binaryTreeNode);
        System.out.println("Binary tree successor node for : " + binaryTreeNode.getValue() + " ,is : "
                + binaryTreeSuccessorNode.getValue());

    }

    private BinaryTreeNode binaryTreeSuccessor(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode.getRight() != null) {
            return binaryTreeMinimum(binaryTreeNode.getRight());
        }
        BinaryTreeNode binaryTreeNodeSuccessor = binaryTreeNode.getParent();

        //Special case : When the Node whose successor to be found is:
        // 1. leaf node without any further nodes
        // 2. The leaf node itself is the right node of it's parent
        // In such a case the parent node need to be iterated till one reaches the next parent
        while (binaryTreeNodeSuccessor != null && binaryTreeNode.getValue() == binaryTreeNodeSuccessor.getRight().getValue()) {
            binaryTreeNode = binaryTreeNodeSuccessor;
            binaryTreeNodeSuccessor = binaryTreeNodeSuccessor.getParent();
        }

        return binaryTreeNodeSuccessor;
    }

    private BinaryTreeNode binaryTreeMinimum(BinaryTreeNode binaryTreeNode) {
        while (binaryTreeNode.getLeft() != null) {
            binaryTreeNode = binaryTreeNode.getLeft();
        }
        return binaryTreeNode;
    }

    private int[] sortedArray;
    private BinaryTreeNode[] binaryTreeNodeArray;
    private BinaryTree binaryTree;

    public BinaryTree binarySearchTreeCreationWithOutSeparateInsertionMethod() {
        binaryTreeNodeArray = getSortedBinaryTreeNodeArray();
        int start = 0;
        int end = binaryTreeNodeArray.length - 1;
        int mid = (start + end) / 2;
        binaryTree = new BinaryTree(binaryTreeNodeArray[mid]);
        binaryTreeNodeArray[mid].setLeft(createBinarySearchTreeWithMinimalHeight(binaryTreeNodeArray[mid], start, mid - 1));
        binaryTreeNodeArray[mid].setRight(createBinarySearchTreeWithMinimalHeight(binaryTreeNodeArray[mid], mid + 1, end));
        return binaryTree;
    }

    private BinaryTreeNode createBinarySearchTreeWithMinimalHeight(BinaryTreeNode parentBinaryTreeNode, int start, int end) {
        BinaryTreeNode binaryTreeNode = null;
        if (start <= end) {
            if (start == end) {
                binaryTreeNode = new BinaryTreeNode(parentBinaryTreeNode, binaryTreeNodeArray[start].getValue());
            } else {
                int mid = (start + end) / 2;
                binaryTreeNode = new BinaryTreeNode(parentBinaryTreeNode, binaryTreeNodeArray[mid].getValue());
                binaryTreeNode.setLeft(createBinarySearchTreeWithMinimalHeight(binaryTreeNode, start, mid - 1));
                binaryTreeNode.setRight(createBinarySearchTreeWithMinimalHeight(binaryTreeNode, mid + 1, end));
            }
        }
        return binaryTreeNode;
    }

    private BinaryTreeNode[] getSortedBinaryTreeNodeArray() {
        //Test with both arrays
//        sortedArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        sortedArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        binaryTreeNodeArray = new BinaryTreeNode[sortedArray.length];

        for (int i = 0; i < sortedArray.length; i++) {
            BinaryTreeNode binaryTreeNode = new BinaryTreeNode(null, sortedArray[i]);
            binaryTreeNodeArray[i] = binaryTreeNode;
        }

        return binaryTreeNodeArray;
    }
}
