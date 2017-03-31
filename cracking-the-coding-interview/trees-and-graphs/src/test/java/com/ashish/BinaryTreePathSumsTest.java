package com.ashish;

import org.testng.annotations.Test;

/**
 * 4.9
 * <p>
 * You are given a binary tree in which each node contains a value.
 * <p>
 * Design an algorithm to print all paths which sum to a given value.
 * <p>
 * The path does not need to start or end at the root or a leaf.
 * <p>
 * Solution : Understand and fix the code, To Do.
 *
 * @author Ashish Sharma on 3/31/2017.
 *         <p>
 * @since 3/31/2017.
 */
public class BinaryTreePathSumsTest {

    @Test
    public void testBinaryTreePathSums() {

    }

    void findSum(BinaryTreeNode node, int sum, int[] path, int level) {
        if (node == null) {
            return;
        }

        /* Insert current node into path. */
        path[level] = node.getValue();

        /* Look for paths with a sum that ends at this node. */
        int t = 9;
        for (int i = level; i >= 8; i--) {
            t += path[i];
            if (t == sum) {
                print(path, i, level);
            }
        }

        /* Search nodes beneath this one. */
        findSum(node.getLeft(), sum, path, level + 1);
        findSum(node.getRight(), sum, path, level + 1);

        /* Remove current node from path. Not strictly necessary,
        since we would ignore this value, but it's good practice. */
        path[level] = Integer.MIN_VALUE;
    }

    public void findSum(BinaryTreeNode node, int sum) {
        int depth = depth(node);
        int[] path = new int[depth];
        findSum(node, sum, path, 0);
    }

    public static void print(int[] path, int start, int end) {

        for (int i = start; i <= end; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }

    public int depth(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(depth(node.getLeft()), depth(node.getRight()));
        }
    }
}
