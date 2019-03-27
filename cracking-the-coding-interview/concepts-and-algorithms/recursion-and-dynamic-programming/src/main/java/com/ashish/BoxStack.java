package com.ashish;

import java.util.ArrayList;
import java.util.Collections;

public class BoxStack {

    /* int createStack(ArrayList<Box> boxes) {
     *//* Sort in decending order by height. *//*
        Collections.sort(boxes, new BoxComparator());
        int maxHeight = 0;
        for (int i = 0; i < boxes.size(); i++) {
            int height = createStack(boxes, i);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;
    }*/

    /*int createStack(ArrayList<Box> boxes, int bottomIndex) {
        Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;
        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottom)) {
                int height = createStack(boxes, i);
                maxHeight = Math.max(height, maxHeight);
            }
        }
        maxHeight += bottom.getHeight();
        return maxHeight;
    }*/

    int createStack(ArrayList<Box> boxes) {
        Collections.sort(boxes, new BoxComparator());
        int maxHeight = 0;
        int[] stackMap = new int[boxes.size()];
        for (int i = 0; i < boxes.size(); i++) {
            int height = createStack(boxes, i, stackMap);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;
    }

    int createStack(ArrayList<Box> boxes, int bottomIndex, int[] stackMap) {
        if (bottomIndex < boxes.size() && stackMap[bottomIndex] > 0) {
            return stackMap[bottomIndex];
        }

        Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;
        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottom)) {
                int height = createStack(boxes, i, stackMap);
                maxHeight = Math.max(height, maxHeight);
            }
        }
        maxHeight += bottom.getHeight();
        stackMap[bottomIndex] = maxHeight;
        return maxHeight;
    }

    /*
    Alternative solution
     */

    int createStackAlternateSolution(ArrayList<Box> boxes) {
        Collections.sort(boxes, new BoxComparator());
        int[] stackMap = new int[boxes.size()];
        return createStackAlternateSolution(boxes, null, 0, stackMap);
    }

    int createStackAlternateSolution(ArrayList<Box> boxes, Box bottom, int offset, int[] stackMap) {
        if (offset >= boxes.size()) return 0; // Base case

        /* height with this bottom*/
        Box newBottom = boxes.get(offset);
        int heightWithBottom = 0;
        if (bottom == null || newBottom.canBeAbove(bottom)) {
            if (stackMap[offset] == 0) {
                stackMap[offset] = createStackAlternateSolution(boxes, newBottom, offset + 1, stackMap);
                stackMap[offset] += newBottom.getHeight();
            }
            heightWithBottom = stackMap[offset];
        }
        /* without this bottom*/
        int heightWithoutBottom = createStackAlternateSolution(boxes, bottom, offset + 1, stackMap);
        /* Return better of two options. */
        return Math.max(heightWithBottom, heightWithoutBottom);
    }
}
