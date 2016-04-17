package com.ashish;

import org.testng.annotations.Test;

/**
 * @author Ashish Sharma
 *         Created on 7/7/2015.
 */
public class HeapSortTest {


    @Test
    public void heapProperty() {
        int[] arr = new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        HeapNode[] arrHeapNode = new HeapNode[arr.length];
        for (int i = 0; i < arrHeapNode.length; i++) {
            arrHeapNode[i] = new HeapNode(i, arr[i]);
        }

        HeapSort heapSort = new HeapSort(arrHeapNode);
        System.out.println("Parent Node:" + heapSort.getParentNodeIndex(2, arrHeapNode.length));
        System.out.println("Left Node:" + heapSort.getLeftNodeIndex(5, arrHeapNode.length));
        System.out.println("Right Node:" + heapSort.getRightNodeIndex(6, arrHeapNode.length));
    }

    @Test
    public void testMaxHeapify() {
        int[] arr = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        HeapNode[] arrHeapNode = new HeapNode[arr.length];
        for (int i = 0; i < arrHeapNode.length; i++) {
            arrHeapNode[i] = new HeapNode(i, arr[i]);
        }

        HeapSort heapSort = new HeapSort(arrHeapNode);
        heapSort.maxHeapify(1, arrHeapNode.length - 1);
        arrHeapNode = heapSort.getArrHeapNode();
    }

    @Test
    public void testMaxHeap() {
        int[] arr = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        HeapNode[] arrHeapNode = new HeapNode[arr.length];
        for (int i = 0; i < arrHeapNode.length; i++) {
            arrHeapNode[i] = new HeapNode(i, arr[i]);
        }

        HeapSort heapSort = new HeapSort(arrHeapNode);
        heapSort.buildMaxHeap();
        arrHeapNode = heapSort.getArrHeapNode();
    }

    @Test
    public void testHeapSort() {
        int[] arr = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        HeapNode[] arrHeapNode = new HeapNode[arr.length];
        for (int i = 0; i < arrHeapNode.length; i++) {
            arrHeapNode[i] = new HeapNode(i, arr[i]);
        }

        HeapSort heapSort = new HeapSort(arrHeapNode);
        arrHeapNode = heapSort.heapSort();
        for (int i = 0; i < arrHeapNode.length; i++) {
            System.out.print(arrHeapNode[i].getValue());
            System.out.print(",");
        }
    }

    @Test
    public void testHeapSort2() {
        int[] arr = new int[]{18,76,90,123,56,89,34,97,54,12,34,67,89,0};
        HeapNode[] arrHeapNode = new HeapNode[arr.length];
        for (int i = 0; i < arrHeapNode.length; i++) {
            arrHeapNode[i] = new HeapNode(i, arr[i]);
        }

        HeapSort heapSort = new HeapSort(arrHeapNode);
        arrHeapNode = heapSort.heapSort();
        for (int i = 0; i < arrHeapNode.length; i++) {
            System.out.print(arrHeapNode[i].getValue());
            System.out.print(",");
        }
    }
}
