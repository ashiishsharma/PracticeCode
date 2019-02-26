package com.ashish;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RobotInAGrid {

    public List<Point> getPath(boolean[][] grid) {
        if (grid == null || grid.length == 0) {
            return null;
        }
        List<Point> path = new ArrayList();
        if (getPath(grid, grid.length - 1, grid[0].length - 1, path)) {
            return path;
        }
        return null;
    }

    private boolean getPath(boolean[][] grid, int row, int col, List<Point> path) {
        /* If out of bounds or not available, return.*/
        if (col < 0 || row < 0 || !grid[row][col]) {
            return false;
        }

        boolean isAtOrigin = (row == 0) && (col == 0);

        /* If there's a path from the start to here, add my location. */
        if (isAtOrigin || getPath(grid, row, col - 1, path) ||
                getPath(grid, row - 1, col, path)) {
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }

        return false;
    }

    public ArrayList<Point> getPathDynamicProgramming(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<Point>();
        HashSet<Point> failedPoints = new HashSet<Point>();
        if (getPathDynamicProgramming(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
            return path;
        }
        return null;
    }

    private boolean getPathDynamicProgramming(boolean[][] maze, int row, int col, ArrayList<Point> path,
                                              HashSet<Point> failedPoints) {
        /* If out of bounds or not available, return.*/
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }

        Point p = new Point(row, col);

        /* If we've already visited this cell, return. */
        if (failedPoints.contains(p)) {
            return false;
        }

        boolean isAtOrigin = (row == 0) && (col == 0);

        /* If there's a path from start to my current location, add my location.*/
        if (isAtOrigin || getPathDynamicProgramming(maze, row, col - 1, path, failedPoints) ||
                getPathDynamicProgramming(maze, row - 1, col, path, failedPoints)) {
            path.add(p);
            return true;
        }

        failedPoints.add(p); // Cache result
        return false;
    }
}
