package com.ashish;

import org.testng.annotations.Test;

/**
 * 4.8
 * <p>
 * You have two very large binary trees: T1, with millions of nodes,
 * and T2, with hundreds of nodes.
 * <p>
 * Create an algorithm to decide if T2 is a subtree of T1.
 * <p>
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n
 * is identical to T2.
 * <p>
 * That is, if you cut off the tree at node n, the two trees would be
 * identical.
 * <p>
 *
 * @author Ashish Sharma on 3/31/2017.
 *         <p>
 * @since 3/31/2017
 */
public class FindSubTreeTest {
    private BinaryTree bigBinaryTree;
    private BinaryTree smallBinaryTree;

    @Test
    public void testFindSubTree() {
        bigBinaryTree = binarySearchTreeCreationWithOutSeparateInsertionMethod();
        smallBinaryTree = new BinaryTree(binaryTree.getRoot().getLeft());

        System.out.println("Small tree is subtree of big tree : " + containsTree(bigBinaryTree.getRoot(), smallBinaryTree.getRoot()));
    }

    private boolean containsTree(BinaryTreeNode bigBinaryTreeRootNode, BinaryTreeNode smallBinaryTreeRootNode) {
        if (smallBinaryTreeRootNode == null) { // The empty tree is always a subtree
            return true;
        }
        return subtree(bigBinaryTreeRootNode, smallBinaryTreeRootNode);
    }

    private boolean subtree(BinaryTreeNode bigBinaryTreeRootNode, BinaryTreeNode smallBinaryTreeRootNode) {
        if (bigBinaryTreeRootNode == null) {// big tree empty & subtree still not found.
            return false;
        }

        if (bigBinaryTreeRootNode.getValue() == smallBinaryTreeRootNode.getValue()) {
            return matchTree(bigBinaryTreeRootNode, smallBinaryTreeRootNode);
        }

        return (subtree(bigBinaryTreeRootNode.getLeft(), smallBinaryTreeRootNode) ||
                subtree(bigBinaryTreeRootNode.getRight(), smallBinaryTreeRootNode));
    }

    private boolean matchTree(BinaryTreeNode bigBinaryTreeRootNode, BinaryTreeNode smallBinaryTreeRootNode) {
        boolean leftTreeMatch = false;
        boolean rightTreeMatch = false;
        if (bigBinaryTreeRootNode == null && smallBinaryTreeRootNode == null) {// if both are empty
            return true;// nothing left in the subtree
        }
        // if one, but not both, are empty
        if (bigBinaryTreeRootNode == null || smallBinaryTreeRootNode == null) {
            return false;
        }
        if (bigBinaryTreeRootNode.getValue() != smallBinaryTreeRootNode.getValue()) {
            return false;//data doesn't match
        }
        leftTreeMatch = matchTree(bigBinaryTreeRootNode.getLeft(), smallBinaryTreeRootNode.getLeft());
        rightTreeMatch = matchTree(bigBinaryTreeRootNode.getRight(), smallBinaryTreeRootNode.getRight());

        return leftTreeMatch && rightTreeMatch;
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
