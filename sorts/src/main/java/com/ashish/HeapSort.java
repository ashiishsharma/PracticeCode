package com.ashish;

/**
 * @author Ashish Sharma
 *         Created on 7/7/2015.
 */
public class HeapSort {

    public HeapNode[] getArrHeapNode() {
        return arrHeapNode;
    }

    private final HeapNode[] arrHeapNode;

    public HeapSort(HeapNode[] arrHeapNode) {
        this.arrHeapNode = arrHeapNode;
    }


    public int getParentNodeIndex(int i, int heapSize) {
        if (i < heapSize) {
            return (int) Math.floor(i / 2);
        } else {
            return -1;
        }
    }

    public int getLeftNodeIndex(int i, int heapSize) {
        int index = -1;
        if (i < heapSize) {
            index = 2 * i + 1;
        }
        return index < arrHeapNode.length ? index : -1;
    }

    public int getRightNodeIndex(int i, int heapSize) {
        int index = -1;
        if (i < heapSize) {
            index = 2 * i + 2;
        }
        return index < heapSize ? index : -1;
    }

    public void maxHeapify(int i, int heapSize) {
        HeapNode leftNode = null;
        if (getLeftNodeIndex(i, heapSize) != -1) {
            leftNode = arrHeapNode[getLeftNodeIndex(i, heapSize)];
        }

        HeapNode rightNode = null;
        if (getRightNodeIndex(i, heapSize) != -1) {
            rightNode = arrHeapNode[getRightNodeIndex(i, heapSize)];
        }
        HeapNode largest = null;
        if (leftNode != null) {
            if ((Integer) leftNode.getIndex() < heapSize && (Integer) leftNode.getValue() > (Integer) arrHeapNode[i].getValue()) {
                largest = leftNode;
            } else {
                largest = arrHeapNode[i];
            }
        }

        if (rightNode != null) {
            if (largest != null) {
                if ((Integer) rightNode.getIndex() < heapSize && (Integer) rightNode.getValue() > (Integer) largest.getValue()) {
                    largest = rightNode;
                }
            } else {
                largest = arrHeapNode[i];
            }
        }
        if (largest != null) {
            if ((Integer) largest.getValue() != (Integer) arrHeapNode[i].getValue()) {
                Object temp = largest.getValue();
                largest.setValue(arrHeapNode[i].getValue());
                arrHeapNode[i].setValue(temp);
                maxHeapify((Integer) largest.getIndex(), heapSize);
            }
        }
    }

    public void buildMaxHeap() {
        //Refer coremen algo for detailed description
        //Iterate upwards from leaf nodes parents to root
        for (int i = (int) Math.floor((arrHeapNode.length / 2) - 1); i >= 0; i--) {
            maxHeapify(i, arrHeapNode.length);
        }
    }

    public HeapNode[] heapSort() {
        buildMaxHeap();
        int temp;
        int heapSize = arrHeapNode.length;
        for (int i = arrHeapNode.length - 1; i > 0; i--) {
            temp = (Integer) arrHeapNode[0].getValue();
            arrHeapNode[0].setValue(arrHeapNode[i].getValue());
            arrHeapNode[i].setValue(temp);

            heapSize--;
            maxHeapify(0, heapSize);
        }
        return arrHeapNode;
    }
}
