package com.ashish;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    List<List<Integer>> getSubsets(List<Integer> set, int index) {
        List<List<Integer>> allsubsets;
        if (set.size() == index) {
            //Base case - add empty set
            allsubsets = new ArrayList<List<Integer>>();
            allsubsets.add(new ArrayList<Integer>()); // Empty set
        } else {
            allsubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
            for (List<Integer> subset : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset); //
                newsubset.add(item);
                moreSubsets.add(newsubset);
            }
            allsubsets.addAll(moreSubsets);
        }
        return allsubsets;
    }

    ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
        int max = 1 << set.size(); /* Compute 2An */
        for (int k = 0; k < max; k++) {
            ArrayList<Integer> subset = convertintToSet(k, set);
            allsubsets.add(subset);
        }
        return allsubsets;
    }

    ArrayList<Integer> convertintToSet(int x, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<Integer>();
        int index = 0;
        for (int k = x; k > 0; k >>= 1) {
            if ((k & 1) == 1) {
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;
    }
}
