package com.ashish;

/**
 * Created by shshaash on 3/28/2017.
 */
public class BinaryTreeNodeForBFS {
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private int value;
    private BinaryTreeNodeForBFS parent;
    private BinaryTreeNodeForBFS left;
    private BinaryTreeNodeForBFS right;
    private NodeColor nodeColor;
    private int distanceFromRoot;

    public BinaryTreeNodeForBFS getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNodeForBFS parent) {
        this.parent = parent;
    }

    public BinaryTreeNodeForBFS getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNodeForBFS left) {
        this.left = left;
    }

    public BinaryTreeNodeForBFS getRight() {
        return right;
    }

    public void setRight(BinaryTreeNodeForBFS right) {
        this.right = right;
    }

    public BinaryTreeNodeForBFS(BinaryTreeNodeForBFS parent, int value) {
        this.parent = parent;
        this.value = value;
        this.nodeColor = NodeColor.White;
        this.distanceFromRoot = Integer.MAX_VALUE;
    }

    public NodeColor getNodeColor() {
        return nodeColor;
    }

    public void setNodeColor(NodeColor nodeColor) {
        this.nodeColor = nodeColor;
    }

    public int getDistanceFromRoot() {
        return distanceFromRoot;
    }

    public void setDistanceFromRoot(int distanceFromRoot) {
        this.distanceFromRoot = distanceFromRoot;
    }

    public String toString(){
        return String.valueOf(getValue());
    }

    public enum NodeColor {
        //UnVisited
        White,

        //Visiting
        Gray,

        //Visited
        Black;
    }
}





