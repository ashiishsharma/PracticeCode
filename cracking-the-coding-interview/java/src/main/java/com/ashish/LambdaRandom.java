package com.ashish;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LambdaRandom {
    List<Integer> getRandomSubset(List<Integer> list) {
        List<Integer> subset = new ArrayList<Integer>();
        Random random = new Random();
        for (int item : list) {
            /* Flip coin. */
            if (random.nextBoolean()) {
                subset.add(item);
            }
        }
        return subset;
    }

    List<Integer> getRandomSubsetLambda(List<Integer> list) {
        Random random = new Random();
        List<Integer> subset = list.stream().filter(
                k -> {
                    return random.nextBoolean(); /* Flip coin. */
                }).collect(Collectors.toList());
        return subset;
    }
}
