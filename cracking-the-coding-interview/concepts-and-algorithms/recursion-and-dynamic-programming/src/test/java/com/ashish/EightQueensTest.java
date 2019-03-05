package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * 8.12
 * <p>
 * <B>Eight Queens:</B>
 * <p>
 * Write an algorithm to print all ways of arranging eight queens on an 8x8 chess board so that none
 * of them share the same row, column, or diagonal.
 * In this case, "diagonal" means all diagonals, not just the two that bisect the board.
 *
 * @author Ashish Sharma on 03/05/2019.
 * @since 03/05/2019.
 */
public class EightQueensTest {

    private EightQueens eightQueens;

    @BeforeMethod
    public void init() {
        eightQueens = new EightQueens();
    }

    @Test
    public void testEightQueen() {

    }
}
