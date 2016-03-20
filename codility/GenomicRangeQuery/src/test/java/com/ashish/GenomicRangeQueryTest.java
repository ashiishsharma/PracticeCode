package com.ashish;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ashish Sharma
 */
public class GenomicRangeQueryTest {

    public enum acidName {
        A(1, 'A'),
        C(2, 'C'),
        G(3, 'G'),
        T(4, 'T');

        private int impactValue;
        private char name;

        acidName(int impactValue, char name) {
            this.impactValue = impactValue;
            this.name = name;
        }

        public int getImpactValue() {
            return impactValue;
        }

        public char getName() {
            return name;
        }
    }

    @Test
    public void genomicRangeQuery() {

//        String genomicRangeQuery = "CAGCCTA";
//        int[] P = {2, 5, 0};
//        int[] Q = {4, 5, 6};

        String genomicRangeQuery = "TC";
        int[] P = {0, 0, 1};
        int[] Q = {0, 1, 1};


        int[] answer = solution(genomicRangeQuery, P, Q);

        for (int i : answer) {
            System.out.print(i + ",");
        }
    }

    public int[] solution(String S, int[] P, int[] Q) {

        Map impactFactorMap = new HashMap();
        impactFactorMap.put('A', 1);
        impactFactorMap.put('C', 2);
        impactFactorMap.put('G', 3);
        impactFactorMap.put('T', 4);

        int[] impactFactorArr = new int[P.length];

        for (int i = 0; i < P.length; i++) {
            int rangeStart = P[i];
            int endRange = Q[i];
            int impactFactor = Integer.MAX_VALUE;

            if (rangeStart != endRange) {
                for (int j = rangeStart; j <= endRange; j++) {
                    char c = S.charAt(j);
                    if (impactFactor > (Integer) impactFactorMap.get(c)) {
                        impactFactor = (Integer) impactFactorMap.get(c);
                    }
                }
            } else {
                impactFactor = (Integer) impactFactorMap.get(S.charAt(rangeStart));
            }
            impactFactorArr[i] = impactFactor;
        }

        return impactFactorArr;
    }
}
