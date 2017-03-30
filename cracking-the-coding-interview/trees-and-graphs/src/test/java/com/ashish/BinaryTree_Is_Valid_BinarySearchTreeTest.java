package com.ashish;

import org.testng.annotations.Test;

/**
 * 4.5
 * <p>
 * Implement a function to check if a binary tree is a binary search tree.
 * <p>
 *
 * @author Ashish Sharma on 29-03-2017.
 *         <p>
 * @since 29-03-2017.
 */
public class BinaryTree_Is_Valid_BinarySearchTreeTest {

    @Test
    public void validBinarySearchTreeTest() {
        BinaryTree binaryTree = binarySearchTreeCreationWithOutSeparateInsertionMethod();
        int minValue = Integer.MIN_VALUE;
        int maxValue = Integer.MAX_VALUE;
        System.out.println("is given Tree a valid Binary Search Tree : " + isValidBinarySearchTree(binaryTree.getRoot(), minValue, maxValue));
    }

    private boolean isValidBinarySearchTree(BinaryTreeNode binaryTreeNode, int minValue, int maxValue) {
        if (minValue <= binaryTreeNode.getValue() && maxValue >= binaryTreeNode.getValue()) {
            if (binaryTreeNode.getLeft() != null) {
                isValidBinarySearchTree(binaryTreeNode.getLeft(), minValue, binaryTreeNode.getValue());
            }
            if (binaryTreeNode.getRight() != null) {
                isValidBinarySearchTree(binaryTreeNode.getRight(), binaryTreeNode.getValue(), maxValue);
            }
        } else {
            return false;
        }
        return true;
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
