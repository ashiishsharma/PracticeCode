package com.ashish;


import org.testng.annotations.Test;

/**
 * 4.3
 * <p>
 * Given a sorted (increasing order) array with unique integer elements,
 * write an algorithm to create a binary search tree with minimal height
 *
 * @author Ashish Sharma on 26-03-2017.
 *         <p>
 * @since 26-03-2017.
 */
public class SortedArrayToBinarySearchTreeTest {

    private int[] sortedArray;
    private BinaryTreeNode[] binaryTreeNodeArray;

    @Test
    public void binarySearchTreeCreationIterative() {
        binaryTreeNodeArray = getSortedBinaryTreeNodeArray();
    }

    private BinaryTreeNode treeInsertion(BinaryTreeNode rootNode, BinaryTreeNode binaryTreeNode) {
        BinaryTreeNode root = rootNode;
        BinaryTreeNode binaryTreeNodeTemp = null;
        while (rootNode != null) {
            binaryTreeNodeTemp = rootNode;
            if (binaryTreeNode.getValue() < rootNode.getValue()) {
                rootNode = rootNode.getLeft();
            } else {
                rootNode = rootNode.getRight();
            }
        }
        binaryTreeNode.setParent(binaryTreeNodeTemp);
        if (binaryTreeNodeTemp == null) {
            rootNode = binaryTreeNode; // For Empty tree
        } else if (binaryTreeNode.getValue() < binaryTreeNodeTemp.getValue()) {
            binaryTreeNodeTemp.setLeft(binaryTreeNode);
        } else {
            binaryTreeNodeTemp.setRight(binaryTreeNode);
        }

        return root;
    }

    private BinaryTreeNode[] getSortedBinaryTreeNodeArray() {
        sortedArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        binaryTreeNodeArray = new BinaryTreeNode[sortedArray.length];

        for (int i = 0; i < sortedArray.length; i++) {
            BinaryTreeNode binaryTreeNode = new BinaryTreeNode(null, sortedArray[i]);
            binaryTreeNodeArray[i] = binaryTreeNode;
        }

        return binaryTreeNodeArray;
    }
}
