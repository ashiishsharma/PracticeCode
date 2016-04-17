package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @author Ashish Sharma
 *         Created on 8/16/2015.
 */
public class BinaryTreeOperationsTest {

    private BinaryTree binaryTree;

    @BeforeMethod
    public void init() {
        binaryTree = getBinaryTree1();
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

    @Test
    public void inOrderTreeWalkTest() {
        binaryTree = getBinaryTree2();
        BinaryTreeNode binaryTreeNode = binaryTree.getRoot();
        inOrderTreeWalk(binaryTreeNode);

    }

    private void inOrderTreeWalk(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode != null) {
            inOrderTreeWalk(binaryTreeNode.getLeft());
            System.out.println(binaryTreeNode.getValue() + ",");
            inOrderTreeWalk(binaryTreeNode.getRight());
        }
    }

    @Test
    public void binaryTreeSearchTest() {
        binaryTree = getBinaryTree2();
        BinaryTreeNode binaryTreeNode = binaryTree.getRoot();
        int keyToSearch = 13;
        BinaryTreeNode foundNode = binaryTreeSearch(binaryTreeNode, keyToSearch);
        if (foundNode != null) {
            System.out.println(foundNode.getValue());
        } else {
            System.out.println("Not found");
        }
    }

    private BinaryTreeNode binaryTreeSearch(BinaryTreeNode binaryTreeNode, int keyToSearch) {
        if (binaryTreeNode == null || keyToSearch == binaryTreeNode.getValue()) {
            return binaryTreeNode;
        }
        if (keyToSearch < binaryTreeNode.getValue()) {
            return binaryTreeSearch(binaryTreeNode.getLeft(), keyToSearch);
        } else {
            return binaryTreeSearch(binaryTreeNode.getRight(), keyToSearch);
        }
    }

    @Test
    public void binaryTreeSearchIterativeTest() {
        binaryTree = getBinaryTree2();
        BinaryTreeNode binaryTreeNode = binaryTree.getRoot();
        int keyToSearch = 13;
        BinaryTreeNode foundNode = binaryTreeSearchIterative(binaryTreeNode, keyToSearch);
        if (foundNode != null) {
            System.out.println(foundNode.getValue());
        } else {
            System.out.println("Not found");
        }
    }

    private BinaryTreeNode binaryTreeSearchIterative(BinaryTreeNode binaryTreeNode, int keyToSearch) {

        while (binaryTreeNode != null && keyToSearch != binaryTreeNode.getValue()) {
            if (keyToSearch < binaryTreeNode.getValue()) {
                binaryTreeNode = binaryTreeNode.getLeft();
            } else {
                binaryTreeNode = binaryTreeNode.getRight();
            }
        }
        return binaryTreeNode;
    }

    @Test
    public void binaryTreeMinimumTest() {
        binaryTree = getBinaryTree2();
        BinaryTreeNode binaryTreeNode = binaryTree.getRoot();
        BinaryTreeNode minimumNode = binaryTreeMinimum(binaryTreeNode);
        if (minimumNode != null) {
            System.out.println(minimumNode.getValue());
        } else {
            System.out.println("Not found");
        }
    }

    private BinaryTreeNode binaryTreeMinimum(BinaryTreeNode binaryTreeNode) {
        while (binaryTreeNode.getLeft() != null) {
            binaryTreeNode = binaryTreeNode.getLeft();
        }
        return binaryTreeNode;
    }

    @Test
    public void binaryTreeMaximumTest() {
        binaryTree = getBinaryTree2();
        BinaryTreeNode binaryTreeNode = binaryTree.getRoot();
        BinaryTreeNode maximumNode = binaryTreeMaximum(binaryTreeNode);
        if (maximumNode != null) {
            System.out.println(maximumNode.getValue());
        } else {
            System.out.println("Not found");
        }
    }

    private BinaryTreeNode binaryTreeMaximum(BinaryTreeNode binaryTreeNode) {
        while (binaryTreeNode.getRight() != null) {
            binaryTreeNode = binaryTreeNode.getRight();
        }
        return binaryTreeNode;
    }

    @Test
    public void binaryTreeSuccessorTest() {
        binaryTree = getBinaryTree2();
        BinaryTreeNode binaryTreeNode = binaryTree.getRoot();

//        int keyToSearch = 13;
//        binaryTreeNode = binaryTreeSearch(binaryTreeNode, keyToSearch);

        BinaryTreeNode successorNode = binaryTreeSuccessor(binaryTreeNode);
        if (successorNode != null) {
            System.out.println(successorNode.getValue());
        } else {
            System.out.println("Not found");
        }
    }

    private BinaryTreeNode binaryTreeSuccessor(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode.getRight() != null) {
            return binaryTreeMinimum(binaryTreeNode.getRight());
        }
        BinaryTreeNode binaryTreeNodeSuccessor = binaryTreeNode.getParent();

        while (binaryTreeNodeSuccessor != null && binaryTreeNode.getValue() == binaryTreeNodeSuccessor.getRight().getValue()) {
            binaryTreeNode = binaryTreeNodeSuccessor;
            binaryTreeNodeSuccessor = binaryTreeNodeSuccessor.getParent();
        }

