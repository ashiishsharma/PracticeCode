package com.ashish;


import org.testng.annotations.Test;

/**
 * 4.3
 * <p>
 * Given a sorted (increasing order) array with unique integer elements,
 * write an algorithm to create a binary search tree with minimal height
 * <p>
 * Solution :
 * 1. Pass on the middle element of the array to insert as root node.
 * 2. Pass the left subarray recursively to insert for left subtree.
 * 3. Pass the right subarray recursively to insert for right subtree.
 *
 * @author Ashish Sharma on 26-03-2017.
 *         <p>
 * @since 26-03-2017.
 */
public class SortedArrayToBinarySearchTreeTest {

    private int[] sortedArray;
    private BinaryTreeNode[] binaryTreeNodeArray;
    private BinaryTree binaryTree;

    @Test
    public void binarySearchTreeCreationWithSeparateInsertionMethod() {
        binaryTreeNodeArray = getSortedBinaryTreeNodeArray();

        int start = 0;
        int end = binaryTreeNodeArray.length - 1;
        int mid = (start + end) / 2;
        binaryTree = new BinaryTree(binaryTreeNodeArray[mid]);
        createBinarySearchTreeWithMinimalHeight(binaryTree, start, mid - 1);
        createBinarySearchTreeWithMinimalHeight(binaryTree, mid + 1, end);
    }

    @Test
    public void binarySearchTreeCreationWithOutSeparateInsertionMethod() {
        binaryTreeNodeArray = getSortedBinaryTreeNodeArray();
        int start = 0;
        int end = binaryTreeNodeArray.length - 1;
        int mid = (start + end) / 2;
        binaryTree = new BinaryTree(binaryTreeNodeArray[mid]);
        binaryTreeNodeArray[mid].setLeft(createBinarySearchTreeWithMinimalHeight(binaryTreeNodeArray[mid], start, mid - 1));
        binaryTreeNodeArray[mid].setRight(createBinarySearchTreeWithMinimalHeight(binaryTreeNodeArray[mid], mid + 1, end));
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

    private void createBinarySearchTreeWithMinimalHeight(BinaryTree binaryTree, int start, int end) {
        if (start <= end) {
            if (start == end) {
                treeInsertion(binaryTree.getRoot(), binaryTreeNodeArray[start]);
            } else if (start + 1 == end) {
                //Saving couple of recursive method calls
                treeInsertion(binaryTree.getRoot(), binaryTreeNodeArray[start]);
                treeInsertion(binaryTree.getRoot(), binaryTreeNodeArray[end]);
            } else {
                int mid = (start + end) / 2;
                treeInsertion(binaryTree.getRoot(), binaryTreeNodeArray[mid]);
                createBinarySearchTreeWithMinimalHeight(binaryTree, start, mid - 1);
                createBinarySearchTreeWithMinimalHeight(binaryTree, mid + 1, end);
            }
        }
    }

    private BinaryTreeNode treeInsertion(BinaryTreeNode rootNode, BinaryTreeNode binaryTreeNodeToInsert) {
        BinaryTreeNode root = rootNode;
        BinaryTreeNode binaryTreeNodeTemp = null;
        while (rootNode != null) {
            binaryTreeNodeTemp = rootNode;
            if (binaryTreeNodeToInsert.getValue() < rootNode.getValue()) {
                rootNode = rootNode.getLeft();
            } else {
                rootNode = rootNode.getRight();
            }
        }
        binaryTreeNodeToInsert.setParent(binaryTreeNodeTemp);
        if (binaryTreeNodeTemp == null) {
            rootNode = binaryTreeNodeToInsert; // For Empty tree
        } else if (binaryTreeNodeToInsert.getValue() < binaryTreeNodeTemp.getValue()) {
            binaryTreeNodeTemp.setLeft(binaryTreeNodeToInsert);
        } else {
            binaryTreeNodeTemp.setRight(binaryTreeNodeToInsert);
        }

        return root;
    }

    private BinaryTreeNode[] getSortedBinaryTreeNodeArray() {
        //Test with both arrays
        sortedArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        sortedArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        binaryTreeNodeArray = new BinaryTreeNode[sortedArray.length];

        for (int i = 0; i < sortedArray.length; i++) {
            BinaryTreeNode binaryTreeNode = new BinaryTreeNode(null, sortedArray[i]);
            binaryTreeNodeArray[i] = binaryTreeNode;
        }

        return binaryTreeNodeArray;
    }
}
