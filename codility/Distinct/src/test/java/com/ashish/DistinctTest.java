package com.ashish;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ashish Sharma
 */
public class DistinctTest {
    @Test
    public void distinctTest() {
        int[] A = {2, 1, 1, 2, 3, 1};
        System.out.println(solution(A));
    }


    public int solution(int[] A) {
        Set set = new HashSet();
        for (int i : A) {
            set.add(i);
        }
        return set.size();
    }


}
