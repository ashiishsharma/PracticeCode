package com.ashish;

import org.testng.annotations.Test;

/**
 * 4.7
 * <p>
 * Design an algorithm and write code to find the first common ancestor of two nodes
 * in a binary tree. Avoid storing additional nodes in a data structure.
 * NOTE: This is not necessarily a binary search tree.
 *
 * @author Ashish Sharma on 3/30/2017.
 *         <p>
 * @since 3/30/2017.
 */
public class CommonAncestor_BinaryTreeTest {

    @Test
    public void testCommonAncestor() {
        BinaryTree binaryTree = binarySearchTreeCreationWithOutSeparateInsertionMethod();

        //Define nodes for which common ancestors need to be found
        BinaryTreeNode binaryTreeNodeForCommonAncestor1 = binaryTree.getRoot().getLeft().getLeft();
        BinaryTreeNode binaryTreeNodeForCommonAncestor2 = binaryTree.getRoot().getLeft().getRight().getRight();

        BinaryTreeNode commonAncestor = getCommonAncestor(binaryTree.getRoot(), binaryTreeNodeForCommonAncestor1
                , binaryTreeNodeForCommonAncestor2);
        System.out.println("Common ancestor for : " + binaryTreeNodeForCommonAncestor1.getValue() +
                ", and : " + binaryTreeNodeForCommonAncestor2.getValue() + " , is : " + commonAncestor.getValue());
    }

    private BinaryTreeNode getCommonAncestor(BinaryTreeNode root,
                                             BinaryTreeNode binaryTreeNodeForCommonAncestor1,
                                             BinaryTreeNode binaryTreeNodeForCommonAncestor2) {
        if (root == null) {
            return null;
        }

        if (root == binaryTreeNodeForCommonAncestor1 && root == binaryTreeNodeForCommonAncestor2) {
            return root;
        }

        BinaryTreeNode x = getCommonAncestor(root.getLeft(),
                binaryTreeNodeForCommonAncestor1,
                binaryTreeNodeForCommonAncestor2);
        if (x != null &&
                x != binaryTreeNodeForCommonAncestor1 &&
                x != binaryTreeNodeForCommonAncestor2) { // Already found ancestor
            return x;
        }

        BinaryTreeNode y = getCommonAncestor(root.getRight(),
                binaryTreeNodeForCommonAncestor1,
                binaryTreeNodeForCommonAncestor2);
        if (y != null &&
                y != binaryTreeNodeForCommonAncestor1 &&
                y != binaryTreeNodeForCommonAncestor2) { // Already found ancestor
            return y;
        }

        if (x != null && y != null) { // p and q found in diff. subtrees
            return root; // This is the common ancestor
        } else if (root == binaryTreeNodeForCommonAncestor1 || root == binaryTreeNodeForCommonAncestor2) {
            return root;
        } else {
            // If either x or y is non-null, return the non-null value
            return x == null ? y : x;
        }
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
