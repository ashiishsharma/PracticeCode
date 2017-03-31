package com.ashish;

/**
 * @author Ashish Sharma
 *         Created on 8/16/2015.
 */
public class BinaryTree {
    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    BinaryTreeNode root;

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }
}
