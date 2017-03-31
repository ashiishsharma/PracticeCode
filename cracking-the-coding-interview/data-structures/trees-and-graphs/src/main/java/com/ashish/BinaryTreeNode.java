package com.ashish;

/**
 * @author Ashish Sharma
 *         Created on 8/16/2015.
 */
public class BinaryTreeNode {
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private int value;
    private BinaryTreeNode parent;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNode parent) {
        this.parent = parent;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public BinaryTreeNode(BinaryTreeNode parent, int value) {
        this.parent = parent;
        this.value = value;
    }

}
