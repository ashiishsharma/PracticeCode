package com.ashish;

import org.testng.annotations.Test;

/**
 * 1.6
 * Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 * <p>
 * Created by Ashish Sharma on 12/27/2015.
 */
public class MatrixRotationTest {

    @Test
    public void rotateTest() {


    }

    public void rotate(int[][] matrix, int n) {
        for (int layer = 0; layer < n / 2; layer++) {

            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; ++i) {

                int offset = i - first;

                //save top
                int top = matrix[first][i];

                // left -> top
                matrix[first][i] = matrix[last - offset][first];

                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top;
            }
        }

    }
}