        return binaryTreeNodeSuccessor;
    }

    @Test
    public void biaryTreePredecessorTest() {
        binaryTree = getBinaryTree2();
        BinaryTreeNode binaryTreeNode = binaryTree.getRoot();

//        int keyToSearch = 13;
//        binaryTreeNode = binaryTreeSearch(binaryTreeNode, keyToSearch);

        BinaryTreeNode predecessorNode = binaryTreePredecessor(binaryTreeNode);
        if (predecessorNode != null) {
            System.out.println(predecessorNode.getValue());
        } else {
            System.out.println("Not found");
        }
    }

    private BinaryTreeNode binaryTreePredecessor(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode.getLeft() != null) {
            return binaryTreeMaximum(binaryTreeNode.getLeft());
        }
        BinaryTreeNode binaryTreeNodePredecessor = binaryTreeNode.getParent();

        while (binaryTreeNodePredecessor != null && binaryTreeNode.getValue() == binaryTreeNodePredecessor.getLeft().getValue()) {
            binaryTreeNode = binaryTreeNodePredecessor;
            binaryTreeNodePredecessor = binaryTreeNodePredecessor.getParent();
        }

        return binaryTreeNodePredecessor;
    }

    private BinaryTree getBinaryTree3() {
        BinaryTreeNode root = new BinaryTreeNode(null, 12);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(root, 5);
        root.setLeft(binaryTreeNode5);

        BinaryTreeNode binaryTreeNode18 = new BinaryTreeNode(root, 18);
        root.setRight(binaryTreeNode18);

        BinaryTreeNode binaryTreeNode15 = new BinaryTreeNode(binaryTreeNode18, 15);
        binaryTreeNode18.setLeft(binaryTreeNode15);

        BinaryTreeNode binaryTreeNode19 = new BinaryTreeNode(binaryTreeNode18, 19);
        binaryTreeNode18.setRight(binaryTreeNode19);

        BinaryTreeNode binaryTreeNode17 = new BinaryTreeNode(binaryTreeNode15, 17);
        binaryTreeNode15.setRight(binaryTreeNode17);


        BinaryTreeNode binaryTreeNode9 = new BinaryTreeNode(binaryTreeNode5, 9);
        binaryTreeNode5.setRight(binaryTreeNode9);

        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(binaryTreeNode5, 2);
        binaryTreeNode5.setLeft(binaryTreeNode2);


        BinaryTree binaryTree = new BinaryTree(root);
        return binaryTree;
    }


    @Test
    public void treeInsertionTest() {
        binaryTree = getBinaryTree3();
        BinaryTreeNode binaryTreeNode = binaryTree.getRoot();

        BinaryTreeNode binaryTreeNode13 = new BinaryTreeNode(null, 13);

        binaryTreeNode = treeInsertion(binaryTreeNode, binaryTreeNode13);
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

    @Test
    public void transplantTest() {
        binaryTree = getBinaryTree3();
        BinaryTreeNode rootBinaryTreeNode = binaryTree.getRoot();

        int keyToSearch = 18;
        BinaryTreeNode u_binaryTreeNode = binaryTreeSearch(rootBinaryTreeNode, keyToSearch);

        keyToSearch = 19;
        BinaryTreeNode v_binaryTreeNode = binaryTreeSearch(rootBinaryTreeNode, keyToSearch);

        transplant(rootBinaryTreeNode, u_binaryTreeNode, v_binaryTreeNode);

    }

    private void transplant(BinaryTreeNode rootBinaryTreeNode, BinaryTreeNode u_binaryTreeNode, BinaryTreeNode v_binaryTreeNode) {
        if (u_binaryTreeNode.getParent() == null) {
            rootBinaryTreeNode = v_binaryTreeNode;
        } else if (u_binaryTreeNode == u_binaryTreeNode.getParent().getLeft()) {
            u_binaryTreeNode.getParent().setLeft(v_binaryTreeNode);
        } else {
            u_binaryTreeNode.getParent().setRight(v_binaryTreeNode);
        }
        if (v_binaryTreeNode != null) {
            v_binaryTreeNode.setParent(u_binaryTreeNode.getParent());
        }
    }

    @Test
    public void binaryTreeDeleteTest() {
        binaryTree = getBinaryTree3();
        BinaryTreeNode rootBinaryTreeNode = binaryTree.getRoot();

        int keyToSearch = 18;
        BinaryTreeNode binaryTreeNode = binaryTreeSearch(rootBinaryTreeNode, keyToSearch);

        binaryTreeDelete(rootBinaryTreeNode, binaryTreeNode);
    }

    private void binaryTreeDelete(BinaryTreeNode rootBinaryTreeNode, BinaryTreeNode binaryTreeNode) {
        BinaryTreeNode tempBinaryTreeNode = null;
        if (binaryTreeNode.getLeft() == null) {
            transplant(rootBinaryTreeNode, binaryTreeNode, binaryTreeNode.getRight());
        } else if (binaryTreeNode.getRight() == null) {
            transplant(rootBinaryTreeNode, binaryTreeNode, binaryTreeNode.getLeft());
        } else {
            tempBinaryTreeNode = binaryTreeMinimum(binaryTreeNode.getRight());
            if (tempBinaryTreeNode.getParent().getValue() != binaryTreeNode.getValue()) {
                transplant(rootBinaryTreeNode, tempBinaryTreeNode, tempBinaryTreeNode.getRight());
                tempBinaryTreeNode.setRight(binaryTreeNode.getRight());
                tempBinaryTreeNode.getRight().setParent(tempBinaryTreeNode);
            }
            transplant(rootBinaryTreeNode, binaryTreeNode, tempBinaryTreeNode);
            tempBinaryTreeNode.setLeft(binaryTreeNode.getLeft());
            tempBinaryTreeNode.getLeft().setParent(tempBinaryTreeNode);
        }
    }


}
