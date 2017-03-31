package com.ashish;

import org.testng.annotations.Test;

/**
 * 1.7
 * <p>
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column are set to 0.
 * <p>
 * @author Ashish Sharma on 12/27/2015.
 */
public class MatrixToZeroTest {

    @Test
    public void setToZeroTest() {

    }

    public void setToZero(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        //store the row and column index with value 0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    row[j] = true;
                }
            }
        }

        // Set arr[i][j] to 0 if either row i or column j has a 0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || column[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
