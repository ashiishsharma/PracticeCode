package com.ashish;

public class Box {

    private int height;
    private int width;
    private int depth;
    private BoxComparator boxComparator;

    public Box() {
        boxComparator = new BoxComparator();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public boolean canBeAbove(Box bottom) {
        int i = boxComparator.compare(this, bottom);
        if (i < 0) {
            return false;
        } else {
            return true;
        }
    }
}
