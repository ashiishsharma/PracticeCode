package com.ashish;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Ashish Sharma
 */
public class PassingCarsTest {

    @Test
    public void passingCarsTest() {
        int[] carArr = {0, 1, 0, 1, 1};
//        int[] carArr = {0, 1, 0, 1, 1, 0, 1, 1, 0, 1};
//        int[] carArr = {0,0,0,1,1,1};

        System.out.println(solution2(carArr));
    }

    public int solution(int[] A) {
        int[] carArr = A;
        int[] carCounter = new int[carArr.length];

        int lastCarGoingEast = 0;
        for (int i = 0; i < carArr.length; i++) {
            if (carArr[i] == 0) {
                lastCarGoingEast++;
            } else if (carArr[i] == 1) {
                incrementCarCrossPair(carCounter, lastCarGoingEast);
            }
        }

        int sum = Arrays.stream(carCounter).sum();
        if (sum > 1000000000) {
            sum = -1;
        }
        return sum;
    }

    private void incrementCarCrossPair(int[] carCounter, int lastCarGoingEast) {
        for (int i = 0; i < lastCarGoingEast; i++) {
            carCounter[i]++;
        }
    }

    public int solution2(int[] A)
    {
        int crossingPair = 0;
        int carGoingEast = 0;
        for (int carGoingInDirection : A)
        {
            if (carGoingInDirection == 0)
            {
                carGoingEast = carGoingEast + 1;
            }
            if (carGoingEast > 0)
            {
                if (carGoingInDirection == 1)
                {
                    crossingPair = crossingPair + carGoingEast;
                    if (crossingPair > 1000000000)
                    {
                        return -1;
                    }
                }
            }
        }
        return crossingPair;
    }
}
