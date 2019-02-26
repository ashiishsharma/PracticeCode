package com.ashish;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * <B>Cracking The Coding Interview : Edition : 6</B>
 * <p>
 * 8.2
 * <p>
 * <B>Robot in a Grid:</B>
 * Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are "off limits" such that
 * the robot cannot step on them.
 * Design an algorithm to find a path for the robot from the top left to the bottom right.
 * <p>
 *
 * <p><B>Solution</B></p>: Core logic solution is to backtrack from bottom right to top left recursively
 *
 * @author Ashish Sharma on 02/22/2019.
 * <p>
 * @since 02/22/2019.
 */
public class RobotInAGridTest {

    RobotInAGrid robotInAGrid;

    @BeforeMethod
    public void init() {
        robotInAGrid = new RobotInAGrid();
    }


    @Test
    public void testRobotGrid() {

        List<Point> path = null;
        //The grid array signifies the data structure that shows what grid boxes are available and what are not.
        boolean[][] grid = new boolean[][]{{true, true, true, true}, {true, true, true, true},
                {true, true, true, true}, {true, true, false, true}};
        path = robotInAGrid.getPath(grid);

        path.forEach(point -> System.out.println(point.toString()));
    }

    @Test
    public void testRobotGridDynamicProgramming() {

        List<Point> path = null;
        //The grid array signifies the data structure that shows what grid boxes are available and what are not.
        boolean[][] grid = new boolean[][]{{true, true, true, true}, {true, true, true, true},
                {true, true, true, true}, {true, true, false, true}};
        path = robotInAGrid.getPathDynamicProgramming(grid);

        path.forEach(point -> System.out.println(point.toString()));
    }

}
