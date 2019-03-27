package com.ashish;

import java.util.Comparator;

public class BoxComparator implements Comparator<Box> {
    @Override
    public int compare(Box box1, Box box2) {
        return box1.getHeight() - box2.getHeight();
    }
}
