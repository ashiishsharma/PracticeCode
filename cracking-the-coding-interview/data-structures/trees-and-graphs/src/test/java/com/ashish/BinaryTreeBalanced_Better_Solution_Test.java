package com.ashish;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 4.1
 * <p>
 * Solution : Inefficient, O(n2)
 * <p>
 * Implement a function to check if a binary tree is balanced.
 * For the purposes of this question,
 * a balanced tree is defined to be a tree such that the heights of the two
 * subtrees of any node never differ by more than one.
 * <p>
 *
 * @author Ashish Sharma on 1/27/2017.
 *         <p>
 * @since 1/27/2017
 */
public class BinaryTreeBalanced_Better_Solution_Test {

    private BinaryTree binaryTree1;
    private BinaryTree binaryTree2;

    @BeforeMethod
    public void init() {
        binaryTree1 = getBinaryTree1();
        binaryTree2 = getBinaryTree2();
    }

    @Test
    public void testCalculateBinaryTreeHeight() {
        int i = getHeightForBinaryTree(binaryTree2.getRoot());
        System.out.println("Height of binary tree: " + i);
    }

    @Test
    public void testBalancedBinaryTree() {
        System.out.println("Binary tree is balanced : " + isBinaryTreeBalanced(binaryTree1.getRoot()));
    }

    private boolean isBinaryTreeBalanced(BinaryTreeNode root) {
        boolean isTreeBalanced = false;
        if (root == null) {
            isTreeBalanced = true;
            return isTreeBalanced;
        } else {
            int treeHeight = getHeightForBinaryTree(root.getLeft()) - getHeightForBinaryTree(root.getRight());
            if (Math.abs(treeHeight) > 1) {
                isTreeBalanced = false;
                return isTreeBalanced;
            }else {
                isTreeBalanced = isBinaryTreeBalanced(root.getLeft()) && isBinaryTreeBalanced(root.getRight());
                return isTreeBalanced;
            }
        }
    }

    private int getHeightForBinaryTree(BinaryTreeNode binaryTreeNode) {
        int height = 0;
        if (binaryTreeNode == null) {
            return 0;
        } else {
            height = Math.max(getHeightForBinaryTree(binaryTreeNode.getLeft()), getHeightForBinaryTree(binaryTreeNode.getRight())) + 1;
        }
        return height;
    }

    private BinaryTree getBinaryTree2() {
        BinaryTreeNode root = new BinaryTreeNode(null, 15);
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(root, 6);
        root.setLeft(binaryTreeNode6);

        BinaryTreeNode binaryTreeNode18 = new BinaryTreeNode(root, 18);
        root.setRight(binaryTreeNode18);

        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(binaryTreeNode6, 3);
        binaryTreeNode6.setLeft(binaryTreeNode3);

        BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode(binaryTreeNode6, 7);
        binaryTreeNode6.setRight(binaryTreeNode7);

        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(binaryTreeNode3, 2);
        binaryTreeNode3.setLeft(binaryTreeNode2);

        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(binaryTreeNode3, 4);
        binaryTreeNode3.setRight(binaryTreeNode4);

        BinaryTreeNode binaryTreeNode13 = new BinaryTreeNode(binaryTreeNode7, 13);
        binaryTreeNode7.setRight(binaryTreeNode13);

        BinaryTreeNode binaryTreeNode9 = new BinaryTreeNode(binaryTreeNode13, 9);
        binaryTreeNode13.setLeft(binaryTreeNode9);

        BinaryTreeNode binaryTreeNode17 = new BinaryTreeNode(binaryTreeNode18, 17);
        binaryTreeNode18.setLeft(binaryTreeNode17);

        BinaryTreeNode binaryTreeNode20 = new BinaryTreeNode(binaryTreeNode18, 20);
        binaryTreeNode18.setRight(binaryTreeNode20);

        BinaryTree binaryTree = new BinaryTree(root);
        return binaryTree;
    }

    private BinaryTree getBinaryTree1() {
        BinaryTreeNode root = new BinaryTreeNode(null, 5);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(root, 3);
        root.setLeft(binaryTreeNode3);

        BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode(root, 7);
        root.setRight(binaryTreeNode7);

        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(binaryTreeNode3, 2);
        binaryTreeNode3.setLeft(binaryTreeNode2);

        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(binaryTreeNode3, 5);
        binaryTreeNode3.setRight(binaryTreeNode5);

        BinaryTreeNode binaryTreeNode8 = new BinaryTreeNode(binaryTreeNode7, 8);
        binaryTreeNode7.setRight(binaryTreeNode8);

        BinaryTree binaryTree = new BinaryTree(root);
        return binaryTree;
    }
}
