package com.ashish;

/**
 * @author Ashish Sharma
 *         Created on 7/29/2015.
 */
public class HeapNode<Integer, Value> {

    private Integer index;
    private Value value;

    public HeapNode(Integer index, Value value) {
        this.index = index;
        this.value = value;
    }

    public Integer getIndex() {
        return index;
    }

    public Value getValue() {
        return value;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public void setValue(Value value) {
        this.value = value;
    }


}
